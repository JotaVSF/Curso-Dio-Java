import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String name;
    private LocalTime ClockIn;
    private LocalTime ClockOut;

    private static final DateTimeFormatter formatted = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Employee(String name){
        this.name = name;
    }
    public void punchIn () {
        this.ClockIn = LocalTime.now();
    }
    public void clockOut () {
        this.ClockOut = LocalTime.now();
    }
    public String getName(){
        return name;
    }
    public String FormattedClockIn(){
        return ClockIn.format(formatted);
    }
    public String FormattedClockOut(){
        return ClockOut.format(formatted);
    }
    public Duration getWorkDuration(){
        return Duration.between(ClockIn, ClockOut);
    }
    public String getFormattedTimeWork(){
        Duration d = getWorkDuration();
        long h = d.toHours();
        long m = d.toMinutes()%60;
        long s = d.toSeconds()%60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    public boolean MinimumWorkingHours(long minutesMinimums){
        return Duration.between(ClockIn, LocalTime.now()).toMinutes() >= minutesMinimums;
    }
    public long remainingMinutesTo(long minimumMinutes){
        return minimumMinutes = Duration.between(ClockIn, LocalTime.now()).toMinutes();
    }

}
