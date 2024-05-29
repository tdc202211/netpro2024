package homework;

// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class CountAZTenRunnable implements Runnable {

    public void main(String args[]) {
        char c1 = 97;
        char c2 = (char) (c1 + 1);

        CountAZTenRunnable[] list = new CountAZTenRunnable[24];

        for (CountAZTenRunnable i : list) {
            i = new CountAZTenRunnable();
        }
    }

    public void run() {
    }
}
