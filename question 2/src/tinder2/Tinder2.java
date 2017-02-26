/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinder2;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;



/**
 *
 * @author SAINATH
 */

public class Tinder2 {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    
  /* from here the main execution starts . in this code i have created two classes couples and gifts
    and 
    couples class has attributes boy details + girl details and functions 
    check() to check where they commit or not,
    relationvalue() which calculate the happiness and campatability of the couples if commited
    happiness(),compatability() done their respective job
    
    and  gift object have price and value
    
    now my code takes input and finds the respective happiness and compatability
    and prints  all the gifts passed and prints top k happy and compatable couples
    */ 
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File file = new File(System.getProperty("user.dir")+"/input");
        Scanner scan = new Scanner(file);
        int n,i,c,j;
        n = scan.nextInt();
        gift[] gifts = new gift[n];
        
        
        
        /*
        here the gits input taken from low price to high price
        */
        
        for ( i = 0; i < n ; i++)
        {
            gifts[i] = new gift();
            gifts[i].value= scan.nextInt();
            gifts[i].price = scan.nextInt();
            gifts[i].name = scan.next();
        }
        
        
        
        
        /*
        here the input for the couples 
        which includes
        girl name ,boy name , attraction,intelligence,budget,happiness,min attration required
        type,
        girl attration,intelligence,maintainace balance,happiness,prefered intellingence from boy ,prefered attation
        tyoe
        
        */
        
        c = scan.nextInt();
        couple[] pairs = new couple[c];
        for(i=0;i<c;i++)
       {
           pairs[i]=new couple();
        //   System.out.println("Checkpoint1");
           pairs[i].gName = scan.next();
          //   System.out.println("Checkpoint2");
           pairs[i].bName = scan.next();
           pairs[i].bAttr = scan.nextInt();
           pairs[i].bIntel = scan.nextInt();
           pairs[i].bBudget = scan.nextInt();
           pairs[i].bHappy = scan.nextInt();
           pairs[i].bMattr = scan.nextInt();
           pairs[i].bType = scan.next();
           pairs[i].gAttr = scan.nextInt();
           pairs[i].gIntel = scan.nextInt();
           pairs[i].gMain = scan.nextInt();
           pairs[i].gHappy = scan.nextInt();
           pairs[i].gPintel= scan.nextInt();
           pairs[i].gPattr = scan.nextInt();
           pairs[i].gType = scan.next();
            
       //here calculates respective happiness and compatabilities
        if(pairs[i].check()==1)
        {
            pairs[i].relationValue(gifts,c);
            //System.out.println(pairs[i].bName + pairs[i].gName);
        }
       // System.out.println(pairs[i].happiness());
       // System.out.print(pairs[i].compatability());
        
        
       }
        
        
        
    /*This part of the code sorts the couples array according the happiness
        
    */
    
    couple temp = new couple();
    temp = pairs[0];
    for ( i = 0; i < c; i ++)
    {
        
        for(j = i + 1; j < c;j++)
        {
           
            if(pairs[i].cHappy > pairs[j].cHappy) {
                    temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
            } 
        }
        
      
    }
    //System.out.println("Check");
    int k = scan.nextInt();
    
    System.out.println("the k most happy couples");
    for ( i= 0; i<k; i++) {
            System.out.println(pairs[i].bName +" "+pairs[i].gName);
    }
    
    
          
    /*This part of the code sorts the couples array according the compatability
        
    */
    
    
    
    for ( i = 0; i < c; i ++)
    {
        
        for(j = i + 1; j < c;j ++)
        {
            if(pairs[i].cComp > pairs[j].cComp) {
                    temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
            } 
        }
        
    }
    
    k = scan.nextInt();
    
    System.out.println("the k most compatable couples");
    for ( i= 0; i<k; i++) {
            System.out.println(pairs[i].bName +" " + pairs[i].gName);
    }
}
}



