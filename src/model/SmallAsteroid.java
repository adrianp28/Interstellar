package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SmallAsteroid extends GameFigure {

    public final int width = 100;
    public final int height = 100;
    private int health;
    public Image image;
    public int dx;
    public int dy;
    SmallAsteroidState smallAsteroidState;
    SmallAsteroidAnimation smallAsteroidAnimation;

    public SmallAsteroid(float x, float y, int health) {
        super(x, y);
        smallAsteroidState = new SmallAsteroidFlying();
        smallAsteroidAnimation = new SmallAsteroidFlyingAnimation();
        this.health = health;
        Random number = new Random();
        if(number.nextInt(2) == 0)
            dx = number.nextInt(4)+1;
        else
            dx = -(number.nextInt(4)+1);
        if(number.nextInt(2) == 0)
            dy = number.nextInt(4)+1;
        else
            dy = -(number.nextInt(4)+1);
                
        try {
            image = ImageIO.read(getClass().getResource("l0_sprite_asteroid_breaking_final1.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(smallAsteroidAnimation != null)
            smallAsteroidAnimation.render(g, this);
    }

    @Override
    public void update() {
        if(smallAsteroidAnimation != null)
            smallAsteroidAnimation.update(this);
    }
    public void setState(SmallAsteroidState state)
    {
        this.smallAsteroidState = state;
    }
    public void setAnimation(SmallAsteroidAnimation animation){
        this.smallAsteroidAnimation = animation;
    }
    public void goNext()
    {
        if(smallAsteroidState != null)
            smallAsteroidState.goNext(this);
    }
    public void decreaseHealth(int damage)
    {
        this.health -= damage;
    }
    public int getHealth()
    {
        return this.health;
    }
    @Override
    public Rectangle2D.Float getCollisionBox(){
        return new Rectangle2D.Float(super.x, super.y, width, height);
    }
}
