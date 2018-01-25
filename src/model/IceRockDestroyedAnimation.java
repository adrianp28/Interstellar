
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class IceRockDestroyedAnimation implements IceRockAnimation {
    
    @Override
    public void update(IceRock contextAsteroid) {
        Main.gameData.enemyFigures.remove(contextAsteroid);
    }
    @Override
    public void render(Graphics2D g, IceRock contextAsteroid) {
        
    }
}
