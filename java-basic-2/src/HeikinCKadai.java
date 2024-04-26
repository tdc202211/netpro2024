import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HeikinCKadai {
    public static final int N = 100;
    Kamoku[] kamoku = new Kamoku[N];
    static String kamokuname = "数学";
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        HeikinCKadai HeikinCKadai = new HeikinCKadai(kamokuname);
        HeikinCKadai.initalizeScores();
        HeikinCKadai.printAverage();
        HeikinCKadai.gokakusha();
        HeikinCKadai.show();
    }

    HeikinCKadai(String s) {
        this.kamokuname = s;

    }

    void initalizeScores() {
        Random r = new Random();

        for (int i = 0; i < N; i++) {
            int score = r.nextInt(N + 1);
            kamoku[i] = new Kamoku(score);
            list.add(score);
        }

    }

    void printAverage() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += kamoku[i].getScore();

        }
        System.out.println("平均点は" + sum / N);

    }

    void gokakusha() {

    }
    // student idと点数をソートしてだせ。＞＝８０以上

    void show() {
        System.out.println("以下合格者の点数です");
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            if (list.get(i) >= 80) {
                System.out.println(list.get(i));
            }
        }
    }

}
