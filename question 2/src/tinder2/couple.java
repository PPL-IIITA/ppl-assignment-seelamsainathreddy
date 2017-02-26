/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinder2;
import java.lang.Math;
import java.util.Objects;
/**
 *
 * @author sainath reddy
 * here am taking all inputs for a couple in one class boy + girl
 */

public class couple {
     String bName;
        String gName;
        int bAttr,gAttr; 
        int bBudget,gMain;
        int bHappy,gHappy;
        int bIntel,gIntel;
        int cHappy;
        int  cComp;
        int bMattr;
        int gPintel,gPattr;
        String bType,gType;
        int totalPriceSpent;
        
        
        
        
        /*
        this distributes the gifts to his girlfriend
        */
        public int gifter(gift[] gifts, int budget,int n)
        {
            int i;
            if(budget < gifts[0].price)
            {
                this.totalPriceSpent = gifts[0].price;
                this.bBudget = gifts[0].price;
                return 1;
            }
            else
            {
                for( i = 0; i < n && budget >= gifts[i].price;i++)
                {
                    budget = budget - gifts[i].price;
                }
                this.totalPriceSpent = this.bBudget - budget;
            }
            //System.out.println(this.totalPriceSpent+" "+this.bBudget);
            return i;
        }
        
        
        
        //this checks the couple commits or not
        public int check()
        {
            if(this.gAttr >= this.bMattr && this.bBudget >= this.gMain && this.bIntel >= this.gPintel && this.bAttr >= this.gPattr)
                return 1;
       
                
            return 0;
        }
        public int happiness()
        {
            //System.out.println(this.totalPriceSpent);
             if(Objects.equals(this.gType, new String("normal")))
            {
              //  System.out.println("Girl is normal");
                this.gHappy = this.totalPriceSpent;
            }
            
             
             
             else if(Objects.equals(this.gType, new String("desperate")) )
            {
                this.gHappy = (int)Math.pow(2.0,(double)(this.totalPriceSpent));
            }
           
             
             else
            {
                this.gHappy = (int)Math.log((double)(this.totalPriceSpent));
            }
             
             
             
            //System.out.println("Girl Happines is "+this.gHappy);
            
            
            
            //Calculates the happiness of the boy based on his type
            
            
            if(Objects.equals(this.bType, new String("miser")))
            {
                this.bHappy = this.bBudget - this.totalPriceSpent;
            }
            
            
            else if (Objects.equals(this.gType, new String("geek")))
            {
                this.bHappy = this.gIntel;
            }
            
            
            else
            {
                this.bHappy = this.gHappy;
            }
            
            //System.out.println("Boy Happiness is "+this.bHappy);
            return this.bHappy + this.gHappy;
            
        }
        
        

    /**
     *
     * @param this calculates the happiness and campatability 
     */
    public void relationValue(gift[] gifts,int n)
    {
        int noGifts,i;
        if( Objects.equals(this.bType, new String("miser"))||Objects.equals(this.bType, new String("geek")) )
        {
            noGifts = gifter(gifts,this.gMain,n);
            
        }
        else
        {
            noGifts = gifter(gifts, this.bBudget,n);
        }
       // System.out.println(noGifts); 
        
        //this prints the gifts to his gf
        System.out.println("this pair " + this.bName +" " + this.gName +" gave gifts");
        for ( i = 0 ; i < noGifts ; i++)
               System.out.println(gifts[i].name);
        
        
        this.happiness();
        this.compatability();
            
    }
 
    public int compatability(){
        
        this.cComp = Math.abs(this.bIntel - this.gIntel) + Math.abs(this.bAttr - this.gAttr) + (this.bBudget - this.gMain);
        return this.cComp;
                
    }
}


