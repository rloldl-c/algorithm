import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		String[] words = new String[N];
		
		for(int i = 0; i < N; i++) {
			words[i] = input.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		
		output.append(words[0] + "\n");
		for(int i = 1; i < N; i++) {
			if(!words[i].equals(words[i-1])) {
				output.append(words[i] + "\n");
			}
		}
		
		System.out.println(output);
	}

}