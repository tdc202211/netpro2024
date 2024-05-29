package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class b_Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // マルチキャストグループのIPアドレスとポート番号を指定
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 12345;

            // データ送信用のソケットを作成
            socket = new DatagramSocket();
            byte[] sendData;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // クライアントからのメッセージをユーザに入力させる
                System.out.print("送信メッセージを入力してください: ");
                String clientMessage = scanner.nextLine();
                sendData = clientMessage.getBytes();

                // メッセージをサーバに送信
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, port);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
