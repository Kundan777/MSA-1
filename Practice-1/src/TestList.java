import java.util.Arrays;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("A", " B", " C");
		//String str=list.toString();
		//System.out.println(str); 
		String noSpaceStr = list.toString().replaceAll("\\s", "").replaceAll("\\[", "").replaceAll("\\]","");;
		//String noSpaceStr = str.replaceAll("\[", "");// using built in method  
        System.out.println(noSpaceStr); 
	}

}
