//package memoryGame;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{

private BorderLayout borderLayout;
//private BottomPanel bottomPanel;
//private ButtonsPanel buttonsPanel;

public MainPanel(){

    borderLayout = new BorderLayout(1,1);

    setLayout(borderLayout);

    //buttonsPanel = new ButtonsPanel();
    //bottomPanel = new BottomPanel();

    //add(buttonsPanel);
    //add(bottomPanel);
   // borderLayout.addLayoutComponent(buttonsPanel, BorderLayout.CENTER);
    //borderLayout.addLayoutComponent(bottomPanel, BorderLayout.SOUTH);
}
}