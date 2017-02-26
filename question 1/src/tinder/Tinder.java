/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author santosh
 */
public class Tinder {

    /**
     * @param args the command line arguments
     */
    public static class couple
    {
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
        public int check()
        {
            if(this.gAttr >= this.bMattr && this.bBudget >= this.gMain && this.bIntel >= this.gPintel && this.bAttr >= this.gPattr)
                return 1;
       
                
            return 0;
        }
        
        
    }
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        int i;
        couple pairs[] = new couple[10];
       
        
        
       // Scanner scan = new Scanner(System.in);
        
       
      File file = new File(System.getProperty("user.dir")+"/input");
        Scanner scan = new Scanner(file);
     int n = scan.nextInt();
     
     for(i=0;i<n;i++)
       {
           pairs[i]=new couple();
          // System.out.println("Checkpoint1");
            pairs[i].gName = scan.next();
           //  System.out.println("Checkpoint2");
           pairs[i].bName = scan.next();
           pairs[i].bAttr = scan.nextInt();
           pairs[i].bIntel = scan.nextInt();
           pairs[i].bBudget = scan.nextInt();
           pairs[i].bHappy = scan.nextInt();
           pairs[i].bMattr = scan.nextInt();
           
            pairs[i].gAttr = scan.nextInt();
            pairs[i].gIntel = scan.nextInt();
            pairs[i].gMain = scan.nextInt();
            pairs[i].gHappy = scan.nextInt();
            pairs[i].gPintel= scan.nextInt();
            pairs[i].gPattr = scan.nextInt();
            
       }
        
     for(i=0;i<n;i++)
     {
         if ( pairs[i].check()!=0 )
         {
             System.out.println(pairs[i].bName+" and "+pairs[i].gName+" are couple.");
         }
         else
         {
             System.out.println(pairs[i].gName + " rejected " + pairs[i].bName);
         }
     }
        
        
       
        
    }
    
}
