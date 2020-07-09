import java.util.Scanner;

class Menu{
   String item;
   double price;
   
   Menu(String food, double a){
     this.item=food;
     this.price=a;}
      
   double get_price(){
      return this.price;}
   
   void print_item(){
      System.out.print(this.item);
      System.out.print(" [RM"+get_price()+"]");}
}

public class Lab4_Exercise3{
   public static void main (String args[]){
   
   Menu[] menu = new Menu[3]; 
   menu[0] = new Menu("[1]Nasi Goreng", 4.00);
   menu[1] = new Menu("[2]Vanilla Shake",5.00);
   menu[2] = new Menu("[3]Cake",7.00);
   
   System.out.print("The Menu is:\n");
   menu[0].print_item();
    System.out.println();
   menu[1].print_item();
    System.out.println();
   menu[2].print_item();

   
   Scanner food = new Scanner (System.in);
   Scanner quant = new Scanner (System.in);
   String ch;
   
   double sum=0,sum_only;
    
   do{
     System.out.println("\nAdd menu by typing 1,2 and 3. Then press q to exit: ");
     ch = food.nextLine();
     
       if (ch.charAt(0)  == '1'){
        System.out.println("Nasi Goreng [RM4.00] was added to the menu\nThe quantity is:");
        int quantity;
        quantity = quant.nextInt();
        sum += (menu[0].get_price() * quantity);
        sum_only = (menu[0].get_price() * quantity);
        System.out.println("The total prize for Nasi Goreng is: RM"+sum_only);
         }
       else if (ch.charAt(0)  == '2'){
        System.out.println("Vanilla Shake [RM5.00] was added to the menu\nThe quantity is:");
        int quantity;
        quantity = quant.nextInt();
        sum += (menu[1].get_price() * quantity);
        sum_only = (menu[1].get_price() * quantity);
        System.out.println("The total prize for Vanilla Shake is: RM"+sum_only);
         }
       else if (ch.charAt(0)  == '3'){
        System.out.println("Cake [RM7.00] was added to the menu\nThe quantity is:");
        int quantity;
        quantity = quant.nextInt();
        sum += (menu[2].get_price() * quantity);
        sum_only = (menu[2].get_price() * quantity);
        System.out.println("The total prize for Cake is: RM"+sum_only);

         }
       else if (ch.charAt(0) == 'q'){
          break;
          }
       else{
        System.out.println("Please input number such as 1,2,3.");
       }
       
    }while(ch.charAt(0) !='q');
     System.out.print("Your total payment is RM" + sum);
    System.out.println(" \nThank you for your order. ^_^");
   }
  }
