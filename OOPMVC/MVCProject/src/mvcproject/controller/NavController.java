package mvcproject.controller;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import mvcproject.model.NavModel;
import mvcproject.view.NavView;

public class NavController {

    private final NavModel model;
    private final NavView view;

    public NavController(NavModel model, NavView view) {
        this.model = model;
        this.view = view;
        newKeyListener();
        view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon().setIcon(model.getPlayerIcon());
        view.getInitialFrame().getEaglesMenuItem().addActionListener(listener);
        view.getInitialFrame().getFalconsMenuItem().addActionListener(listener);
        view.getInitialFrame().getGiantsMenuItem().addActionListener(listener);
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Object obj = e.getSource();

            if (obj == model.getTimer()) {
                // Update movement coordinates in Model
                model.updateMovement(view.getInitialFrame().getInitialPanel().getScorePanel().getEnemyMove().getValue());

                // Move Tackle 1 graphic
                view.getInitialFrame().getInitialPanel().getGamePanel().moveEnemy1(model.getTackler1X(), model.getTackler1Y());

                // Move Tackle 2 graphic
                view.getInitialFrame().getInitialPanel().getGamePanel().moveEnemy2(model.getTackler2X(), model.getTackler2Y());

                // Difference between coordinate of player/computer for approx. closeness
                model.updateCoord();

                // Player wins
                if (model.playerHasWon()) {
                    view.getInitialFrame().getInitialPanel().getGamePanel().getTextStart().setBounds(new Rectangle(375, 325, 200, 100));
                    view.getInitialFrame().getInitialPanel().getScorePanel().getScoreBoard().setText(Integer.toString(model.getPlayerScore())); // Change player score
                }

                // Enemy wins
                if (model.enemyHasWon()) {
                    view.getInitialFrame().getInitialPanel().getGamePanel().setBackground(Color.RED);

                    view.getInitialFrame().getInitialPanel().getGamePanel().getTextStart().setBounds(new Rectangle(375, 325, 200, 100));

                    view.getInitialFrame().getInitialPanel().getScorePanel().getTackleCount()
                            .setText(Integer.toString(model.getTackleScore())); // Change enemy score
                }

            }

            // Set Player Icon(Team)
            if (obj == view.getInitialFrame().getEaglesMenuItem()) {
                view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon().setIcon(model.getEaglesIcon());
            }
            if (obj == view.getInitialFrame().getFalconsMenuItem()) {
                view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon().setIcon(model.getFalconsIcon());
            }
            if (obj == view.getInitialFrame().getGiantsMenuItem()) {
                view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon().setIcon(model.getGiantsIcon());
            }
        }
    };

    public void newKeyListener() {

        view.getInitialFrame().getInitialPanel().getGamePanel().addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent keyPressed) {
                int keyCode = keyPressed.getKeyCode();

                if (model.isGameStart()) {
                    if (keyCode == KeyEvent.VK_RIGHT) {

                        model.setPlayerX(model.getX() + view.getInitialFrame().getInitialPanel().getScorePanel().getGameSpeed().getValue());
                        view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon()
                                .setBounds(new Rectangle(model.getX(), model.getY(), 50, 50));
                    }
                    if (keyCode == KeyEvent.VK_LEFT) {
                        model.setPlayerX(model.getX() - view.getInitialFrame().getInitialPanel().getScorePanel().getGameSpeed().getValue());
                        view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon()
                                .setBounds(new Rectangle(model.getX(), model.getY(), 50, 50));
                    }
                    if (keyCode == KeyEvent.VK_UP) {
                        model.setPlayerY(model.getY() - view.getInitialFrame().getInitialPanel().getScorePanel().getGameSpeed().getValue());
                        view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon()
                                .setBounds(new Rectangle(model.getX(), model.getY(), 50, 50));
                    }
                    if (keyCode == KeyEvent.VK_DOWN) {
                        model.setPlayerY(model.getY() + view.getInitialFrame().getInitialPanel().getScorePanel().getGameSpeed().getValue());
                        view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon()
                                .setBounds(new Rectangle(model.getX(), model.getY(), 50, 50));
                    }
                }

                // clear board for starting game
                if (keyCode == KeyEvent.VK_ENTER) {
                    model.initialSetup(listener);
                    view.getInitialFrame().getInitialPanel().getGamePanel().setBackground(Color.decode("#78B833"));
                    view.getInitialFrame().getInitialPanel().getGamePanel().getTextStart().setBounds(new Rectangle(0, 0, 0, 0));
                    view.getInitialFrame().getInitialPanel().getGamePanel().getTextStart2().setBounds(new Rectangle(0, 0, 0, 0));
                    view.getInitialFrame().getInitialPanel().getGamePanel().getPlayerIcon()
                            .setBounds(new Rectangle(model.getX(), model.getY(), 50, 50));
                    view.getInitialFrame().getInitialPanel().getScorePanel().getGameSpeed().setBounds(new Rectangle(0, 0, 0, 0));
                    view.getInitialFrame().getInitialPanel().getScorePanel().getEnemyMove().setBounds(new Rectangle(0, 0, 0, 0));
                }
            }
        });
    }
}
