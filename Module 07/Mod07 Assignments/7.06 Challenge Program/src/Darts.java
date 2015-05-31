
import java.util.Scanner;

/*
 * 7.06 Challenge Program - Calculates the value of pi by simulating throwing darts
 * at a board
 *
 */

/**
 *
 * @author 
 * @date 12/18/14
 */

public class Darts {
    
    public static int hits (double x, double y, int times) {
        
    double radius = 1.0;
    int totalHits = 0;
    
    x = 0;
    y = 0;
    
    for (int i = 0; i < times; i++) {   
    x = (2 * Math.random()-1);
    y = (2 * Math.random()-1); 
    if ((Math.pow(x, 2) + Math.pow(y, 2)) <= (Math.pow(radius, 2))) {
        totalHits++;
    }
        //System.out.println(totalHits);
    }
    return totalHits;          
       } 
    
    public static double pi (int totalHits, int tThrows) {
        
        double pi = 4 * ((double)totalHits / (double)tThrows);  // converting everything to double fixed accuracy errors
        
        // DEBUG
        //System.out.println("total hits " + totalHits);
        //System.out.println("darts/trial " + tThrows);
        //System.out.println("pi: "+  pi);
        
        return pi;
    }
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("How many darts/trials? ");
        int tThrows = in.nextInt();
        
        System.out.println("And how many trials? ");
        int trials = in.nextInt();
        System.out.println();
        
        double x = 0;
        double y = 0;
        double aTotal = 0;
        double average = 0;
        
        for (int i = 0; i < trials; i++) {
            
            int tHits = hits(x,y,tThrows);
            double piTOTAL = pi(tHits, tThrows);
            
            aTotal = aTotal + piTOTAL;
            
            System.out.printf("%s%5f\n","Trial [" + (i+1) + "]: pi = ", piTOTAL); 
        }
        average = (aTotal / trials);
        System.out.printf("Estimate of pi = %1f", average);
    }
    }
    

