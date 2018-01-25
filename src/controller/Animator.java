package controller;

import java.util.concurrent.TimeUnit;
import model.ExplosionGenerator;
import model.GameData;
import view.MainWindow;

public class Animator implements Runnable {

    public boolean running = true;
    public String gameStatus = "Begin";
    private final int FRAMES_PER_SECOND = 40;
    private boolean alive = true;
    private ExplosionGenerator generator = new ExplosionGenerator();
    @Override
    public void run() {

        while (running) {
            long startTime = System.currentTimeMillis();
            if(gameStatus.equals("Started"))
            {
                processCollisions();

                Main.gameData.update();
                Main.gamePanel.gameRender();
                Main.gamePanel.printScreen();
            }
            long endTime = System.currentTimeMillis();
            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
            }
        }
        //System.exit(0);
    }
    private void processCollisions() {
        if(alive)
        {
        for (model.GameFigure f : Main.gameData.friendFigures)
        {
            for(model.GameFigure e : Main.gameData.enemyFigures)
            {
                if(e.getCollisionBox().intersects(f.getCollisionBox()))
                {
                    if(e instanceof model.Asteroid)
                    {
                        model.Asteroid tempAsteroid = (model.Asteroid)e;
                        switch(GameData.shooter.weapon){
                            case "Bullet":
                                tempAsteroid.decreaseHealth(15);
                                break;
                            case "Missile":
                                tempAsteroid.decreaseHealth(50);
                                break;
                            case "Bomb":
                                tempAsteroid.decreaseHealth(100);
                                break;
                            default:
                        }
                        if(f instanceof model.Shooter)
                        {
                            Main.gamePanel.shooter.health -= 5;
                            tempAsteroid.goNext();
                        }
                        if(tempAsteroid.getHealth() <= 0){
                            tempAsteroid.goNext();
                            Main.gameData.increaseScore(5);
                        }
                        
                    }
                    if(e instanceof model.IceRock)
                    {
                        model.IceRock tempAsteroid = (model.IceRock)e;
                        switch(GameData.shooter.weapon){
                            case "Bullet":
                                tempAsteroid.decreaseHealth(15);
                                break;
                            case "Missile":
                                tempAsteroid.decreaseHealth(50);
                                break;
                            case "Bomb":
                                tempAsteroid.decreaseHealth(100);
                                break;
                            default:
                        }
                        if(f instanceof model.Shooter)
                        {
                            Main.gamePanel.shooter.health -= 5;
 
                        }
                        if(tempAsteroid.getHealth() <= 0){
                            tempAsteroid.goNext();
                            Main.gameData.increaseScore(10);
                        }
                    }
                    if(e instanceof model.SmallAsteroid)
                    {
                        model.SmallAsteroid tempAsteroid = (model.SmallAsteroid)e;
                        switch(GameData.shooter.weapon){
                            case "Bullet":
                                tempAsteroid.decreaseHealth(15);
                                break;
                            case "Missile":
                                tempAsteroid.decreaseHealth(50);
                                break;
                            case "Bomb":
                                tempAsteroid.decreaseHealth(100);
                                break;
                            default:
                        }
                        
                        if(f instanceof model.Shooter)
                        {
                            Main.gamePanel.shooter.health -= 5;
                            tempAsteroid.goNext();
                        }
                        if(tempAsteroid.getHealth() <= 0){
                            tempAsteroid.goNext();
                            Main.gameData.increaseScore(1);
                        }
                    }
                    if(e instanceof model.AlienSprinter)
                    {
                        model.AlienSprinter tempAsteroid = (model.AlienSprinter)e;
                        switch(GameData.shooter.weapon){
                            case "Bullet":
                                tempAsteroid.decreaseHealth(15);
                                break;
                            case "Missile":
                                tempAsteroid.decreaseHealth(50);
                                break;
                            case "Bomb":
                                tempAsteroid.decreaseHealth(100);
                                break;
                            default:
                        }
                        if(f instanceof model.Shooter)
                        {
                            Main.gamePanel.shooter.health -= 25;
                            tempAsteroid.goNext();
                        }
                        if(tempAsteroid.getHealth() <= 0){
                            tempAsteroid.goNext();
                            Main.gameData.increaseScore(20);
                        }
                    }
                    if(f instanceof model.Bullet)
                        f.state = model.GameFigureState.STATE_DONE;
                    if(f instanceof model.Missile)
                        f.state = model.GameFigureState.STATE_DONE;
                    if(f instanceof model.Bomb)
                        f.state = model.GameFigureState.STATE_DONE;
                    if(Main.gamePanel.shooter.health <= 0)
                    {
                        f.state = model.GameFigureState.SHOOTER_STATE_HEALTH_LEVEL_1;
                        alive = false;
                    }
                    MainWindow.scoreLabel.setText("Score: " + Main.gameData.getScore());
                    MainWindow.waveLabel.setText("Wave: " + Main.gameData.wave);
                }
                
            }
        }
        }
    }

}
