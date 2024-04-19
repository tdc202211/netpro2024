
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

    public static void main(String[] args) {
        while (true) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // BufferedReader というのは、データ読み込みのクラス(型)
            // クラスの変数を作るには、new を使う。

            // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
            // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
            try {

                System.out.println("何歳ですか?");
                String line = reader.readLine();

                if(line.equals("q")||line.equals("e")){
                    break;
                }

                int age = Integer.parseInt(line);

                if (0 <= age && age < 120) {
                    System.out.println("あなたは" + age + "歳ですね。");
                    System.out.println("あなたは2030年には、" + (age + 6) + "歳ですね。");
                    if (2024 - age >= 2019) {
                        if (6 - age == 1) {
                            System.out.println("あなたの生まれた元号は令和元年です");
                        } else {
                            System.out.println("あなたの生まれた元号は令和" + (6 - age) + "年です。");
                        }
                    } else if (2024 - age >= 1989) {
                        if (36 - age == 1) {
                            System.out.println("あなたの生まれた元号は平成元年です。");
                        } else {
                            System.out.println("あなたの生まれた元号は平成" + (36 - age) + "年です。");
                        }
                    } else if (2024 - age >= 1926) {
                        if (99 - age == 1) {
                            System.out.println("あなたの生まれた元号は昭和元年です。");
                        } else {
                            System.out.println("あなたの生まれた元号は昭和" + (99 - age) + "年です。");
                        }
                    } else if (2024 - age >= 1912) {
                        if (113 - age == 1) {
                            System.out.println("あなたの生まれた元号は大正元年です。");
                        } else {
                            System.out.println("あなたの生まれた元号は大正" + (113 - age) + "年です。");
                        }
                    } else {
                        if (157 - age == 1) {
                            System.out.println("あなたの生まれた元号は明治元年です。");
                        } else {
                            System.out.println("あなたの生まれた元号は明治" + (157 - age) + "年です。");
                        }
                    }

                } else {
                    System.out.println("再入力してください");
                }

            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
