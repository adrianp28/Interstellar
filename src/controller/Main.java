package controller;

import javax.swing.JFrame;
import model.GameData;
import view.GamePanel;
import view.MainWindow;

public class Main {

    public static GamePanel gamePanel;
    public static GameData gameData;
    public static Animator animator;

    public static int WIN_WIDTH = 1500;
    public static int WIN_HEIGHT = 800;

    public static void main(String[] args) {

        animator = new Animator();
        gameData = new GameData();
        gamePanel = new GamePanel();

        JFrame game = new MainWindow();
        game.setTitle("p8 Tyler Stewart");
        game.setSize(WIN_WIDTH, WIN_HEIGHT);
        game.setLocation(0, 0);
        game.setResizable(false); // window size cannot change
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);

        // start animation
        new Thread(animator).start();

    }
}
