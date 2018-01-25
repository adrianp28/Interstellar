
package model;

/**
 * Participant: ConcreteState
 */
public class IceRockFlyingState implements IceRockState {
    public IceRockFlyingState()
    {
        
    }
    @Override
    public void goNext(IceRock contextAsteroid)
    {
        contextAsteroid.setState(new IceRockExplodingState());
        contextAsteroid.setAnimation(new IceRockExplodingAnimation());
    } 
    
}
