package StringProblems;

public class WordSummationEqual {
    public static void main(String[] args) {
        String firstWord = "acb" , secondWord = "cba" , targetWord = "cdb";
        boolean isEqual = isSumEqual(firstWord,secondWord,targetWord);
        System.out.println(isEqual);
    }

    private static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = convert(firstWord);
        int second = convert(secondWord);
        int target = convert(targetWord);
        return (first+second==target);
    }

    private static int convert(String word) {
        int ans = 0;
        for(char ch : word.toCharArray()){
            ans = ans * 10 + (ch - 97);
        }
        return ans;
    }

}
/*
The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).

The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s, which is then converted into an integer.

For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.
You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a' through 'j' inclusive.

Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false otherwise.
Input: firstWord = "acb", secondWord = "cba", targetWord = "cdb"
Output: true
Explanation:
The numerical value of firstWord is "acb" -> "021" -> 21.
The numerical value of secondWord is "cba" -> "210" -> 210.
The numerical value of targetWord is "cdb" -> "231" -> 231.
We return true because 21 + 210 == 231
 */
