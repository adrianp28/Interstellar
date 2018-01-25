
package model;

/**
 * Participant: ConcreteState
 */
public class AsteroidExploding implements AsteroidState {
    public AsteroidExploding(){
        
    }
    @Override
    public void goNext(Asteroid contextAsteroid)
    {
        contextAsteroid.setState(new AsteroidDestroyed());
        contextAsteroid.setAnimation(new AsteroidAnimationDestroyed());
    }
}
