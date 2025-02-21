package Screen;
import javax.swing.JFrame;

public class GameScreen extends JFrame {
    public static final int with = (int) (685*1.5);
    public static final int height = (int) (384*1.5);
    private BackGround backGround = new BackGround();
    public GameScreen() {
        this.add(backGround);
        setTitle("Game hay nhat the gioi");
        setSize(with, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setVisible(true);
        backGround = new BackGround();
        
    }
    
    public static void main(String[] args) {
        new GameScreen();
    }
}
