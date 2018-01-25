
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class AlienDestroyedAnimation implements AlienAnimation{
    @Override
    public void update(AlienSprinter context) {
        
        Main.gameData.enemyFigures.remove(context);
    }
    @Override
    public void render(Graphics2D g, AlienSprinter context) {
        
    } 
    
}
