//package memoryGame;

import javax.swing.*;
import java.awt.*;

public class MemoryGame extends JFrame {

    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 900;

    private MainPanel mainPanel;

    public MemoryGame() {

        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("Memory Game");

         mainPanel = new MainPanel();

        add(mainPanel);

        setVisible(true);
    }
}
