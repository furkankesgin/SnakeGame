import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame f=new JFrame("Graphics");
        MyPanel p = new MyPanel();
        f.addKeyListener(p);
        f.add(p);
        f.setBounds(100, 100, 500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        Timer t = new Timer(100, p);
        t.start();
    }

}

class MyPanel extends JComponent implements ActionListener,KeyListener {
    int Vx=20,Vy=0;
    Rectangle2D.Float [] rect=new Rectangle2D.Float[10];
    public MyPanel() {
        for (int i = 0; i < rect.length; i++) {
            rect[i]=new Rectangle2D.Float(i*20, 0, 20, 20);
        }
    }


    Random rand = new Random();


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int can = 0;
        for (Rectangle2D.Float r : rect) {

            if(can % 2 == 0) {
                g2.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
                g2.fill(r);
            }

            else {
                g2.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));;
                g2.fill(r);
            }
            can++;
        }
    }
    public void actionPerformed(ActionEvent e) {



        for (int i = 0; i <rect.length-1; i++) {
            rect[i].x = rect[i+1].x;
            rect[i].y = rect[i+1].y;
        }
        rect[9].x += Vx;
        rect[9].y += Vy;
        repaint();
    }
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                Vy= -20;
                Vx = 0;
                break;

            case KeyEvent.VK_DOWN:
                Vy = 20;
                Vx = 0;
                break;
            case KeyEvent.VK_LEFT:
                Vx=-20;
                Vy=0;
                break;
            case KeyEvent.VK_RIGHT:
                Vx=20;
                Vy=0;
                break;
        }

    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}
