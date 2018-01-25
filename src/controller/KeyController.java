package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.AlienSprinter;
import model.Asteroid;
import model.GameData;
import model.IceRock;
import model.Shooter;
import view.GamePanel;
import view.MainWindow;

public class KeyController extends KeyAdapter {
    Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
    @Override
    public void keyPressed(KeyEvent e) {
        

        // horizontal move only
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                shooter.thrust("West");
                break;
            case KeyEvent.VK_D:
                shooter.thrust("East");
                break;
            case KeyEvent.VK_W:
                shooter.thrust("North");
                break;
            case KeyEvent.VK_S:
                shooter.thrust("South");
                break;
            case KeyEvent.VK_SPACE:
                shooter.switchWeapon();
                break;
            //This is a shortcut
            case KeyEvent.VK_P:
                Main.gameData.wave++;
                MainWindow.waveLabel.setText("Wave: " + Main.gameData.wave);
                break;
            case KeyEvent.VK_C:
                Main.gameData.enemyFigures.add(new AlienSprinter(
                    10,
                    10,
                    shooter.x, shooter.y, 40));
                break;
            case KeyEvent.VK_X:
                Main.gameData.enemyFigures.add(new IceRock(
                    (int) (Math.random() * GamePanel.width),
                    (int) (Math.random() * GamePanel.height),
                    200));
                break;
            case KeyEvent.VK_Z:
                Main.gameData.enemyFigures.add(new Asteroid(
                    (int) (Math.random() * GamePanel.width),
                    (int) (Math.random() * GamePanel.height),
                    100));
                break;
            case KeyEvent.VK_L:
                Main.gameData.enemyFigures.clear();
                break;
                
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                shooter.slowDown();
                break;
            case KeyEvent.VK_D:
                shooter.slowDown();
                break;
            case KeyEvent.VK_W:
                shooter.slowDown();
                break;
            case KeyEvent.VK_S:
                shooter.slowDown();
                break;
    }

}
}
