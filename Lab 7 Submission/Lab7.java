import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


class HeaderPanel extends JPanel{
   private JLabel header;
   public HeaderPanel(){
      	header = new JLabel("Course Evaluation Form");
      	add(header);
   }
}

class FormPanel extends JPanel implements ActionListener, ItemListener{

   JLabel label_name;
   JTextField name;
   JLabel label_matric;
   JTextField matric;
   JLabel label_code;
   JComboBox<String> code;
   JLabel label_rating;
   JLabel label_outcome;
   JButton button_submit;
   JButton button_clear;
   JCheckBox check_box1;
   JCheckBox check_box2;
   JLabel label_output; 
   JScrollPane scroll_pane1;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    
   String output="";
   String code_selection="";
   String radiobutton_selected="";
   String checkbox_selected="";
   String filePath="data.txt"; 
      
   public FormPanel(){   
      setLayout(new FlowLayout(FlowLayout.LEFT));     
      
      label_name = new JLabel("Name");
      label_name.setPreferredSize(new Dimension(150, 20));
      label_name.setBorder(border);
      
      add(label_name);
      name = new JTextField(20);
      add(name);
      
      label_matric = new JLabel("Matric No.");
      label_matric.setPreferredSize(new Dimension(150, 20));
      add(label_matric);
      matric = new JTextField(15);
      add(matric);   
      
      String[] course_name={"[Select]", "KK14203 Object-Oriented Programming", "KT14203 Computer Architecture And Organization", "KT14403 Discrete Structures"};
      
      label_code = new JLabel("Course Code");
      label_code.setPreferredSize(new Dimension(150, 20));
      add(label_code);
      code = new JComboBox<String>(course_name);
      add(code); 

      code.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            code_selection = (String) code.getSelectedItem();
         }
      });  
      
      label_rating = new JLabel("Rating");
      label_rating.setPreferredSize(new Dimension(150, 20));
      add(label_rating);
      
      JRadioButton rb_1 = new JRadioButton("1");
      rb_1.addActionListener(this);
      JRadioButton rb_2 = new JRadioButton("2");
      rb_2.addActionListener(this);
      JRadioButton rb_3 = new JRadioButton("3");
      rb_3.addActionListener(this);
      JRadioButton rb_4 = new JRadioButton("4");
      rb_4.addActionListener(this);
      JRadioButton rb_5 = new JRadioButton("5");
      rb_5.addActionListener(this);
      add(rb_1);
      add(rb_2);
      add(rb_3);
      add(rb_4);
      add(rb_5);
      
      ButtonGroup button_group1 = new ButtonGroup();
      button_group1.add(rb_1);
      button_group1.add(rb_2);
      button_group1.add(rb_3);
      button_group1.add(rb_4);
      button_group1.add(rb_5);
      
      label_outcome = new JLabel("Outcome");
      label_outcome.setPreferredSize(new Dimension(150, 20));
      add(label_outcome);
      
      check_box1 = new JCheckBox("Basic knowledge");
      check_box1.addItemListener(this);
      check_box2 = new JCheckBox("Advanced knowledge");
      check_box2.addItemListener(this);
      add(check_box1);
      add(check_box2);
      
      button_submit = new JButton("Submit");
      add(button_submit);
      button_clear = new JButton("Clear");
      add(button_clear);

      button_submit.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){              
            if(printOutput())
               writeInput();     
         }  
      });
      
      button_clear.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            label_output.setText("Output");  
            name.setText("");
            matric.setText(""); 
            code.setSelectedIndex(0);
            button_group1.clearSelection();
            check_box1.setSelected(false);
            check_box2.setSelected(false);
         }  
      });
      
      label_output = new JLabel("Output");
      label_output.setBorder(border);
      label_output.setVerticalAlignment(JLabel.TOP);
      
      scroll_pane1 = new JScrollPane(label_output);
      scroll_pane1.setPreferredSize(new Dimension(410,120));
      add(scroll_pane1);     
   }
   
   public void actionPerformed(ActionEvent ae) {
      radiobutton_selected = ae.getActionCommand();    	   
   }
   
   public void itemStateChanged(ItemEvent ie) {
      JCheckBox check = (JCheckBox)ie.getSource();
      checkbox_selected += check.getText() + " ";   
   }
   
   public boolean printOutput(){
   JFrame f= new JFrame();
      try {
         if(name.getText().isEmpty() || matric.getText().isEmpty() || code_selection.equals("[Select]") || code_selection.equals("")||
            radiobutton_selected.equals("") || checkbox_selected.equals("")){
            throw new Exception();
            }
      output = "<html>";
      output += "Thank you for your evaluation<br><br>"; 
      output += "Name: " + name.getText() + "<br>";
      output += "Matric: " + matric.getText() + "<br>"; 
      output += "Course: " + code_selection + "<br>";
      output += "Rating: " + radiobutton_selected + "<br>";       
      output += "Outcome: " + checkbox_selected + "<br>";
      output += "</html>";          
      label_output.setText(output);
      scroll_pane1.getViewport().revalidate();
      JOptionPane.showMessageDialog(f,"File is saved"); 

      
      }
      catch (Exception e){
         label_output.setText(e.toString());
         output = "<html>";
         if (name.getText().isEmpty()){
            output += "Name can not be empty<br>";}
         if ( matric.getText().isEmpty()){
            output += "Matrics number can not be empty<br>";}
         if (code_selection.equals("[Select]") || code_selection.equals("")){
            output += "Course Code code is not selected<br>";}
         if (radiobutton_selected.equals("")){
            output += "Rating is not selected<br>";}
         if (checkbox_selected.equals("")){
            output += "Outcome is not selected<br>";}
         output += "All field must be filled<br>";
         output += "</html>";  
         label_output.setText(output);
         JOptionPane.showMessageDialog(f,"Please fill all the fields"); 
         
       return false;
      }
      return true;
    }
    public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
      JFrame f= new JFrame();
      
      String input = name.getText() + ", " + matric.getText() + ", " + code_selection + ", " + radiobutton_selected + ", " + checkbox_selected;
      
  		try {

			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(input);
		} catch (IOException e) {			
         label_output.setText(e.toString());
         JOptionPane.showMessageDialog(f,"File is not saved"); 
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				label_output.setText(e.toString());
			}
		}
    }
}

