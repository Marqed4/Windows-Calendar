import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class AlarmActivation {

    String title;
    String desc;

    public AlarmActivation(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }


    public void displayTray() throws AWTException {

        SystemTray tray = SystemTray.getSystemTray();

        String appDataAddress = System.getenv("APPDATA");
        Image image = Toolkit.getDefaultToolkit().createImage(appDataAddress + "Windows Calendar\\Assets\\Notification Image.png");

        TrayIcon trayIcon = new TrayIcon(image, "Windows Calendar Notification");

        trayIcon.setImageAutoSize(true);

        trayIcon.setToolTip("");
        tray.add(trayIcon);

        trayIcon.displayMessage(this.title, this.desc, MessageType.INFO);
    }
}