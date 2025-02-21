package Screen;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class BackGround extends JPanel {
    private BufferedImage backGround;
    public BackGround() {
        //try {
            //Đọc ảnh từ file
            //backGround = ImageIO.read(new File("G:/My Drive/BTLJAVA/Game-with-java/image/BackGround.png"));
            this.setBackground(Color.GRAY);

        // } catch (IOException e) {//Bắt lỗi nếu không đọc được ảnh
        //     e.printStackTrace();
        // }
    }
    //Vẽ ảnh lên
    @Override
    public void paintComponent(Graphics g) {//Hàm paintComponent để vẽ ảnh lên
        super.paintComponent(g);
        //g.setColor(Color.BLACK);
        //g.drawImage(backGround, 0, 0, GameScreen.with,GameScreen.height, null);
            
        //g.dispose();
    }
}