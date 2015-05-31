/**
 * @title 18.03 Challenge Program - uses arrays & sorts & searches thru them
 * @author 
 * @date 5/25/15
 */
public class TestContact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contact[] myContacts = new Contact[6];
        
        myContacts[0] = new Contact("John Carter","brother","Mar 3","(342)555-7069","jcarter@carter.com");
        myContacts[1] = new Contact("Elise Carter","mom","Apr 19","(342)555-7011","carterMom@carter.com");
        myContacts[2] = new Contact("Ellie Carter", "me","Jun 10","(342)555-8102","ecarter@carter.com");
        myContacts[3] = new Contact("Sue Ellen","friend","Mar 9","(341)555-9182","susieE@hotmail.com");
        myContacts[4] = new Contact("Frank Carter", "dad","Dec 1","(342)555-7011","carterDad@carter.com");
        myContacts[5] = new Contact("Johnnie","friend","Jan 21","(341)555-7789","jDawg5555@yahoo.com");
        
        System.out.println("                    Contact List\n\n");
        printContacts(myContacts);
       
        System.out.println();
        sortName(myContacts);
        
        
        if (findByName(myContacts, "Johnnie") != -1)
            System.out.println("Found the listing(s): " + myContacts[findByName(myContacts, "Johnnie")]);
        else
            System.out.println("There were no listings\n");
           
        
        if (findByName(myContacts, "Sam Parker") != -1)
            System.out.println("Found the listing(s): " + myContacts[findByName(myContacts, "Sam Parker")]);
        else
            System.out.println("There were no listings");
           
        // RELATIONS
        System.out.println("");
        findByRelation(myContacts, "friend");
       
        System.out.println("");
        findByRelation(myContacts, "aunt");
        
       // PHONE NUMBER
        System.out.println("");
        findByPhone(myContacts, "(333)555-8989");
       
        System.out.println("");
        findByPhone(myContacts, "(342)555-7011");
       // BIRTHDAY
        System.out.println("");
        findByBMonth(myContacts, "May");
       
        System.out.println("");
        findByBMonth(myContacts, "Mar");
       // EMAIL
        System.out.println("");
        sortEmail(myContacts);
        
        if (findByEmail(myContacts, "rgoodman@hotmail.com") != -1)
            System.out.println("Found the listing(s): " + myContacts[findByEmail(myContacts, "rgoodman@hotmail.com")]);
        else
            System.out.println("There were no listings\n");
       
        sortEmail(myContacts);
 
        if (findByEmail(myContacts, "susieE@hotmail.com") != -1)
            System.out.println("Found the listing(s):" + myContacts[findByEmail(myContacts, "susieE@hotmail.com")]);
        else
            System.out.println("There were no listings");
    }
   
    public static void printContacts(Contact[] c)
    {
        System.out.println("Name        Relation   Birthday     Phone       Email");
        System.out.println("------------------------------------------------------");
        for (Contact i : c)
        {
            System.out.println(i);
        }
    }

    public static int findByName(Contact[] c, String toFind)
    {
        System.out.println("Find Name - " + toFind);
        int high = c.length;
        int low = -1;
        int probe;
 
        while (high - low > 1)
        {
            probe = (high + low) / 2;
            if (c[probe].getName().compareTo(toFind) > 0)
                high = probe;
            else
                low = probe;
        }
        if ( (low >= 0) && (c[low].getName().equals(toFind)))
            return low;
        else
            return -1;
    }
   
    public static int findByEmail(Contact[] c, String toFind)
    {
        System.out.println("Find Email - " + toFind);
        int high = c.length;
        int low = -1;
        int probe;
 
        while (high - low > 1)
        {
            probe = (high + low) / 2;
            if (c[probe].getEmail().compareTo(toFind) > 0)
                high = probe;
            else
                low = probe;
        }
        if ( (low >= 0) && (c[low].getEmail().equals(toFind)))
            return low;
        else
            return -1;
    }
   
    public static void findByBMonth(Contact[] c, String toFind)
    {
        int i = 0;
        System.out.println("Find Bday - " + toFind);
        boolean found = false;
        
        while ( !found && i < c.length )
        {
            if ( c[ i ].getBDay().substring(0,3).equalsIgnoreCase(toFind) )
            {
                if (i==3) {System.out.println("Found the listing(s): "); }
              
                 System.out.println(c[i].toString());
            }
            i++;
        }
        i--;   
    }
   
    public static void findByRelation(Contact[] c, String toFind)
    {
        int found = 0;
        System.out.println("Find Releation - " + toFind);
       
        System.out.println("Found the listing(s): ");
        for(int i = 0; i < c.length; i++)
        {
           if (c[i].getRelation().equalsIgnoreCase(toFind))
           {
               System.out.println(c[i].toString());
               found++;
           }
        }
        if (found == 0)
           System.out.println("There were no listings for " + toFind);
    }
   
    public static void findByPhone(Contact[] c, String toFind)
    {
        System.out.println("Find Phone - " + toFind);
        int found = 0;
       
        for(int i = 0; i < c.length; i++)
        {
           if (c[i].getPhone().equals(toFind))
           {
               if (i==0) {System.out.println("Found the listing(s): "); }
               System.out.println(c[i]);
               found++;
           }
        }
       
    }
   
     public static void sortEmail(Contact[] c)
    {    
           for (int i = 0 ; i < c.length ; i++)
           {
               Contact next = c[i];
               int insertindex = 0;
               int k = i;
               while (k > 0 && insertindex == 0)
               {
                  if (next.getEmail().compareTo(c[k-1].getEmail()) > 0)
                  {
                      insertindex = k;
                  }
                  else
                  {
                     c[k] = c[k-1];
                  }
                   k--;
               }
   
               c[insertindex] = next;
           } 
    }
     
    public static void sortName(Contact[] c)
    {    
           for (int i = 0 ; i < c.length ; i++)
           {
               Contact next = c[i];
               int insertindex = 0;
               int k = i;
               while (k > 0 && insertindex == 0)
               {
                  if (next.getName().compareTo(c[k-1].getName()) > 0)
                  {
                      insertindex = k;
                  }
                  else
                  {
                     c[k] = c[k-1];
                  }
                   k--;
               }
   
               c[insertindex] = next;
           }  
    }
   
}