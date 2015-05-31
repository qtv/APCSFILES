import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * 14.07 Challenge Program - decryptes a message by replacing letters.
 * @author 
 * @date 5/20/15
 */

public  class FrequencyAnalysis
{
    // instance variables
     
    private File file;                                 
    private int[] occurence;
    private char[] key;

    // object / constructor
    public FrequencyAnalysis(File plaintext)
    {
        file = plaintext;
        this.key = new char[26];
        this.occurence = new int[26];
    }

    
    public static ArrayList<String> parse(File newFile) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(newFile);
        ArrayList<String> char1 = new ArrayList<String>();
        
        while (inFile.hasNext())
        {
            char1.add((inFile.next().toLowerCase()));
        }
        
        return char1;
            
    }
    
    // overrides method, parses file and splits it into an arraylist
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
    

    public int findLetter(char letter)
    {
        for (int i = 0; i < FrequencyAnalysisTester.alphabet.length; i++)
        {
            if (FrequencyAnalysisTester.alphabet[i] == letter)
            {
                return i;
            }
        }
        return -1;
    }
    

    public void Occurences(String token)
    {
        int index;
        token = token.toLowerCase();
        
        for (int i = 0; i < token.length(); i++)
        {
            index = this.findLetter(token.charAt(i));
            if (index  != -1)
            {
                this.occurence[index]++;
            }
        }
            
    }
    
    // creates key by looking at the index of one above the current letter
    // format should be 
    public void createKey()
    {
        this.key = FrequencyAnalysisTester.alphabet;  
        
        for (int i = 0; i < this.occurence.length - 1; i++)
        {
            if (this.occurence[i] < this.occurence[i + 1])
            {
                int replace= this.occurence[i];
                this.occurence[i] = this.occurence[i + 1];
                this.occurence[i + 1] = replace;
                
                char replaceChar = this.key[i];
                this.key[i] = this.key[i + 1];
                this.key[i + 1] = replaceChar;
                
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
            this.Occurences(char2);
        }
        
        this.createKey();
        this.printResults();
        
    }
    
    // returns key
    public char [] getKey()
    {
        char[] key = this.key;
        return key;
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
        System.out.println("\nDecrypted message is:");
        for (int i = 0; i < char1.size(); i++)
        {
            System.out.print(char1.get(i) + " ");
        }
            
    }
}
