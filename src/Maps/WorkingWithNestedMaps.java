package Maps;

import java.util.TreeMap;

public class WorkingWithNestedMaps {
    static TreeMap<Integer, String> subMap1 = new TreeMap<>();
    static TreeMap<Integer, String> subMap2 = new TreeMap<>();
    static TreeMap<Integer, String> subMap3 = new TreeMap<>();
    static TreeMap<String, TreeMap<Integer,String>> mainMap = new TreeMap<String, TreeMap<Integer,String>>();
    static TreeMap<Integer,String> secondMap = new TreeMap<Integer,String>();

    public static void main(String args[]){

        for(int i=0; i < 10; i++){
            subMap1.put(i,"This is the value of the FIRST subList: " + i);
        }

        for(int i=0; i < 10; i++){
            subMap2.put(i,"This is the value of the SECOND SubList: " + i);
        }

/**This replaces one value from the key 4 for 'Blanking only one line'*/
//        subMap1.replace(4,subMap1.get(4),"Blanking only one line");

        mainMap.put("This is the Main list 1",subMap1);
        mainMap.put("This is the Main list 2",subMap2);

/**This line completely removes the key 7 from the subMap1 treemap*/
//        mainMap.get("This is the Main list 1").remove(7);
/**This line replaces only the subMap1 value from the 'This is the Main list 1' key with a blank treemap*/
//        mainMap.replace("This is the Main list 1",subMap1,new TreeMap<>());
/**This removes the value from the subMap1 treemap within the 'This is the Main list 1' key*/
//        mainMap.get("This is the Main list 1").replace(4,mainMap.get("This is the Main list 1").get(4),"Blank");
System.out.println("The contents of subMap1: " + subMap1.get(4));
/**This displays the contents of the mainMap*/
        mainMap.forEach((key,value) ->{
System.out.println(key + "\t\t\tWith the value of: " + value);
        } );
/**This adds the contents of 'This is the Main list 1' into the SecondMap*/
        mainMap.get("This is the Main list 1").forEach((key,value) -> {
            secondMap.put(key,value);
                }
        );


//System.out.println(mainMap.get("This is the Main list 1"));
        //mainMap.get("This is the Main List 1").replace(4,"This is the value of the SECOND SubList: 4","Blank");

        secondMap.forEach((key,value) ->{
System.out.println("\n" + key + "\t\t\tWith the value of: " + value);
        } );
    }
}
