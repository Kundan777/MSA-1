
public class NonRepeatingChar {
	static final int NO_OF_CHAR=256;
	static char count[]= new char[NO_OF_CHAR];
	 static void getCharCountArray(String arr){
		 for(int i=0;i<arr.length();i++){
			 count[arr.charAt(i)]++;
		 }
	 } 
	 
	 static int getFirstNonRepeating(String str){
		 getCharCountArray(str);
		 int index=-1,i;
		 for(i=0;i<str.length();i++){
			 if(count[str.charAt(i)]==1){
				 index=i;
				 break;
			 }
		 }
		 return index;
		 
	 } 
public static void main(String[] args) {
	
	{ 
        String str = "geeksforgeeks"; 
        int index =  getFirstNonRepeating(str); 
          
        System.out.println(index == -1 ? "Either all characters are repeating or string " + 
                   "is empty" : "First non-repeating character is " +  str.charAt(index)); 
    } 
}
}
