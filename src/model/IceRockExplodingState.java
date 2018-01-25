
package model;

/**
 * Participant: ConcreteState
 */
public class IceRockExplodingState implements IceRockState {
    public IceRockExplodingState()
    {
        
    }
    @Override
    public void goNext(IceRock contextAsteroid)
    {
        contextAsteroid.setState(new IceRockDestroyedState());
        contextAsteroid.setAnimation(new IceRockDestroyedAnimation());
    }  
    
}
