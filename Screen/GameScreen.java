package Screen;
import javax.swing.JFrame;

public class GameScreen extends JFrame  {

    private static final int originalTileSize =  16; //16x16
    private static final int scale = 3;
    public static final int tileSize = originalTileSize * scale;//48x48
    private static final int maxScreenCol = 16;
    private static final int maxScreenRow = 12;
    public static final int with = tileSize * maxScreenCol;//768
    public static final int height = tileSize * maxScreenRow;//576
    private GamePanle backGround = new GamePanle();


    public GameScreen() {
        this.add(backGround);
        setTitle("Game hay nhat the gioi");
        setSize(with, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setVisible(true);
    }
    public void startGame() {
        backGround.startGame();
    }

    
}
