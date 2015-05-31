/*
 * 9.04 Catapult - A program that calculates the distance a catapult would throw 
 * when given a certain angle and speed.
 */

/**
 *
 * @author 
 * @version 1/04/15
 */

public class Catapult {
    
    //velocity = speed, degress = angle
     private double velocity, distance, degrees;
    
    /**
     * Default constructor for the Catapult object.
     */
     // v = row , angle = column
    public Catapult(double v, double angle)
    {
        velocity = v;
        degrees = angle;
    }
    
    public void calcDistance(){
        // v^2 sin 2 (angle) / g, where g is 9.8 m / s ^2
        distance = (Math.pow(velocity, 2) * Math.sin( 2 * Math.toRadians(degrees)) / 9.8);
    }
    /**
     * Get method for degrees.
     */
    public double getDegrees(){
        return degrees;
    }
    
     /**
     * Get method for distance.
     */
    
    public double getDistance(){
        return distance;
    }
    
    /**
     * Get method for velocity.
     */
    public double getVelocity(){
        return velocity;
    }
    
}
