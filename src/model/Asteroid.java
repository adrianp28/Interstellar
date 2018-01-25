package model;

import controller.Main;
import view.GamePanel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Asteroid extends GameFigure {

    public final int width = 140;
    public final int height = 140;
    private int health;
    public Image image;
    public int dx;
    public int dy;
    AsteroidState asteroidState;
    AsteroidAnimation asteroidAnimation;

    public Asteroid(float x, float y, int health) {
        super(x, y);
        this.health = health;
        asteroidState = new AsteroidFlying();
        asteroidAnimation = new AsteroidAnimationFlying();
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
            image = ImageIO.read(getClass().getResource("l0_sprite_asteroid_final_initial1.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(asteroidAnimation != null)
            asteroidAnimation.render(g, this);
    }

    @Override
    public void update() {
        if(asteroidAnimation != null)
            asteroidAnimation.update(this);
    }
    
    public void goNext()
    {
        if(asteroidState != null)
            asteroidState.goNext(this);
    }
    public void decreaseHealth(int damage)
    {
        this.health -= damage;
    }
    public int getHealth()
    {
        return this.health;
    }
    public void setState(AsteroidState state) {
        this.asteroidState = state;
    }
    public void setAnimation(AsteroidAnimation animation){
        this.asteroidAnimation = animation;
    }
    @Override
    public Rectangle2D.Float getCollisionBox(){
        return new Rectangle2D.Float(super.x, super.y, width, height);
    }
}
