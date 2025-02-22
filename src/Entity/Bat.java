package src.Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import src.Screen.GameScreen;

public class Bat extends Enemy {

    public Bat(int x, int y, int speed) {
        super(x, y, speed);
        setFrameDelay(5);
        setFrameWith(46);
        setFrameHeight(30);
        setTotalFrame(7);
        setCurrentFrame(0);
        setFrameCounter(0);
        try {
            setImage(ImageIO.read(new File("image/Flying (46x30).png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Player player) {
        super.update(player);
        setFrameCounter(getFrameCounter() + 1);
        if (getFrameCounter() >= getFrameDelay()) {
            setFrameCounter(0);
            setCurrentFrame((getCurrenFame() + 1) % getTotalFrame());
        }
    }

    // @Override
    public void draw(Graphics2D g) {
        int frameX = getCurrenFame() * getFrameWith();
        BufferedImage currentSprite = getImage().getSubimage(frameX, 0, getFrameWith(), getFrameHeight());
        g.drawImage(currentSprite, getX(), getY(), getFrameWith() * 2, getFrameHeight() * 2, null);
    }

}
