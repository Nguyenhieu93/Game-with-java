package inputs;

import src.Core.GamePanle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    private GamePanle gamePanel;
    public MouseInput(GamePanle gamePanel){
        this.gamePanel = gamePanel;

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Mouse Dragged");
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Mouse Moved");
        //gamePanel.changeRectPos(e.getX(),e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gamePanel.changeRectPos(e.getX(), e.getY());
        System.out.println("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
