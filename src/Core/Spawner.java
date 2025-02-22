package src.Core;

import java.util.ArrayList;
import java.util.Random;

import src.Entity.Bat;
import src.Entity.Pig;
import src.Entity.Player;

public class Spawner {
    private final ArrayList<Bat> bats;
    private final ArrayList<Pig> pigs;
    private final Random random;
    private int spawnTimer;
    private static final int SPAWN_INTERVAL = 300;

    public Spawner() {
        bats = new ArrayList<>();
        pigs = new ArrayList<>();
        random = new Random();
        spawnTimer = 0;
    }

    public void update(Player player) {
        spawnTimer++;
        if (spawnTimer >= SPAWN_INTERVAL) {
            spawnBat();
            spawnPig();
            spawnTimer = 0;
        }
        for (Bat bat : bats) {
            bat.update(player);
        }
        for (Pig pig : pigs) {
            pig.update(player);
        }
    }

    private void spawnBat() {
        int x = random.nextInt(800 - 50);
        int y = random.nextInt(600 - 50);
        bats.add(new Bat(x, y, 2));
    }

    private void spawnPig() {
        int x = random.nextInt(800 - 50);
        int y = random.nextInt(600 - 50);
        pigs.add(new Pig(x, y, 2));
    }

    public ArrayList<Bat> getBats() {
        return bats;
    }

    public ArrayList<Pig> getPigs() {
        return pigs;
    }
}
