/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipplprob4;

import java.util.Objects;

/**
 *
 * @author ism2015006
 */
class luxury
{
    double difficulty,price,value,luxuryRating;
}
class essential
{
    double price, value;
}
class utility
{
    double utilityValue, utilityClass, price ,value;
}
public class gift {
    double price;
    int type;
    String name;
    String x = new String("luxury");
    String y = new String("essential");
    String  z = new String("utility");
    luxury l = new luxury();
    essential e = new essential();
    utility u = new utility();
    double price()
    {
        if(Objects.equals(this.type,x ))
        {
            
            return this.l.price;
        }
        else if (Objects.equals(this.type,y ) )
        {
            this.price = this.e.price;
            return this.e.price;
        }
        else
        {
            this.price = this.u.price;
        }
        return 0;
    }
    String getType()
    {
        if(type ==  0)
        {
            return "luxury";
        }
        else if (type == 1)
        {
            return "essential";
        }
        else
        {
            return "utility";
        }
        
    }
    
}
