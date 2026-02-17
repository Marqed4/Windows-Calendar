import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.io.File;

public class DateAlarm {
    Queue<LocalDateTime> alarms;

    //Creates a DataAlarm Object
    public DateAlarm() throws IOException {
        this.alarms = new PriorityQueue<>();

        Scanner sc;

        //Checks if the "Notification_Data" file exists, if not it creates one.
        String appDataAddress = System.getenv("APPDATA");
        try {
            sc = new Scanner(new File(appDataAddress + "\\Windows Calendar\\Notification_Data"));
        } catch (FileNotFoundException e) {
            File Notification_Data = new File(appDataAddress + "\\Windows Calendar\\Notification_Data");
            Notification_Data.createNewFile();
            sc = new Scanner(new File(appDataAddress + "\\Windows Calendar\\Notification_Data"));
        }

        //Loads notification data into DataAlarm object
        while (sc.hasNextInt()) {
            this.alarms.add(LocalDateTime.parse(sc.nextLine()));
        }
    }

    public void setAlarm(LocalDateTime time) {
        this.alarms.add(time);
    }

    public void removeAlarm(LocalDateTime time) {
        this.alarms.remove(time);
    }


}