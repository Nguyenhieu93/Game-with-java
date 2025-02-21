package Screen;
import javax.imageio.ImageIO;
import javax.swing.*;

import player.player;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class BackGround extends JPanel implements Runnable {
    private BufferedImage backGround;
    KeyHandle keyHandle = new KeyHandle();
    Thread gameThread;
    int FPS = 60;
    player plr = new player();
    public BackGround() {
        try {
            //Đọc ảnh từ file
            backGround = ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/BackGround.png"));
            //this.setBackground(Color.GRAY);

        } catch (IOException e) {//Bắt lỗi nếu không đọc được ảnh
            e.printStackTrace();
        }
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);
    }
    
    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            update();
            repaint();
            double remaining = nextDrawTime - System.nanoTime();
            remaining = remaining / 1000000;
            try {
                if (remaining < 0 ){
                    remaining = 0;
                }
                Thread.sleep( (long) (remaining));
                nextDrawTime +=  drawInterval;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //1. Update: cập nhât trạng thái của các đối tượng trong game
            //2. Render: Vẽ các đối
            //3. Delay: Dừng game lại 1 chút
        }
    }
    public void update(){
        if (keyHandle.upPressed == true) {
            plr.setY(plr.getY() - plr.getSpeed());
            System.out.println("up");
        }
        else if (keyHandle.downPressed == true) {
            plr.setY(plr.getY() + plr.getSpeed());
        }
        else if (keyHandle.leftPressed == true) {
            plr.setX(plr.getX() - plr.getSpeed());
        }
        else if (keyHandle.rightPressed == true) {
            plr.setX(plr.getX() + plr.getSpeed());
        }
    }
    public void repaint(){
        
    }
    //Vẽ ảnh lên
    public void paintComponent(Graphics g) {//Hàm paintComponent để vẽ ảnh lên
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.BLACK);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(plr.getX(), plr.getY(), GameScreen.tileSize, GameScreen.tileSize);
        g2d.dispose();
    }
}