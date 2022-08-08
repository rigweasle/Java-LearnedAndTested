package ParallelProcessing;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.concurrent.ForkJoinPool;

public class UsingForkJoinPool {
    public static void main(String args[]){

/*        int processors = Runtime.getRuntime().availableProcessors();
        TreeMap<String,Integer> map = new TreeMap<String, Integer>();
        LocalDate startDate;


System.out.println("CPU cores: " + processors);
        startDate = LocalDate.of(2022,5,10);
        ForkJoinPool cpuPool = new ForkJoinPool(processors);
        LocalDate endDate = startDate.plusMonths(3);

        while(startDate.isBefore(endDate)) {
System.out.println("Thread number# " + Thread.currentThread().getId() + " Did this");

            cpuPool.invoke(new parallelAddDate(startDate,null));

        }*/
    }
}

