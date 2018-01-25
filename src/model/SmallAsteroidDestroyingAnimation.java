
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class SmallAsteroidDestroyingAnimation implements SmallAsteroidAnimation {
    @Override
    public void update(SmallAsteroid contextAsteroid) {
        Main.gameData.enemyFigures.remove(contextAsteroid);
    }
    @Override
    public void render(Graphics2D g, SmallAsteroid contextAsteroid) {
    
    } 
    
}
