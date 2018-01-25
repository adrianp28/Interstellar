
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class AlienFlyingAnimation implements AlienAnimation{
    @Override
    public void update(AlienSprinter context) {
        double angle = Math.atan2(GameData.shooter.y - context.y, GameData.shooter.x - context.x);
            context.dx = (float) (context.UNIT_TRAVEL_DISTANCE * Math.cos(angle));
            context.dy = (float) (context.UNIT_TRAVEL_DISTANCE * Math.sin(angle));
            context.x += context.dx;
            context.y += context.dy;
    }
    @Override
    public void render(Graphics2D g, AlienSprinter context) {
        g.drawImage(context.image, (int)context.x, (int)context.y, null);
    }  
}
