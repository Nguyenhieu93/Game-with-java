package src.Core;

import src.Entity.Player;
import src.Entity.Bat;
import src.Entity.Pig;
import java.awt.*;

public class Renderer {
    private final Player player;
    private final Spawner spawner;

    public Renderer(Player player, Spawner spawner) {
        this.player = player;
        this.spawner = spawner;
    }

    public void render(Graphics2D g) {
        player.draw(g);
        for (Bat bat : spawner.getBats()) {
            bat.draw(g);
        }
        for (Pig pig : spawner.getPigs()) {
            pig.draw(g);
        }
        g.dispose();
    }
}
