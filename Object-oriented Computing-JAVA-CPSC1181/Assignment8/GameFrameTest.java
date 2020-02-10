import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameFrameTest extends JFrame {
	static JLabel blankCardLabel;
    static JLabel cardOne;
    JLabel cardTwo;
    JLabel cardThree;
    JLabel cardFour;
    JLabel cardFive;
    JLabel cardSix;
    JLabel cardSeven;
    JLabel cardEight;
    JLabel cardNine;
    JLabel cardTen;
    JLabel cardEleven;
    JLabel cardTwelve;
    JLabel cardThirteen;
    JLabel cardFourteen;
     BufferedImage blankCardPic;
    JLabel deck;
	BufferedImage revealCardPic;
    JPanel eastPanel;
    JPanel southPanel;
    JPanel messagePanel;
    JPanel cardPanel;
    BoxLayout eastPanelBL;
    BoxLayout southPanelBL;
    BoxLayout cardPanelBL;
    JLabel playerOne = new JLabel("Player One");
    JLabel playerTwo = new JLabel("Player Two");
    JLabel playerThree = new JLabel("Player Three");
    JLabel playerFour = new JLabel("Player Four");
    JLabel c;
	 public GameFrameTest() {
        setLayout(new BorderLayout());
		add(new JLabel("Memory Game", SwingConstants.CENTER), BorderLayout.NORTH);
		deck = new JLabel(new ImageIcon(blankCard()));
        cardOne = new JLabel(new ImageIcon(blankCard()));
        cardTwo = new JLabel(new ImageIcon(blankCard()));
        cardThree = new JLabel(new ImageIcon(blankCard()));
        cardFour = new JLabel(new ImageIcon(blankCard()));
        cardFive = new JLabel(new ImageIcon(blankCard()));
        cardSix = new JLabel(new ImageIcon(blankCard()));
        cardSeven = new JLabel(new ImageIcon(blankCard()));
        cardEight = new JLabel(new ImageIcon(blankCard()));
        cardNine = new JLabel(new ImageIcon(blankCard()));
        cardTen = new JLabel(new ImageIcon(blankCard()));
        cardEleven = new JLabel(new ImageIcon(blankCard()));
        cardTwelve = new JLabel(new ImageIcon(blankCard()));
        cardThirteen = new JLabel(new ImageIcon(blankCard()));
        cardFourteen = new JLabel(new ImageIcon(blankCard()));
		cardPanel = new JPanel();
        cardPanelBL = new BoxLayout(cardPanel, BoxLayout.Y_AXIS);
        cardPanel.setLayout(cardPanelBL);

        JPanel topRowPanel = new JPanel();
		
		topRowPanel.add(cardOne);
        topRowPanel.add(cardTwo);
        topRowPanel.add(cardThree);
        topRowPanel.add(cardFour);
        topRowPanel.add(cardFive);
        topRowPanel.add(cardSix);
        topRowPanel.add(cardSeven);
        cardPanel.add(topRowPanel);
		
		JPanel bottomRowPanel = new JPanel();
        bottomRowPanel.add(cardEight);
        bottomRowPanel.add(cardNine);
        bottomRowPanel.add(cardTen);
        bottomRowPanel.add(cardEleven);
        bottomRowPanel.add(cardTwelve);
        bottomRowPanel.add(cardThirteen);
        bottomRowPanel.add(cardFourteen);
        cardPanel.add(bottomRowPanel);
		
		add(cardPanel,BorderLayout.CENTER);
        //cardOne.setBounds(50,50,50,50);
        eastPanel = new JPanel();
        eastPanelBL = new BoxLayout(eastPanel, BoxLayout.Y_AXIS);
        eastPanel.setLayout(eastPanelBL);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        eastPanel.add(playerOne);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        eastPanel.add(playerTwo);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        eastPanel.add(playerThree);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        eastPanel.add(playerFour);
        add(eastPanel, BorderLayout.EAST);  
        southPanel = new JPanel(new BorderLayout());
        southPanel.add(new JTextArea(10,10),BorderLayout.CENTER);
        messagePanel = new JPanel(new BorderLayout());
        messagePanel.add(new JTextField(10),BorderLayout.CENTER);
        messagePanel.add(new JButton("Send"),BorderLayout.EAST);
        southPanel.add(messagePanel,BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH); 
		
	}
	
		
public BufferedImage blankCard() {
        try {
            blankCardPic = ImageIO.read(new File("cecilia.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return blankCardPic;
    }
}