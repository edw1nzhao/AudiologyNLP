import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class NLP_Test {

	public static void main(String[] args) throws Exception {

	     
		//Loading the tokenizer model 
		InputStream inputStreamTokenizer = new 
	    FileInputStream("./models/en-token.bin");
	    TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); 
	       
	      //Instantiating the TokenizerME class 
	    TokenizerME tokenizer = new TokenizerME(tokenModel); 
	       
	      //read the input text as a single string

	    FileReader in = new FileReader("./report.txt");
	    BufferedReader br = new BufferedReader(in);
	    
	    String line = br.readLine();
	    String sentence = line;
	    while (line != null) { 
	        sentence += line;
	        line = br.readLine();
	    }
	    
	    //Tokenizing the sentence in to a string array 
	    String tokens[] = tokenizer.tokenize(sentence); 
		
	    //Loading the name finder model 
		InputStream inputStreamNameFinder = new FileInputStream("./models/en"
				+ "-ner-person.bin");       
		TokenNameFinderModel name_model = new TokenNameFinderModel(inputStreamNameFinder);
		
		NameFinderME nameFinder = new NameFinderME(name_model);
		Span nameSpans[] = nameFinder.find(tokens);        
	      
	      //Printing the names and their spans in a sentence 
		System.out.print("NAMES: ");
	    for(Span s: nameSpans)  {
	    	//print out the name as well as its location
	    	System.out.println(s.toString()+"  "+tokens[s.getStart()]);
	    	
	    	//only print out name
	    	//System.out.println(tokens[s.getStart()]);
	    }
	    
	    //loading the date finder model
	    InputStream inputStreamNameFinder2 = new FileInputStream("./models/en"
				+ "-ner-date.bin");       
		TokenNameFinderModel date_model = new TokenNameFinderModel(inputStreamNameFinder2);
		
		NameFinderME  dateFinder = new NameFinderME(date_model);
		Span dateSpans[] = dateFinder.find(tokens);        
		System.out.println(); 
	      //Printing the names and their spans in a sentence 
		System.out.print("DATES: ");
	    for(Span s: dateSpans)  {
	    	System.out.println(s.toString()+"  "+tokens[s.getStart()]);
	    }
	    
	    //loading the location finder model
	    InputStream inputStreamNameFinder3 = new FileInputStream("./models/en"
				+ "-ner-location.bin");       
		TokenNameFinderModel location_model = new TokenNameFinderModel(inputStreamNameFinder3);
		
		NameFinderME  locationFinder = new NameFinderME(location_model);
		Span locationSpans[] = locationFinder.find(tokens);        
	     
		System.out.println();
	      //Printing the names and their spans in a sentence 
		System.out.print("LOCATIONS: ");
	    for(Span s: locationSpans)  {
	    	System.out.println(s.toString()+"  "+tokens[s.getStart()]);
	    }
	    
	    //loading the organization finder model
	    InputStream inputStreamNameFinder4 = new FileInputStream("./models/en"
				+ "-ner-organization.bin");       
		TokenNameFinderModel org_model = new TokenNameFinderModel(inputStreamNameFinder4);
		
		NameFinderME  orgFinder = new NameFinderME(org_model);
		Span orgSpans[] = orgFinder.find(tokens);        
	     
		System.out.println();
	      //Printing the names and their spans in a sentence 
		System.out.print("Organizations: ");
	    for(Span s: orgSpans)  {
	    	System.out.println(s.toString()+"  "+tokens[s.getStart()]);
	    }
	    
	      	
	
	}
}
