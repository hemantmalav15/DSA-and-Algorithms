import java.io.*;
import java.util.*;

public class Main {

    //  if String "aaabbcccdeee" then this function return -> "abcde"
	public static String compression1(String str){
		
		String ans = "" + str.charAt(0);

		for(int i = 1; i<str.length(); i++){
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);

			if(curr != prev){
				ans = ans + curr;
			}
		}

		return ans;
	}

    //  if String "aaabbcccdeee" then this function return -> "a3b2c3de3"
	public static String compression2(String str){
		
		String ans = "" + str.charAt(0);
		int count = 1;

		for(int i = 1; i<str.length(); i++){
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);

			if(curr == prev){
				count++;
			}
			else{
				if(count > 1){
					ans += count;
					count = 1;
				}
				ans += curr;
			}
		}
		if(count > 1){
			ans += count;
		}

		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}