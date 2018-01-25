package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainWindow extends JFrame {

    public static JButton startButton;
    public static JButton quitButton;
    public static JButton addUfoButton;
    public static MouseController mouseController;
    public static JLabel scoreLabel;
    public static JLabel waveLabel;
    public static JLabel titleLabel;
    public static Font gameFont;
    public static Font menuFont;
    public MainWindow() {

        Container c = getContentPane();

        c.add(Main.gamePanel, "Center");
        menuFont = new Font("Monospaced", 1, 32);
        gameFont = new Font("Monospaced", 0, 16);
        titleLabel = new JLabel("Interstellar");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(menuFont);
        
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.YELLOW);
        scoreLabel.setFont(gameFont);
        waveLabel = new JLabel("Wave: 1");
        waveLabel.setForeground(Color.RED);
        waveLabel.setFont(gameFont);
        JPanel northPanel = new JPanel(new GridLayout(1, 5));
        northPanel.setBackground(Color.black);
        northPanel.setBackground(Color.black);
        northPanel.add(titleLabel);
        northPanel.add(scoreLabel);
        northPanel.add(waveLabel);
        startButton = new JButton("Start");
        startButton.setBackground(new Color(3, 169, 244));
        startButton.setForeground(Color.WHITE);
        northPanel.add(startButton);
        quitButton = new JButton("Quit");
        quitButton.setBackground(Color.BLACK);
        quitButton.setForeground(Color.WHITE);
        northPanel.add(quitButton);
        


        c.add(northPanel, "North");
        ButtonListener buttonListener = new ButtonListener();
        startButton.addActionListener(buttonListener);
        quitButton.addActionListener(buttonListener);

        mouseController = new MouseController();
        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        Main.gamePanel.addKeyListener(keyListener);
        Main.gamePanel.setFocusable(true);
        // just have one Component "true", the rest must be "false"
        startButton.setFocusable(false);
        quitButton.setFocusable(false);
    }

}
