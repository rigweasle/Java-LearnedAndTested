package ParallelProcessing;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class MultiThreadProcessor implements Runnable {
    private TreeMap<LocalDate,String> inputMap;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public MultiThreadProcessor(TreeMap<LocalDate,String> inputMap) {
        this.inputMap = inputMap;
    }

    @Override
    public void run() {
        inputMap.forEach((key,value) ->{
                        lock.writeLock().lock();
/**If there is work to be done per line, this is where it will go*/
                        CreatingNewLimitedList.addLineToDateMap(key,"Processed on Thread: " + Thread.currentThread().getName());
//System.out.println("\t\tDate submitted: " + key + "\n\t\t\tOn Thread: " + Thread.currentThread().getName());
                        lock.writeLock().unlock();
                        });
    }
}