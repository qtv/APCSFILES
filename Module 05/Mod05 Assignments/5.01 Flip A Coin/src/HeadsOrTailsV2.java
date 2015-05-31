/*
 * To change this license header, choose License Headers in Project Properties.
 */
/**
 *
 * @author 
 */
import java.util.Scanner;
public class HeadsOrTailsV2
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        // random method to simulate the ouctome of flipping a coin
        
        // ask for the amount of the coin flip
        
        System.out.println("How many times will you flip the coin?");
        Integer userFlipAmount = in.nextInt();
        
        Integer realFlipAmount = 0;
        
        int headsAmount = 0;
        int tailsAmount = 0;
        
        while (realFlipAmount < userFlipAmount) {
            realFlipAmount++;
            
           double randomNumber = Math.random() +0.1;  // random number between
           // 0 and 1, biased by positive 0.1
           
           if (randomNumber < 0.5) { 
               headsAmount++;
               System.out.println("H " + randomNumber);}
           else if (randomNumber > 0.5) {
            tailsAmount++;
             System.out.println("T " + randomNumber);
           }
           else {
               System.out.println("Error!");
           }
           
          
        }
         System.out.println("Heads : " + headsAmount);
        System.out.println("Tails : " + tailsAmount);
                   
            
        
        }
    }
