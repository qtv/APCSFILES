public class fermantheorem {
    public static void main(String[] args)
    {
        
    int a = 5;
    int b = 4;
    int c = 2;
    int n= 1;
    
    if (((Math.pow(a, n) + Math.pow(b, n)) == Math.pow(c, n)) && n!= 2) {
                        System.out.println("Fermat was wrong!");
                }
                else {
                        System.out.println("Fermat was correct!");
                }   

}
}
