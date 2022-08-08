package datesAndCalendars;

import java.time.LocalDate;

public class LocalDateCopy {
    static LocalDate inputDate;
    static LocalDate startDate;
    static LocalDate testIfChangedDate;


    public static void main(String args[]) {
        inputDate = LocalDate.of(2000,1,1);

        startDate = inputDate;
        testIfChangedDate = inputDate;
        System.out.println("The inputDate is: " + inputDate);
        System.out.println("The start startDate is: " + startDate);
        System.out.println("The testIfChangeDate is: " + testIfChangedDate);

        startDate = startDate.plusDays(14);


        System.out.println("\n ************************\n");
        System.out.println("The inputDate is: " + inputDate);
        System.out.println("The start startDate is: " + startDate);
        System.out.println("The testIfChangeDate is: " + testIfChangedDate);




    }
}
