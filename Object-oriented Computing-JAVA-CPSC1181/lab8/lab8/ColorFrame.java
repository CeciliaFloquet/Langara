import java.awt.*;
 import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ColorFrame extends JFrame{
   private JPanel controlPanel;
   private JPanel controlPanel2;
   private JPanel controlPanel3;
   private JPanel controlPanel4;
   private JPanel controlPanel5;
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
     private static final int WIDTH = 1000;
   private static final int HEIGHT = 1000;
   
   public ColorFrame()  {
      createControlPanel();
      setSize(1000, 1000);  
   }
    class ChoiceListener implements ActionListener{
         public void actionPerformed(ActionEvent event){
            setSampleColor( event);
			
         }
      }
	  
   public void setSampleColor(ActionEvent event){
       Object src = event.getSource();
	   //button
      if(src== button1){
         controlPanel5.setBackground(Color.RED);
		
      }
     if(src== button2){
         controlPanel5.setBackground(Color.GREEN);

		
      }
      if(src== button3){
         controlPanel5.setBackground(Color.BLUE);
		
      }
      
      //radio
      if(radioButton1.isSelected()){
         controlPanel2.setBackground(Color.RED);
      }
      if(radioButton2.isSelected()){
         controlPanel2.setBackground(Color.GREEN);
      }
      if(radioButton3.isSelected()){
         controlPanel2.setBackground(Color.BLUE);
      }
      //checkbox
      if(redCheckBox.isSelected()){
         controlPanel4.setBackground(Color.RED);
         controlPanel3.setBackground(Color.RED);
      }
      if(greenCheckBox.isSelected()){
         controlPanel4.setBackground(Color.GREEN);
         controlPanel3.setBackground(Color.GREEN);
      }
      if(blueCheckBox.isSelected()){
        controlPanel4.setBackground(Color.BLUE);
         controlPanel3.setBackground(Color.BLUE);
      }
      
      
   }
   public void createControlPanel(){
      JPanel styleGroupPanel = createRadioButtons();
      JPanel  ButtonGroupPanel=createButton();
      JPanel CheckGroupPanel = createCheckBoxes();
	   controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(3, 1));
      controlPanel2 = new JPanel();
      controlPanel3 = new JPanel();
      controlPanel4 = new JPanel();
      controlPanel5 = new JPanel();
      controlPanel2.setPreferredSize(new Dimension(200, 300));
      controlPanel3.setPreferredSize(new Dimension(200, 500));
      controlPanel4.setPreferredSize(new Dimension(200, 500));
      controlPanel5.setPreferredSize(new Dimension(300, 300));
      controlPanel.add(ButtonGroupPanel);
      controlPanel.add(styleGroupPanel);
      controlPanel.add(CheckGroupPanel);
      controlPanel2.setBackground(Color.GREEN);
      controlPanel3.setBackground(Color.BLUE);
      controlPanel4.setBackground(Color.BLUE);
      controlPanel5.setBackground(Color.RED);
      add(controlPanel, BorderLayout.NORTH);
      add(controlPanel2, BorderLayout.SOUTH);
      add(controlPanel3, BorderLayout.WEST);
      add(controlPanel4, BorderLayout.EAST);
      add(controlPanel5, BorderLayout.CENTER); 
      
   }
   
   public JPanel createButton(){
		listener2= new ChoiceListener();
		button1= new JButton("RED");
		button1.addActionListener(listener2);
		button2= new JButton("GREEN");
		button2.addActionListener(listener2);
		button3= new JButton("BLUE");
		button3.addActionListener(listener2);
		ButtonGroup group1 = new ButtonGroup();
		button1.setSelected(true);
	   group1.add(button1);
       group1.add(button2);
       group1.add(button3);
       JPanel panel = new JPanel();
	   panel.add(button1);
	   panel.add(button2);
	   panel.add(button3);
	   panel.setBorder(new TitledBorder(new EtchedBorder(), "CENTER COLOR"));

      return panel;
      
   }
   public JPanel createRadioButtons() {
		listener= new ChoiceListener();
		radioButton1 = new JRadioButton("RED");
		radioButton1.addActionListener(listener);
		radioButton2 = new JRadioButton("GREEN");
		radioButton2 .addActionListener(listener);
		radioButton3 = new JRadioButton("BLUE");
		radioButton3.addActionListener(listener);
		radioButton2.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);      
		JPanel panel = new JPanel();
		panel.add(radioButton1);
		panel.add(radioButton2);
		panel.add(radioButton3);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "SOUTH COLOR"));

	   return panel;
      
   }
   
    public JPanel createCheckBoxes() {
		listener= new ChoiceListener();
		redCheckBox = new JCheckBox("RED");
		redCheckBox.addActionListener(listener);
		greenCheckBox = new JCheckBox("GREEN");
		greenCheckBox.addActionListener(listener);
		blueCheckBox = new JCheckBox("BLUE");
		blueCheckBox.addActionListener(listener);
		JPanel panel = new JPanel();
		panel.add(redCheckBox);
		panel.add(greenCheckBox);
		panel.add(blueCheckBox);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "SIDES COLOR"));

	   return panel;
   }
}