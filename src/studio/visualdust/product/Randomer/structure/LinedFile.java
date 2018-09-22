package studio.visualdust.product.Randomer.structure;

import studio.visualdust.product.Randomer.method.EventRW;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Vector;

public class LinedFile {
    Vector<String> strings = new Vector<>();
    ReaderThread readerThread = null;
    String name;
    String path;
    long wordCount;
    long lineCount;

    public LinedFile(File file) {
        readerThread = new ReaderThread(file);
        readerThread.start();
        name = file.getName();
        path = file.getPath();
        wordCount = file.length();
    }

    public boolean isReading() {
        return readerThread.isAlive();
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getLineCount() {
        while (this.isReading()) {
        }
        return lineCount;
    }

    public String getLineOn(int index) {
        while (this.isReading()) {
        }
        return strings.elementAt(index);
    }

    @Override
    public String toString() {
        while (this.isReading()) {
        }
        String string = "";
        for (int i = 0; i < strings.size(); i++) {
            string = string + strings.elementAt(i) + "\n";
        }
        return string;
    }

    private class ReaderThread extends Thread {
        File readerFile = null;

        public ReaderThread(File file) {
            readerFile = file;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = new FileInputStream(readerFile);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String str = bufferedReader.readLine();
                if (str.length() != 0) {
                    strings.add(str);
                }
                lineCount = 1;
                while (str != null) {
                    str = bufferedReader.readLine();
                    if (str == null) break;
                    if (str.length() == 0)
                        continue;
                    strings.add(str);
                    lineCount++;
                }
            } catch (Exception e) {
                EventRW.Write(e);
            }
        }
    }
}
