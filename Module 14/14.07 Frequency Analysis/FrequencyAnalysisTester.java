
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

public class FrequencyAnalysisTester
{
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
        for (int count = 0; count < encryptKey.length; count++)
        {
            System.out.println(encryptKey[count] + " becomes " + unEncryptKey[count]);
        }
        
        //Decode the secret message
        System.out.println("");
        File decrypt = new File("secretmessage.txt");
        FrequencyAnalysis.decipher(unEncryptKey, encryptKey, decrypt);
        
        
    }}