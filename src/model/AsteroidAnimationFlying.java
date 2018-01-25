
package model;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.GamePanel;

/**
 * Participant: ConcreteStrategy
 */
public class AsteroidAnimationFlying implements AsteroidAnimation {

    @Override
    public void update(Asteroid contextAsteroid) {
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
            if(contextAsteroid.getHealth() <= 80)
            {
                try {
                     contextAsteroid.image = ImageIO.read(getClass().getResource("l0_sprite_asteroid_final_initial2.png"));
                 } catch (IOException ex) {
                     JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
                     System.exit(-1);
                }
            }
            if(contextAsteroid.getHealth() <=40)
            {
                try {
                     contextAsteroid.image = ImageIO.read(getClass().getResource("l0_sprite_asteroid_final_initial3.png"));
                 } catch (IOException ex) {
                     JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
                     System.exit(-1);
                }
            }
    }
    @Override
    public void render(Graphics2D g, Asteroid contextAsteroid) {
        g.drawImage(contextAsteroid.image, (int)contextAsteroid.x, (int)contextAsteroid.y, null);
    }
}
