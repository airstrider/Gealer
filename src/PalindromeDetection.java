/**
 * The PalindromeDetection class is an example to determine if a given string is a palindrome. 
 * A palindrome is a word or phrase that is spelled exactly the same forwards or backwards, like . 
 * 
 * For Example:
 * "pop" 
 * "Ah, Satan sees Natasha"
 * 
 * For this question, ignore all non-alphanumeric characters and assume that upper-and lower- case characters are identical. 
 * The function should output whether or not the string is a palindrome and return a boolean. 
 */
public class PalindromeDetection {
	
	public static void main(String[] args) {
		//A given string for the detection
		String word = "Dot saw I was Tod!!";
		
		//Call the method to detect whether the string is a palindrome and return the result
		boolean flag = isPalindrome(word);
		viewTheOutput(word, flag);
	}//main() end
	
	/**
	 * Read a given string and return true if the string is a palindrome. Otherwise, return false 
	 *
	 * @param  word    a string for detecting palindrome
	 * @return         boolean 
	 */
	public static boolean isPalindrome(String word) {
		boolean flag = false;	//initial boolean value is false
		
		//Ignore all non-alphanumeric characters
		String filteredInput = word.replaceAll("[^a-zA-Z0-9 ]", "").trim();
		
		//Assume that upper-and lower-case characters are identical
		StringBuilder sb = new StringBuilder(filteredInput.toUpperCase());
	    
		//Assign the filtered original characters of the StringBuilder to a string variable
		String input = sb.toString();
	
	    //Assign the reversed characters of the StringBuilder to a string variable
		String reversed = sb.reverse().toString();

		//Determine whether a given string is a palindrome
	    if (input.equals(reversed)) {
	    	//if the string is a palindrom, return true 
	    	flag = true;
	    }
		return flag;
	}//isPalindrome() end
	
	/**
	 * View the output of the test.
	 *
	 * @param  word    a string for detecting palindrome
	 * @param  flag    a boolean value. True means the string is a palindrom and false means that the string is not a palindrome.
	 */
	public static void viewTheOutput(String word, boolean flag) {
		if (flag) {
			System.out.println("'"+word+"' is a palindrome");
		} else {
			System.out.println("'"+word+"' is NOT a palindrome");
		}
	}//viewTheOutput() end
}//Class end
