//Mohd Hisyamudin Bin Abd Aziz
//BI19110028
//Project 2

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
import java.io.FileNotFoundException;
import java.lang.Throwable;
import  java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.util.*;
import javax.swing.border.TitledBorder;

class panel_login_systems extends JPanel implements ActionListener{
   
   private static JLabel label_welcome;
   private static JLabel label_username;
   private static JLabel label_password;
   private static JLabel success;
   private static JTextField text_username;
   private static JPasswordField text_password;
   private static JButton button_login;
   private static JFrame frame;
      
   public panel_login_systems(JFrame frame){
      this.frame = frame;
       
      setLayout (null);
      label_welcome = new JLabel ("Enter your username and password");
      label_welcome.setBounds(40, 10, 230, 25);
      add(label_welcome);
      
      label_username = new JLabel("Username:");
      label_username.setBounds(10, 50, 80, 25);
      add(label_username);
      
      label_password = new JLabel("Password:");
      label_password.setBounds(10, 80, 80, 25);
      add(label_password);
      
      text_username = new JTextField(20);
      text_username.setBounds(100,50,165,25);
      add(text_username);
      
      text_password = new JPasswordField(20);
      text_password.setBounds(100,80,165,25);
      add(text_password);
      
      button_login = new JButton("Login");
      button_login.setBounds(10, 110, 80, 25);
      button_login.addActionListener(this);
      add(button_login);
      
      success = new JLabel ("");
      success.setBounds (10,140,300,25);
      add(success);
      
      }
      


      public void actionPerformed(ActionEvent e){
            JFrame ff= new JFrame();
            String user = text_username.getText();
            String password = text_password.getText();
            
            try{
            if(user.equals("hisyam") && password.equals("bi19110028")){
               JOptionPane.showMessageDialog(ff,"Login successful");
               JFrame f2 = new JFrame("Choosing Panel");              
               choosing_panel choose_panel = new choosing_panel(f2);
               f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
               f2.add(choose_panel, BorderLayout.CENTER);
               f2.setSize(530, 260);
               f2.setVisible(true);
               frame.dispose();
               
               }
               
            else{
               JOptionPane.showMessageDialog(ff,"Login not successful");
               System.exit(0);} 
            frame.getContentPane().removeAll();
            }
           catch (Exception ee){
               JOptionPane.showMessageDialog(ff,ee);}
  }

}


class choosing_panel extends JPanel implements ActionListener {
    private JButton button_doctor;
    private JButton button_patient;
    private JLabel label_greet;
    private JFrame frame;

    public choosing_panel(JFrame frame) {
    this.frame= frame;
        //construct components
        button_doctor = new JButton ("Doctor Register"); 
        button_doctor.addActionListener(this);  
      
        button_patient = new JButton ("Patient Register");
        button_patient.addActionListener(this);
        label_greet = new JLabel ("Hello there! Please choose which you want to do");
        
        //adjust size and set layout
        setPreferredSize (new Dimension (530, 240));
        setLayout (null);

        //add components
        add (button_doctor);
        add (button_patient);
        add (label_greet);

        //set component bounds (only needed by Absolute Positioning)
        button_doctor.setBounds (105, 140, 140, 65);
        button_patient.setBounds (270, 140, 140, 65);
        label_greet.setBounds (125, 60, 280, 40);
    }
     public void actionPerformed(ActionEvent e){
     String command = e.getActionCommand(); 

         if(command.equals("Patient Register")){
            JFrame f2 = new JFrame("Patient Main Menu Panel");              
            Pet_Main_Menu pet_panel = new Pet_Main_Menu(f2);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            f2.add(pet_panel, BorderLayout.CENTER);
            f2.setSize(950, 580);
            f2.setVisible(true);
            frame.dispose();  
      }
        else if (command.equals("Doctor Register")){
            JFrame f2 = new JFrame("Doctor Biodata Panel");              
            Doctor_information doctor_panel = new Doctor_information(f2);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            f2.add(doctor_panel, BorderLayout.CENTER);
            f2.setSize(685, 500);
            f2.setVisible(true);
            frame.dispose();
      }


     }
}

class Doctor_information extends JPanel implements ActionListener,MenuListener, KeyListener {
    private JButton button_submit;
    private JButton button_save;
    private JButton button_back;
    private JButton button_clear;
    private JLabel label_doctor;
    private JLabel label_name;
    private JLabel label_birth;
    private JLabel label_output;
    private JComboBox combo_day;
    private JTextField text_name;
    private JComboBox combo_month;
    private JComboBox combo_year;
    private JLabel label_gender;
    private JLabel label_error;
    private JRadioButton radio_male;
    private JRadioButton radio_female;
    private JRadioButton radio_other;
    private JLabel label_contact;
    private JTextField text_number;
    private JTextField text_email;
    private JLabel label_email;
    private JLabel label_birthdate;
    private JTextField text_birth;
    private JLabel label_address;
    private JTextField text_address;
    private JTextArea textarea_information;
    private JFrame frame;
    private ButtonGroup button_group1;
    private JMenuBar menu1;
    private JMenu exitMenu;
    private JMenu fileMenu;
    private JMenuItem load_fileItem;
    private JMenuItem new_fileItem;
    private String first_name;
    private Formatter x;
    private String filePath;
    private JScrollPane scroll1;
    private String gender;


