/** the purpose of this was to create a way to process a list in predefined chunks
 */
package ParallelProcessing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CreatingNewLimitedList {
    static Integer numberOfDays = 60;
    static Integer processors = Runtime.getRuntime().availableProcessors();
    static Integer daysBetweenDates = numberOfDays;
    Integer newThreadMapDays = 0;
    static List<Thread> threads = new ArrayList<>(processors);
    static Map<LocalDate,String> listOfObjToTask = new TreeMap<>();
    static Map<LocalDate,String> dateMap = new TreeMap<>();
    static Map<Integer,List<LocalDate>> listByAvailPcsr = new TreeMap<>();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static LocalDate inputDate = LocalDate.of(2000,3,1);
    static LocalDate startDate = inputDate;
    static LocalDate workingDate = inputDate;
    static LocalDate endDate = inputDate.plusDays(numberOfDays);






/*
    private static final class ThreadRunner implements Runnable {

        */
/*        private int value;*//*


        private ThreadRunner(*/
/*int value*//*
) {
            */
/*            this.value = value;*//*

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

*/


    public static void main(String args[]) throws InterruptedException {




/**This creates the lists of tasks needed */
        while(startDate.isBefore(endDate)) {
//System.out.println("New Date of: " + startDate);
            dateMap.put(startDate,null);
            startDate = startDate.plusDays(1);
//newTestThread.add("Insert object to go into the array here");
        }
/**We're done with the above*/

/**Create lists according to the number of cores*/
        for (Integer i = 0; i < processors; i++) {
            List<LocalDate> dates = new ArrayList<>();
            //dates.add(workingDate.plusDays(i));
            listByAvailPcsr.put(i,dates);
        }
/**We're done with creating a treeMap per processor*/
/*listByAvailPcsr.forEach((key,value) ->{
System.out.println("List #: " + key + "\t\t\tWith the value of: " + value);
} );*/
       // daysBetweenDates =
/**This begins the process of arranging the threads by processor count*/
//System.out.println("New number of tries total is: " + daysBetweenDates);
        while(daysBetweenDates >0){
System.out.println("number of tries within the while: " + daysBetweenDates);
            Integer count = 0;
                while(daysBetweenDates >= processors) {
                    listByAvailPcsr.get(count).add(workingDate);

System.out.println("Running the Greater than line: " + daysBetweenDates);

                daysBetweenDates--;
            }
                while(daysBetweenDates >0){
System.out.println("Finally made it to the lastline: "+ daysBetweenDates);
                    daysBetweenDates--;
                }
        }
listByAvailPcsr.forEach((key,value) ->{
System.out.println("List #: " + key + "\t\t\tWith the value of: " + value);
} );

        /**This creates the threads*/
        for (int i = 0; i < processors; i++) {

//System.out.println("Adding a thread numbered: " + i);
            //threads.add("Insert another object here");
        }

        for (int i = 0; i < processors; i++) {
//System.out.println("Adding a thread numbered: " + i);
//threadsMain.add(new Thread(new ThreadRunner(*//*i*//*)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        threads.clear();
//System.out.println("\t\t\t This is running again");

        dateMap.forEach((key,value) ->{
//System.out.println(key + "\t\t\tWith the value of: " + value);
        } );
//System.out.println(dateMap);
    }

}


