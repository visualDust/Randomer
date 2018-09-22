package studio.visualdust.product.Randomer.method;

import java.io.*;
import java.nio.charset.Charset;

public class FileWriter {
    private static OutputStream FileWriterStream;

    public static void WriteLineUTF8(File file, String string, boolean append) {
        try {
            FileWriterStream = new FileOutputStream(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileWriterStream, Charset.forName("UTF-8")));
            bufferedWriter.write(string);
            bufferedWriter.write("\r\n");
            bufferedWriter.close();
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }

    public static void WriteLineUnicode(File file, String string, boolean append) {
        try {
            FileWriterStream = new FileOutputStream(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileWriterStream, Charset.forName("Unicode")));
            bufferedWriter.write(string);
            bufferedWriter.write("\r\n");
            bufferedWriter.close();
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }
}