class MenuActionListener implements ActionListener {
   FormPanel fp;
   public MenuActionListener(FormPanel p){
      fp = p;
   }
   
   public void actionPerformed(ActionEvent e) {
      BufferedReader reader;
     
	   try {
			reader = new BufferedReader(new FileReader(fp.filePath));
			String line = reader.readLine();
         String output="<html>";
			while (line != null) {
				output += line + "<br>";

				line = reader.readLine();
			}
         output += "<br>";
         fp.label_output.setText(output);
			reader.close();
		} catch (IOException io) {
			fp.label_output.setText(io.toString());
         
		}

  }
}

 class show_dialougeBox implements ActionListener {
 
   public void actionPerformed(ActionEvent e){
      int input = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Select an Option...",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
	         System.out.println(input);
            
            if (input == 0){
                 System.exit(0);}
            else{
               }
      
       }
    }
   

public class Lab7 {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Evaluation");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      HeaderPanel h = new 	HeaderPanel();
      HeaderPanel h2 = new 	HeaderPanel();
      FormPanel fp = new FormPanel();
      
      JMenuBar mb = new JMenuBar(); 

      JMenu x = new JMenu("Menu"); 
      
      JMenuItem m1 = new JMenuItem("Load Data"); 
      m1.addActionListener(new MenuActionListener(fp));
      
      JMenuItem m2 = new JMenuItem("Exit");  
      m2.addActionListener(new show_dialougeBox());
      x.add(m1); 
      x.add(m2);
      mb.add(x); 
      f.setJMenuBar(mb);  
                   
      f.add(h,BorderLayout.NORTH);
      f.add(fp, BorderLayout.CENTER);
      f.setSize(460,400);
      f.setVisible(true);
   }  
}