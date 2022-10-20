package loginapp;

import java.util.StringTokenizer;

public class TokenizationTest {
	
	public static void main(String s[]){
		
		
		String text="Hi How are you. This is awesome";
		
		StringTokenizer tok1 = new StringTokenizer(text,".");
		
		while(tok1.hasMoreTokens()){
			
			System.out.println("Token "+ tok1.nextToken());
		}
	}

}
