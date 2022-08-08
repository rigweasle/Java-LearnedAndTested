package ParallelProcessing;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MakeTreeMapWithThread {

    private static int times = 0;

    private static int processors = Runtime.getRuntime().availableProcessors();
    private static List<Thread> threadsMain = new ArrayList<>(processors);
    /*private static List<Thread> threadsCleared = new ArrayList<>(processors);*/

    private static LinkedHashMap<String, String> mainMap = new LinkedHashMap<>();
    private static LocalDate inputDate = LocalDate.of(2000,1,1);
    private static LocalDate startingDate = inputDate;
    private static LocalDate endingDate = startingDate.plusDays(20);
    private static LocalDate workingDate = inputDate;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static int totalIterations = 0;



    private static final class ThreadRunner implements Runnable {

/*        private int value;*/

        private ThreadRunner(/*int value*/) {
/*            this.value = value;*/
        }

        @Override
        public void run() {
            lock.writeLock().lock();
System.out.println("Working the entry: " + workingDate + "\t\t\tUsing the thread named: " + Thread.currentThread().getName());
            workingDate = workingDate;
            mainMap.put(workingDate.toString(), "On thread: " + Thread.currentThread().getName());
            workingDate = workingDate.plusDays(1);
            totalIterations++;
System.out.println("Total iterations in the RUN command: " + totalIterations);
            startingDate = startingDate.plusDays(1);
            lock.writeLock().unlock();
        }
    }

    public static void main(String args[]) throws InterruptedException {
System.out.println("Number of processors being used: " + processors);

        System.out.println(endingDate);
/*        while(startingDate.isBefore(endingDate)) {
//System.out.println(startingDate);
            startingDate = startingDate.plusDays(1);
*//*            mainMap.put(startingDate.toString(),null);
            startingDate = startingDate.plusDays(1);*//*

        }*/
        System.out.println("The total Map size is: " + mainMap.size());
/**
 * The below is working but creates new threads every 16 times
 */

        while (workingDate.isBefore(endingDate)) {
System.out.println("This is not null" + workingDate);
System.out.println("Total iterations in the WHILE command: " + totalIterations);

            for (int i = 0; i < processors; i++) {
System.out.println("Adding a thread numbered: " + i);
                threadsMain.add(new Thread(new ThreadRunner(/*i*/)));
            }

            for (Thread thread : threadsMain) {
                thread.start();
            }

            for (Thread thread : threadsMain) {
                thread.join();
            }
            threadsMain.clear();
System.out.println("\t\t\t This is running again");

        }
/*        for (int i = 0; i < processors; i++) {
System.out.println("Adding a thread numbered: " + i);
            threadsMain.add(new Thread(new ThreadRunner(*//*i*//*)));
        }

        threadsCleared = threadsMain;
        while (workingDate.isBefore(endingDate)) {
            for (Thread thread : threadsCleared) {
                thread.start();
                //thread.
            }

            for (Thread thread : threadsCleared) {
                thread.join();
            }
            threadsCleared = threadsMain;
        }*/




/*        //System.out.println(mainMap);
        LocalDate newInputDate = LocalDate.of(2000,3,1);
        LocalDate newStartDate = newInputDate;
        LocalDate newEndDate = newInputDate.plusDays(20);
        int numOfTries = 0;
        int newPoolSize = 16;

        HashMap<String,String> newTestMap = new HashMap();
        List<Runnable> newTestThread = new ArrayList<>(newTestMap.size());

        while(newStartDate.isBefore(newEndDate)) {
System.out.println("New Date of: " + newStartDate);
            newTestThread.add(new ThreadRunner());
            newStartDate = newStartDate.plusDays(1);
        }
System.out.println("newTestThread total threads: " + newTestThread.size());
        while(numOfTries > 0) {
            if (numOfTries <= newPoolSize) {
                for(int i=0; i<numOfTries;i++) {
System.out.println("Counting up to: " + numOfTries);
System.out.println("Ran that Less Than Tries Line");
                }
            } else {
                for(int i=0; i<newPoolSize;i++){
System.out.println("Counting up to: " + numOfTries);
                    System.out.println("Ran the More than Tries line");
                }
            }
        }*/


/*
        mainMap.forEach((first, second) ->
    {
        System.out.println("This is the date: " + first + "\t and this is the value: " + second);
    });
*/


    }


}
