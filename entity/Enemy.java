package entity;

import Screen.GameScreen;
import java.awt.*;

public class Enemy extends Entity {
    public Enemy(int x, int y, int speed) {
        setX(x);
        setY(y);
        setSpeed(speed);
    }

    public void update(Player player) {
        double dx = player.getX() - this.getX();
        double dy = player.getY() - this.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance != 0) {
            this.setX(this.getX() + (int) ((dx / distance) * getSpeed()));
            this.setY(this.getY() + (int) ((dy / distance) * getSpeed()));
        }
    }

    // public void draw(Graphics2D g) {
    //     g.setColor(Color.RED);
    //     g.fillRect(getX(), getY(), GameScreen.tileSize, GameScreen.tileSize);
    // }
}
