
package model;

import controller.Main;
import java.awt.Graphics2D;

/**
 * Participant: ConcreteStrategy
 */
public class AlienExplodingAnimation implements AlienAnimation{
    ExplosionGenerator generator;
    
    public AlienExplodingAnimation()
    {
        generator = new ExplosionGenerator();
    }
    @Override
    public void update(AlienSprinter context) {
        
        context.explodingTime++;
        System.out.println(context.explodingTime);
        if(context.explodingImage >= 21)
        {
            System.out.println("CHese");
            context.setAnimation(new AlienDestroyedAnimation());
            context.setState(new AlienDestroyedState());
            
        }
    }
    @Override
    public void render(Graphics2D g, AlienSprinter context) {
        if(context.explodingTime% 2 == 0 && context.explodingImage < 21){
            System.out.println("Yay");
            g.drawImage(generator.getImage(context.explodingImage), (int)context.x, (int)context.y, null);
            context.explodingImage++;
            
        }
    } 
    
}
