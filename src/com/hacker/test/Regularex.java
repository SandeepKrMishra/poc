package Regularex;
import java.util.regex.*;

public class Regularex {
	public static void main(String[] args) {
		Pattern p = Pattern.compile(".*");
		Matcher m = p.matcher("");
		boolean b1 = m.matches();
		
		System.out.println("hk"+b1);
		// 2nd way
		boolean b2 = Pattern.compile(".s").matcher("as").matches();
		// 3rd way
		
		
		boolean b3 = Pattern.matches(".s", "as");
		System.out.println(b1 + "  " + b2 + "  " + b3);
		System.out.println(Pattern.matches(".s", "as"));
		System.out.println(Pattern.matches(".s", "mk"));
		System.out.println(Pattern.matches(".s", "mst"));
		System.out.println(Pattern.matches(".s", "amms"));
		System.out.println(Pattern.matches("..s", "mas"));
		System.out.println(Pattern.matches("...s", "amms"));

	}
}
