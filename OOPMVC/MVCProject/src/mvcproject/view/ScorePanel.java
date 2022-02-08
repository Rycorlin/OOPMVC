package mvcproject.view;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    private final JLabel scoreBoard = new JLabel("0");

    private final JLabel tackleCount = new JLabel("0");
    private final JSlider gameSpeed = new JSlider(1, 10, 5);
    private final JSlider enemyMove = new JSlider(1, 10, 5);

    ScorePanel() {
        super();
        Color color = Color.decode("#CBFFFA");
        setBackground(color);

        JLabel playerMoveSpeed = new JLabel("Player Move Speed");
        JLabel enemyMoveSpeed = new JLabel("Enemy Move Speed");

        playerMoveSpeed.setForeground(Color.red);
        enemyMoveSpeed.setForeground(Color.red);

        JLabel showScore = new JLabel("Touchdowns: ");
        add(showScore);
        add(scoreBoard);
        add(playerMoveSpeed);
        add(gameSpeed);
        add(enemyMove, BorderLayout.CENTER);
        add(enemyMoveSpeed);
        JLabel tackleDisplay = new JLabel("Tackled: ");
        add(tackleDisplay);
        add(tackleCount);
        setFocusable(false);

        gameSpeed.setMinorTickSpacing(1);
        gameSpeed.setMajorTickSpacing(1);
        gameSpeed.setPaintTicks(true);
        gameSpeed.setPaintLabels(true);
        gameSpeed.setFocusable(false);

        enemyMove.setMinorTickSpacing(1);
        enemyMove.setMajorTickSpacing(1);
        enemyMove.setPaintTicks(true);
        enemyMove.setPaintLabels(true);
        enemyMove.setFocusable(false);
    }


    public JLabel getScoreBoard() {
        return scoreBoard;
    }

    /**
     * @return the tackleCount
     */
    public JLabel getTackleCount() {
        return tackleCount;
    }

    public JSlider getGameSpeed() {
        return gameSpeed;
    }

    public JSlider getEnemyMove() {
        return enemyMove;
    }
}
