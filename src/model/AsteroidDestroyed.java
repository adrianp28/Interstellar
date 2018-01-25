
package model;

/**
 * Participant: ConcreteState
 */
public class AsteroidDestroyed implements AsteroidState {
    public AsteroidDestroyed(){
        
    }
    @Override
    public void goNext(Asteroid contextAsteroid){
        contextAsteroid.setState(null);
        contextAsteroid.setAnimation(null);
    }
}
