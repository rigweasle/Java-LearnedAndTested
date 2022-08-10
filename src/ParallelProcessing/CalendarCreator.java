package ParallelProcessing;

/*import Transactions.Transaction;
import Transactions.TransactionLine;*/

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public interface CalendarCreator {
    void addTransaction(LocalDate addDate, String addTransaction);
    void remTransaction(LocalDate remDate, String remTransaction);
    void clearDateLine(LocalDate remDateLine);
    void clearAllDates();
    List<String> getDateTransactionsLines(Date retrieveDate);
    TreeMap<LocalDate, String> getTransactionCalendar();

}