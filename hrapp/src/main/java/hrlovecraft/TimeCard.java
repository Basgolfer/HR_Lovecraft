package hrlovecraft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCard {

    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private long employeeId;

    public TimeCard(String timeIn){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyyHHmm");
        this.timeIn= LocalDateTime.parse(timeIn, formatter);
        timeOut=LocalDateTime.now();
    }

    public void clockIn() {
        this.timeIn = LocalDateTime.now();
    }

    public void clockOut() {
        this.timeOut = LocalDateTime.now();
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public long getEmployeeId() {
        return employeeId;
    }

}
