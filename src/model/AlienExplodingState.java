
package model;

/**
 * Participant: ConcreteState
 */
public class AlienExplodingState implements AlienState {
    public AlienExplodingState(){
        
    }
    @Override
    public void goNext(AlienSprinter context)
    {
        context.setState(new AlienDestroyedState());
        context.setAnimation(new AlienDestroyedAnimation());
    }  
    
}
