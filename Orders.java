/**
 * Created by: Cameron Wildey
 * Date: 3/2/16
 * Class: CIS 219 Wally's Widgets 
 * This program is used to take the user information given in TestOrders
 * and implement it into these methods. One method being calcProduct, another
 * for calcTotal, also a method to find the shipping cost $25 for FredEx
 * and cost per weight via USPS.
*/

public class Orders { 
    
    public static double productCost(int qty, char product) {
        
        final double WIDGET_COST = 0.25;
        final double GIZMO_COST = 0.75;
        double cost = 0.0;
        
        if(product == 'w' || product == 'W')
        
            cost = qty * WIDGET_COST;
        
        else 
            
            cost = qty * GIZMO_COST;
        
        return cost;
        
    }//end of method product cost
    
    public static double shippingCost(int qty, char product, char shipping) {
        
        final double WIDGET_PER_POUND = 12;
        final double GIZMO_PER_POUND = 16;
        final double COST_OF_FRED = 25.0;
        final double COST_OF_USPS = 1.25;
        double cost = 0.0;
        
        if(shipping == 'u' || shipping == 'U') {
            
            if(product == 'w' || product == 'W') {
                
                cost = (qty / WIDGET_PER_POUND) * COST_OF_USPS;
                
            }//end if widget
            else {
                
                cost = Math.ceil(qty / GIZMO_PER_POUND) * COST_OF_USPS;
                
            }//end else
            
        }//end of USPS
        else {
            
            cost = COST_OF_FRED;
            
        }//end of FredEx
        
        return cost;
        
    }//end of class shippingCost
    
}//end of class Orders