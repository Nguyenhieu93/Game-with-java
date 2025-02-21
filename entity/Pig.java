package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Screen.GameScreen;

public class Pig extends Enemy {
    private BufferedImage spriteSheet;
    private int frameWidth = 36, frameHeight = 30;
    private int totalFrames = 7, currentFrame = 0;
    private int frameDelay = 25, frameCounter = 0;

    public Pig(int x, int y, int speed) {
        super(x, y, speed);
        try {
            spriteSheet = ImageIO.read(new File("image/Idle (36x30).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Player player) {
        super.update(player);
        frameCounter++;
        if (frameCounter >= frameDelay) {
            frameCounter = 0;
            currentFrame = (currentFrame + 1) % totalFrames; // Chuyển frame bay
        }
    }

    // @Override
    public void draw(Graphics2D g) {
        if (spriteSheet != null) {
            int frameX = currentFrame * frameWidth;
            System.out.println(frameX);
            BufferedImage currentSprite = spriteSheet.getSubimage(frameX, 0, frameWidth, frameHeight);
            g.drawImage(currentSprite, getX(), getY(), frameWidth * 2, frameHeight * 2, null);
        } else {
            // Nếu ảnh lỗi, vẽ hình chữ nhật thay thế
            g.setColor(Color.RED);
            g.fillRect(getX(), getY(), GameScreen.tileSize, GameScreen.tileSize);
        }
    }

}
