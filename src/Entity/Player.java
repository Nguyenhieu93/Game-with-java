
package src.Entity;

import src.Screen.GameScreen;
import src.Screen.KeyHandle;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.plaf.InputMapUIResource;
import src.Screen.GameScreen;
import src.Screen.KeyHandle;

public class Player extends Entity {
    public String dt;
    public String flip;
    public Player(int x, int y, int speed) {
        setX(x);
        setY(y);
        setSpeed(speed);

        dt = "idle";
        flip = "right";
        try {
            setupDrawDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(KeyHandle keyHandle) {
        String tempFlip = flip;
        if (keyHandle.upPressed || keyHandle.downPressed || keyHandle.leftPressed || keyHandle.rightPressed) {
            if (keyHandle.upPressed) {
                if (!dt.equals("up")) {
                    setCurrentFrame(0);
                    setFrameCounter(0);
                    setTotalFrame(8);
                    if (flip.equals("left")) {
                        try {
                            setImage(
                                    ImageIO.read(new File("image/Player_Run.png")));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        setImage(flipImage(getImage(), true, false));
                        dt = "up";
                    } else {
                        try {
                            setImage(ImageIO.read(new File("image/Player_Run.png")));
                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                        dt = "up";
                    }
                }
                setY(getY() - getSpeed());
            }
            if (keyHandle.downPressed) {
                if (!dt.equals("down")) {

                    setCurrentFrame(0);
                    setFrameCounter(0);
                    setTotalFrame(8);
                    if (flip.equals("left")) {
                        try {
                            setImage(
                                    ImageIO.read(new File("image/Player_Run.png")));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        setImage(flipImage(getImage(), true, false));
                        dt = "down";
                    } else {
                        try {
                            setImage(ImageIO.read(new File("image/Player_Run.png")));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        dt = "down";
                    }
                }
                setY(getY() + getSpeed());
            }
            if (keyHandle.leftPressed) {
                if (!dt.equals("left")) {
                    dt = "left";
                    setCurrentFrame(0);
                    setFrameCounter(0);
                    setTotalFrame(8);
                    try {
                        setImage(ImageIO.read(new File("image/Player_Run.png")));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    setImage(flipImage(getImage(), true, false));
                }
                setX(getX() - getSpeed());
            }
            if (keyHandle.rightPressed) {
                if (!dt.equals("right")) {
                    dt = "right";
                    setCurrentFrame(0);
                    setFrameCounter(0);
                    setTotalFrame(8);
                    try {
                        setImage(ImageIO.read(new File("image/Player_Run.png")));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                setX(getX() + getSpeed());
            }

        }else {
            if (!dt.equals("idle")) {
                try {
                    setupDrawDefault();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (dt.equals("left")) {
                    setImage(flipImage(getImage(), true, false));
                    flip = "left";
                }else if( dt.equals("right")) {
                    flip = "right";
                }
                else {
                    if (flip.equals("left")) {
                        setImage(flipImage(getImage(), true, false));
                    }
                }
                dt = "idle";
            }
            else {
                if (flip.equals("left") && !flip.equals(tempFlip)) {
                    setImage(flipImage(getImage(), true, false));
                }
                tempFlip = flip;
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
        setFrameDelay(10);
        setFrameCounter(0);
        setImage(ImageIO.read(new File("image/Player_Idle.png")));
    }

    public void draw(Graphics2D g) {
        int frameX = getCurrenFame() * getFrameWith();
        BufferedImage currentSprite = getImage().getSubimage(frameX, 0, getFrameWith(), getFrameHeight());
        g.drawImage(currentSprite, getX(), getY(), getFrameWith() * 2, getFrameHeight() * 2, null);
    }
}
