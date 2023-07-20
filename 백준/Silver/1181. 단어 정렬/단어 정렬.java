import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			set.add(sc.next());
		}
		
		String[] words = set.toArray(new String[set.size()]);

		Arrays.sort(words);
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for(int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}

	}

}