    public Doctor_information(JFrame frame) {
    this.frame = frame;
        //construct preComponents
        String[] combo_dayItems = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] combo_monthItems = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] combo_yearItems = {"Year", "2020", "2021", "2022"};
        String radiobutton_selected = " ";
        fileMenu = new JMenu ("File");
        new_fileItem = new JMenuItem ("New File");
        fileMenu.add (new_fileItem);
        load_fileItem = new JMenuItem ("Load File");
        fileMenu.add (load_fileItem);
        exitMenu = new JMenu ("Exit");
        menu1 = new JMenuBar();
        menu1.add (fileMenu);
        menu1.add (exitMenu);

        //adjust size and set layout
        setPreferredSize (new Dimension (752, 457));
        setLayout (null);
        
        //construct components
        button_submit = new JButton ("Submit");
        button_save = new JButton ("Save");
        button_back = new JButton ("Back");
        button_clear = new JButton ("Clear");
        label_doctor = new JLabel ("Doctor's Information");
        label_name = new JLabel ("Name                    :");
        label_birth = new JLabel ("Work Date            :");
        combo_day = new JComboBox (combo_dayItems);
        text_name = new JTextField (30);
        combo_month = new JComboBox (combo_monthItems);
        combo_year = new JComboBox (combo_yearItems);
        label_gender = new JLabel ("Gender                 :");
        radio_male = new JRadioButton ("Male");
        radio_female = new JRadioButton ("Female");
        radio_other = new JRadioButton ("Other");
        label_contact = new JLabel ("Contact Number  :");
        text_number = new JTextField (20);
        text_email = new JTextField (28);
        label_email = new JLabel ("Email                     :  ");
        label_birthdate = new JLabel ("Birth Date             :");
        text_birth = new JTextField (25);
        label_address = new JLabel ("Address                 :");
        text_address = new JTextField (40);
        textarea_information = new JTextArea (20, 20);
        label_output = new JLabel ("The output");
        scroll1 = new JScrollPane(textarea_information);
        label_error = new JLabel ("");
        label_error.setForeground(Color.red);
        
        //button group
        button_group1 = new ButtonGroup();
        button_group1.add(radio_male);
        button_group1.add(radio_female);
        button_group1.add(radio_other);
        
        //action listener for radio button
        radio_male.addActionListener(this);
        radio_female.addActionListener(this);
        radio_other.addActionListener(this);
        

        //adjust size and set layout
        setPreferredSize (new Dimension (752, 457));
        setLayout (null);
        
        //add action listener
        button_back.addActionListener(this);
        button_clear.addActionListener(this);
        button_save.addActionListener(this);
        button_submit.addActionListener(this);
        
        //action listener for menu
        exitMenu.addMenuListener(this); 
        new_fileItem.addActionListener(this);
        load_fileItem.addActionListener(this);
        
        //key listener for text field
        text_number.addKeyListener(this);
   
        //add components
        add (button_submit);
        add (button_save);
        add (button_back);
        add (button_clear);
        add (label_doctor);
        add (label_name);
        add (label_birth);
        add (combo_day);
        add (text_name);
        add (combo_month);
        add (combo_year);
        add (label_gender);
        add (radio_male);
        add (radio_female);
        add (radio_other);
        add (label_contact);
        add (text_number);
        add (text_email);
        add (label_email);
        add (label_birthdate);
        add (text_birth);
        add (label_address);
        add (text_address);
        add (label_output);
        add (menu1);
        add (scroll1);
        add (label_error);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //set component bounds (only needed by Absolute Positioning)
        button_submit.setBounds (245, 355, 80, 25);
        button_save.setBounds (135, 355, 80, 25);
        button_back.setBounds (245, 390, 80, 25);
        button_clear.setBounds (135, 390, 80, 25);
        label_doctor.setBounds (145, 30, 135, 25);
        label_name.setBounds (5, 75, 105, 25);
        label_birth.setBounds (5, 110, 100, 25);
        combo_day.setBounds (135, 110, 75, 25);
        text_name.setBounds (135, 75, 190, 25);
        combo_month.setBounds (220, 110, 75, 25);
        combo_year.setBounds (310, 110, 85, 25);
        label_gender.setBounds (5, 145, 115, 25);
        radio_male.setBounds (135, 145, 65, 25);
        radio_female.setBounds (215, 145, 85, 25);
        radio_other.setBounds (305, 145, 100, 25);
        label_contact.setBounds (5, 180, 110, 25);
        text_number.setBounds (135, 180, 190, 25);
        text_email.setBounds (135, 215, 190, 25);
        label_email.setBounds (5, 220, 110, 25);
        label_birthdate.setBounds (5, 255, 110, 25);
        text_birth.setBounds (135, 250, 190, 25);
        label_address.setBounds (5, 290, 105, 25);
        label_error.setBounds (5, 310, 400, 25);
        text_address.setBounds (135, 290, 190, 25);
        label_output.setBounds (500, 50, 100, 25);
        menu1.setBounds (0, 0, 755, 20);
        scroll1.setBounds(425, 80, 215, 350);


    }
    public void actionPerformed(ActionEvent e){
     String command = e.getActionCommand(); 
     
         if(command.equals("Back")){
            JFrame f2 = new JFrame("Choosing Panel");              
            choosing_panel choose_panel = new choosing_panel(f2);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            f2.add(choose_panel, BorderLayout.CENTER);
            f2.setSize(530, 260);
            f2.setVisible(true);
            frame.dispose();
         }
         else if(command.equals("Clear")){
            combo_day.setSelectedIndex(0);
            text_name.setText("");
            combo_month.setSelectedIndex(0);
            combo_year.setSelectedIndex(0);
            button_group1.clearSelection();
            text_number.setText("");
            text_email.setText("");
            text_birth.setText("");
            text_address.setText("");    
            textarea_information.setText("");        
            }      
        else if(command.equals("Submit")){
        
            String name, contact, emails, birth, address, text,day,month,year,gender;
            name = text_name.getText();
            contact = text_number.getText();
            birth = text_birth.getText();
            address = text_address.getText();
            emails = text_email.getText();
            day = combo_day.getSelectedItem().toString();
            month = combo_month.getSelectedItem().toString();
            year = combo_year.getSelectedItem().toString();
            JFrame f = new JFrame("");
            
        try{
            if(text_name.getText().isEmpty() || text_number.getText().isEmpty() |text_birth.getText().isEmpty() ||text_address.getText().isEmpty() ||text_email.getText().isEmpty()
               || day.equals("Day") || month.equals("Month") || year.equals("Year") ){
                  throw new Exception();}

            if (radio_male.isSelected()) { 
              gender = "Male"; 
            } 
  
            else if (radio_female.isSelected()) { 
              gender = "Female"; 
            } 
            else {
              gender = "Other"; 
            } 
            Doctor doctor = new Doctor("Generic");
            doctor.set_profile (name, contact, emails,birth, address, day, month, year,gender );
            text = doctor.doctor_print_gui ();
            textarea_information.append(text);
         }catch (Exception ee) {
               JOptionPane.showMessageDialog(f,"All Field Must be Filled.");}
        }
        
        else if(e.getSource().equals(new_fileItem)){

            create_file();
        }
        else if(command.equals("Save")){
            String day = combo_day.getSelectedItem().toString();
            String month = combo_month.getSelectedItem().toString();
            String year = combo_year.getSelectedItem().toString();
            JFrame f = new JFrame("");
            try{
               if(text_name.getText().isEmpty() || text_number.getText().isEmpty() |text_birth.getText().isEmpty() ||text_address.getText().isEmpty() ||text_email.getText().isEmpty()
               || day.equals("Day") || month.equals("Month") || year.equals("Year") ){
                  throw new Exception();}
                  
            writeInput();
            
            }
            
            catch (Exception ee) {			
               JOptionPane.showMessageDialog(f,"All Field Must be Filled and file name can not be empty.");}

        }
        
        else if(e.getSource().equals(load_fileItem)){
        String reading = JOptionPane.showInputDialog("File Name to be readed ");
    
        JFrame f= new JFrame();
        BufferedReader reader = null;
     
	     try {
			   reader = new BufferedReader(new FileReader(reading+".txt"));
			   String line = reader.readLine();
            String output = " ";
			   while (line != null) {
				   output += line + "\n";
				   line = reader.readLine();
			   }
            textarea_information.append(output);
            JOptionPane.showMessageDialog(f,"File have been readed");
		   } 
         catch (IOException io) {
         	 JOptionPane.showMessageDialog(f,"No such file to be readed");
			    io.printStackTrace();
         
		   }
      finally 
       {
	   try {
	      if (reader != null){
		      reader.close();}
        
      }
      catch (IOException ioe){
		   JOptionPane.showMessageDialog(f,"No such file to be readed");      }
    }
  }
}
     public void menuSelected(MenuEvent e){
         if (e.getSource().equals(exitMenu)){
            int input = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Select an Option...",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
	         System.out.println(input);
            if (input == 0){
                 System.exit(0);}
            else{
               }
         }

         }
      public void menuDeselected (MenuEvent e){}
      public void menuCanceled (MenuEvent e){}
      
      public void create_file(){
      
         JFrame f= new JFrame();
         first_name = JOptionPane.showInputDialog("File Name"); 
         
         try{
            if (first_name.equals("")){
               throw new Exception();}
            x = new Formatter(first_name + ".txt");
            JOptionPane.showMessageDialog(f,"File is created");}
         catch(Exception e){
            JOptionPane.showMessageDialog(f,"File is not created");
         }
      
      }
      

      public void writeInput(){
         radio_male.setActionCommand("Male");
         radio_female.setActionCommand("Female");
         radio_other.setActionCommand("Other");
         
         filePath = JOptionPane.showInputDialog("File Name to be saved in");     
         File file = new File(filePath+".txt");
    
		   FileWriter fr = null;
		   BufferedWriter br = null;
		   PrintWriter pr = null;
         JFrame f= new JFrame();
      

      
  		   try {
            if(text_name.getText().isEmpty()||button_group1.getSelection().getActionCommand().equals("") || text_birth.getText().isEmpty()  || text_address.getText().isEmpty() ||text_email.getText().isEmpty()||
             combo_day.equals("Day")|| combo_month.equals("Month")|| combo_year.equals("Year") ){
            throw new Exception();}
            
            String input = "Doctor Name: "+ text_name.getText() +"\nGender: " + button_group1.getSelection().getActionCommand() + "\nContact Number: " +text_number.getText()+ "\nBirth Date: " + text_birth.getText() + ".\nAddress:  " + text_address.getText() + ".\nEmail: " + text_email.getText()
                            + "\nStarted Work: " + combo_day.getSelectedItem().toString()+ " " + combo_month.getSelectedItem().toString()+ " "
                            + combo_year.getSelectedItem().toString()+ "\n\n";
                         
			   fr = new FileWriter(file,true);
			   br = new BufferedWriter(fr);
			   pr = new PrintWriter(br);
			   pr.println(input);
            JOptionPane.showMessageDialog(f,"Input is saved in file"); 
            
		} catch (Exception e) {			
            JOptionPane.showMessageDialog(f,"File is not found"); 
            
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(f,"File is not found"); 
			}
		}
    }
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
      char c = e.getKeyChar();
    
      try{
        int a = Integer.parseInt(text_number.getText());
      }
      catch(NumberFormatException e1){
         if (Character.isLetter(c)){
            text_number.setEditable (false);
            label_error.setText("The Contact Number field only can contain Number.");

         } 
         else{
            text_number.setEditable (true); 
            label_error.setText("");
         }
      }
  }
    

    public void keyReleased(KeyEvent e) {
   }
 
}
      
    
   
