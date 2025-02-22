package src.Core;

import javax.imageio.ImageIO;
import javax.swing.*;

import inputs.MouseInput;
import src.Entity.Bat;
import src.Entity.Enemy;
import src.Entity.Pig;
import src.Entity.Player;
import src.Screen.GameScreen;
import src.Screen.KeyHandle;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GamePanle extends JPanel implements Runnable {
    private BufferedImage backGround;
    KeyHandle keyHandle = new KeyHandle();
    Thread gameThread;
    private MouseInput mouseInput;
    private int targetX = -1, targetY = -1;
    int FPS = 60;

    private Random random = new Random();
    private int spawnTimer = 0;
    private final int SPAWN_INTERVAL = 300;

    private final Player player;
    private final Spawner spawner;
    private final Renderer renderer;

    public GamePanle() {
        mouseInput = new MouseInput(this);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
         try {
         //Đọc ảnh từ file
         backGround = ImageIO.read(new File("image/BackGround.png"));
         //this.setBackground(Color.GRAY);

         } catch (IOException e) {//Bắt lỗi nếu không đọc được ảnh
            e.printStackTrace();
         }
        //this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);
        this.requestFocus();

        player = new Player( 100, 110, 5);
        spawner = new Spawner();
        renderer = new Renderer(player, spawner);

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
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
            // 1. Update: cập nhât trạng thái của các đối tượng trong game
            // 2. Render: Vẽ các đối
            // 3. Delay: Dừng game lại 1 chút
        }
    }
    public void changeRectPos(int x, int y) {
        targetX = x;
        targetY = y;
    }
    
    public void update() {
        if (targetX >= 0 && targetY >= 0) { // Kiểm tra vị trí hợp lệ
            int dx = targetX - player.getX();
            int dy = targetY - player.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
    
            if (distance > player.getSpeed()) {
                player.setX(player.getX() + (int) ((dx / distance) * player.getSpeed()));
                player.setY(player.getY() + (int) ((dy / distance) * player.getSpeed()));
            } else {
                System.out.println("Reached Target: " + targetX + ", " + targetY);
                player.setX(targetX);
                player.setY(targetY);
                targetX = -1;
                targetY = -1; // Reset vị trí đích
            }
        }
    
        player.update(keyHandle);
    }
    
    

    // Vẽ ảnh lên
    @Override
    public void paintComponent(Graphics g) {// Hàm paintComponent để vẽ ảnh lên
        super.paintComponent(g);
        //g.drawImage(backGround, 0, 0, GameScreen.with, GameScreen.height, null);
        renderer.render((Graphics2D) g);
    }
}