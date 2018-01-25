package model;

import view.GamePanel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class IceRock extends GameFigure {

    public final int width = 100;
    public final int height = 100;
    public int explosionRadius = 50;
    private int health;
    public Image image;
    public int dx = 3;
    public int dy = 3;
    public final int dr = 3;
    IceRockState iceRockState;
    IceRockAnimation iceRockAnimation;
    public IceRock(float x, float y, int health) {
        super(x, y);
        iceRockState = new IceRockFlyingState();
        iceRockAnimation = new IceRockFlyingAnimation();
        this.health = health;
        try {
            image = ImageIO.read(getClass().getResource("l0_sprite_ice_rock_final1.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(iceRockAnimation != null)
            iceRockAnimation.render(g, this);
    }

    @Override
    public void update() {
        if(iceRockAnimation != null)
            iceRockAnimation.update(this);
    }
    public void setState(IceRockState state)
    {
        this.iceRockState = state;
    }
    public void goNext()
    {
        if(iceRockState != null)
            iceRockState.goNext(this);
    }
    public void setAnimation(IceRockAnimation animation)
    {
        this.iceRockAnimation = animation;
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
        if(iceRockState instanceof IceRockFlyingState)
            return new Rectangle2D.Float(super.x, super.y, width, height);
        else if(iceRockState instanceof IceRockExplodingState)
            return new Rectangle2D.Float(super.x-100, super.y-100, width+100, height+100);
        else
            return new Rectangle2D.Float(super.x, super.y, width, height);
    }
}
