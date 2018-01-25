
package model;

import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class SmallAsteroidExplodingAnimation implements SmallAsteroidAnimation {
    @Override
    public void update(SmallAsteroid contextAsteroid) {
        contextAsteroid.setState(new SmallAsteroidDestroyed());
        contextAsteroid.setAnimation(new SmallAsteroidDestroyingAnimation());
    }
    @Override
    public void render(Graphics2D g, SmallAsteroid contextAsteroid) {
    
    }
}
