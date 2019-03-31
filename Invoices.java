
package invoices;
import java.util.Scanner ;
import java.util.ArrayList ;

public class Invoices {
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        int tab_cnt = 0 ;
        int usr ;
        float total = 0  , total_due = 0;
        

        Customer customer = new Customer(null ,null ,null ,null , 0 ,0) ;     //Placeholder values 
        
        ArrayList tab = new ArrayList() ;
        System.out.println("Give the credentials of the customer") ;
        System.out.println("Name :");
        customer.Name = in.nextLine() ;
        System.out.println("Surname :") ;
        customer.Surname = in.nextLine() ;
        System.out.println("Billing Adress :");
        customer.billing_adress = in.nextLine() ;
        System.out.println("Shipping Adress :") ;
        customer.shipping_adress = in.nextLine() ;
        System.out.println("Customer payment :") ;
        customer.payments = in.nextFloat() ;
        
        System.out.println("Give the information of the product");
        while (tab_cnt == 0){                                           //Give multiple products
        Product product =  new Product (null , 0 , 0, 0) ;
        System.out.println("Name :") ;
        product.Name = in.next() ;
        System.out.println("Single unit cost:");
        product.cost_per_product = in.nextFloat() ;
        System.out.println("Quantinty of the product:");
        product.quantinty = in.nextInt() ;
        product.price = product.cost_per_product * product.quantinty ;
        tab.add(product) ;
        total = total + product.price ;
        
        System.out.println("Stop adding products ? (1 for yes /0 for no)");
        usr = in.nextInt() ;
        System.out.print(usr);
            if(usr == 1 ){
                tab_cnt =  1 ;
                break ;
            }
        total_due = total - customer.payments ;
        } 
        //Full invoice print 
        System.out.println("=================================================================\n");
        System.out.println("The completed invoice for the customer is as follows :") ;
        System.out.println ("Customer name : " + customer.Name + " " + customer.Surname) ;
        System.out.println("-----------------------------------------------------------------") ;
        System.out.println("Billing Adress : " + customer.billing_adress +" \nShipping Adress : " + customer.shipping_adress) ;
        System.out.println("Payment by customer : " + customer.payments + " $");
        System.out.println("=================================================================");
        
        Product products = new Product(null, 0 ,0 ,0) ;
        for (int i = 0 ; i < tab.size() ; i++) {
            products = (Product) tab.get(i) ;
            System.out.println("Product bought : " + products.Name);
            System.out.println("-----------------------------------------------------------------") ;
            System.out.println("Cost per unit :" + products.cost_per_product + " $" +"\nTotal units : " + products.quantinty + " $") ;
            System.out.println("-----------------------------------------------------------------") ;
            }
        
        if(total_due  < 0) {
            System.out.println("Full price has been payed\n");
            System.out.println("=================================================================\n \n");
        }
        else {
            System.out.println("Payments due by the customer : " + total_due + " $\n") ;
            System.out.println("=================================================================\n \n");
        }
    }
    
}
class Customer {       //Customer Credentials
       String Name ;
       String Surname;
       String billing_adress ;
       String shipping_adress ;
       float payments ;
       float payments_due ;
        public Customer (String Name , String Surname , String billing_adress , String shipping_adress ,float payments , float payments_due){
            this.Name = Name ;
            this.Surname = Surname ;
            this.billing_adress = billing_adress ;
            this.shipping_adress = shipping_adress ;
            this.payments = payments_due ;
            this.payments_due = payments_due ;
        }
   }
class Product {          //Product details
       String Name ;
       float cost_per_product ;
       int quantinty ;
       float price ;
       
       public Product  (String name ,float cost_per_product , int quantinty , float price){
            this.Name = name ;
            this.cost_per_product = cost_per_product ;
            this.quantinty = quantinty ;
            this.price = price ;
            
            
   }
}