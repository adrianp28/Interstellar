package view;

import controller.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import model.GameFigure;
import model.Shooter;

public class GamePanel extends JPanel {

    // size of the canvas - determined at runtime once rendered
    public static int width;
    public static int height;

    // off screen rendering
    private Graphics2D g2;
    private Image dbImage = null; // double buffer image
    public Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
    public void gameRender() {
        width = getSize().width;
        height = getSize().height;
        if (dbImage == null) {
            // Creates an off-screen drawable image to be used for double buffering
            dbImage = createImage(width, height);
            if (dbImage == null) {
                System.out.println("Critical Error: dbImage is null");
                System.exit(1);
            } else {
                g2 = (Graphics2D) dbImage.getGraphics();
            }
        }

        g2.clearRect(0, 0, width, height);
        g2.setBackground(Color.BLACK);
       // Random num = new Random();
        //g2.setColor(Color.YELLOW);
//        for(int i = 0; i < 50; i++)
//        {
//            g2.fillOval(num.nextInt(width), num.nextInt(height), 4, 4);
//        }
        //Health Bar
        g2.setColor(new Color(3, 169, 244));
        Font gameFont = new Font("Monospaced", 0, 16);
        g2.setFont(gameFont);
        g2.drawString("Health:", 50, 540);
        g2.setColor(Color.RED);
        g2.fillRect(10, 560, shooter.health*3, 30);
        g2.setColor(Color.WHITE);
        g2.drawRect(10, 560, 300, 30);
        //Weapon Heat
        g2.setColor(new Color(3, 169, 244));
        g2.setFont(gameFont);
        g2.drawString("Gun Heat:", 50, 620);
        if(shooter.weaponHeat >= 55)
            g2.setColor(Color.BLUE);
        else if(shooter.weaponHeat >= 25)
            g2.setColor(Color.YELLOW);
        else
            g2.setColor(Color.RED);
        g2.fillRect(10, 640, shooter.weaponHeat*3, 30);
        g2.setColor(Color.WHITE);
        g2.drawRect(10, 640, 300, 30);
        g2.drawString("Weapon Selection:", 340, 570);
        g2.setColor(new Color(3, 169, 244));
        g2.drawString("Bullets", 340, 590);
        g2.drawString("Missiles", 340, 610);
        g2.drawString("Bombs", 340, 630);
        g2.setColor(Color.YELLOW);
        if(shooter.weapon.equals("Bullet"))
            g2.drawRect(330, 575, 100, 20);
        else if(shooter.weapon.equals("Missile"))
            g2.drawRect(330, 595, 100, 20);
        else
            g2.drawRect(330, 615, 100, 20);
        Font gameFont2 = new Font("Monospaced", 0, 32);
        g2.setFont(gameFont2);
        g2.setColor(Color.YELLOW);
        
        if(shooter.health <=0)
        {
            g2.drawString("Game Over!", 600, 400);
        }
        if (Main.animator.running && Main.animator.gameStatus.equals("Started")) {

            for (GameFigure f : Main.gameData.enemyFigures) {
                f.render(g2);
            }

            for (GameFigure f : Main.gameData.friendFigures) {
                f.render(g2);
            }

        }
    }

    // use active rendering to put the buffered image on-screen
    public void printScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            if (g != null) {
                g.dispose();
            }
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }
}
