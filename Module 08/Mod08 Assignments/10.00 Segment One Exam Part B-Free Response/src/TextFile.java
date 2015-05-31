public class TextFile 
{
private String fileName;

private ArrayList<String> words;

// constructors not shown
// postcondition: returns the number of bytes in this file

public int fileSize()
{
int total = 0;
int wordSize = words.size; // adds spaces beforehand

for (int i = 0; i < words.size; i++ ) {
    wordSize = (words.get(i)).length();
    
    total = total + wordSize;
}
return total;
}

// precondition: 0 <= index < words.size()

// postcondition: removes numWords words from the words ArrayList beginning at

// index.

public void deleteWords(int index, int numWords)

{

}

// precondition: 0 <= index <= words.size()

// postcondition: adds elements from newWords array to words ArrayList beginning

// at index.

public void addWords(int index, String[] newWords)

{

}

// other methods not shown

}