
package model;

import java.awt.Graphics2D;

/**
 * Participant: Strategy
 */
public interface AlienAnimation {
    
    void update(AlienSprinter context);
    void render(Graphics2D g, AlienSprinter context);
    
}
