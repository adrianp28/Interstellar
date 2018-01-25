
package model;

/**
 * Participant: ConcreteState
 */
public class SmallAsteroidFlying implements SmallAsteroidState {
    public SmallAsteroidFlying()
    {
        
    }
    @Override
    public void goNext(SmallAsteroid contextAsteroid)
    {
        contextAsteroid.setState(new SmallAsteroidExploding());
        contextAsteroid.setAnimation(new SmallAsteroidExplodingAnimation());
    } 
    
}
