package SpaceInvaders;

import java.awt.*;

public class PlayerLaser extends Laser{
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), 5, 10);
    }

    public PlayerLaser(int x, int y){
        super(x, y);
        setSpeed(-5);
    }
}
