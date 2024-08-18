package StringProblems;

import java.util.Arrays;

class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lo = new int[26], up = new int[26];
        Arrays.fill(lo , -1);
        Arrays.fill(up , -1);
        for(int i = 0 ; i < word.length() ; i++ ){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                lo[ch - 'a'] = i;
            }
            else{
                if(up[ch - 'A'] == -1)
                    up[ch - 'A'] = i;
            }
        }
        int specialChars = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(lo[i] != -1 && up[i] != -1 && lo[i] < up[i]){
                specialChars++;
            }
        }
        return specialChars;
    }
}



public class CountSpecialCharsII {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.numberOfSpecialChars("eE"));

    }
}
