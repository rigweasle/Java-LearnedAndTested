package ParallelProcessing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class TransactionCalendar implements CalendarCreator{

    private final LocalDate inputDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private TreeMap<LocalDate,String> mainMap = new TreeMap<>();

    public TransactionCalendar (LocalDate inputDate){
        this.inputDate = inputDate;
        startDate = inputDate;
        endDate = startDate.plusMonths(3);
        while(startDate.isBefore(endDate)) {
/**The below STRING variable should be removed with the appropriate TreeMap for Transactionlines*/
            String valueString = "Replace this with a transaction object for Date: " + startDate;
            mainMap.put(startDate,valueString);
            startDate = startDate.plusDays(1);
        }
    }

    @Override
    public void addTransaction(LocalDate addDate, String addTransaction) {
        mainMap.put(addDate,addTransaction);
    }

    @Override
    public void remTransaction(LocalDate remDate, String remTransaction) {
        mainMap.remove(remDate,remTransaction);
    }

    @Override
    public void clearDateLine(LocalDate remDateLine) {
        mainMap.replace(remDateLine,mainMap.get(remDateLine),"Blank");
    }

    @Override
    public void clearAllDates() {
        mainMap.clear();
    }

    @Override
    public TreeMap<LocalDate, String> getTransactionCalendar() {
        return mainMap;
    }

    @Override
    public List<String> getDateTransactionsLines(Date retrieveDate) {
        List<String> sendList = new ArrayList<>();
/**This snippet will be for when you use this with a subTreeMap*/
        /*        TreeMap<String,Transaction> sendList = new TreeMap<>();
        mainMap.get(retrieveDate).forEach((key,value) -> {
            sendList.put(key,value);
        });*/
        return sendList;
    }
}
