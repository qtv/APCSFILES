public class phLevels {
    public static void main(String [ ] args) {
        
    double [] phLevels = {5.6, 6.2, 6.0, 5.5, 5.7, 6.1, 7.4, 5.5, 5.5, 6.3, 6.4, 2.1, 6.9 } ;
    
    double min = Double.MAX_VALUE;
     
        for(int i = 0; i < phLevels.length; i++)
        {
            if (phLevels[i] < min)
                min = phLevels[i];
        }
        
    double max = Double.MIN_VALUE;
    double total = 0;
    for(int i = 0; i < phLevels.length; i++)
        {
            if (phLevels[i] > max)
                max = phLevels[i];
            
            if (phLevels[i] != max && phLevels[i] !=min) {
                total= total + phLevels[i];
            }
        }
    
    double average = total / (double)(phLevels.length - 2);
    
    for(int i = 0; i < phLevels.length; i++) {
        if (phLevels[i] != max && phLevels[i] !=min) {
                System.out.println(phLevels[i]);
    }
    }
    System.out.printf("\n%s%1.2f", "Average: ", average);
}
}
