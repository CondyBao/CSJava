package SpaceInvaders;

public class Player extends SpaceThing{
    private int speed;

    public Player(int speed, int x, int y, int w, int h, String imgName) {
        super(x, y, w, h, imgName);
        this.speed = speed;
    }
}
