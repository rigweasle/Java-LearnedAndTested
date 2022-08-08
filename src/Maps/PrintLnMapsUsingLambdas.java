package Maps;

import java.time.LocalDate;
import java.util.HashMap;

public class PrintLnMaps {
    static HashMap<Integer,String> map = new HashMap();
    static Integer startNumber = 0;
    static Integer endNumber = 10;

    public static void main(String args[]) {

        while(startNumber < endNumber){
            map.put(startNumber,"This is the value for key: " + startNumber);
            startNumber++;
        }

        map.forEach((key,value) ->{
            System.out.println(key + "\t\t\tWith the value of: " + value);
        } );

    }

}
