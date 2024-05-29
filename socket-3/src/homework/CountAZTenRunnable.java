package homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CountAZTenRunnable implements Runnable {
    String myAlfabetStr = "noalfabet";

    public static void main(String[] args) {

        char c1 = 97; // ASCII値 97 は 'a' です

        CountAZTenRunnable[] list = new CountAZTenRunnable[26];
        Thread[] th = new Thread[26];

        for (int i = 0; i < 26; i++) {
            list[i] = new CountAZTenRunnable();
            list[i].setChar(c1 + "");
            c1 = (char) (97 + i);
            th[i] = new Thread(list[i]);
            th[i].start();
        }
    }

    public void setChar(String alfabetstr) {
        myAlfabetStr = alfabetstr;
    }

    public void run() {
        try {

            FileWriter file = new FileWriter("CountAZTenRunnable.java,6_C_Result.txt", true);
            PrintWriter pw = new PrintWriter(new BufferedWriter(file));

            for (int i = 0; i < 11; i++) {
                System.out.println(myAlfabetStr + i);
                pw.write(myAlfabetStr + i + "\n");
                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(500); // ミリ秒単位のスリープ時間
            }
            pw.close();
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
