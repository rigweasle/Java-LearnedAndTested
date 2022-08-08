package ParallelProcessing;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MakeTreeMap {

    private static TreeMap<String,String> mainMap = new TreeMap<>();
    private static Integer counter = 0;
    private static int processors = Runtime.getRuntime().availableProcessors();
    private static ForkJoinPool pool = new ForkJoinPool(processors);
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static int taskCount = 0;


/*    public TreeMap<String,String> newMap (String name,String number){
        this.mainMap = newMap(name,number);
        return mainMap;
    }*/

    public static final class Adder {
        public static void setCounter(){
            counter++;
        }
        public static void addLine() {
            setCounter();
            String input = "Line number: " + counter;
            String inThread = "Thread used was: " + Thread.currentThread().getName();
            //counter++;
System.out.println("Processing line: " + counter);
            mainMap.put(input,inThread);
System.out.println("MainMap has been added on " + input + "\n\t on Thread: " + inThread);
        }
    }

    public static final class TaskAdd extends RecursiveTask<TreeMap<String,String>> {


        @Override
        protected TreeMap compute() {
/*            while(taskCount < 10){
                System.out.println("Currently on adding line: " + taskCount);
                String taskLine = "Added Task " + taskCount;
                String taskThread = "\n\tWas run on thread: " + Thread.currentThread().getName();
                mainMap.put(taskLine,taskThread);
                taskCount++;
            }*/
            //lock.readLock().lock();
            //taskCount++;
            System.out.println("Currently on adding line: " + taskCount);
            System.out.println("Running on Thread: " + Thread.currentThread());
            String taskLine = "Added Task " + taskCount;
            String taskThread = "\n\tWas run on thread: " + Thread.currentThread().getName();
            mainMap.put(taskLine,taskThread);
            //lock.readLock().unlock();
            return null;
        }
    }
    public static final class ProcessForks {
        public static void process(){
/*            while (counter <= 50) {
System.out.println("This is whats bring fed through: " + counter);
                pool.submit(() -> {Adder.setCounter();
                    Adder.addLine();
                });
            }*/
            lock.readLock().lock();

            while(taskCount <10){
                //lock.writeLock().lock();
                taskCount++;
                System.out.println("ran " + taskCount);
                //lock.writeLock().unlock();
                pool.execute(new TaskAdd());


            }
            //pool.invoke(new TaskAdd());
        }

    }


public static void main(String args[]){
    System.out.println(mainMap);
System.out.println("Number of Processors: " + pool.getParallelism());
int n =0;
while(n < 10){
    mainMap.put("Key of: " + n, "value of " + n);
    n++;
    }
        ProcessForks.process();
    Iterator itr = mainMap.keySet().iterator();
//System.out.println(itr);
/*    while (itr.hasNext()){
        String key = itr.next().toString();
        System.out.println(key + mainMap.get(key));
        //System.out.println(itr.next().toString() + mainMap.get(itr.next()));
    }*/
}
}
