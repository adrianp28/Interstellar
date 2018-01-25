package model;

import controller.Main;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class AlienSprinter extends GameFigure {

    public final int width = 80;
    public final int height = 80;
    private int health;
    public Image image;
    public Point2D.Float target;
    public static final int UNIT_TRAVEL_DISTANCE = 10; // per frame move
    public float dx;
    public float dy;
    public int explodingTime = 0;
    public int explodingImage = 0;
    AlienState alienState;
    AlienAnimation alienAnimation;

    public AlienSprinter(float sx, float sy, float tx, float ty, int health) {
        super(sx, sy);
        alienState = new AlienFlyingState();
        alienAnimation = new AlienFlyingAnimation();
        this.target = new Point2D.Float(tx, ty);
        this.health = health;
        double angle = Math.atan2(ty - sy, tx - sx);
        dx = (float) (UNIT_TRAVEL_DISTANCE * Math.cos(angle));
        dy = (float) (UNIT_TRAVEL_DISTANCE * Math.sin(angle));
        try {
            image = ImageIO.read(getClass().getResource("aliem.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(alienAnimation != null)
            alienAnimation.render(g, this);
    }

    @Override
    public void update() {
        if(alienAnimation != null)
            alienAnimation.update(this);
    }
    public void setState(AlienState state)
    {
        if(alienState != null)
            this.alienState = state;
    }
    public void setAnimation(AlienAnimation animation)
    {
        this.alienAnimation = animation;
    }
    public void goNext()
    {
        if(alienState != null)
            this.alienState.goNext(this);
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
