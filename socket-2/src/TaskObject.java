
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskObject implements Serializable, ITask {

    int x;
    int result;
    List<Integer> primes = new ArrayList<>();

    @Override
    // クライアントで最初に計算させる数字を入力しておく関数
    public void setExecNumber(int x) {
        this.x = x;
    }

    @Override
    // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。
    public void exec() {

        boolean[] isPrime = new boolean[x + 1];
        Arrays.fill(isPrime, true);

        for (int p = 2; p * p <= x; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= x; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int p = 2; p <= x; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }
    }

    @Override
    // クライアントで結果を取り出す関数
    public int getResult() {
        return primes.get(primes.size() - 1);
    }
}