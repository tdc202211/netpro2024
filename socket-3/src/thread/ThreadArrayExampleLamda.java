package thread;

public class ThreadArrayExampleLamda {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3]; // スレッドの配列を作成

        // スレッドを配列に追加し、それぞれのスレッドに異なる処理を割り当てる
        for (int i = 0; i < threads.length; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(() -> {
                for (int j = 1; j <= 10; j++) {
                    System.out.println("Thread " + threadNum + ": " + j);
                    try {
                        Thread.sleep(100); // 100ミリ秒待機
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // すべてのスレッドを開始
        for (Thread thread : threads) {
            thread.start();
        }

        // すべてのスレッドの終了を待機
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have finished.");
    }
}
