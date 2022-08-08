package ParallelProcessing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static int processors = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executor = Executors.newFixedThreadPool(processors);
    private static int numberOfTries = 40;
    private static int currentTry = 0;

    public static class taskRun implements Runnable{

        public static void TaskRun(){
        }
        @Override
        public void run() {
            System.out.println("");
        }
    }

    public static void main(String args[]) {



    }
}
