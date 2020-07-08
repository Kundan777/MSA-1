package pra;


//Java implementation of the approach 
class GFG1 { 

	// Function that returns true if arr[] 
	// can be made strictly increasing after 
	// modifying at most one element 
	 public static boolean checkPossibility(int[] nums) {
	        int count = 0;
	        int index =-1;
	        for ( int i = 0; i< nums.length-1;i++){
	            if(nums[i] > nums[i+1]){
	                index = i;
	                count++;
	            }
	        } 
	            if(count > 1)
	                return false;
	            if(count ==1){
	                if(index+1 == nums.length-1 || index == 0)
	                    return true;
	                
	                return  (nums[index]<nums[index+2] || nums[index-1]<nums[index+1]);
	            }   
	        return  true;
	    }
	// Driver code 
	public static void main(String[] args) 
	{ 

		int[] arr = {1,3,2}; 
		int n = arr.length; 

		if (checkPossibility(arr)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	} 
} 
