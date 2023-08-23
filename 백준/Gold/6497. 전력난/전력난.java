import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N;
	static Edge[] edgeList;
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static void make() {
		parents = new int[M];
		for(int i = 0; i < M; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{	
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			edgeList = new Edge[N];
			int total = 0;
			
			if(M == 0 && N == 0) break;
			
			for(int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				int weight = Integer.parseInt(tokens.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
				total +=  weight;
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int res = 0;
			int cnt = 0;
			
			for(Edge edge: edgeList) {
				if(union(edge.from, edge.to)) {
					res += edge.weight;
					
					if(++cnt == M-1) break;
				}
			}
			
			output.append(total - res).append("\n");
		}
		
		System.out.println(output);
	}

}