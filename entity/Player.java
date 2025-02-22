package entity;

import Screen.GameScreen;
import Screen.KeyHandle;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.plaf.InputMapUIResource;

public class Player extends Entity {
    public String dt;

    public Player(int x, int y, int speed) {
        setX(x);
        setY(y);
        setSpeed(speed);
        dt = "idle";
        try {
            setupDrawDefault();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void update(KeyHandle keyHandle) {
        if (keyHandle.upPressed == true) {
            if (dt != "up") {

                setCurrentFrame(0);
                setFrameCounter(0);
                setTotalFrame(8);
                if (dt == "left") {
                    try {
                        setImage(
                                ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Run_Left.png")));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    dt = "up";
                } else if (dt == "right") {
                    try {
                        setImage(ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Run.png")));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    dt = "up";
                } else {
                    dt = "up";
                }
            }
            setY(getY() - getSpeed());
        }
        if (keyHandle.downPressed == true) {
            if (dt != "down") {

                setCurrentFrame(0);
                setFrameCounter(0);
                setTotalFrame(8);
                if (dt == "left") {
                    try {
                        setImage(
                                ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Run_Left.png")));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    dt = "down";
                } else if (dt == "right") {
                    try {
                        setImage(ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Run.png")));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    dt = "down";
                } else {
                    dt = "down";
                }
            }
            setY(getY() + getSpeed());
        }
        if (keyHandle.leftPressed == true) {
            if (dt != "left") {
                dt = "left";
                setCurrentFrame(0);
                setFrameCounter(0);
                setTotalFrame(8);
                try {
                    setImage(ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Run.png")));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                setImage(flipImage(getImage(), true, false));
            }
            setX(getX() - getSpeed());
        }
        if (keyHandle.rightPressed == true) {
            if (dt != "right") {
                dt = "right";
                setCurrentFrame(0);
                setFrameCounter(0);
                setTotalFrame(8);
                try {
                    setImage(ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Run.png")));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            setX(getX() + getSpeed());
        }
        if (!keyHandle.upPressed
                && !keyHandle.downPressed
                && !keyHandle.leftPressed
                && !keyHandle.rightPressed) {

            if (!dt.equals("idle")) {
                try {
                    setupDrawDefault();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (dt.equals("left")) {
                    setImage(flipImage(getImage(), true, false));
                }
                dt = "idle";
            }
        }
        setFrameCounter(getFrameCounter() + 1);
        if (getFrameCounter() >= getFrameDelay()) {
            setFrameCounter(0);
            setCurrentFrame((getCurrenFame() + 1) % getTotalFrame());
        }

    }

    private void setupDrawDefault() throws IOException {
        setFrameWith(32);
        setFrameHeight(32);
        setTotalFrame(4);
        setCurrentFrame(0);
        setFrameDelay(25);
        setFrameCounter(0);
        setImage(ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/Player_Idle.png")));
    }

    public void draw(Graphics2D g) {

        int frameX = getCurrenFame() * getFrameWith();
        BufferedImage currentSprite = getImage().getSubimage(frameX, 0, getFrameWith(), getFrameHeight());
        g.drawImage(currentSprite, getX(), getY(), getFrameWith() * 2, getFrameHeight() * 2, null);

        // g.setColor(Color.BLUE);
        // g.fillRect(getX(), getY(), GameScreen.tileSize, GameScreen.tileSize);
    }
}