class Pet_Main_Menu extends JPanel implements ActionListener, MenuListener, KeyListener  {

    private JButton button_owner;
    private JButton button_pet;
    private JButton button_prescription;
    private JButton button_clear;
    private JButton button_ward;
    private JButton button_back;
    private JButton button_save;
    private JLabel label_owner;
    private JLabel label_owner_name;
    private JLabel label_ic;
    private JLabel label_age;
    private JLabel label_address;
    private JLabel label_gender;
    private JTextField text_name;
    private JTextField text_ic;
    private JTextField text_age;
    private JTextField text_address;
    private JRadioButton radio_male;
    private JRadioButton radio_female;
    private JRadioButton radio_other;
    private JLabel label_pet;
    private JLabel label_pet_name;
    private JLabel label_pet_type;
    private JLabel label_pet_age;
    private JLabel label_pet_future;
    private JLabel label_pet_history;
    private JTextField text_pet_name;
    private JTextField text_pet_type;
    private JTextField text_pet_age;
    private JTextField text_pet_feature;
    private JLabel label_topprescription;
    private JLabel label_disease;
    private JLabel label_date;
    private JLabel label_medicine;
    private JLabel label_prescription;
    private JLabel label_price;
    private JTextField text_pet_disease;
    private JTextField text_medicine;
    private JTextField text_prescription;
    private JTextField text_price;
    private JLabel label_ward;
    private JLabel label_needward;
    private JLabel label_ward_num;
    private JLabel label_ward_date;
    private JLabel label_discharge;
    private JLabel label_ward_price;
    private JLabel label_error;
    private JTextField text_wardnum;
    private JTextField text_ward_price;
    private JLabel label_output;
    private JMenuBar menu1;
    private JRadioButton radio_yes;
    private JRadioButton radio_no;
    private JComboBox combo_day;
    private JComboBox combo_month;
    private JComboBox combo_year;
    private JRadioButton radio_yes_ward;
    private JRadioButton radio_no_ward;
    private JComboBox combo_warded_day;
    private JComboBox combo_warded_month;
    private JComboBox combo_warded_year;
    private JComboBox combo_discharge_day;
    private JComboBox combo_discharge_month;
    private JComboBox combo_dischage_year;
    private JFrame frame;
    private ButtonGroup button_group1;
    private ButtonGroup button_group2;
    private ButtonGroup button_group3;
    private JLayeredPane layeredPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JScrollPane scroll_owner;
    private JScrollPane scroll_pet;
    private JScrollPane scroll_prescription;
    private JScrollPane scroll_ward;
    private JScrollPane scroll_all;
    private JLabel label_owners_output;
    private JLabel label_pet_output;
    private JLabel label_prescription_output;
    private String filePath;
    private JMenu fileMenu;
    private JMenu exit;
    private JMenuItem load_fileItem;
    private JMenuItem add_fileItem;
    private Formatter x;
    private String first_name;
    private JTextArea textarea_owner;
    private JTextArea textarea_pet;
    private JTextArea textarea_prescription;   
    private JTextArea textarea_ward;
    private JTextArea textarea_all;
    private Ward wards;
    private Prescription prescriptions;
    private Pet pets;
    private Owner owners;
    
