
package model;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.GamePanel;

/**
 * Participant: ConcreteStrategy
 */
public class IceRockFlyingAnimation implements IceRockAnimation {
    
    @Override
    public void update(IceRock contextAsteroid) {
        contextAsteroid.x += contextAsteroid.dx;
            contextAsteroid.y += contextAsteroid.dy;

            if(contextAsteroid.x > GamePanel.width)
            {
                contextAsteroid.x = 0 - contextAsteroid.width;
            }
            else if (contextAsteroid.x < 0 - contextAsteroid.width-10)
            {
                contextAsteroid.x = GamePanel.width;
            }
            if(contextAsteroid.y > GamePanel.height)
            {
                contextAsteroid.y = 0 - contextAsteroid.height;
            }
            else if (contextAsteroid.y < 0 - contextAsteroid.height-10)
            {
                contextAsteroid.y = GamePanel.height;
            }
            String imageString = "l0_sprite_ice_rock_final1.png";
            if(contextAsteroid.getHealth() <= 180)
                imageString = "l0_sprite_ice_rock_final2.png";
            if(contextAsteroid.getHealth() <= 140)
                imageString = "l0_sprite_ice_rock_final3.png";
            if(contextAsteroid.getHealth() <= 120)
                imageString = "l0_sprite_ice_rock_final4.png";
            if(contextAsteroid.getHealth() <= 100)
                imageString = "l0_sprite_ice_rock_final5.png";
            if(contextAsteroid.getHealth() <= 60)
                imageString = "l0_sprite_ice_rock_final6.png";
            if(contextAsteroid.getHealth() <= 60)
                imageString = "l0_sprite_ice_rock_final7.png";
            if(contextAsteroid.getHealth() <= 40)
                imageString = "l0_sprite_ice_rock_final8.png";
            if(contextAsteroid.getHealth() <= 20)
                imageString = "l0_sprite_ice_rock_final9.png";
            try {
                     contextAsteroid.image = ImageIO.read(getClass().getResource(imageString));
                 } catch (IOException ex) {
                     JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
                     System.exit(-1);
                }
    }
    @Override
    public void render(Graphics2D g, IceRock contextAsteroid) {
        g.drawImage(contextAsteroid.image, (int)contextAsteroid.x, (int)contextAsteroid.y, null);
    }
}
