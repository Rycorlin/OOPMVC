package mvcproject.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private final JButton playerIcon = new JButton();
    private final JButton enemyIcon1 = new JButton("Tackler1");
    private final JButton enemyIcon2 = new JButton("Tackler2");

    private final JLabel textStart = new JLabel("Press enter to start the game...");
    private final JLabel textStart2 = new JLabel("Use arrow keys to make it past the tacklers!");

    GamePanel() {
        super();
        Color backgroundColor = Color.decode("#21B6A8");
        setBackground(backgroundColor);
        setLayout(null);
        add(playerIcon);
        add(enemyIcon1);
        add(enemyIcon2);
        add(textStart);
        add(textStart2);
        textStart.setBounds(new Rectangle(375, 200, 200, 100));
        textStart2.setBounds(new Rectangle(375, 300, 300, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
    }

    public void moveEnemy1(int x, int y) {
        getEnemyIcon1().setBounds(new Rectangle(x, y, 100, 50));
    }

    public void moveEnemy2(int x, int y) {
        getEnemyIcon2().setBounds(new Rectangle(x, y, 100, 50));
    }

    public JButton getPlayerIcon() {
        return playerIcon;
    }

    public JButton getEnemyIcon1() {
        return enemyIcon1;
    }

    public JButton getEnemyIcon2() {
        return enemyIcon2;
    }

    public JLabel getTextStart() {
        return textStart;
    }

    public JLabel getTextStart2() {
        return textStart2;
    }
}
