import java.awt.*;
 import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

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

public class GameFrame extends JFrame{
	private JPanel controlPanel;
	private JPanel controlPanel1;
	private ArrayList<JPanel> panels;
	private JLabel cardOne;
	private JLabel cardTwo;
    private JLabel cardThree;
    private JLabel cardFour;
    private JLabel cardFive;
    private JLabel cardSix;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JCheckBox redCheckBox;
	private JCheckBox greenCheckBox;
	private JCheckBox blueCheckBox;
	private ActionListener listener;
	private ActionListener listener2;
	BufferedImage blankCardPic;
   
   public GameFrame()  {
	   createPanelInfo();
	   panels= new ArrayList<JPanel>();
	   //createPanel();  
   }
	class ChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent event){

		}
	}

	public void createPanel(){
	
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(5, 4));
		controlPanel.setLocation(200,200);
		controlPanel.setPreferredSize(new Dimension(800, 800));
		controlPanel.setBackground(Color.GREEN);
		//for(int i =0; i< 10; i++) {
			JPanel temp = new JPanel();
			panels.add(temp);
			temp.setLocation(0, 0);
			//temp.setBorder(new TitledBorder(new EtchedBorder(), "CENTER COLOR"));
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			temp.setPreferredSize(new Dimension(50, 50));
			temp.setBackground(Color.BLUE);
			controlPanel.add(temp);
			add(controlPanel);
		//}
	}
	
	public void createPanelInfo(){
		cardOne = new JLabel(new ImageIcon(blankCard()));
        cardTwo = new JLabel(new ImageIcon(blankCard()));
        cardThree = new JLabel(new ImageIcon(blankCard()));
        cardFour = new JLabel(new ImageIcon(blankCard()));
        cardFive = new JLabel(new ImageIcon(blankCard()));
		
		
		
		
		
		JPanel styleGroupPanel = test();
		JPanel controlPanel = new JPanel();
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 1));
		controlPanel1 = new JPanel();
		controlPanel1.setLayout(new GridLayout(5, 1));
		//controlPanel1.add(test());
		
		 JPanel topRowPanel = new JPanel();
		
		topRowPanel.add(cardOne);
        topRowPanel.add(cardTwo);
        topRowPanel.add(cardThree);
        topRowPanel.add(cardFour);
        topRowPanel.add(cardFive);
		controlPanel1.add(topRowPanel);
		add(controlPanel, BorderLayout.NORTH);
	add(controlPanel1);
		
    
		
      
	}
	public JPanel test() {
		listener2= new ChoiceListener();
		ImageIcon image = new ImageIcon("smile.jpg");
		button1= new JButton("Player1");
		button1.addActionListener(listener2);
		
		




		
		ButtonGroup group1 = new ButtonGroup();
		
		//button1.setSelected(true);
	   group1.add(button1);
     
		      
		JPanel panel = new JPanel();
	   panel.add(button1);
	   
	 setContentPane(panel);
		
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Game"));

	   return panel;
      
	}
	public JPanel createRadioButtons() {
		listener= new ChoiceListener();
		radioButton1 = new JRadioButton("Player1");
		radioButton1.addActionListener(listener);
		radioButton2 = new JRadioButton("Player2");
		radioButton2 .addActionListener(listener);
		
		radioButton2.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		      
		JPanel panel = new JPanel();
		panel.add(radioButton1);
		panel.add(radioButton2);
		
		
		
		
		panel.setBorder(new TitledBorder(new EtchedBorder(), "PLAYERS"));

	   return panel;
      
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