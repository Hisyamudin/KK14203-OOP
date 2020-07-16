abstract class Cake{

   String name;
   String[] topping, topping_order;
   double price_small, price_medium, price_big, total_price;
   int size, quantity;

   Cake(String cake_name){
      name = cake_name;
   }

   abstract void set_cake (String[] tops, double small_price, double medium_price, double big_price);
         
   
   void order_cake (String[] topping_selection, int quants, int s){
      topping_order = topping_selection;
      size = s;
      quantity = quants;
   }
      
   double get_size_price(){
   double the_price = 0;
      if (size == 1){
         the_price = price_small;}
      
      else if (size == 2){
         the_price = price_medium;}
         
      else if (size == 3){
         the_price = price_big;}
      return the_price;
    }
    
    double get_total_price (){
      total_price = get_size_price() * quantity + (topping_order.length * 10);
      return total_price;
    }
      
    String get_size(){
    String the_size = " ";
      if (size == 1){
         the_size = "Small";}
      else if (size == 2){
         the_size = "Medium";}
      else if (size == 3){
         the_size = "Big";}
      return the_size;
    }
    
    void print_cake (){
      System.out.println ("-------------------------------------");
      System.out.println ("               Cake Menu             ");
      System.out.println ("-------------------------------------");
      System.out.println (name + " Cake with available toppings:");
      
      for (int i=0; i<topping.length; i++){
         System.out.println ((i+1)+ ")" + topping[i]);}
      
      System.out.println ();
      System.out.println ("Price:");
      System.out.println ("Small : RM" + price_small);
      System.out.println ("Medium: RM" + price_medium);
      System.out.println ("Big   : RM" + price_big);
      System.out.println ();
    }
    
    void print_order(){
       System.out.println ("Cake Order detail:");
       System.out.println ("-------------------------------------");
       
       System.out.println ("Topping:");
       for (int i=0; i<topping_order.length; i++){
         System.out.print (  (i+1) + ") " + topping_order[i]+" ");}
         
       System.out.println ("\nSize  :" + get_size());
       
       System.out.println ("-------------------------------------");
       System.out.println ("Total Price:" + get_total_price ());
       System.out.println ("-------------------------------------");
    }
}
class BlackForest extends Cake{

   BlackForest (String cake_name){
      super(cake_name);}
   
   void set_cake (String[] tops, double small_price, double medium_price, double big_price){
      topping=tops;
      price_small = small_price;
      price_medium = medium_price; 
      price_big = big_price;
   }
}

public class TestCake1_Lab5_Excercise3{
   public static void main(String args[]){
      Cake c = new BlackForest("BlackForest");
      String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
      c.set_cake(topping, 45.00, 65.00, 80.00);
      c.print_cake();
      String[] order = {"Chocolate", "Cherries"};
      c.order_cake(order, 1, 2);
      c.print_order();
   }
}

