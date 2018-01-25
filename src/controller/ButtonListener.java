package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AlienSprinter;
import model.GameData;
import model.Shooter;
import view.MainWindow;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == MainWindow.startButton) {
            Main.animator.gameStatus = "Started";
            Main.gameData.wave = 1;
            Main.gameData.enemyFigures.clear();
            Main.gameData.score = 0;
            Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
            shooter.health = 100;
            MainWindow.scoreLabel.setText("Score: " + Main.gameData.getScore());
            MainWindow.waveLabel.setText("Wave: " + Main.gameData.wave);
            MainWindow.startButton.enable(false);
        } else if (ae.getSource() == MainWindow.quitButton) {
            if (Main.animator.running) {
                Main.animator.running = false;
            } else {
                System.exit(0);
            }
        }
        else if (ae.getSource() == MainWindow.addUfoButton){
            Main.gameData.addUFO();
        }
    }

}
