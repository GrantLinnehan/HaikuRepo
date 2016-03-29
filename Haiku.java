import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Haiku {
	public Haiku() throws IOException{
		int previous = 0;
		String prevLine = "";
		int previous2 = 0;
		String prev2Line = "";
		int current = 0;
		String currLine="";
		try (BufferedReader br = new BufferedReader(new FileReader("Haiku.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	prev2Line = prevLine;
		    	previous2 = previous;
		    	prevLine = currLine;//these lines keep track of the current and last two lines and their syllables
		    	previous = current;
		    	currLine=line;
		    	current = getSyllables(line);
		    	if(previous2 == 5 && previous ==7 && current==5){
		    		System.out.print(prev2Line+"\n"+prevLine+"\n"+currLine);//if there r 5,7,7 sylls then it prints the saved lines
		    	}
		    		
		    }
		}
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Haiku haiku = new Haiku();
		}
	
	public int getSyllables(String line) {
		// TODO Auto-generated method stub
		int sylls = 0;
		for(int i = 0;i<line.length();i++){
			if(isVowel(line.charAt(i))){//finds vowels, each vowel = 1 syll unless....
				if(!isVowel(line.charAt(i-1))){//unless the letter before it was also a vowel(for most cases)
					if((i+1)==line.length()||line.charAt(i+1)==' '){
						if(line.charAt(i)!='e')//or unless there is an e at the end of the word like in crane
							sylls++;
					}
					else sylls++;
				}
			}	
					
		}
		return sylls;
	}
	
	public boolean isVowel(char letter){
		if(letter == 'a' || letter == 'i' || letter == 'o' || letter == 'e' || letter == 'u')//this method checks is a char is a vowel
			//this method is mostly to simplify typing out the getSyllables class
			return true;
		else return false;
	}
	}


