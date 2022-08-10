package ParallelProcessing;

import java.time.LocalDate;

public interface ProcessSplitter {
    public void ProcessSplitter();
    public void splitNewCalendar(LocalDate inputDate);
    public void splitNewJob();
}
