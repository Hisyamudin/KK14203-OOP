import java.util.Scanner;

abstract class Profile{              //Abstraction
    String name, name1, address, contact_number,birth_date, email, day, month, year, gender;
    int age;
   
   Profile (String profile_name){
      name = profile_name;
   }
   abstract void set_profile (String name, String contact, String emails, String birth, String addresses, String days , String months,String years,String genders);
   
    String doctor_print_gui (){
      String text = "-------------------------------------------\n";
      text += "              Doctor Profile             \n";
      text += "-------------------------------------------\n\n";
      text += "-------------------------------------------\n";
      text +=  "Name          :" + name1 ;
      text +=  "\nWork date   :"+ day + " "+month + " "+year;
       
      text += "\nGender            :" + gender;
      text += "\nContact number :" + contact_number;
      text += "\nEmail          :" + email;
      text += "\nBirth Date     :" + birth_date;
      text += "\nAddress:" + address;
      text += "\n-------------------------------------------\n";

     return text;
    }

   }
   
class Doctor extends Profile{

   Doctor (String profile_name){
      super(profile_name);}
      
   void set_profile (String name, String contact, String emails, String birth, String addresses, String days,String months,String years, String genders){
         name1 = name;
         contact_number = contact;
         email = emails;
         birth_date = birth;
         address= addresses;
         day=days;
         month = months;
         year = years;
         gender = genders;
      }
      
}

class Owner{
   
   private String name, ic, age, address, gender;
   
   Owner( String names, String ics, String ages, String addresses, String genders){
      name = names;
      ic = ics;
      age = ages;
      address = addresses;
      gender = genders;
   }
      
   
   String owner_print_gui (){
      String text = "-------------------------------------------\n";
      text += "              Owner's Information             \n";
      text += "-------------------------------------------\n\n";
      text += "-------------------------------------------";
      text +=  "\nName         :" + name ;
      text +=  "\nIC           :"+ ic;
       
      text += "\nAge           :" + age;
      text += "\nAddress       :" + address;
      text += "\nGender        :" + gender;
      text += "\n-------------------------------------------\n";

     return text;
    }

}

class Pet{
   private String name, type, age, feature, history;

   Pet( String names, String types, String ages, String features, String histories){
      name = names;
      type = types;
      age = ages;
      feature = features;
      history = histories;
   }
   
   String pet_print_gui (){
      String text = "-------------------------------------------\n";
      text += "              The Pet Information             \n";
      text += "-------------------------------------------\n\n";
      text += "-------------------------------------------";
      text +=  "\nName          :" + name ;
      text +=  "\nType          :"+ type;
       
      text += "\nAge            :" + age;
      text += "\nFeatures       :" + feature;
      text += "\nHistory        :" + history;
      text += "\n-------------------------------------------\n";

     return text;
    }
 }  
class Prescription{
   private String disease, day, month, year, medicine, prescription;
   private int price;
   
   Prescription( String diseases, String days, String months, String years, String medicines, String prescriptions, int prices){
      disease = diseases;
      day = days;
      month = months;
      year = years;
      medicine = medicines;
      prescription = prescriptions;
      price =  prices;
     
   }
   int get_prescription_price(){
      return price;}
   
   String prescription_print_gui (){
      String text = "-------------------------------------------\n";
      text += "              The Pet Prescription             \n";
      text += "-------------------------------------------\n\n";
      text += "-------------------------------------------";
      text +=  "\nDisease Name       :" + disease ;
      text +=  "\nDate Checked       :"+ day + " "+month + " "+year;
       
      text += "\nMedicine            :" + medicine;
      text += "\nPrescriptions       :" + prescription;
      text += "\nPrice (RM)          :" + price;
      text += "\n-------------------------------------------\n";

     return text;
    }

}

class Ward{
   private String need,day1, month1, year1,day2, month2, year2,ward_num;
   int ward_price;

   Ward( String needs, String ward_nums,String days1, String months1, String years1,int ward_prices,String days2, String months2, String years2){
      need = needs;
      ward_num = ward_nums;
      day1 = days1;
      month1 = months1;
      year1 = years1;
      day2 = days2;
      month2 =  months2;
      year2 = years2;
      ward_price = ward_prices;
     
   }
   int get_ward_price(){
      return ward_price;}
   
   String ward_print_gui (){
      String text = "-------------------------------------------\n";
      text += "              The Pet Ward             \n";
      text += "-------------------------------------------\n\n";
      text += "-------------------------------------------";
      text += "\nDoes the pet need to be warded  :"+ need ;
      text += "\nWard Number                     :" + ward_num;
      text += "\nThe Pet Warded at               :"+ day1 + " "+month1 + " "+year1;
       
      
      text += "\nThe Pet Discharged at           :"+ day2 + " "+month2 + " "+year2;
      text += "\nWard Price (RM)                 :" + ward_price;
      text += "\n-------------------------------------------\n";

     return text;
    }

}