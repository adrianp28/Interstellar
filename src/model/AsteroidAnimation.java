
package model;

import java.awt.Graphics2D;

/**
 * Participant: Strategy
 */
public interface AsteroidAnimation {
    
    void update(Asteroid context);
    void render(Graphics2D g, Asteroid context);
    
}
