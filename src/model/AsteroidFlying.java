
package model;
/**
 * Participant: ConcreteState
 */
public class AsteroidFlying implements AsteroidState {
    public AsteroidFlying()
    {
        
    }
    @Override
    public void goNext(Asteroid contextAsteroid)
    {
        contextAsteroid.setState(new AsteroidExploding());
        contextAsteroid.setAnimation(new AsteroidAnimationExploding());
    }
}
