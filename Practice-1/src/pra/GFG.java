package pra;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		for(int i=0;i<a;i++)
		{
		    int b=sc.nextInt();
		    int arr[]= new int[b];
		    for(int j=0;j<arr.length;j++){
		        arr[j]=sc.nextInt();
		    }   
		  sum(arr);  
		}
		    
		
		
	}
	public static void sum(int arr[]){
		Arrays.sort(arr);
		int t=0;
		int n=arr.length;
		for (int i = n - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k)
			{
				if (arr[i] == arr[j] + arr[k])
				  {t++;j++;k--;}
				else if (arr[i] > arr[j] + arr[k])
					j++;
				else
					k--;
			}
		}
		
		if(t>0)
			System.out.println(t);
		else 
			System.out.println("-1");

	}
	}