import java.util.Scanner;

public class XmasTree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String[] word = str.split(",");

        for (int k = 1; k <= Integer.parseInt(word[0]); k++) {
            int a = 0;

            for (int i = 1; i <= Integer.parseInt(word[0]) - k; i++) { // 左側の余白作り
                if ((a + k) % 2 != 0) {
                    System.out.print(word[3]);
                } else {
                    System.out.print(" ");
                }
                a++;
            }

            for (int i = 1; i <= 2 * k - 1; i++) { // ツリーの横一列
                System.out.print("*");
                a++;
            }

            for (int i = 0; i <= Integer.parseInt(word[0]) - k; i++) { // 右側の余白作り
                if ((a + k) % 2 != 0) {
                    System.out.print(word[3]);
                } else {
                    System.out.print(" ");
                }
                a++;
            }

            System.out.println(" "); // 改行
        }

        for (int k = 1; k <= Integer.parseInt(word[1]); k++) {

            for (int i = 1; i <= Integer.parseInt(word[0]) - Math.ceil(Double.parseDouble(word[2]) / 2.0); i++) // 左側の余白作り
                System.out.print(" ");

            for (int i = 1; i <= Integer.parseInt(word[2]); i++)
                System.out.print("*");

            System.out.println();
        }
    }

}
// https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Integer.html