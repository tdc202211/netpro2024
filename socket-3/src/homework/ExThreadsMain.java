package homework;

public class ExThreadsMain implements Runnable {
    String myAlfabetStr = "noalfabet";

    public static void main(String[] args) {

        char c1 = 97; // ASCII値 97 は 'a' です

        CountAZTenRunnable[] list = new CountAZTenRunnable[26];
        Thread[] th = new Thread[26];

        for (int i = 0; i < 26; i++) {
            list[i] = new CountAZTenRunnable();
            list[i].setChar("Alphabet：" + c1);
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
            for (int i = 0; i < 11; i++) {
                System.out.println(myAlfabetStr + "：" + i);
                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(500); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
