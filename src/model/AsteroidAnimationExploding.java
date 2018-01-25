
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class AsteroidAnimationExploding implements AsteroidAnimation{
    @Override
    public void update(Asteroid contextAsteroid) {
        Main.gameData.add(3, contextAsteroid.x, contextAsteroid.y);
        contextAsteroid.setAnimation(new AsteroidAnimationDestroyed());
        contextAsteroid.setState(new AsteroidDestroyed());
    }
    @Override
    public void render(Graphics2D g, Asteroid contextAsteroid) {
        
    }
}
