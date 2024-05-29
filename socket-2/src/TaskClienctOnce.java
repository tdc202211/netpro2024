

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClienctOnce {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");
            //ここまでが接続を確立する作業

            //ここからが自由記述
            //ここでサーバにメッセージを送るための「oos」を作成
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            String message = scanner.next();
            scanner.close();

            TaskObject present = new TaskObject();//オブジェクトを作成
            present.setExecNumber(Integer.valueOf(message));

            oos.writeObject(present);
            oos.flush();

            //ここでサーバからメッセージを受け取るための「ois」を作成
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject okaeshiPresent = (TaskObject) ois.readObject();

            int replayMsg = okaeshiPresent.getResult();
            System.out.println("サーバからのメッセージは" + replayMsg);
            //ここまでが自由記述

            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
