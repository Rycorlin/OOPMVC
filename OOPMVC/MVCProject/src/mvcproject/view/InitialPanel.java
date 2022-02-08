package mvcproject.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class InitialPanel extends JPanel {

    private final GamePanel gamePanel;
    private final ScorePanel scorePanel;

    InitialPanel() {
        super();
        setBackground(Color.green);
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        scorePanel = new ScorePanel();
        gamePanel = new GamePanel();

        add(scorePanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

}
