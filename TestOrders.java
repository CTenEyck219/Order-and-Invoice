/**
 * Created by: Cameron Wildey
 * Date: 3/2/16
 * Class: CIS 219 Wally's Widgets
 * This program is to receive an order for widgets or gizmos from the user
 * and take the user input and use it in the methods housed in class orders
 * that will take the information and depending on the user input and give
 * the current order along with the total orders that are made throughout the 
 * duration of the program being run.
*/

import java.text.DecimalFormat;
import javax.swing.*;

public class TestOrders {
    
    public static void main(String[] args) {
        
        takeOrders();
        
    }//end of main
    
    public static void takeOrders() {
        
        DecimalFormat mine = new DecimalFormat("$##.00");
        //initiating attributes
        String name, selection, userQty, shipping;
        char product, shippingMethod;
        int qty;
        int totalWidget = 0, totalGizmo = 0, counter = 0;
        double totalShipping = 0.0, costTotal = 0.0, totalProductGizmo = 0.0;
        double totalProductWidget = 0.0;
        double productCost, shippingCost = 0.0, totalCost =0.0;
        
        boolean done = false;
        String userInput;
        
         while(!done) {
             name = JOptionPane.showInputDialog("Enter Customer name");
        
            selection = JOptionPane.showInputDialog("Enter order type :\nw - "
                    + "widget \ng - gizmo");
              product = Character.toUpperCase(selection.charAt(0));
        
            switch (product) {
                case 'W':
                    userQty = JOptionPane.showInputDialog("Enter the quantity "
                            + "of widgets (ordered by the dozen - input of "
                            + "1 = 12 widgets)");
                    qty = Integer.parseInt(userQty);
                    qty = qty * 12;
                    if(qty > 144 || qty < 0){
                        userQty = JOptionPane.showInputDialog("The amount you "
                                + "enterd exceeds the limit of 144 widgets that"
                                + " can be ordered. \nPlease place a smaller "
                                + "order (Max 12)");
                       qty = Integer.parseInt(userQty);
                      qty = qty * 12;
                   }//end of if widget order over 144
                  shipping = JOptionPane.showInputDialog("Enter shipping type:"
                           + "\nf - FredEx \nu - USPS");
                  shippingMethod = Character.toUpperCase(shipping.charAt(0));
                 switch(shippingMethod) {
                        case 'F':
                            shippingCost = Orders.shippingCost(qty, product, 
                                 shippingMethod);
                            shipping = "FredEx";
                            break;    
                        case 'U':
                           shippingCost = Orders.shippingCost(qty, product, 
                                    shippingMethod);
                            shipping = "USPS";
                            break;
                        default: 
                            JOptionPane.showMessageDialog(null, "The "
                                    + "information that you enterd was "
                                    + "incorrect. Please try again");
                            break;
                    }//end switch case for shipping widget
                    productCost = Orders.productCost(qty, product);
                    totalCost = productCost + shippingCost;
                   JOptionPane.showMessageDialog(null, "Customer: " + name + 
                           "\nOrdered " + qty + " Widgets costing " + 
                            mine.format(productCost) + "\nShipped via " + 
                         shipping + " costing " + mine.format(shippingCost) +
                         "\nTotal order cost is "  + mine.format(totalCost));
                    totalWidget += qty;
                    totalShipping += shippingCost;
                    totalProductWidget += productCost;
                    costTotal += totalCost;
                    counter++;
                    break;
                case 'G':
                    userQty = JOptionPane.showInputDialog("Enter the quantity"
                            + " of gizmos (ordered by dozen - "
                            + "input of 1 = 8 gizmos)");
                    qty = Integer.parseInt(userQty);
                    qty = qty * 8;
                   if(qty < 0) {
                        userQty = JOptionPane.showInputDialog("You have "
                                + "entered a number that is below 0. "
                                + "\nPlease re-enter the"
                                + " quantity of gizmos you wish to order");
                    qty = Integer.parseInt(userQty);
                    qty = qty * 8;
                    }
                    shipping = JOptionPane.showInputDialog("Enter shipping "
                            + "type: \nf - FredEx \nu - USPS");
                    shippingMethod = Character.toUpperCase(shipping.charAt(0));
                    switch(shippingMethod) {
                       case 'F':
                            shippingCost = Orders.shippingCost(qty, product, 
                                   shippingMethod);
                            shipping = "FredEx";
                            break;    
                        case 'U':
                            shippingCost = Orders.shippingCost(qty, product, 
                                    shippingMethod);
                            shipping = "USPS";
                           break;
                       default: 
                         JOptionPane.showMessageDialog(null, "The information"
                                  + " that you enterd was incorrect. "
                                  + "Please try again");
                         break;
                  }//end switch case for shipping gizmo
                 productCost = Orders.productCost(qty, product);
                 totalCost = productCost + shippingCost;
                 JOptionPane.showMessageDialog(null, "Customer: " + name + 
                           "\nOrdered " + qty + " Gizmos costing " + 
                            mine.format(productCost) + "\nShipped via " + 
                         shipping + " costing " + mine.format(shippingCost) +
                         "\nTotal order cost is "  + mine.format(totalCost));
                 totalGizmo += qty;
                 totalShipping += shippingCost;
                 totalProductGizmo += productCost;
                 costTotal += totalCost;
                 counter++;
                 break;
              default:
                 JOptionPane.showMessageDialog(null, "The information that you "
                          + "enterd was incorrect. Please try again");
                    break;  
            }//end of switch
            
            userInput = JOptionPane.showInputDialog("Would you like to place"
                    + " another order? Y/N");
            char answer = userInput.charAt(0);
            
            if(answer == 'N' || answer == 'n') {
                done = true;
                
            }//end of if statement
            
          }//end of while loop
         
         JOptionPane.showMessageDialog(null, "Summary Report: \n" + counter + 
                 " Total Orders: \n" + totalGizmo + " Gizmos were sold -----"
                 + "Revenue ----- " + mine.format(totalProductGizmo) + "\n" + 
                 totalWidget + " Widgets were sold -----Revenue----- "
                 + mine.format(totalProductWidget) + "\n      Total "
                 + "------Revenue----- " + mine.format(costTotal));
        
    }//end of method takeOrders
    
}//end of class testOrders