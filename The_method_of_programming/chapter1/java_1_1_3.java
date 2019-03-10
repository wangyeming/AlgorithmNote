package chapter1;

//给定一个字符串，逐个翻转字符串中的每个单词。
//1. 无空格字符构成一个单词。
//2. 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//3. 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
public class java_1_1_3 {

    public static void main(String[] argv) {
        Solution solution = new Solution();
        String str = " I am a  student  ";
        System.out.println(solution.reverseWords(str));
//        str = "the sky is blue";
//        System.out.println(solution.reverseWords(str));
//        String str3 = "abc";
//        System.out.println(solution.reverseWords(str3));
//        String str4 = " ";
//        System.out.println("result is|" + solution.reverseWords(str4) + "|end");
    }

}
