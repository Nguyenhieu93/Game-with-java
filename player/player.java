package player;

public class player {
    private int x;
    private int y;
    private int speed = 5;
    public player(){
        x = 100;
        y = 100;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getSpeed(){
        return speed;
    }
}
