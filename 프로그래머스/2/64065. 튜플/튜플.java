import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] input = s.replace("{", "").replace("}}", "").split("},");
        
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i = 0; i < input.length; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            int prev = 0;
            
            for(int j = 0; j < input[i].length(); j++) {
                char c = input[i].charAt(j);
                
                if(c == ',') {
                    tmp.add(prev);
                    prev = 0;
                } else {
                    prev = prev * 10 + (c - '0');
                }
                
                if(j == input[i].length() - 1) {
                    tmp.add(prev);
                }
            }
            
            arr.add(tmp);
        }
        
        List<Integer> tmp = new ArrayList<>();
        
        for(int i = 0; i < arr.size(); i++) {
            for(int n: arr.get(i)) {
                if(!tmp.contains(n)) {
                    tmp.add(n);
                }
            }
        }

        int[] answer = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}