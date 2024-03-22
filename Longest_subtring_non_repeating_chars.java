package string;

import java.util.HashMap;

public class Longest_subtring_non_repeating_chars {
    public static void getSubstring(String str){
        HashMap<Character, Integer> h = new HashMap<>();
        int max = 0;
        int rmax = 0;
        int prev = 0;
        char[] ch = str.toCharArray();
        for(int i =0; i<str.length(); i++){
            if(h.containsKey(ch[i])){
                rmax = i - prev;
                prev = i;
                h.clear();
                h.put(ch[i], 1);
                if(rmax > max)
                    max = rmax;
            }else{

                h.put(ch[i], 1);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        getSubstring("ABCDEFGABEF");
    }
}
