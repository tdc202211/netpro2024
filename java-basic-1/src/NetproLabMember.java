import java.util.ArrayList;
import java.util.Random;

public class NetproLabMember {
    public static void main(String[] args) {
        int sum;
        int female;
        int limit;
        Random rand = new Random();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 15; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            sum = rand.nextInt(21) + 100;
            female = (int) (double) sum * (20 + i) / 100;
            limit = rand.nextInt(7) + 7;
            list.add(sum);
            list.add(female);
            list.add(limit);

            lists.add(list);
        }

        double[] a = new double[15];
        for (int i = 0; i < 15; i++) {
            double x = 1;
            double y = 1;
            double z = 1;
            for (int j = 0; j < lists.get(i).get(2); j++) {
                x = x * (lists.get(i).get(0) - lists.get(i).get(2) - j);
                y = y * (lists.get(i).get(0) - j);
                z = z * (lists.get(i).get(1) - j);
            }
            a[i] = x / y / z;
        }
        double answer = 1;
        for (double i : a) {
            answer = answer * i;
        }

        System.out.println(answer);
    }
}
