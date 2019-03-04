package chapter2;

//替换字符串的空格为%20
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

    //原地修改字符串
    public static void replaceSpace(char[] decodeStr, int length) {
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            char c = decodeStr[i];
            if (c == ' ') {
                newLength += 3;
            } else {
                newLength++;
            }
        }
        if (newLength == length) {
            return;
        }
        System.out.println("length " + length + " newLength " + newLength);
        int end = newLength - 1;
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
