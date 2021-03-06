
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
/**
 * 14.07 Challenge Program - decryptes a message by replacing letters.
 * @author 
 * @date 5/20/15
 */
public class FrequencyAnalysisTester
{
           public static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                           'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static void main(String[] args) throws IOException
    {
        //local variables
        
        File plaintext = new File("plaintext.txt");
        File cipher = new File("ciphertext.txt");
        
        //Create analysis objects
        FrequencyAnalysis text = new FrequencyAnalysis(plaintext);
        FrequencyAnalysis code = new FrequencyAnalysis(cipher);
        
        // starts the analysis / whole thing really for plaintext
        text.analyze();

        final char[] unEncryptKey = text.getKey();
        
        
        // now do the same thing to encrypted file
        code.analyze();
        final char[] encryptKey = code.getKey();
        

        
        //print results for testing purposes
      //  for (int i = 0; i < encryptKey.length; i++)
       // {
       //     System.out.println(encryptKey[i] + " becomes " + unEncryptKey[i]);
       // }
        
        //Decode the secret message
        System.out.println("");
        File decrypt = new File("secretmessage.txt");
        FrequencyAnalysis.decipher(unEncryptKey, encryptKey, decrypt);
        
        
    }}