/*
 * To change this license header, choose License Headers in Project Properties.
 *
 */

/**
 *
 * @author 
 */
public class PointsOnACircleV1 {
    public static void main(String[] args) {
        
    double[] xCoord = { 1.0, 0.90, 0.80, 0.70, 0.60, 0.50, 0.40, 0.30, 0.20, 0.10, 0.00, -0.10, -0.20, -0.30, -0.40, -0.50, -0.60, -0.70,-0.80, -0.90, -1.00 };

        double radius = 1.0;

        System.out.println("      Points on a Circle of Radius 1.0");
        System.out.println("       x1        y1        x2        y2");
        System.out.println("---------------------------------------------");
        
        double y2= 0.0;
        double y1 = 0.0;
        
        for (int i = 0; i < xCoord.length; i++) {
            
            y1 = Math.sqrt(Math.pow(radius,2) - Math.pow(xCoord[i],2));
            
            if (y1 != 0.00)
            {
                y2 = -y1;
            }
            System.out.printf("%10.2f%10.2f%10.2f%10.2f%n", xCoord[i], y1, xCoord[i], y2);
        }
    }
    
}
