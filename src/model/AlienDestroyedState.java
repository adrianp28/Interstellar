
package model;

/**
 * Participant: ConcreteState
 */
public class AlienDestroyedState implements AlienState {
    public AlienDestroyedState(){
        
    }
    @Override
    public void goNext(AlienSprinter context)
    {
        context.setState(null);
        context.setAnimation(null);
    }  
    
}
