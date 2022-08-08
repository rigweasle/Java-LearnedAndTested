package ParallelProcessing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** This whole thing is looping and I can't figure out how or where. Idunno! */

public class CustomThreadPool {
    private static int processors = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executor = Executors.newFixedThreadPool(processors);
    private static int numberOfTries = 40;
    private static int currentTry = 0;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static class CustomThreadPoolTest {
        //Thread pool size
        private final int poolSize;

        //Internally pool is an array
        private final WorkerThread[] workers;

        // FIFO ordering
        private final LinkedBlockingQueue<Runnable> queue;

        public CustomThreadPoolTest(int poolSize) {
            this.poolSize = poolSize;
            queue = new LinkedBlockingQueue<Runnable>();
            workers = new WorkerThread[poolSize];

            for (int i = 0; i < poolSize; i++) {
                workers[i] = new WorkerThread();
                workers[i].start();
            }
        }

        public void execute(Runnable task) {
            synchronized (queue) {
                queue.add(task);
                queue.notify();
System.out.println("Execute has finished");
            }
        }

        private class WorkerThread extends Thread {
            public void run() {
                Runnable task;

                while (currentTry <5) {
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            try {
System.out.println("Is this where it's getting stuck?");
                                queue.wait();
System.out.println("And now we wait");
                            } catch (InterruptedException e) {
System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                            }
                        }
                        task = (Runnable) queue.poll();
System.out.println("Or is it this one?");
                    }

                    try {
                        lock.readLock().lock();
                        currentTry++;
                        task.run();
                        lock.readLock().unlock();
                    } catch (RuntimeException e) {
System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                    }
                }
            }
        }

        public void shutdown() {
System.out.println("Shutting down thread pool");
            for (int i = 0; i < poolSize; i++) {
                workers[i] = null;
            }
        }
    }

    public static class Task implements Runnable{
        String name;

        private Task(String name) {
            this.name = name;
        }
            public String getName () {
                return name;
            }

        @Override
        public void run() {
System.out.println("Ran this line: " + currentTry + " Times." + "\t\t\tOn Thread: " + Thread.currentThread().getName());
        }
    }

    public static void main(String args[]) {

        CustomThreadPoolTest customThreadPool = new CustomThreadPoolTest(4);

        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
System.out.println("Created : " + task.getName());

            customThreadPool.execute(task);
System.out.println("Made it out");
        }
/*        customThreadPool.shutdown();
System.out.println("Program completed");*/
    }
}
