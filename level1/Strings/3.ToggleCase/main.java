import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);

            // convert lowerCase to upperCase or viseversa using this formula
            // 'D' - 'A' == 'd' - 'a'
            // CH - 'A' == ch - 'a'
            if(ch >= 'A' && ch <= 'Z'){
                //means this char is an uppercase
                ch = (char)(ch + 'a' - 'A');
                sb.append(ch);
            }else{
                //means this char is an lowercase
                ch = (char)(ch + 'A' - 'a');
                sb.append(ch);
            }
        }
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}