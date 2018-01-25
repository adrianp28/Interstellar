
package model;

import java.awt.Graphics2D;

/**
 * Participant: Strategy
 */
public interface SmallAsteroidAnimation {
    
    void update(SmallAsteroid context);
    void render(Graphics2D g, SmallAsteroid context);
    
}
