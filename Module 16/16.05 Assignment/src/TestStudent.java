
import java.util.ArrayList;

/**
 * 16.05 - Tests the Student Class and adds methods for altering an arraylist.
 * @author 
 * @date 5/24/15
 */
public class TestStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // ARRAY OF STUDENTS   
        ArrayList<Student> myClass = new ArrayList<Student>();
        
        Student mark = new Student("Mark Kennedy",70, 80, 90, 100, 90);
        Student max = new Student("Max Gerard",80, 85, 90, 85, 80);
        Student jean = new Student("Jean Smith",50, 79, 89, 99, 100);
        Student betty = new Student("Betty Farm",85, 80, 85, 88, 89);
        Student dilbert = new Student("Dilbert Gamma",70, 70, 90, 70, 80);
        
        // ADD STUDENTS TO ARRAY
        myClass.add(mark);
        myClass.add(max);
        myClass.add(jean);
        myClass.add(betty);
        myClass.add(dilbert);
        
        // BEGIN PRINT / CALLING METHODS
        
        // beginning grades
        System.out.println("Starting Gradebook:\n");
        System.out.println("  Student            Q1        Q2        Q3        Q4         Q5");
        System.out.println("----------------------------------------------------------------");
        printBook(myClass);
        
        // change name grades
        replaceName(myClass, "Betty Farm", "Betty Boop");
        printBook(myClass);
        // change quiz score grades
        replaceQuiz(myClass, "Jean Smith", 80, 1);
        printBook(myClass);
        
        // replacing student
        Student mike = new Student("Mike Kappa",80, 80, 80, 90, 90);
        replaceStudent(myClass, "Dilbert Gamma", mike);
        printBook(myClass);
        
        // inserting grades
        System.out.println("\nInserting Lily Mu: 85, 95, 70, 0, 100 before Betty \n");
        System.out.println("  Student            Q1        Q2        Q3        Q4         Q5");
        System.out.println("----------------------------------------------------------------");
        Student lily = new Student("Lily Mu",85, 95, 70, 0, 100);
        insertStudent(myClass, "Betty Boop", lily);
        printBook(myClass);
        
        // deleting grades
        System.out.println("\nDeleting Max Gerard\n");
        System.out.println("  Student            Q1        Q2        Q3        Q4         Q5");
        System.out.println("----------------------------------------------------------------");
        deleteStudent(myClass, "Max Gerard");
        printBook(myClass);
    }
     
    public static void printBook(ArrayList<Student> c)
    {
        for(Student i : c)
        {
            System.out.println(i.toString());
        }
    }
    
     public static void replaceName (ArrayList<Student> c, String name, String newName) {
        
        System.out.println("\nChanging " + name + " to " + newName );
        System.out.println("\n  Student            Q1        Q2        Q3        Q4         Q5");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; c.size() > i; i++) {
            String name1 = c.get(i).getName();
            if (name.equalsIgnoreCase(name1)){
                
                int qz1 = c.get(i).getQuiz(1);
                int qz2 = c.get(i).getQuiz(2);
                int qz3 = c.get(i).getQuiz(3);
                int qz4 = c.get(i).getQuiz(4);
                int qz5 = c.get(i).getQuiz(5);
                c.set(i, new Student(newName, qz1, qz2, qz3, qz4,qz5)); 
            }
       }
        }
     
     public static void replaceQuiz (ArrayList<Student> c, String name, int newQuiz, int numQuiz) {
        System.out.println("\nChanging the votes for " + name + " to " + newQuiz);
        System.out.println("\n  Student            Q1        Q2        Q3        Q4         Q5");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; c.size() > i; i++) {
            String name1 = c.get(i).getName();
            
            if (name.equalsIgnoreCase(name1)){
                c.get(i).setQuiz(numQuiz, newQuiz);
            }
        }
    }
     
     public static void insertStudent(ArrayList<Student> c, String name, Student newGuy) {
        // System.out.println("\n  Student            Q1        Q2        Q3        Q4         Q5");
       //  System.out.println("----------------------------------------------------------------");
         
         for (int i = 0; c.size() > i; i++) {
            String name1 = c.get(i).getName();
            if (name.equalsIgnoreCase(name1)){
                           c.add(i, newGuy);
                           break;
            }
            
         }
     }
     
      public static void deleteStudent(ArrayList<Student> c, String name) {
          
          for (int i = 0; c.size() > i; i++) {
            String name1 = c.get(i).getName();
            if (name.equalsIgnoreCase(name1)){
                c.remove(i);
            }
            
      }}
    public static void replaceStudent(ArrayList<Student> c, String name, Student newguy) {
        System.out.println("\nReplacing " + name + " with " + newguy.getName());
        System.out.println("\n  Student            Q1        Q2        Q3        Q4         Q5");
        System.out.println("----------------------------------------------------------------");
        
        insertStudent(c, name, newguy);
        deleteStudent(c, name);
    }
}
