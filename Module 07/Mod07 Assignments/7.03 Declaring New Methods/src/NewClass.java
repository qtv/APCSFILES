import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class NewClass
{
   
    public static void main(String[]args) throws IOException // had to include IOException here too
    {
     int[ ] array = new int[3];
int index = 1;
array[index] = index - 1;
index++;
array[index] = array[index - 1] - 1;
array[index - 2] = index % 3; 

for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}
    }
    }
