package pra;

import java.util.ArrayList;
import java.util.Iterator;

public class DecomposeRunLeng {
	public static int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> al= new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i++){
            int a=nums[i];
            int b=nums[i+1];
            for(int j=0;j<a;j++){
            	al.add(b);
            	i++;
        }
        }
        int[] aa= new int[al.size()];
        Iterator itr=al.listIterator();
        int j=0;
        while(itr.hasNext()){
        	aa[j]=(int) itr.next();
        	j++;
        }
		return  aa;
    }
	public static void main(String[] args) {
		
		int arr[] = {65,44,72,15}; 
        int n = arr.length; 
        //int x = 6; 
   
        // Delete x from arr[] 
        int[] n1 = decompressRLElist(arr); 
   
        System.out.println("Modified array is"); 
        for (int i = 0; i < n; i++) 
            System.out.print(n1[i]+" ");
		
	}
}
