
package model;

/**
 * Participant: ConcreteState
 */
public class SmallAsteroidExploding implements SmallAsteroidState {
    public SmallAsteroidExploding()
    {
        
    }
    @Override
    public void goNext(SmallAsteroid contextAsteroid)
    {
        contextAsteroid.setState(new SmallAsteroidDestroyed());
        contextAsteroid.setAnimation(new SmallAsteroidDestroyingAnimation());
    } 
    
}
