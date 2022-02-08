package mvcproject.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;

public class InitialFrame extends JFrame {

    private final JMenuItem eaglesMenuItem;
    private final JMenuItem falconsMenuItem;
    private final JMenuItem giantsMenuItem;
    private final InitialPanel initialPanel;

    InitialFrame() {
        super("My Frame");
        initialPanel = new InitialPanel();
        add(initialPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBarTeamSet = new JMenuBar();
        JMenu menuTeamSet = new JMenu("Set your team");
        eaglesMenuItem = new JMenuItem("Eagles");
        falconsMenuItem = new JMenuItem("Falcons");
        giantsMenuItem = new JMenuItem("Giants");

        menuTeamSet.add(eaglesMenuItem);
        menuTeamSet.add(falconsMenuItem);
        menuTeamSet.add(giantsMenuItem);
        menuTeamSet.setOpaque(true);
        menuTeamSet.setBackground(Color.LIGHT_GRAY);
        menuBarTeamSet.add(menuTeamSet);

        this.setJMenuBar(menuBarTeamSet);

        getContentPane().add(initialPanel);

        setSize(1024, 768);
        setVisible(true);
    }

    public InitialPanel getInitialPanel() {
        return initialPanel;
    }

    public JMenuItem getEaglesMenuItem() {
        return eaglesMenuItem;
    }

    public JMenuItem getFalconsMenuItem() {
        return falconsMenuItem;
    }

    public JMenuItem getGiantsMenuItem() {
        return giantsMenuItem;
    }

}
