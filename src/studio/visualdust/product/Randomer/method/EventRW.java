package studio.visualdust.product.Randomer.method;

import studio.visualdust.product.Randomer.resource.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventRW {
    public static File logoutfile = new File(LocalDate.now().toString() + "_" + Resource.softName + ".md");
    public static OutputStream logstream;

    public static void Write(Exception e) {
        try {
            logstream = new FileOutputStream(logoutfile, true);
            logstream.write(("").getBytes());
            logstream.write(("> " + LocalDateTime.now().toString() + " Exception : " + e.toString() + "\r\n\r\n").getBytes());
            logstream.write(("").getBytes());
        } catch (Exception e1) {
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        System.out.println(e.toString());
        e.printStackTrace();
    }

    public static void Write(String event) {
        try {
            logstream = new FileOutputStream(logoutfile, true);
            logstream.write((LocalDateTime.now().toString() + " Event : " + event + "\r\n").getBytes());
        } catch (Exception e1) {
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        System.out.println(event);
    }

    public static void WriteStrOnly(String string) {
        try {
            logstream = new FileOutputStream(logoutfile, true);
            logstream.write(string.getBytes());
        } catch (Exception e1) {
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        System.out.println(string);
    }
}
