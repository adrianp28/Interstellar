
package model;

/**
 * Participant: ConcreteState
 */
public class SmallAsteroidDestroyed implements SmallAsteroidState {
    public SmallAsteroidDestroyed()
    {
        
    }
    @Override
    public void goNext(SmallAsteroid contextAsteroid)
    {
        contextAsteroid.setState(null);
        contextAsteroid.setAnimation(null);
    } 
}
