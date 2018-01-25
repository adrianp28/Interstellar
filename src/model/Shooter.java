package model;

import controller.Main;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.MainWindow;

public class Shooter extends GameFigure {
    
    Line2D.Float barrel;
    Rectangle2D.Float base;
    private final int WIDTH = 150;
    private final int HEIGHT = 150;
    public int health = 100;
    public int weaponHeat = 100;
    private int weaponHeatTime = 0;
    public String weapon;
    private int thrustx = 0, thrusty = 0;
    private boolean thrusting;
    private String direction;
    private Image image;
    private double imageAngleRad = 0;
    public boolean overheated = false;
    ExplosionGenerator generator;
    public int explodingTime = 0;
    public int explodingImage = 0;
    public Shooter(int x, int y) {
        super(x, y);
        generator = new ExplosionGenerator();
        thrusting = false;
        direction = "North";
        weapon = "Bullet";
        super.state = GameFigureState.SHOOTER_STATE_HEALTH_LEVEL_5;
        try {
            image = ImageIO.read(getClass().getResource("l0_sprite_spaceship_final01.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(state == GameFigureState.SHOOTER_STATE_HEALTH_LEVEL_5)
        {
            int cx = WIDTH / 2;
            int cy = HEIGHT / 2;
            AffineTransform oldAT = g.getTransform();
            g.translate(cx+super.x, cy+super.y);
            double dx = MainWindow.mouseController.x - super.x;
            double dy = MainWindow.mouseController.y - super.y;
            imageAngleRad = Math.atan2(dy, dx);
            g.rotate(imageAngleRad);
            g.translate(-cx, -cy);
            g.drawImage(image, 0, 0, null);
            g.setTransform(oldAT);

            if(thrusting)
            {
                switch(direction)
                {
                    case "North":
                        if(thrusty <=14)
                            thrusty+=2;
                        if(!checkBounds("North"))
                            super.y -= thrusty;
                        break;
                    case "South":
                        if(thrusty <=14)
                            thrusty+=2;
                        if(!checkBounds("South"))
                            super.y += thrusty;
                        break;
                    case "East":
                        if(thrustx <=14)
                            thrustx+=2;
                        if(!checkBounds("East"))
                            super.x += thrustx;
                        break;
                    case "West":
                        if(thrustx <=14)
                            thrustx+=2;
                        if(!checkBounds("West"))
                            super.x -= thrustx;
                        break;
                    default:
                        break;
                }
            }
            else
            {
                switch(direction)
                {
                    case "North":
                        if(thrusty >4)
                            thrusty-=2;
                        if(!checkBounds("North"))
                            super.y -= thrusty;
                        break;
                    case "South":
                        if(thrusty >4)
                            thrusty-=2;
                        if(!checkBounds("South"))
                            super.y += thrusty;
                        break;
                    case "East":
                        if(thrustx >4)
                            thrustx-=2;
                        if(!checkBounds("East"))
                            super.x += thrustx;
                        break;
                    case "West":
                        if(thrustx >4)
                            thrustx-=2;
                        if(!checkBounds("West"))
                            super.x -= thrustx;
                        break;
                    default:
                        break;
                }
            }
        }
        else{
            if(explodingTime% 2 == 0 && explodingImage < 21){
                System.out.println("Yay");
                g.drawImage(generator.getImage(explodingImage), (int)x, (int)y, null);
                explodingImage++;
            
            }
        }
    }

    @Override
    public void update() {
        if(state == GameFigureState.SHOOTER_STATE_HEALTH_LEVEL_5)
        {
            // no periodic update is required (not animated)
            // if health level is implemented, update level
            // update is done via 'translate' when a key is pressed
            if(weaponHeat < 10)
                overheated = true;
            if(!overheated)
            {
                if(weaponHeat < 100)
                {
                    weaponHeat+=1;
                }
            }
            else{
                weaponHeatTime++;
                if(weaponHeatTime >= 100)
                {
                    weaponHeat = 11;
                    weaponHeatTime = 0;
                    overheated = false;
                }
            }
        }
        else{
            explodingTime++;
        
            if(explodingImage >= 21)
            {
                state =GameFigureState.STATE_DONE;
                Main.animator.gameStatus = "GameOver";
            }
        }
    }

    public void translate(int dx, int dy) {
        super.x += dx;
        super.y += dy;
    }
    public void thrust(String direction)
    {
        thrusting = true;
        this.direction = direction;
    }
    public void slowDown()
    {
        thrusting = false;
    }
    public boolean checkBounds(String direction)
    {
        switch(direction)
        {
            case "North":
                if (super.y - thrusty <= 0)
                    return true;
                break;
            case "South":
                if(super.y +thrusty >= Main.WIN_HEIGHT - 150)
                    return true;
                break;
            case "East":
                if(super.x +thrustx >= Main.WIN_WIDTH - 150)
                    return true;
                break;
            case "West":
                if(super.x -thrustx <= 0)
                    return true;
                break;
            default:
                
                break;
        }
        return false;
    }
    public void setImage(String url)
    {
        try {
            image = ImageIO.read(getClass().getResource(url));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }
    // Missile shoot location: adjut x and y to the image
    public float getXofMissileShoot() {
        return super.x + WIDTH/2;
    }
    
    public float getYofMissileShoot() {
        
        return super.y + HEIGHT / 2;
    }
    public void switchWeapon()
    {
        switch (weapon){
            case "Bullet":
                weapon = "Missile";
                break;
            case "Missile":
                weapon = "Bomb";
                break;
            case "Bomb":
                weapon = "Bullet";
                break;
        }
    }
    @Override
    public Rectangle2D.Float getCollisionBox(){
        return new Rectangle2D.Float(super.x, super.y, WIDTH-70, HEIGHT-70);
    }
}
