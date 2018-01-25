package model;

import view.GamePanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameData {

    private final int RADIUS = 6;
    public final List<GameFigure> enemyFigures;
    public final List<GameFigure> friendFigures;
    public static Shooter shooter;
    public int score;
    public int wave = 1;
    
    public GameData() {

        enemyFigures = new CopyOnWriteArrayList<>();
        friendFigures = new CopyOnWriteArrayList<>();

        // GamePanel.width, height are known when rendered. 
        // Thus, at this moment,
        // we cannot use GamePanel.width and height.
        shooter = new Shooter(500, 500);

        friendFigures.add(shooter);

        //enemyFigures.add(new FlyingSaucer(50, 60));
        //enemyFigures.add(new FlyingSaucer(400, 20));
        score = 0;
    }
    public void reAdd()
    {
        friendFigures.add(shooter);
    }
    public void add(int n, float x, float y) {
            enemyFigures.add(new SmallAsteroid(
                    (int) (x+10),
                    (int) (y+10),
                    40));
            enemyFigures.add(new SmallAsteroid(
                    (int) (x+10),
                    (int) (y+10),
                    40));
            enemyFigures.add(new SmallAsteroid(
                    (int) (x+10),
                    (int) (y+10),
                    40));
    }
    public void addUFO(){
        enemyFigures.add(new FlyingSaucer((float)(Math.random()*700)-10, (float)(Math.random()*500)-10));
    }
    public void update() {
        
        // no enemy is removed in the program
        // since collision detection is not implemented yet.
        // However, if collision detected, simply set
        // f.state = GameFigure.STATE_DONE
        ArrayList<GameFigure> removeEnemies = new ArrayList<>();
        GameFigure f;
        for (int i = 0; i < enemyFigures.size(); i++) {
            f = enemyFigures.get(i);
            
            if (f.state == GameFigureState.STATE_DONE) {
                //removeEnemies.add(f);
                
            }
        }
        enemyFigures.removeAll(removeEnemies);

        for (GameFigure g : enemyFigures) {
            g.update();
        }

        // missiles are removed if explosion is done
        ArrayList<GameFigure> removeFriends = new ArrayList<>();
        for (int i = 0; i < friendFigures.size(); i++) {
            f = friendFigures.get(i);
            if (f.state == GameFigureState.STATE_DONE) {
                removeFriends.add(f);
            }
        }
        friendFigures.removeAll(removeFriends);

        for (GameFigure g : friendFigures) {
            g.update();
        }
        Random num = new Random();
        int x = num.nextInt(GamePanel.WIDTH);
        int y = num.nextInt(10);
        
        if(num.nextInt(5000) <= wave*10)
        {
            int choice = num.nextInt(3)+1;
            if(choice == 1 || wave == 1)
                enemyFigures.add(new Asteroid(
                        (int) (x),
                        (int) (y),
                        100));
            if(choice == 2 && wave >= 2)
                enemyFigures.add(new IceRock(
                    (int) (Math.random() * GamePanel.width),
                    (int) (Math.random() * GamePanel.height),
                    200));
            if(choice == 3 && wave >= 4)
                enemyFigures.add(new AlienSprinter(
                    10,
                    10,
                    shooter.x, shooter.y, 40));
        }
        if(score >= (wave  * 50) && wave <10)
            wave++;
        
    }
    public void increaseScore(int points)
    {
        score+= points;
    }
    
    public int getScore()
    {
        return score;
    }
}
