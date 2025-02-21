package entity;

import Screen.GameScreen;
import Screen.KeyHandle;

import java.awt.*;

public class Player extends Entity{
    public Player(int x, int y, int speed) {
        setX(x);
        setY(y);
        setSpeed(speed);
    }
    public void update(KeyHandle keyHandle) {
        if (keyHandle.upPressed == true) {
            setY(getY() - getSpeed());
        }
        if (keyHandle.downPressed == true) {
            setY(getY() + getSpeed());
        }
        if (keyHandle.leftPressed == true) {
            setX(getX() - getSpeed());
        }
        if (keyHandle.rightPressed == true) {
            setX(getX() + getSpeed());
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), GameScreen.tileSize, GameScreen.tileSize);
    }
}
