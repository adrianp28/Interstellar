
package model;

/**
 * Participant: ConcreteState
 */
public class IceRockDestroyedState implements IceRockState {
    public IceRockDestroyedState()
    {
        
    }
    @Override
    public void goNext(IceRock contextAsteroid)
    {
        contextAsteroid.setState(null);
        contextAsteroid.setAnimation(null);
    } 
    
}
