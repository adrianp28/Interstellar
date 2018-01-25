
package model;

/**
 * Participant: ConcreteState
 */
public class AlienFlyingState implements AlienState {
    public AlienFlyingState(){
        
    }
    @Override
    public void goNext(AlienSprinter context)
    {
        context.setState(new AlienExplodingState());
        context.setAnimation(new AlienExplodingAnimation());
    } 
    
}
