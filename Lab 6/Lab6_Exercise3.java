import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import javax.swing.JTextArea;

public class Lab6_Exercise3 extends JPanel implements ActionListener{
    private JLabel j_label1;
    private JLabel j_label2;
    private JButton button_add;
    private JTextArea text_area1;
    private JComboBox combo_box1;
    private JButton button_order;
    private JButton button_save;
    private static Cake cake;
    private static ArrayList<String> the_order;
      
    String txt = " ";
    String input = " ";
    String filePath="data.txt";
     
    public Lab6_Exercise3() {
        
        String[] j_combo_items = {"[Select]"};
        j_label1 = new JLabel ("Cake Menu");
        j_label2 = new JLabel ("Toppings Selection");
        button_add = new JButton ("Add Topping");
        button_save = new JButton ("Save");
        text_area1 = new JTextArea (5, 5);
        JScrollPane scroll_pane1 = new JScrollPane(text_area1);
        combo_box1 = new JComboBox (j_combo_items);
        button_order = new JButton ("Order");
       
        
        button_add.addActionListener(this);
        button_order.addActionListener(this);
        button_save.addActionListener(this);

        setPreferredSize (new Dimension (514, 325));
        setLayout (null);

        add (j_label1);
        add (j_label2);
        add (button_add);
        add (scroll_pane1);
        add (combo_box1);
        add (button_order);
        add (button_save);

        j_label1.setBounds (195, 10, 100, 25);
        j_label2.setBounds (25, 55, 125, 25);
        button_add.setBounds (365, 55, 125, 25);
        scroll_pane1.setBounds (25, 120, 465, 180);
        combo_box1.setBounds (180, 55, 180, 25);
        button_order.setBounds (365, 90, 125, 25);
        button_save.setBounds (220, 90, 125, 25);
    }
    
   public void actionPerformed(ActionEvent ae){
      String command = ae.getActionCommand(); 
      
      if(command.equals("Add Topping")){
         the_order.add(combo_box1.getSelectedItem().toString());      
         text_area1.append(combo_box1.getSelectedItem().toString() + "\n");   
      }
      else if(command.equals("Order")){
         String str_order[] = new String[the_order.size()]; 
   
         for (int j = 0; j < the_order.size(); j++) { 
            str_order[j] = the_order.get(j); 
         }
         
         cake.order_cake(str_order, 1, 2);
         txt = cake.print_cake_GUI();
         text_area1.append(txt);
      }   
      
      else if(command.equals("Save")){
          write_input();}
      
   }
    public void write_input(){
         File file = new File(filePath);
         FileWriter stream = null;
         PrintWriter pr = null;
      
         String input = "Order\nTopping: "+ the_order + "\nSize: " + cake.size + "\nQuantity: " + cake.quantity + "\nTotal Price: RM " + cake.get_total_price() + ". \n" ;
      
         try {
            stream = new FileWriter(file, true);
            pr = new PrintWriter(stream);
            pr.print(input);
      } 
         catch (IOException e) {			
            text_area1.append("cant save");

      } 
         finally {
            try {
               pr.close();
               stream.close();
         } 
         catch (IOException e) {
              text_area1.append("cant save");


        }
      }
   }
     
   public void updateCB(String[] topping){
      for(int i=0; i<topping.length; i++){
         combo_box1.addItem(topping[i]);
      }      
   }


   public static void main (String[] args) {
      cake = new Cake("Generic");
      the_order = new ArrayList<String>();
      
      JFrame frame = new JFrame ("MyPanel");
      String[] topping = {"Lava Chocolate", "Cream Cheese", "Butter Cream", "Fondant"};
      cake.setCake(topping, 45.00, 65.00, 80.00); 
      
      Lab6_Exercise3 capp = new Lab6_Exercise3(); 
      capp.updateCB(topping);
      
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (capp);
      frame.pack();
      frame.setVisible (true);
   }
}