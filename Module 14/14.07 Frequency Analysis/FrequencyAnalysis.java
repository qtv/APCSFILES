import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public  class FrequencyAnalysis
{
    // instance variables
     
    private File file;                                 
    private int[] occurence;
    private char[] key;

        private final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                           'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // object / constructor
    public FrequencyAnalysis(File plaintext)
    {
        file = plaintext;
        this.key = new char[26];
        this.occurence = new int[26];
    }

    
    public static ArrayList<String> parse(File newFile) throws IOException
    {
        Scanner inFile = new Scanner(newFile);
        ArrayList<String> tokens = new ArrayList<String>();
        
        while (inFile.hasNext())
        {
            tokens.add(inFile.next().toLowerCase());
        }
        
        return tokens;
            
    }
    
    // ovverides method, parses file and splits it into an arraylist
    public ArrayList<String> parse() throws FileNotFoundException 
    {
        ArrayList<String> char1 = new ArrayList<String>();
        Scanner inFile = new Scanner(file);
        
        
        while (inFile.hasNext())
        {
            char1.add((inFile.next().toLowerCase()));
        }
        return char1;
            
    }
    

    public int findLetter(char let)
    {
        for (int i= 0; i < alphabet.length; i++)
        {
            if (alphabet[i] == let)
            {
                return i;
            }
        }
        return -100;
    }
    
    public void occurences(String char1)
    {
        int index;
        char1 = char1.toLowerCase();
        
        for (int i = 0; i < char1.length(); i++)
        {
            index = this.findLetter(char1.charAt(i));
            
            if (index  != -100)
            {
                this.occurence[index]++;
            }
            else
            {
            }
        }
            
    }
    
    // creates key based on occurance 
    public void createKey()
    {
        // moves alphabet to key
        
       this.key = alphabet;  
        
        for (int i = 0; i < this.occurence.length -1 ; i++)
       {
           if (this.occurence[i] < this.occurence[i + 1])
           {
               int integer = this.occurence[i];
                this.occurence[i] = this.occurence[i + 1];
               this.occurence[i + 1] = integer;
                
                char idk = this.key[i];
            this.key[i] = this.key[i + 1];
               this.key[i + 1] = idk;
                
             i = -1;
                
           }
       }
        
    }
    
    // print!
    public void printResults() throws FileNotFoundException 
    {
        int totalLetters = 0;
        for (int i : this.occurence)
        {
            totalLetters = totalLetters + i;
        }
        
        // write out to ciphertext
        PrintWriter outFile = new PrintWriter(new File("ciphertextfreq.txt"));
        
        // print
        System.out.printf("%5s%15s%10s%n", "Letter", "  # of Occurences", "Percent");
        
        System.out.println("------------------------------------");
        
        
        outFile.printf("%5s%15s%10s%n", "Letter", "  of Occurences", "Percent");
        
        outFile.println("---------------------------------------");
        
        for (int i = 0; i < occurence.length; i++)
        {
            System.out.printf("%2c%13d%16.2f%%%n", this.key[i], this.occurence[i], (this.occurence[i] *1.0/totalLetters)*100.0 );
            outFile.printf("%2c%13d%16.2f%%%n", this.key[i], this.occurence[i], (this.occurence[i] *1.0/totalLetters)*100.0 );
        }
        
        outFile.close();
    }
        
    // call from tester
    // creates a key and prints results
    // also populizes Occurences
    public void analyze() throws FileNotFoundException 
    {
        ArrayList<String> char1 = this.parse();
        
        
        for(String char2 : char1)
        {
            this.occurences(char2);
        }
        
        this.createKey();
        this.printResults();
        
    }
    
    // returns key
    public char [] getKey()
    {
        return this.key;
    }
   
    public static void decipher(char[] unencryptKey, char[] encryptKey, File file) throws IOException
    {
        
        // parses file and assigns the file contents to an arraylist string
        ArrayList<String> char1 = parse(file);
        
        // replace everything
        for (int i2 = 0; i2< char1.size(); i2++)
        {
            String char2 = char1.get(i2);
            
            for (int i = 0; i < unencryptKey.length; i++)
            {
                // output list of everything being replaced
                System.out.println("Replacing the letter " + encryptKey[i] + " in " + char2 + " with " + unencryptKey[i]);
                char2 = char2.replace(encryptKey[i], unencryptKey[i]);
                char1.set(i2, char2);
            }
        }
        
        for (int i = 0; i < char1.size(); i++)
        {
            System.out.print(char1.get(i) + " ");
        }
            
    }
}
