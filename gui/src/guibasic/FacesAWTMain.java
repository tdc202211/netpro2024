//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            int xStart0 = 50;
            int yStart0 = 50;

            FaceObj[] fobjs = new FaceObj[9];

            fobjs[0] = new FaceObj();
            fobjs[0].setPosition(xStart0, yStart0);
            fobjs[0].setEmotionLevel(0,0);
            fobjs[0].drawFace(g);

            fobjs[1] = new FaceObj();
            fobjs[1].setPosition(xStart0 + 230, yStart0);
            fobjs[1].setEmotionLevel(0,50);
            fobjs[1].drawFace(g);

            fobjs[2] = new FaceObj();
            fobjs[2].setPosition(xStart0 + 460, yStart0);
            fobjs[2].setEmotionLevel(0,100);
            fobjs[2].drawFace(g);

            fobjs[3] = new FaceObj();
            fobjs[3].setPosition(xStart0, yStart0 + 230);
            fobjs[3].setEmotionLevel(50,0);
            fobjs[3].drawFace(g);

            fobjs[4] = new FaceObj();
            fobjs[4].setPosition(xStart0 + 230, yStart0 + 230);
            fobjs[4].setEmotionLevel(50,50);
            fobjs[4].drawFace(g);

            fobjs[5] = new FaceObj();
            fobjs[5].setPosition(xStart0 + 460, yStart0 + 230);
            fobjs[5].setEmotionLevel(50,100);
            fobjs[5].drawFace(g);

            fobjs[6] = new FaceObj();
            fobjs[6].setPosition(xStart0, yStart0 + 460);
            fobjs[6].setEmotionLevel(100,0);
            fobjs[6].drawFace(g);

            fobjs[7] = new FaceObj();
            fobjs[7].setPosition(xStart0 + 230, yStart0 + 460);
            fobjs[7].setEmotionLevel(100,50);
            fobjs[7].drawFace(g);

            fobjs[8] = new FaceObj();
            fobjs[8].setPosition(xStart0 + 460, yStart0 + 460);
            fobjs[8].setEmotionLevel(100,100);
            fobjs[8].drawFace(g);
        }

    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        private int w = 200;
        private int h = 200;
        private int xStart = 350;
        private int yStart = 350;
        private int happy;
        private int sad;

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        public void setPosition(int xStart0, int yStart0) {
            this.xStart = xStart0;
            this.yStart = yStart0;
        }

        public void setEmotionLevel(int happy, int sad) {
            this.happy = happy;
            this.sad = sad;
        }

        public void drawRim(Graphics g) { // wが横幅、hが縦幅
            Color color1 = new Color(0, 0, 0);
            g.setColor(color1);

            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)

        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 80;

            Color color = new Color(255, 123, 24);
            g.setColor(color);

            int x[] = { ((xMiddle - nx / 2) + (xMiddle + nx / 2)) / 2, xMiddle - nx / 2, xMiddle + nx / 2 };
            int y[] = { yMiddle - 15, yMiddle - 5, yMiddle - 5 };
            g.fillPolygon(x, y, 3);

        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            Color color1 = new Color(0, 0, 0);
            g.setColor(color1);

            g.fillOval(xStart + 45, yStart + 35, r, r);
            g.fillOval(xStart + 100, yStart + 35, r, r);

            Color color = new Color(255, 255, 255);
            g.setColor(color);

            g.fillOval(xStart + 45, yStart + 35, r - 20, r - 20);
            g.fillOval(xStart + 100, yStart + 35, r - 20, r - 20);
        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;

            Color color = new Color(255, 123, 24);
            g.setColor(color);

            int x[] = { xMiddle - mx / 2 - happy, xMiddle + mx / 2, xMiddle + mx / 2 };
            int y[] = { yMiddle - 50 + sad, yMiddle - 50, yMiddle };
            g.fillPolygon(x, y, 3);

        }
    }

}// Faces class end
