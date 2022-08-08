package UsingTimers;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class Timers {

    private static void main(String[] args) {
    Clock clock = Clock.systemUTC();
    Instant start = clock.instant();

    Instant end = clock.instant();
    Duration duration = Duration.between(start,end);
    System.out.println("Total time run: " + duration.toSeconds());

/** This is how to get the time in nanoseconds */
        long start1 = System.nanoTime();

        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
}
