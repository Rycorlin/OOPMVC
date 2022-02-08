package mvcproject.model;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NavModel extends JPanel {

    private int playerX = 50;
    private int playerY = 50;
    private int tackler1X = 700;
    private int tackler1Y = 350;
    private int tackler2X = 750;
    private int tackler2Y = 400;

    private boolean gameStart = false;
    private boolean enemyWins = false;
    private boolean playerWins = false;

    private int tackler1xDifference;
    private int tackler1yDifference;
    private int tackler2xDifference;
    private int tackler2yDifference;

    private final ImageIcon iconPlayerImage = new ImageIcon("OOPMVC/MVCProject/images/fbp.jpg");
    private final ImageIcon iconEaglesImage = new ImageIcon("OOPMVC/MVCProject/images/eagles.jpg");
    private final ImageIcon iconFalconsImage = new ImageIcon("OOPMVC/MVCProject/images/falcons.jpg");
    private final ImageIcon iconGiantsImage = new ImageIcon("OOPMVC/MVCProject/images/giants.jpg");

    private final Image imgPlayer = iconPlayerImage.getImage();
    private final Image imgEagles = iconEaglesImage.getImage();
    private final Image imgFalcons = iconFalconsImage.getImage();
    private final Image imgGiants = iconGiantsImage.getImage();

    private final Image scaledPlayer = imgPlayer.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    private final Image scaledEagles = imgEagles.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    private final Image scaledFalcons = imgFalcons.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    private final Image scaledGiants = imgGiants.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);

    private final ImageIcon playerIcon = new ImageIcon(scaledPlayer);
    private final ImageIcon eaglesIcon = new ImageIcon(scaledEagles);
    private final ImageIcon falconsIcon = new ImageIcon(scaledFalcons);
    private final ImageIcon giantsIcon = new ImageIcon(scaledGiants);

    private int playerScore = 0;
    private int tackleScore = 0;

    private Timer timer;
    private int delay = 1000; //milliseconds

    public NavModel() {

    }

    public void updateMovement(int moveSpeed) {
        //Tackler One
        if (getTackler1X() < getX()) {
            setTackler1X(getTackler1X() + moveSpeed);
        }
        if (getTackler1Y() < getY()) {
            setTackler1Y(getTackler1Y() + moveSpeed);
        }
        if (getTackler1X() > getX()) {
            setTackler1X(getTackler1X() - moveSpeed);
        }
        if (getTackler1Y() > getY()) {
            setTackler1Y(getTackler1Y() - moveSpeed);
        }

        //Tackler Two                
        if (getTackler2X() < getX() && getX() > 500) {
            setTackler2X(getTackler2X() + moveSpeed);
        }
        if (getTackler2Y() < getY()) {
            setTackler2Y(getTackler2Y() + moveSpeed);
        }
        if (getTackler2X() > getX() && getX() > 500) {
            setTackler2X(getTackler2X() - moveSpeed);
        }
        if (getTackler2Y() > getY()) {
            setTackler2Y(getTackler2Y() - moveSpeed);
        }
    }

    public void updateCoord() {
        setTackler1xDifference(getTackler1X() - getX());
        setTackler1yDifference(getTackler1Y() - getY());
        setTackler2xDifference(getTackler2X() - getX());
        setTackler2yDifference(getTackler2Y() - getY());
    }

    public boolean playerHasWon() {
        if (getX() > 950) {
            setPlayerScore(getPlayerScore() + 1);
            setPlayerWins(true);
            getTimer().stop();
            setGameStart(false);
        }
        return isPlayerWins();
    }

    public boolean enemyHasWon() {
        if (getTackler1xDifference() < 10 && getTackler1xDifference() > -10 && getTackler1yDifference() < 10 && getTackler1yDifference() > -10) {
            setEnemyWins(true);
            setTackleScore(getTackleScore() + 1);
            getTimer().stop();
            setGameStart(false);
        }
        if (getTackler2xDifference() < 10 && getTackler2xDifference() > -10 && getTackler2yDifference() < 10 && getTackler2yDifference() > -10) {
            setEnemyWins(true);
            setTackleScore(getTackleScore() + 1);
            getTimer().stop();
            setGameStart(false);
        }
        return isEnemyWins();
    }

    public void initialSetup(ActionListener listener) {
        setGameStart(true);
        setPlayerX(50);
        setPlayerY(50);
        setTackler1X(700);
        setTackler1Y(350);
        setTackler2X(750);
        setTackler2Y(400);
        setDelay(1000);
        setEnemyWins(false);
        setPlayerWins(false);
        setDelay(getDelay() / 10);
        setTimer(new Timer(getDelay(), listener));
        getTimer().start();
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getTackler1X() {
        return tackler1X;
    }

    public void setTackler1X(int tackler1X) {
        this.tackler1X = tackler1X;
    }

    public int getTackler1Y() {
        return tackler1Y;
    }

    public void setTackler1Y(int tackler1Y) {
        this.tackler1Y = tackler1Y;
    }

    public int getTackler2X() {
        return tackler2X;
    }

    public void setTackler2X(int tackler2X) {
        this.tackler2X = tackler2X;
    }

    public int getTackler2Y() {
        return tackler2Y;
    }

    public void setTackler2Y(int tackler2Y) {
        this.tackler2Y = tackler2Y;
    }

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    public boolean isEnemyWins() {
        return enemyWins;
    }

    public void setEnemyWins(boolean enemyWins) {
        this.enemyWins = enemyWins;
    }

    public int getTackler1xDifference() {
        return tackler1xDifference;
    }

    public void setTackler1xDifference(int tackler1xDifference) {
        this.tackler1xDifference = tackler1xDifference;
    }

    public int getTackler1yDifference() {
        return tackler1yDifference;
    }

    public void setTackler1yDifference(int tackler1yDifference) {
        this.tackler1yDifference = tackler1yDifference;
    }

    public int getTackler2xDifference() {
        return tackler2xDifference;
    }

    public void setTackler2xDifference(int tackler2xDifference) {
        this.tackler2xDifference = tackler2xDifference;
    }

    public int getTackler2yDifference() {
        return tackler2yDifference;
    }

    public void setTackler2yDifference(int tackler2yDifference) {
        this.tackler2yDifference = tackler2yDifference;
    }

    public ImageIcon getPlayerIcon() {
        return playerIcon;
    }

    public ImageIcon getEaglesIcon() {
        return eaglesIcon;
    }

    public ImageIcon getFalconsIcon() {
        return falconsIcon;
    }

    public ImageIcon getGiantsIcon() {
        return giantsIcon;
    }

    public int getTackleScore() {
        return tackleScore;
    }

    public void setTackleScore(int tackleScore) {
        this.tackleScore = tackleScore;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean isPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(boolean playerWins) {
        this.playerWins = playerWins;
    }

}
