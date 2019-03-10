package chapter2;

/**
 * 替换字符串的空格为%20
 * <p>
 * 实现一个函数，把字符串中的每个空格替换为%20
 * <p>
 * 考察点：字符串的编程能力，对内存覆盖的高度警惕，从后向前替换的技巧
 */
public class JAVA_5_1 {

    public static void main(String[] argv) {
        char[] data = new char[30];
        char[] str = "This is a  dog.".toCharArray();
        for (int i = 0; i < str.length; i++) {
            data[i] = str[i];
        }
        System.out.println(data);
        replaceSpace(data, 15);
        System.out.println(data);
    }

    //因为从空格字符修改为%20，长度从1变为了3，势必会覆盖后面的字符空间。
    //这里需要跟面试官确认，1. 允许自己分配足够的内存  2. 传入的字符串数组本身空间就足够
    public static void replaceSpace(char[] decodeStr, int length) {
        int newLength = 0;
        //第一遍遍历，根据空格数量，计算格式化最后的长度
        for (int i = 0; i < length; i++) {
            char c = decodeStr[i];
            if (c == ' ') {
                newLength += 3;
            } else {
                newLength++;
            }
        }
        if (newLength == length) {
            //说明没有空格
            return;
        }
        int end = newLength - 1;
        //从后向前写，就不存在先覆盖的问题了
        for (int i = length - 1; i >= 0; i--) {
            char c = decodeStr[i];
            if (c == ' ') {
                decodeStr[end] = '%';
                decodeStr[end - 1] = '2';
                decodeStr[end - 2] = '0';
                end -= 3;
            } else {
                decodeStr[end] = c;
                end--;
            }
        }
    }
}
