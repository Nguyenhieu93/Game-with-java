package entity;

import Screen.GameScreen;
import Screen.KeyHandle;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.plaf.InputMapUIResource;

public class Player extends Entity{
    public String dt;
    public Player(int x, int y, int speed) {
        setX(x);
        setY(y);
        setSpeed(speed);
        dt = "idle";
    }
    public void update(KeyHandle keyHandle) {
        if (keyHandle.upPressed == true) {
            dt = "up";
            setY(getY() - getSpeed());
        }
        if (keyHandle.downPressed == true) {
            dt = "down";
            setY(getY() + getSpeed());
        }
        if (keyHandle.leftPressed == true) {
            dt = "left";
            setX(getX() - getSpeed());
        }
        if (keyHandle.rightPressed == true) {
            dt = "right";
            setX(getX() + getSpeed());
        }
        if (!keyHandle.upPressed
            && !keyHandle.downPressed
            && !keyHandle.leftPressed
            && !keyHandle.rightPressed){
                dt = "idle";
            }
    }
    private void setupDrawDefalt() throws IOException{
        setFrameWith(32);
        setFrameHeight(32);
        setTotalFrame(4);
        setCurrentFrame(0);
        setFrameDelay(25);
        setFrameCounter(0);
        setImage(ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Idle.png")));
    }
    public void draw(Graphics2D g) {
        switch (dt) {
            case "idle":
                int frameX = getCurrenFame() * getFrameWith();
                BufferedImage currentSprite =  getImage().getSubimage(frameX, 0, getFrameWith(), getFrameWith());
                g.drawImage(currentSprite, getX(), getY(), getFrameWith(),getFrameHeight(),null);
                break;
        
            default:
                g.setColor(Color.BLUE);
                g.fillRect(getX(), getY(), GameScreen.tileSize, GameScreen.tileSize);
                break;
        }

    }
}
