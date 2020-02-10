//package memoryGame;
import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

private JButton buttonRestart;
private JLabel labelScore;
private JLabel labelMesseges;
private BorderLayout borderLayout;
int score = 0;

public BottomPanel(){

    borderLayout = new BorderLayout();
    setLayout(borderLayout);
    buttonRestart = new JButton("Restart");
    buttonRestart.setPreferredSize(new Dimension(150,50));
    labelMesseges = new JLabel();
    labelScore = new JLabel("" + labelScore, SwingConstants.CENTER);
    labelScore.setPreferredSize(new Dimension(50,50));

    labelMesseges.setText(" ");
    labelMesseges.setBorder(BorderFactory.createMatteBorder(0,2,0,2,Color.black));

    labelScore.setFont(new Font("Courier", Font.BOLD, 16));
    labelScore.setText("36");

    add(buttonRestart);
    add(labelMesseges);
    add(labelScore);
    borderLayout.addLayoutComponent(buttonRestart, BorderLayout.WEST);
    borderLayout.addLayoutComponent(labelMesseges,BorderLayout.CENTER);
    borderLayout.addLayoutComponent(labelScore,BorderLayout.EAST);
}
}