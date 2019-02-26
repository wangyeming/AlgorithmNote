package chapter1;

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] sentenceChars = s.toCharArray();
        return reverseSentence(sentenceChars);
    }

    public static String reverseSentence(char[] sentenceChars) {
        int length = sentenceChars.length;
        //移除句首空格
        for (int i = 0; i < length; i++) {
            char letter = sentenceChars[i];
            if (letter != ' ') {
                break;
            }
            removeChar(sentenceChars, i, length);
            length--;
            i--;
        }
        //移除句末空格
        for (int i = length - 1; i >= 0; i--) {
            char letter = sentenceChars[i];
            if (letter != ' ') {
                break;
            }
            System.out.println("移除句末空格 " + i);
            length--;
        }
        //开始反转
        int start = -1;
        for (int i = 0; i < length; i++) {
            char letter = sentenceChars[i];
            if (i == length - 1) {
                if (start == -1) {
                    //该句话只有一个字母
                    break;
                } else {
                    //处理句子最后一个字符是单词字母的情况
                    reverseWord(sentenceChars, start, i);
                }
            }
            if (letter == ' ') {
                if (start == -1) {
                    //移除句子前面的空格，单词间多余的空格
                    removeChar(sentenceChars, i, length);
                    length--;
                    i--;
                } else {
                    reverseWord(sentenceChars, start, i - 1);
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }
        reverseWord(sentenceChars, 0, length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(sentenceChars[i]);
        }
        return stringBuilder.toString();
    }


    public static void reverseWord(char[] words, int start, int end) {
//        System.out.println("reverseWord " + start + end);
        while (start < end) {
            char tmp = words[start];
            words[start] = words[end];
            words[end] = tmp;
            start++;
            end--;
        }
    }

    public static void removeChar(char[] words, int index, int length) {
//        System.out.println("removeChar " + index);
        for (int i = index; i < length - 1; i++) {
            words[i] = words[i + 1];
        }
    }
}
