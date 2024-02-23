import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int min;

	public static void main(String[] args) throws IOException {
		String top = input.readLine();
		String bottom = input.readLine();
		min = top.length() + bottom.length();
		
		if(top.length() > bottom.length()) {
			calc(top, bottom);
		} else {
			calc(bottom, top);
		}
		
		System.out.println(min);
	}
	
	static void calc(String longGear, String shortGear) {
		for(int i = -shortGear.length()+1; i < longGear.length(); i++) {
			boolean flag = true;
			
			for(int j = 0; j < shortGear.length(); j++) {
				if(i + j >= 0 && i + j < longGear.length()) {
					if(longGear.charAt(i+j) - '0' + shortGear.charAt(j) - '0' > 3) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) {
				if(i < 0) {
					min = Integer.min(min, -i + longGear.length());
				} else if(i + shortGear.length() > longGear.length()) {
					min = Integer.min(min, shortGear.length() + i);
				} else {
					min = Integer.min(min, longGear.length());
				}
			}
		}
	}
}