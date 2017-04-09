/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipplprob4;
import java.util.Objects;
/**
 *
 * @author ism2015006 seelamsainath reddy
 */

public class DatingCouples {
    girl g = new girl();
    boy b = new boy();
    double happiness;
    double compatability;
    double totalPriceSpent;
    DatingCouples(girl g,boy b)
    {
        this.g = g;
        this.b = b;
    }
    /**
     * this function performs the break up for last k couples and rearranges the couples and
     * prints the new couples formed
     * @param pair
     * @param coupleCount
     * @param k 
     */
        public static void brokeUpAndReassign(DatingCouples pair[],int coupleCount,int k){
        int i;
        
        System.out.println("These couples broke up");
	for( i = coupleCount - 1; i >= coupleCount - k  ; i -- )
	{
			System.out.println(pair[i].b.naam + " " + pair[i].g.naam );
	}
	boy boytemp = new boy();
	for ( i = coupleCount - k ; i < coupleCount - 1; i ++ )
	{	
		boytemp = pair[i].b;
		pair[i].b = pair[i+1].b;
		pair[i + 1].b = boytemp;
	}
	int temp ;
	temp = coupleCount;
	coupleCount = coupleCount - k;
	for ( i = temp - k; i < temp ; i ++ )
	{
		if(DatingCouples.examineCouple(pair[i].b, pair[i].g))
		{
			pair[coupleCount] = pair[i];
			coupleCount ++;
		}
	}
	System.out.println("The newly formed couples are");
	for ( i = temp - k; i < coupleCount; i ++ )
	{       System.out.println(i);
		System.out.println(pair[i].b.naam+" " + pair[i].g.naam);
	}
    }
        /**
         * this sorts the so formed couples according to their happiness value
         * @param pair
         * @param numberOfCouples 
         */
    
  public static void sortByHappiness(DatingCouples pair[],int numberOfCouples){
       
      DatingCouples dummy = new DatingCouples(null,null);
    for ( int x = 0; x < numberOfCouples;x++)
    {     
        for(int y = x + 1; y < numberOfCouples; y ++ )
        {
              if(pair[x].happiness > pair[y].happiness);
              {
                    dummy = pair[x];
                    pair[x] = pair[y];
                    pair[y] = dummy;
            } 
          
        }
    }
  }
  /**
   * this sorts the couples according to the compatability value
   * @param pair
   * @param numberOfCouples 
   */
   public static void sortByCompatability(DatingCouples pair[],int numberOfCouples){
       
      DatingCouples dummy = new DatingCouples(null,null);
    for ( int x = 0; x < numberOfCouples;x++)
    {     
        for(int y = x + 1; y < numberOfCouples; y ++ )
        {
              if(pair[x].compatability > pair[y].compatability);
              {
                    dummy = pair[x];
                    pair[x] = pair[y];
                    pair[y] = dummy;
            } 
          
        }
    }
  }
    
   
   
   
 /**
  * Checks whether a couple can have a long date
  * @param b
  * @param g
  * @return 
  */  
 public static boolean examineCouple(boy b,girl g){
     if(g.maintainance <= b.paise && g.sundar >= b.minimumSundarRequire){ 
           return true;
     }
     else 
     {
         return false;
     }
     }
    
    
    
    
   
    
    /**
     * assigns gifts according to a greedy approach
     * @param gifts
     * @param budget
     * @param n
     * @return 
     */
    int distributeGifts(gift[] gifts, double budget,int n)
    {
         int i;

            if(budget < gifts[0].price)
            {
         
                this.totalPriceSpent = gifts[0].price;
                b.paise = gifts[0].price;
                return 1;
            }
            else
            {
                for( i = 0; i < n && budget >= gifts[i].price;i++)
                {

                    b.paise = b.paise - gifts[i].price;
                }
                this.totalPriceSpent = b.paise - budget;
            }

            return i;
    }
    
    
    
    
    
    /**
     * calculates the happpiness and compatabilities of couples and prints the gifts that are being passed
     * @param gifts
     * @param n 
     */
    public void calculateRelation(gift[] gifts,int n)
    {
        int noGifts,i;
        if(Objects.equals("1",b.kaise) || Objects.equals("2", b.kaise) )
        {
            noGifts = distributeGifts(gifts,g.maintainance,n);
       
        }
        else
        {
            noGifts = distributeGifts(gifts, b.paise,n);
      
        }
 
        
        
        
        
        
        
        System.out.println("The gifts are");
        for ( i = 0 ; i <= noGifts - 1 ; i++)
              System.out.println("\t"+gifts[i].name+" which costs "+"rs." + gifts[i].price + " is 0f type "+ gifts[i].getType());
        System.out.print("\n");
        
        
        happiness = this.calculateHappiness();
        compatability = this.calculateCompatability();
            
    }
    
    
    
    
    
    
    /**
     * Calculates compatibility
     * This function calculates the compatability as the sum of absolute difference 
     * between attractions and intelligence and the remaining money the boy has with him
     */
    public double calculateCompatability(){
        
        this.compatability = Math.abs(b.buddi - g.buddi) + Math.abs(b.sundar - g.sundar) + (b.paise - g.maintainance);
        return this.compatability;
                
    }
    
    
    
    
    
    
    
    //Calculates happiness
    public double calculateHappiness()
        {
 //           System.out.println(this.totalPriceSpent);
             if(Objects.equals(g.kounsa, new String("1")))
            {

                g.happiness = this.totalPriceSpent;
            }
            
             
             
            else if(Objects.equals(g.kounsa, new String("2")) )
            {
                g.happiness = Math.pow(2.0,(double)(this.totalPriceSpent));
            }
           
             
             else
            {
                g.happiness= Math.log((double)(this.totalPriceSpent));
            }
             
             
             
         
            
            
            
            //Calculates the happiness of the boy based on his type
            
            
            if(Objects.equals(b.kaise, new String("1")))
            {
                b.happiness = b.paise - this.totalPriceSpent;
            }
            
            
            else if (Objects.equals(b.kaise, new String("2")))
            {
               b.happiness = g.buddi;
            }
            
            
            else
            {
                b.happiness = g.happiness;
            }
            

            return b.happiness + g.happiness;
            
        }
    
  
}