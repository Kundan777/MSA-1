import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
	public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
	public static int getWord(String str,List<String> set){
		char ar[]=str.toCharArray();
		Arrays.sort(ar);
		String s= new String(ar);
		int a=0;
		for(int i=0;i<set.size();i++){
			String s1=set.get(i);
			System.out.println(s1 +"  "+s);
			
			if(s1.contains(s)){
				a=i;
						
			}
		}
		return a;
		
	}
	 private void permute(String str, int l, int r) 
	    { 
	        if (l == r) 
	            System.out.println(str); 
	        else
	        { 
	            for (int i = l; i <= r; i++) 
	            { 
	                str = swap(str,l,i); 
	                permute(str, l+1, r); 
	                str = swap(str,l,i); 
	            } 
	        } 
	    } 
	 
	 public String swap(String a, int i, int j) 
	    { 
	        char temp; 
	        char[] charArray = a.toCharArray(); 
	        temp = charArray[i] ; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp; 
	        return String.valueOf(charArray); 
	    } 
	 public static void main(String[] args) {
		 String[] array = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
	   //  Set<String> set = new HashSet<>();
	     ArrayList<String> set= new ArrayList<>();
	    // Scanner sc=new Scanner(System.in);
	     String s= "ogtdes";
	     for(String set1:array){
	    	 set.add(sortString(set1));
	     }
	     System.out.println("Set: " + set);
	     System.out.println(array[getWord(s,set)]);
	     
	     
	    
	}

}
