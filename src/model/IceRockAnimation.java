
package model;

import java.awt.Graphics2D;

/**
 * Participant: Strategy
 */
public interface IceRockAnimation {
    
    void update(IceRock context);
    void render(Graphics2D g, IceRock context);
}