    public Pet_Main_Menu(JFrame frame) {
      
        //Making Layered pane
        layeredPane = new JLayeredPane();
		  layeredPane.setBounds(675, 150, 245, 361);
		  frame.getContentPane().add(layeredPane);
		
		  panel1 = new JPanel();
		  panel1.setBorder(new TitledBorder(null, "Owner Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  panel1.setBackground(Color.YELLOW);
		  panel1.setBounds(10, 10, 225, 341);
		  layeredPane.add(panel1);
		  panel1.setLayout(null);
		
		  textarea_owner = new JTextArea();
        scroll_owner = new JScrollPane(textarea_owner);
        scroll_owner.setBounds(10, 21, 205, 310);
        panel1.add(scroll_owner);  
        scroll_owner.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		  panel2 = new JPanel();
		  panel2.setBorder(new TitledBorder(null, "Pet Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  layeredPane.setLayer(panel2, 0);
		  panel2.setBackground(Color.BLUE);
		  panel2.setBounds(10, 10, 225, 341);
		  layeredPane.add(panel2);
		  panel2.setLayout(null);
		
		  textarea_pet = new JTextArea();
        scroll_pet = new JScrollPane(textarea_pet);
        scroll_pet.setBounds(10, 21, 205, 310);
        scroll_pet.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel2.add (scroll_pet);
		
		  panel3 = new JPanel();
		  panel3.setBorder(new TitledBorder(null, "Prescription Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  layeredPane.setLayer(panel3, 0);
		  panel3.setBackground(Color.ORANGE);
		  panel3.setBounds(10, 10, 225, 341);
		  layeredPane.add(panel3);
		  panel3.setLayout(null);
		
		  textarea_prescription = new JTextArea();
        scroll_prescription = new JScrollPane(textarea_prescription);
        scroll_prescription.setBounds(10, 20, 205, 311);
        scroll_prescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel3.add(scroll_prescription); 
		
		  panel4 = new JPanel();
		  panel4.setBorder(new TitledBorder(null, "Ward Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  panel4.setBackground(Color.GREEN);
		  layeredPane.setLayer(panel4, 0);
		  panel4.setBounds(10, 10, 225, 341);
		  layeredPane.add(panel4);
	     panel4.setLayout(null);
		
		  textarea_ward = new JTextArea();
        scroll_ward = new JScrollPane(textarea_ward);
        scroll_ward.setBounds(10, 20, 205, 311);
        scroll_ward.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel4.add (scroll_ward);

        panel5 = new JPanel();
		  panel5.setBorder(new TitledBorder(null, "Load Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	     panel5.setBackground(Color.GRAY);
		  layeredPane.setLayer(panel5, 0);
		  panel5.setBounds(10, 10, 225, 341);
		  layeredPane.add(panel5);
		  panel5.setLayout(null);
		
		  textarea_all = new JTextArea();
        scroll_all = new JScrollPane(textarea_all);
        scroll_all.setBounds(10,21,205,310);
        scroll_all.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel5.add (scroll_all);
         
        this.frame = frame;
        
        //construct preComponents
        fileMenu = new JMenu ("File");
        load_fileItem = new JMenuItem ("Load File");
        add_fileItem = new JMenuItem ("Create File");
        fileMenu.add (add_fileItem);
        fileMenu.add (load_fileItem);
        exit = new JMenu ("Exit");
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        String[] combo_dayItems = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] combo_monthItems = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] combo_yearItems = {"Year", "2020", "2021", "2022"};
        String[] combo_warded_dayItems = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] combo_warded_monthItems = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] combo_warded_yearItems = {"Year", "2020", "2021", "2022"};
        String[] combo_discharge_dayItems = {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] combo_discharge_monthItems = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] combo_dischage_yearItems = {"Year", "2020", "2021", "2022"};
        
        //construct components
        label_owner = new JLabel ("Owner's Information");
        label_owner.setBorder(border);
        label_owner_name = new JLabel ("Name");
        label_ic = new JLabel ("IC");
        label_age = new JLabel ("Age");
        label_address = new JLabel ("Address");
        label_gender = new JLabel ("Gender");
        label_error = new JLabel ("");
        text_name = new JTextField (25);
        text_ic = new JTextField (14);
        text_age = new JTextField (5);
        text_address = new JTextField (40);
        radio_male = new JRadioButton ("Male");
        radio_female = new JRadioButton ("Female");
        radio_other = new JRadioButton ("Other");
        label_pet = new JLabel ("Pet's Information");
        label_pet.setBorder(border);
        label_pet_name = new JLabel ("Name");
        label_pet_type = new JLabel ("Type");
        label_pet_age = new JLabel ("Age");
        label_pet_future = new JLabel ("Feature");
        label_pet_history = new JLabel ("History");
        text_pet_name = new JTextField (20);
        text_pet_type = new JTextField (20);
        text_pet_age = new JTextField (6);
        text_pet_feature = new JTextField (20);
        label_topprescription = new JLabel ("Pet's Prescription");
        label_topprescription.setBorder(border);
        label_disease = new JLabel ("Disease");
        label_date = new JLabel ("Date");
        label_medicine = new JLabel ("Medicine");
        label_prescription = new JLabel ("Prescription");
        label_price = new JLabel ("Price (RM)");
        text_pet_disease = new JTextField (20);
        text_medicine = new JTextField (30);
        text_prescription = new JTextField (40);
        text_price = new JTextField (10);
        label_ward = new JLabel ("Pet's Ward");
        label_ward.setBorder(border);
        label_needward = new JLabel ("Need ward?");
        label_ward_num = new JLabel ("Ward");
        label_ward_date = new JLabel ("Warded Date");
        label_discharge = new JLabel ("Discharge");
        label_ward_price = new JLabel ("Ward Price");
        text_wardnum = new JTextField (8);
        text_ward_price = new JTextField (8);
        label_output = new JLabel ("Output");  
        menu1 = new JMenuBar();
        menu1.add (fileMenu);
        menu1.add (exit);
        button_owner = new JButton ("Owner");
        button_pet = new JButton ("Pet");
        button_prescription = new JButton ("Prescription");
        button_ward = new JButton ("Ward");
        button_back = new JButton ("Back");
        button_clear = new JButton  ("Clear");
        button_save = new JButton ("Save");
        radio_yes = new JRadioButton ("Yes");
        radio_no = new JRadioButton ("No");
        combo_day = new JComboBox (combo_dayItems);
        combo_month = new JComboBox (combo_monthItems);
        combo_year = new JComboBox (combo_yearItems);
        radio_yes_ward = new JRadioButton ("Yes");
        radio_no_ward = new JRadioButton ("No");
        combo_warded_day = new JComboBox (combo_warded_dayItems);
        combo_warded_month = new JComboBox (combo_warded_monthItems);
        combo_warded_year = new JComboBox (combo_warded_yearItems);
        combo_discharge_day = new JComboBox (combo_discharge_dayItems);
        combo_discharge_month = new JComboBox (combo_discharge_monthItems);
        combo_dischage_year = new JComboBox (combo_dischage_yearItems);
        label_error.setForeground(Color.red);
                
        //Radio Button Group
        button_group1 = new ButtonGroup();
        button_group1.add(radio_male);
        button_group1.add(radio_female);
        button_group1.add(radio_other);
        
        button_group2 = new ButtonGroup();
        button_group2.add(radio_yes_ward);
        button_group2.add(radio_no_ward);

        button_group3 = new ButtonGroup();
        button_group3.add(radio_yes);
        button_group3.add(radio_no);
        
        //colour to button
        button_owner.setBackground(Color.YELLOW);
        button_pet.setBackground(Color.BLUE);
        button_prescription.setBackground(Color.ORANGE);
        button_ward.setBackground(Color.GREEN);

        //Button add action listener
        button_clear.addActionListener(this);
        button_owner.addActionListener(this);
        button_pet.addActionListener(this);
        button_prescription.addActionListener(this);
        button_ward.addActionListener(this);
        button_back.addActionListener(this);
        button_save.addActionListener(this);
        
        //menu action listener
        exit.addMenuListener(this); 
        load_fileItem.addActionListener(this);
        add_fileItem.addActionListener(this);
        
        //key listener
        text_ic.addKeyListener(this);
        text_age.addKeyListener(this);
        text_pet_age.addKeyListener(this);
        text_price.addKeyListener(this);
        text_ward_price.addKeyListener(this);

        //adjust size and set layout
        setPreferredSize (new Dimension (936, 529));
        setLayout (null);
                 
        //add components
        add (label_owner);
        add (label_owner_name);
        add (label_ic);
        add (label_age);
        add (label_address);
        add (label_gender);
        add (text_name);
        add (text_ic);
        add (text_age);
        add (text_address);
        add (radio_male);
        add (radio_female);
        add (radio_other);
        add (label_pet);
        add (label_pet_name);
        add (label_pet_type);
        add (label_pet_age);
        add (label_pet_future);
        add (label_pet_history);
        add (text_pet_name);
        add (text_pet_type);
        add (text_pet_age);
        add (text_pet_feature);
        add (label_topprescription);
        add (label_disease);
        add (label_date);
        add (label_medicine);
        add (label_prescription);
        add (label_price);
        add (text_pet_disease);
        add (text_medicine);
        add (text_prescription);
        add (text_price);
        add (label_ward);
        add (label_needward);
        add (label_ward_num);
        add (label_ward_date);
        add (label_discharge);
        add (label_ward_price);
        add (text_wardnum);
        add (text_ward_price);
        add (label_output);
        add (menu1);
        add (button_owner);
        add (button_pet);
        add (button_prescription);
        add (button_ward);
        add (button_back);
        add (button_clear);
        add (button_save);
        add (radio_yes);
        add (radio_no);
        add (combo_day);
        add (combo_month);
        add (combo_year);
        add (radio_yes_ward);
        add (radio_no_ward);
        add (combo_warded_day);
        add (combo_warded_month);
        add (combo_warded_year);
        add (combo_discharge_day);
        add (combo_discharge_month);
        add (combo_dischage_year);
        add (label_error);
        
        //set component bounds (only needed by Absolute Positioning)
        label_owner.setBounds (105, 40, 130, 25);
        label_owner_name.setBounds (10, 85, 100, 25);
        label_ic.setBounds (10, 115, 100, 25);
        label_age.setBounds (10, 145, 100, 25);
        label_address.setBounds (10, 175, 100, 25);
        label_gender.setBounds (10, 205, 100, 25);
        text_name.setBounds (120, 85, 190, 25);
        text_ic.setBounds (120, 115, 190, 25);
        text_age.setBounds (120, 145, 190, 25);
        text_address.setBounds (120, 175, 190, 25);
        radio_male.setBounds (120, 205, 55, 25);
        radio_female.setBounds (180, 205, 70, 25);
        radio_other.setBounds (250, 205, 60, 25);
        label_pet.setBounds (415, 40, 130, 25);
        label_pet_name.setBounds (345, 85, 100, 25);
        label_pet_type.setBounds (345, 115, 100, 25);
        label_pet_age.setBounds (345, 145, 100, 25);
        label_pet_future.setBounds (345, 175, 100, 25);
        label_pet_history.setBounds (345, 205, 100, 25);
        text_pet_name.setBounds (455, 85, 180, 25);
        text_pet_type.setBounds (455, 115, 180, 25);
        text_pet_age.setBounds (455, 145, 180, 25);
        text_pet_feature.setBounds (455, 175, 180, 25);
        label_topprescription.setBounds (105, 280, 130, 25);
        label_disease.setBounds (10, 320, 100, 25);
        label_date.setBounds (10, 350, 100, 25);
        label_medicine.setBounds (10, 380, 100, 25);
        label_prescription.setBounds (10, 410, 100, 25);
        label_price.setBounds (10, 440, 100, 25);
        label_error.setBounds (10, 470, 400, 25);
        text_pet_disease.setBounds (120, 320, 190, 25);
        text_medicine.setBounds (120, 380, 190, 25);
        text_prescription.setBounds (120, 410, 190, 25);
        text_price.setBounds (120, 440, 190, 25);
        label_ward.setBounds (415, 280, 130, 25);
        label_needward.setBounds (350, 315, 100, 25);
        label_ward_num.setBounds (350, 345, 100, 25);
        label_ward_date.setBounds (350, 375, 100, 25);
        label_discharge.setBounds (350, 405, 100, 25);
        label_ward_price.setBounds (350, 435, 100, 25);
        text_wardnum.setBounds (455, 345, 180, 25);
        text_ward_price.setBounds (455, 435, 180, 25);
        label_output.setBounds (765, 45, 100, 25);
        menu1.setBounds (0, 0, 940, 25);
        button_owner.setBounds (680, 85, 105, 25);
        button_pet.setBounds (810, 85, 105, 25);
        button_prescription.setBounds (680, 115, 105, 25);
        button_ward.setBounds (810, 115, 105, 25);
        button_clear.setBounds (455, 470, 85, 25);
        button_back.setBounds (550, 500, 85, 25);
        button_save.setBounds (550, 470, 85, 25);
        radio_yes.setBounds (450, 205, 50, 25);
        radio_no.setBounds (505, 205, 65, 25);
        combo_day.setBounds (120, 350, 50, 25);
        combo_month.setBounds (175, 350, 75, 25);
        combo_year.setBounds (255, 350, 55, 25);
        radio_yes_ward.setBounds (450, 315, 50, 25);
        radio_no_ward.setBounds (505, 315, 55, 25);
        combo_warded_day.setBounds (455, 375, 50, 25);
        combo_warded_month.setBounds (510, 375, 65, 25);
        combo_warded_year.setBounds (580, 375, 55, 25);
        combo_discharge_day.setBounds (455, 405, 50, 25);
        combo_discharge_month.setBounds (510, 405, 65, 25);
        combo_dischage_year.setBounds (580, 405, 55, 25);
        
    }
     public void actionPerformed(ActionEvent e){
     String command = e.getActionCommand(); 

         if(command.equals("Clear")){
            text_name.setText("");
            text_ic.setText("");
            text_age.setText("");
            text_address.setText("");
            button_group1.clearSelection();
            text_pet_name.setText("");
            text_pet_type.setText("");
            text_pet_age.setText("");
            text_pet_feature.setText("");
            text_pet_disease.setText("");
            text_medicine.setText("");
            text_prescription.setText("");
            text_price.setText("");
            text_wardnum.setText("");
            text_ward_price.setText("");
            button_group2.clearSelection();
            combo_day.setSelectedIndex(0);
            combo_month.setSelectedIndex(0);
            combo_year.setSelectedIndex(0);
            button_group3.clearSelection();
            combo_warded_day.setSelectedIndex(0);
            combo_warded_month.setSelectedIndex(0);
            combo_warded_year.setSelectedIndex(0);
            combo_discharge_day.setSelectedIndex(0);
            combo_discharge_month.setSelectedIndex(0);
            combo_dischage_year.setSelectedIndex(0);
            textarea_owner.setText("");
            textarea_pet.setText("");
            textarea_prescription.setText("");   
            textarea_ward.setText("");
            textarea_all.setText("");
      }     
       
       
        else if (command.equals("Back")){
            JFrame f2 = new JFrame("Choosing Panel");              
            choosing_panel choose_panel = new choosing_panel(f2);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            f2.add(choose_panel, BorderLayout.CENTER);
            f2.setSize(530, 260);
            f2.setVisible(true);
            frame.dispose();
        }
        
        else if (command.equals("Save")){
            writeInput();
        }

        else if (command.equals("Owner")){
            switch_panels(panel1);
            JFrame f= new JFrame();
            radio_male.setActionCommand("Male");
            radio_female.setActionCommand("Female");
            radio_other.setActionCommand("Other");

            
            try{
               if(text_name.getText().isEmpty() || text_ic.getText().isEmpty() ||text_age.getText().isEmpty() || text_address.getText().isEmpty()  || button_group1.getSelection().getActionCommand().equals("")){
                  throw new Exception();}

            String name, ic, age, address, gender, text;

            name = text_name.getText();
            ic = text_ic.getText();
            age = text_age.getText();
            address = text_address.getText();
            gender = button_group1.getSelection().getActionCommand();
            
            Owner owners = new Owner(name, ic, age, address, gender);
            text = owners.owner_print_gui ();
            textarea_owner.append(text);
            }
            catch (Exception ee) {			
               JOptionPane.showMessageDialog(f,"All Field in the Owner Field Must be Filled.");}
        }
        else if (command.equals("Pet")){
            switch_panels(panel2);
            JFrame f= new JFrame();
            radio_yes.setActionCommand("Yes");
            radio_no.setActionCommand("No");
            
            try{
               if(text_pet_name.getText().isEmpty() || text_pet_type.getText().isEmpty() ||text_pet_age.getText().isEmpty() || text_pet_feature.getText().isEmpty()  || button_group3.getSelection().getActionCommand().equals("")){
                  throw new Exception();}
            
               String pet_name, pet_type, pet_age, pet_feature, history, text;

               pet_name = text_pet_name.getText();
               pet_type = text_pet_type.getText();
               pet_age = text_pet_age.getText();
               pet_feature = text_pet_feature.getText();
               history = button_group3.getSelection().getActionCommand();
               pets = new Pet(pet_name, pet_type, pet_age, pet_feature, history);
               text = pets.pet_print_gui ();
               textarea_pet.append(text); 
               
            }catch (Exception ee) {			
               JOptionPane.showMessageDialog(f,"All Field in the Pet Field Must be Filled.");}
        }
        
        else if (command.equals("Prescription")){
            switch_panels(panel3);
            JFrame f= new JFrame();
            
            String pet_disease, day, month, year, pet_medcine, pet_prescriptions, text;
            int prices;
            
            day = combo_day.getSelectedItem().toString();
            month = combo_month.getSelectedItem().toString();
            year = combo_year.getSelectedItem().toString();
            
            try{
               if(text_price.getText().isEmpty() || text_pet_disease.getText().isEmpty() ||text_medicine.getText().isEmpty() ||text_prescription.getText().isEmpty()
                  || day.equals("Day") || month.equals("Month") || year.equals("Year") ){
                  throw new Exception();}

               String texts = text_price.getText();
               prices = Integer.parseInt(texts);

               pet_disease = text_pet_disease.getText();
               pet_medcine = text_medicine.getText();
               pet_prescriptions = text_prescription.getText();
      
               prescriptions = new Prescription( pet_disease, day, month, year, pet_medcine, pet_prescriptions, prices);
               text = prescriptions.prescription_print_gui ();
               textarea_prescription.append(text);
               
            }catch (Exception ee) {			
               JOptionPane.showMessageDialog(f,"All Field in the Prescription Field Must be Filled.");}
        }    
        
        else if (command.equals("Ward")){
            switch_panels(panel4);
            JFrame f= new JFrame();
            
            String need_ward, ward_nums, warded_day, warded_month, warded_year, discharge_day, discharge_month, discharge_year, text;
            int prices2;
            radio_yes_ward.setActionCommand("Yes");
            radio_no_ward.setActionCommand("No");
            warded_day = combo_warded_day.getSelectedItem().toString();
            warded_month = combo_warded_month.getSelectedItem().toString();
            warded_year = combo_warded_year.getSelectedItem().toString();
            discharge_day = combo_discharge_day.getSelectedItem().toString();
            discharge_month =combo_discharge_month.getSelectedItem().toString();
            discharge_year =combo_dischage_year.getSelectedItem().toString();
            
            try{
               if(text_wardnum.getText().isEmpty() || button_group2.getSelection().getActionCommand().equals("")){
                  throw new Exception();}
          
            String texts = text_ward_price.getText();
            prices2 = Integer.parseInt(texts);

            need_ward = button_group2.getSelection().getActionCommand();

            ward_nums = text_wardnum.getText();

      
            wards = new Ward( need_ward, ward_nums,warded_day, warded_month, warded_year,prices2,discharge_day, discharge_month, discharge_year);
            text = wards.ward_print_gui ();
            textarea_ward.append(text);
            }catch (Exception ee) {			
               JOptionPane.showMessageDialog(f,"All Field in the Ward Field Must be Filled.");}

        }
        
       else if(e.getSource().equals(load_fileItem)){
        String reading = JOptionPane.showInputDialog("File Name to be readed ");
        switch_panels(panel5);
        JFrame f= new JFrame();
        BufferedReader reader = null;
     
	     try {
            if (reading.equals("")){
               throw new Exception();}
			   reader = new BufferedReader(new FileReader(reading+".txt"));
			   String line = reader.readLine();
            String output = " ";
			   while (line != null) {
				   output += line + "\n";
				   line = reader.readLine();
			   }
            textarea_all.append(output);
            JOptionPane.showMessageDialog(f,"File have been readed");
		   } 
         catch (Exception io) {
			    JOptionPane.showMessageDialog(f,"No file to be readed");
         
		   }
      finally 
         {
	      try {
	         if (reader != null){
		      reader.close();}
        
      }
         catch (IOException ioe){
		JOptionPane.showMessageDialog(f,"File can not be read");
          }
        }
      }
    else if(e.getSource().equals(add_fileItem)){
      create_file();}
    }
     
     public void menuSelected(MenuEvent e){
         if (e.getSource().equals(exit)){
            int input = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Select an Option...",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
	         System.out.println(input);
            if (input == 0){
                 System.exit(0);}
            else{
               }
         }
      }
      public void menuDeselected (MenuEvent e){}
      public void menuCanceled (MenuEvent e){}
    
     public void switch_panels (JPanel panel){
         layeredPane.removeAll();
         layeredPane.add(panel);
         layeredPane.repaint();
         layeredPane.revalidate();
     }
     public void writeInput(){
     
         radio_male.setActionCommand("Male");
         radio_female.setActionCommand("Female");
         radio_other.setActionCommand("Other");
         radio_yes.setActionCommand("Yes");
         radio_no.setActionCommand("No");
         radio_yes_ward.setActionCommand("Yes");
         radio_no_ward.setActionCommand("No");
         
         filePath = JOptionPane.showInputDialog("File Name to be saved in");
         File file = new File(filePath+".txt");
    
		   FileWriter fr = null;
		   BufferedWriter br = null;
		   PrintWriter pr = null;
         JFrame f= new JFrame();
      
    	   try {
            if(text_name.getText().isEmpty() || text_ic.getText().isEmpty() || text_address.getText().isEmpty()  || button_group1.getSelection().getActionCommand().equals("") || 
            text_pet_name.getText().isEmpty()  || text_pet_type.getText().equals("")|| text_pet_age.getText().isEmpty()|| text_pet_feature.getText().isEmpty()|| button_group3.getSelection().getActionCommand().equals("")
            || text_pet_disease.getText().isEmpty()|| combo_day.equals("Day")|| combo_month.equals("Month")||combo_year.equals("Year")|| text_medicine.getText().isEmpty()||filePath.equals("")||
            text_prescription.getText().isEmpty() || text_price.getText().isEmpty()|| button_group2.getSelection().getActionCommand().equals("")|| text_wardnum.getText().isEmpty()
            || combo_warded_day.equals("Day")|| combo_warded_month.equals("Month")|| combo_warded_year.equals("Year")|| combo_discharge_day.equals("Day")|| combo_discharge_month.equals("Month")|| combo_dischage_year.equals("Year")){
            throw new Exception();
            }
             String input =  "Name: " + text_name.getText() +"\nIC: " + text_ic.getText() +"\nAge: "+text_age.getText()+ "\nAddress: " + text_address.getText() + "\nGender:  " + button_group1.getSelection().getActionCommand()
                            + ".\nPet Name: " + text_pet_name.getText() + ".\nPet Type: " + text_pet_type.getText() + ".\nPet Age: " + text_pet_age.getText() + ".\nPet Feature: " +  text_pet_feature.getText()
                            + "\nHistory: " + button_group3.getSelection().getActionCommand() + "\nPet Disease: " + text_pet_disease.getText()+"\nDate: " + combo_day.getSelectedItem().toString()+ " "+combo_month.getSelectedItem().toString()+ " "
                            + combo_year.getSelectedItem().toString()+ "\nMedicine: " + text_medicine.getText()+ "\nPrescription: " + text_prescription.getText()+ "\nPrice: " + text_price.getText() + "\nNeed To Be Warded:  "
                            + button_group2.getSelection().getActionCommand() +"\nWard Number: " + text_wardnum.getText()+ 
                            "\nWarded Day: " + combo_warded_day.getSelectedItem().toString()+ " " +combo_warded_month.getSelectedItem().toString()+ " " +combo_warded_year.getSelectedItem().toString()+"\nDischarge Day: "+combo_discharge_day.getSelectedItem().toString()+ " "
                            + combo_discharge_month.getSelectedItem().toString()+ " " + combo_dischage_year.getSelectedItem().toString()+"\nWard Price: RM"+text_ward_price.getText()
                            ;

			   fr = new FileWriter(file,true);
			   br = new BufferedWriter(fr);
			   pr = new PrintWriter(br);
			   pr.println(input);
            JOptionPane.showMessageDialog(f,"Input is saved in file"); 
            
		}  catch (Exception e) {			
            JOptionPane.showMessageDialog(f,"All Field Must be Filled and file name can not be empty."); 
		}  finally {
			   try {
				   pr.close();
				   br.close();
				   fr.close();
			}  catch (IOException e) {
				 JOptionPane.showMessageDialog(f,"There is an error."); 
			}
		}
    }
    public void create_file(){
      
         JFrame f= new JFrame();
         first_name = JOptionPane.showInputDialog("File Name"); 
         
         try{
            if (first_name.equals("")){
               throw new Exception();}
            x = new Formatter(first_name + ".txt");
            JOptionPane.showMessageDialog(f,"File is created");}
         catch(Exception e){
            JOptionPane.showMessageDialog(f,"File is not created");
         }
      
      }
   

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    char c = e.getKeyChar();
    
    try{
      int a = Integer.parseInt(text_ic.getText());
      int b = Integer.parseInt(text_ic.getText());
      int z = Integer.parseInt(text_age.getText());
      int d = Integer.parseInt(text_pet_age.getText());
      int v = Integer.parseInt(text_price.getText());
      int f = Integer.parseInt(text_ward_price.getText());

      
    }
    catch(NumberFormatException e1){
     if (Character.isLetter(c)){
         text_ic.setEditable (false);
         text_age.setEditable (false);
         text_pet_age.setEditable (false);
         text_price.setEditable (false);
         text_ward_price.setEditable (false);
         label_error.setText("The IC, Age, Price and Ward Price field only can contain Number.");

      } 
      else{
         text_ic.setEditable (true); 
         text_age.setEditable (true);
         text_pet_age.setEditable (true); 
         text_price.setEditable (true); 
         text_ward_price.setEditable (true);
         label_error.setText("");
      }
     }
  }
    

    public void keyReleased(KeyEvent e) {
   }
}

public class Veterinary_Registration_System{
   
   public static void main(String[] args){
 
   JFrame f = new JFrame("Panel Login System");
   panel_login_systems login_panel = new panel_login_systems(f);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   f.add(login_panel, BorderLayout.CENTER);
   f.setSize(350,200);
   f.setVisible(true); 

   }
}