/** the purpose of this was to create a way to process a list in predefined chunks
 */
package ParallelProcessing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CreatingNewLimitedList {
    private static Integer numberOfDays = 60;
    private static Integer processors = Runtime.getRuntime().availableProcessors();
    private static Integer daysBetweenDates = numberOfDays;
    private static List<Thread> threads = new ArrayList<>(processors);
    private static Map<LocalDate,String> listOfObjToTask = new TreeMap<>();
    private static Map<LocalDate,String> dateMap = new TreeMap<>();
    private static Map<Integer,Map<LocalDate,String>> listByAvailPcsr = new TreeMap<>();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static LocalDate inputDate = LocalDate.of(2000,3,1);
    private static LocalDate startDate = inputDate;
    private static LocalDate workingDate = inputDate;
    private static LocalDate endDate = inputDate.plusDays(numberOfDays);
    private static TransactionCalendar newTranCal;

    public static void addLineToDateMap(LocalDate addDate,String addString){
        newTranCal.addTransaction(addDate,addString);
    }
    public static void main(String args[]) throws InterruptedException {

        newTranCal = new TransactionCalendar(inputDate);

/**This creates the lists of tasks needed */
/*        while(startDate.isBefore(endDate)) {
//System.out.println("New Date of: " + startDate);
            dateMap.put(startDate,null);
            startDate = startDate.plusDays(1);
        }*/
/**We're done with the above*/

/**Create lists according to the number of cores*/
        for (Integer i = 0; i < processors; i++) {
            TreeMap<LocalDate,String> dates = new TreeMap<>();
            //dates.add(workingDate.plusDays(i));
            listByAvailPcsr.put(i,dates);
        }
/**We're done with creating a treeMap per processor*/
/*listByAvailPcsr.forEach((key,value) ->{
System.out.println("List #: " + key + "\t\t\tWith the value of: " + value);
} );*/
       // daysBetweenDates =
/**This begins the process of arranging the tasks into a list by processor count*/
        while(daysBetweenDates >0){
            Integer count = 0;
                while(daysBetweenDates >= processors) {
                    if (count <listByAvailPcsr.size() -1){
                        listByAvailPcsr.get(count).put(workingDate,null);
                        count++;
                    } else {
                        listByAvailPcsr.get(count).put(workingDate,null);
                        count = 0;
                    }
                daysBetweenDates--;
                    workingDate = workingDate.plusDays(1);
            }
                while(daysBetweenDates >0){
                    if (count <listByAvailPcsr.size() -1){
                        listByAvailPcsr.get(count).put(workingDate,null);
                        count++;
                    } else {
                        listByAvailPcsr.get(count).put(workingDate,null);
                        count = 0;
                    }
                    workingDate = workingDate.plusDays(1);
                    daysBetweenDates--;
                }
        }
/**The above can be split off into its own class to minimize confusion and be repurposed for use with other tasks*/

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
            TreeMap<LocalDate,String> sendMap = new TreeMap<>();
            sendMap.putAll(listByAvailPcsr.get(i));
            threads.add(new Thread(new MultiThreadProcessor(sendMap)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        threads.clear();
//System.out.println("\t\t\t This is running again");

/*        dateMap.forEach((key,value) ->{
System.out.println(key + "\t\t\tWith the value of: " + value);
        } );*/
//System.out.println(dateMap);

        newTranCal.getTransactionCalendar().forEach((key,value) ->{
System.out.println("So this is what was added: " + key + "\t\t\t\tHolding the value of: " + value);
                });
    }

}


