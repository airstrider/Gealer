import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * The KeyCountTest class is an example to sum up keys in a text file. 
 * The file contains data in the format of "key,count" where key is a string and count is an integer. 
 * Each line will only contain one key-count pair. 
 * The output should contain each key occurring in the file along with the sum of the count for all occurrences of a given key.
 * 
 * For Example:
 * John,2
 * Jane,3
 * John,4
 * Jane,5
 * Would result in the output: "The total for John is 6. The total for Jane is 8."
 */
public class KeyCountTest {
	public static void main(String[] args) {
		//Variables
		HashMap<String, Integer> map = null;
		String path = KeyCountTest.class.getResource("").getPath();
		String file = path+"text.txt";
		
		//Call methods
		map = sumUpKeys(map, file);
		viewTheOutput(map);
	}//main() end

	/**
    * Read "key,count" format data from a text file and return the sum of the count for all occurrences of a given key. 
    *
    * @param  map     the HashMap object to contains key-value type data
    * @param  file    the path that the text file exists (e.g."/document/text.txt")
    * @return         HashMap object 
    */
	public static HashMap<String, Integer> sumUpKeys(HashMap<String, Integer> map, String file) {
		String lineText;	//variable for key,count type data
		BufferedReader br = null;	//BufferedReader object
		
		//initiate a HashMap object
		if(map == null) {
			map = new HashMap<String, Integer>();
		}

		try {
 			br = new BufferedReader(new FileReader(file));
			while ((lineText = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(lineText,",");
				while (st.hasMoreElements()) {
					//Separate a line data into a key object and a value one respectively
					String key = st.nextElement().toString();
					Integer count = Integer.parseInt(st.nextElement().toString());

					if(map.containsKey(key)) {
						//If the key already exists, add a new count to the existing count
						map.put(key,((Integer)(map.get(key).intValue()+count)));
					} else {
						//If the key is new, put the key-value set into the map object
						map.put(key, count);
					}
				}//inner loop end
			}//outer loop end
 		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					//close the reader
					br.close();	
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return map;
	}//sumUpKeys() end
	
	/**
    * View the output such as "The total for John is 6. The total for Jane is 8." 
    *
    * @param  map     the HashMap object to contains key-value type data
    */
	public static void viewTheOutput(HashMap<String, Integer> map) {
		//Initiate an iterator object
		Iterator<String> it = map.keySet().iterator();

		//retrieve each element from the map object
		while(it.hasNext()) {
			String key = it.next().toString();
			System.out.print("Total for "+key+" is "+map.get(key)+". ");
		}//loop end
	}//viewTheOutput() end
}//Class end
