import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.io.File;

public class DateAlarm {
    Queue<LocalDateTime> alarms;
    String[] title;
    String[] desc;

    //Creates a DataAlarm Object
    //Notification String data format: LocalDateTime | Title | Description
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
        while (sc.hasNextLine()) {
            this.alarms.add(LocalDateTime.parse(sc.nextLine()));
        }


        long delay = Duration.between(LocalDateTime.now(), this.alarms.peek()).getSeconds();

        if (delay <= 0) {
            removeAlarm(this.alarms.peek());
        }
    }

    public void setAlarm(LocalDateTime time) throws IOException {
        this.alarms.add(time);

        //Add alarm data to "Notification_Data" file
        String appDataAddress = System.getenv("APPDATA");

        Scanner sc;
        try {
            sc = new Scanner(new File(appDataAddress + "\\Windows Calendar\\Notification_Data"));
        } catch (FileNotFoundException e) {
            File Notification_Data = new File(appDataAddress + "\\Windows Calendar\\Notification_Data");
            Notification_Data.createNewFile();
            sc = new Scanner(new File(appDataAddress + "\\Windows Calendar\\Notification_Data"));
        }

    }

    public void removeAlarm(LocalDateTime time) {
        this.alarms.remove(time);
        //todo
        //remove the alarm info from the Notification_Data.txt
    }

    //I learned threads dealing with memory allocation via malloc! Can it come in handy here?
    public void checkAlarm() throws InterruptedException {
        AlarmActivation alarm;

        Thread thread = new Thread(() -> {
            long delay = Duration.between(this.alarms.peek(), LocalDateTime.now()).getSeconds();

            try {
                if (delay > 0) {
                    Thread.sleep(delay * 1000);
                }

                alarm = new AlarmActivation();
                removeAlarm(LocalDateTime.now());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread.start();
    }
}