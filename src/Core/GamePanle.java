package src.Core;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.Entity.Bat;
import src.Entity.Enemy;
import src.Entity.Pig;
import src.Entity.Player;
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
    int FPS = 100;

    private Random random = new Random();
    private int spawnTimer = 0;
    private final int SPAWN_INTERVAL = 300;

    private final Player player;
    private final Spawner spawner;
    private final Renderer renderer;

    public GamePanle() {
        // try {
        // //Đọc ảnh từ file
        // backGround = ImageIO.read(new File("G:/My
        // Drive/BTLJAVA/Game-with-java/image/BackGround.png"));
        // //this.setBackground(Color.GRAY);

        // } catch (IOException e) {//Bắt lỗi nếu không đọc được ảnh
        // e.printStackTrace();
        // }
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);
        this.requestFocus();

        player = new Player(100, 100, 4);
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
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
            // 1. Update: cập nhât trạng thái của các đối tượng trong game
            // 2. Render: Vẽ các đối
            // 3. Delay: Dừng game lại 1 chút
        }
    }

    public void update() {
        player.update(keyHandle);
        spawner.update(player);
    }

    // Vẽ ảnh lên
    public void paintComponent(Graphics g) {// Hàm paintComponent để vẽ ảnh lên
        super.paintComponent(g);
        renderer.render((Graphics2D) g);
    }
}