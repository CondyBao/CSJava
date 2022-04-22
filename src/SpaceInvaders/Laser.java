package SpaceInvaders;

import java.awt.*;

public abstract class Laser {
    private int x, y, speed, laserHeight, laserWidth;

    public int getX() {
        return x;
    } // return x info

    public int getY() {
        return y;
    } // return y info

    public int getWidth() {
        return laserWidth;
    } // return the laser width

    public int getHeight() {
        return laserHeight;
    } // return the laser height

    public void setWidth(int width) {
        laserWidth = width;
    } // set the laser width

    public void setHeight(int height) {
        laserHeight = height;
    } // set the laser height

    public void move() {
        y += speed;
    } // move the laser according to speed

    public abstract void draw(Graphics g); // abstract method depending on laser type

    public void setSpeed(int speed) {
        this.speed = speed;
    } // set the laser speed depending on laser type

    public Laser(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
