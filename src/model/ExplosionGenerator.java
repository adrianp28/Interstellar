
package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ExplosionGenerator {
    private Image[] images;
    public ExplosionGenerator()
    {
        images = new Image[21];
        try {
            String fileName = "Images\\l0_sprite_explosion01.png";
            for(int i = 0; i < 21; i++)
            {
                if(i <=8)
                    fileName = "Images\\l0_sprite_explosion0"+Integer.toString(i+1)+".png";
                else
                    fileName = "Images\\l0_sprite_explosion"+Integer.toString(i+1)+".png";
                images[i] = ImageIO.read(getClass().getResource(fileName));
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    public Image getImage(int i){
        return images[i];
    }

}
