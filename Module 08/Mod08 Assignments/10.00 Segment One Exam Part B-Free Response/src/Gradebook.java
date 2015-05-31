
import java.util.Arrays;

public class Gradebook 
{
private int[] studentScores = {96,72,84,65,89,60,78, 86, 75,61,85};

private String[] studentLetters = {"A","C","B","D","A","D","B","B","C","D","B"};

// postcondition: retruns -1.0 if letterGrade does not appear in studentLetters

// otherwise, returns average of all studentScores[n],

// for all 0 <= n < studentScores.length, such that

// studentLetters[n] is equal to letterGrade

public double letterAverage(String letterGrade)

{
  String [] scoreGrade = new String[studentScores.length];
  
  boolean ifContains = true;
  for (int i = 0; i < studentScores.length; i++) {
      
        if (studentScores[i] >= 90) { scoreGrade[i] = "A"; }
        else if (studentScores[i] >= 80) { scoreGrade[i] = "B"; }
        else if (studentScores[i] >= 70) { scoreGrade[i] = "C"; }
        else if (studentScores[i] >= 60) { scoreGrade[i] = "D"; }
        else scoreGrade[i] = "F";
      
}
  for( int i=0; i< studentLetters.length; i++)  {
         
     if(scoreGrade[i].equals(studentLetters[i])) {
         
       ifContains = true;
     }
     else ifContains = false;
     }
  
  int [] index = new int[studentScores.length];
  
  if (ifContains == false) {
         return -1;
     }
     else {
      
      if (letterGrade.equals("A")) {
          
  for (int i=0;i<studentScores.length;i++) {
      
  if (scoreGrade[i].equals("A")) {
        index[i] = i;
  }
      }
      }
      
      if (letterGrade.equals("B")) {
          
  for (int i=0;i<studentScores.length;i++) {
      
  if (scoreGrade[i].equals("B")) {
        index[i] = i;
  }
      }
      }
      
      if (letterGrade.equals("C")) {
          
  for (int i=0;i<studentScores.length;i++) {
      
  if (scoreGrade[i].equals("C")) {
        index[i] = i;
  }
      }
      }
      
      if (letterGrade.equals("D")) {
          
  for (int i=0;i<studentScores.length;i++) {
      
  if (scoreGrade[i].equals("D")) {
        index[i] = i;
  }
      }
      }
      
      if (letterGrade.equals("F")) {
          
  for (int i=0;i<studentScores.length;i++) {
      
  if (scoreGrade[i].equals("F")) {
        index[i] = i;
  }
      }
      }
      
      int total = 0;
      
      for (int i = 0; i < index.length; i++) {
          
          total+= studentScores[index];
      }
      
      return total / index.length;
  }
  
  }
  
  
}
