/**
 * 16.05 - Student constructor / get methods
 * @author 
 * @date 5/24/15
 */
public class Student {
    private String name;
    private int qz1,qz2,qz3,qz4,qz5;
    
    public Student(String name, int qz1, int qz2, int qz3, int qz4, int qz5)
    {
        this.name = name;
        this.qz1 = qz1;
        this.qz2 = qz2;
        this.qz3 = qz3;
        this.qz4 = qz4;
        this.qz5 = qz5;
    }
    
    // get quiz number
    public int getQuiz(int quizNum)
    {
        if(quizNum == 1)
        {return qz1;}
        else if(quizNum == 2)
        {return qz2;}
        else if(quizNum == 3)
        {return qz3;}
        else if(quizNum == 4)
        {return qz4;}
        else if(quizNum == 5)
        {return qz5;}
        else {return 0;}
    }
    public void setQuiz(int quizNum, int score)
    {
        if(quizNum == 1)
        {qz1 = score;}
        else if(quizNum == 2)
        {qz2 = score;}
        else if(quizNum == 3)
        {qz3 = score;}
        else if(quizNum == 4)
        {qz4 = score;}
        else if(quizNum == 5)
        {qz5 = score;}
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
                //return getName() + "        " + getQuiz(1)  + "        "+
                  //      getQuiz(2) + "        " +
                  //      getQuiz(3)  + "        " + getQuiz(4)  + "        "+getQuiz(5);
                          
        
        String s = String.format("%1s%1s        %-10d  %-8d  %-8d  %-8d  %-9d", getName(), ": ", getQuiz(1), getQuiz(2),
               getQuiz(3), getQuiz(4), getQuiz(5));
       return s;

    }
}