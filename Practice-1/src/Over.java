
public class Over {
	static int Trial(int a,int b,int c){
		if(a>=b && c<b)
			return b;
			else if (a>=b)
				return Trial(a,c,b);
			else 
				return Trial (b,a,c);
	
	}
	public static void main(String[] args) {
		System.out.println(Trial(2,10,8));
	}
}
