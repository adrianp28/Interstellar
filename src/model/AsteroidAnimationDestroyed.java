
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class AsteroidAnimationDestroyed implements AsteroidAnimation{
    @Override
    public void update(Asteroid contextAsteroid) {
        Main.gameData.enemyFigures.remove(contextAsteroid);
    }
    @Override
    public void render(Graphics2D g, Asteroid contextAsteroid) {
        
    } 
    
}
