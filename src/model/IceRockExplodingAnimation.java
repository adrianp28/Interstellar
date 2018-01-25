
package model;

import java.awt.Graphics2D;
import javafx.scene.paint.Color;

/**
 * Participant: ConcreteStrategy
 */
public class IceRockExplodingAnimation implements IceRockAnimation {
    
    @Override
    public void update(IceRock contextAsteroid) {
        contextAsteroid.explosionRadius += 5;
        if(contextAsteroid.explosionRadius  >= 100)
        {
            contextAsteroid.setAnimation(new IceRockDestroyedAnimation());
            contextAsteroid.setState(new IceRockDestroyedState());
        }
    }
    @Override
    public void render(Graphics2D g, IceRock contextAsteroid) {
        g.setColor(new java.awt.Color(3, 169, 244));
        g.fillOval((int)(contextAsteroid.x - contextAsteroid.explosionRadius), (int)(contextAsteroid.y - contextAsteroid.explosionRadius), 
                    contextAsteroid.explosionRadius * 2, contextAsteroid.explosionRadius * 2);
    }
}
