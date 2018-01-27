package azbuka;

import java.util.*;

public class azbuka_to_01_and_to_02 {
	public static void main(String[] args){
		
		
		/////////////////
	}
	public static String En_to_morse(String q){

	    char[] english = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
	                  'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
	                  'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
	                  ',', '.', '?' };

	    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
	                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
	                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
	                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
	                "-----", "--..--", ".-.-.-", "..--.." };

	   
	    

	    char[] chars = q.toLowerCase().toCharArray();

	    String str = "";
	    for (int i = 0; i < chars.length; i++){
	        for (int j = 0; j < english.length; j++){

	            if (english[j] == chars[i]){
	                str = str + morse[j] + " ";  
	            }
	        }
	    }
	    return(str);
	} 
	
	
	
}
	
	


