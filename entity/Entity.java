package entity;

import java.awt.image.BufferedImage;
public class Entity {
    private int x;
    private int y;
    private int speed ;
    private int frameWith;
    private int frameHeight;
    private int totalFrames;
    private int currentFrame;
    private int frameDelay;
    private int frameCounter;

    private BufferedImage image;
    public void setImage(BufferedImage image){
        this.image = image;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setSpeed(int speed){
        this.speed = speed;
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
    public void setFrameWith(int with){
        this.frameWith = with;
    }
    public int getFrameWith(){
        return this.frameWith;
    }
    public void setFrameHeight(int height){
        this.frameHeight = height;
    }
    public int getFrameHeight(){
        return this.frameHeight;
    }
    public void setTotalFrame(int total){
        this.totalFrames = total;
    }
    public int getTotalFrame(){
        return this.totalFrames;
    }
    public void setCurrentFrame(int current){
        this.currentFrame = current;
    }
    public int getCurrenFame(){
        return this.currentFrame;
    }
    public void setFrameDelay(int delay){
        this.frameDelay = delay;
    }
    public int getFrameDelay(){
        return this.frameDelay;
    }
    public void setFrameCounter(int counter){
        this.frameCounter = counter;
    }
    public int getFrameCounter(){
        return this.frameCounter;
    }
}
