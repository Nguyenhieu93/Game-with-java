package Screen;
import javax.imageio.ImageIO;
import javax.swing.*;

import entity.Enemy;
import entity.Player;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class GamePanle extends JPanel implements Runnable {
    private BufferedImage backGround;
    KeyHandle keyHandle = new KeyHandle();
    Thread gameThread;
    int FPS = 420;
    Player player = new  Player(100,100,2);
    Enemy enemy = new Enemy(200,200,2);
    public GamePanle() {
        // try {
        //     //Đọc ảnh từ file
        //     backGround = ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/BackGround.png"));
        //     //this.setBackground(Color.GRAY);

        // } catch (IOException e) {//Bắt lỗi nếu không đọc được ảnh
        //     e.printStackTrace();
        // }
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);
        this.requestFocus();
    }
    
    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double detal = 0;
        double lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            detal += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if (detal >= 100) {
                update();
                repaint();
                detal--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
            //1. Update: cập nhât trạng thái của các đối tượng trong game
            //2. Render: Vẽ các đối
            //3. Delay: Dừng game lại 1 chút
        }
    }
    public void update(){
        player.update(keyHandle);
        enemy.update(player);
    }

    //Vẽ ảnh lên
    public void paintComponent(Graphics g) {//Hàm paintComponent để vẽ ảnh lên
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
        enemy.draw(g2d);
        g2d.dispose();
    }
}