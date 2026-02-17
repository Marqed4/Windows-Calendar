import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.io.File;


/*
todo
Priority:

1. Create 36 calendar panes
2. Up & Down buttons to switch/navigate between weeks.
3. Allow the right clicking on the pane shows event menu.
4. Ability to view calendar by Day/ Week/ Year.

Luxury:
1. Bottom left of screen allows an email to be sent.
2. Seven day forecast, showing weather conditions of the following seven days.
3.
*/

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