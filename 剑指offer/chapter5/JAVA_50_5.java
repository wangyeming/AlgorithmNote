package chapter5;

/**
 * 字符流中第一个只出现一次的字符
 * <p>
 * 请实现一个函数，用来找出字符流中第一个只出现一个的字符
 * <p>
 * 考察点：哈希
 */
public class JAVA_50_5 {

    public static void main(String[] args) {
        String str = "abcdabc";
        CharStatistics charStatistics = new CharStatistics();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            System.out.println("now str is " + sb.toString());
            charStatistics.insert(c);
            System.out.println(charStatistics.firstAppearingOnce());
        }
    }

    //思路：因为字符流每次输入一个字符，所有我们需要插入字符的操作尽可能快，同时，有可以尽快找到最前非重复元素
    private static class CharStatistics {
        private int[] charMap = new int[256];
        private int index = 1;

        //O(1)
        public void insert(char c) {
            if (charMap[c] == 0) {
                //第一次出现该字符，标记上位置
                charMap[c] = index;
            } else {
                charMap[c] = -1;
            }
            index++;
        }

        //O(n)
        public char firstAppearingOnce() {
            int minIndex = Integer.MAX_VALUE;
            char firstAppearingOnceChar = '\0';
            for (int i = 0; i < charMap.length; i++) {
                if (charMap[i] > 0 && charMap[i] < minIndex) {
                    //找到只出现一次的字符中，位置最靠前的
                    firstAppearingOnceChar = (char) i;
                    minIndex = charMap[i];
                }
            }
            return firstAppearingOnceChar;
        }
    }


}