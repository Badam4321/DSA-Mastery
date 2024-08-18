package StringProblems;

public class MostWordsFound {
    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int maxNumOfWords = 0;
        for(String str : sentences){
            maxNumOfWords = Math.max(maxNumOfWords , numberOfWords(str));
        }
        System.out.println(maxNumOfWords);
    }
    private static  int numberOfWords(String sentence){
        int spaces = 0;
        for(char ch : sentence.toCharArray()){
            if(ch == ' ')
                spaces ++;
        }
        return spaces + 1;
    }
}
