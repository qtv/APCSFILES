public class Magazine { 
private static double SUBSCRIPTION_DISCOUNT = .60; 

private String title; 
private String publisher; 
private double newsstandPrice; 


public Magazine(String theTitle, String thePublisher, double theNewsPrice) { 
title = theTitle; 
publisher = thePublisher; 
newsstandPrice = theNewsPrice;	
}	

    Magazine(String popular_Mechanics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public String getTitle() { 
return title; 
} 

public String getPublisher() { 
return publisher; 
} 

public double getNewsstandPrice() { 
return newsstandPrice; 
} 

public double getSubscriptionPrice() { 
// implementation not shown 
    return 0;
} 

public void setNewsstandPrice(double newPrice) { 
newsstandPrice = newPrice; 
} 
} 