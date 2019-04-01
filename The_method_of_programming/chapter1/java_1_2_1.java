package chapter1;

/**
 * 字符串的包含
 * <p>
 * 给定一长字符串a和短字符串b，如何最快地判断出短字符串b中的所有字符都在长字符串中。假设输入字符串只包含大写字母
 */
public class java_1_2_1 {

    public static void main(String[] argv) {
        String str1 = "ABCA";
        String str2 = "BAAC";
        System.out.println(isContain(str1, str2));
    }

    //思路：
    //1. 首先蛮力轮询的时间复杂度是O(mn)，比较耗时
    //2. 其次排序后比较的时间复杂度是O(nlogn + mlogm) + O(m+n)
    //3. 如果借助素数相乘，判断a能否整除b的话，时间复杂度O(m+n),然而大数相乘时间效率有问题的同时，很容易溢出。
    //4. 如果借助哈希表的话，时间复杂度是O(m+n)，但是空间复杂度是O(n)
    //5. 把A-Z这26个字母分别用位表示，1表示存在，0表示不存在，那么统计A的时候用位或，统计B的时候用位与，便可以实现时间复杂度O(m+n),空间O(1)
    //int类型4*8=32位>26,如果是A-Za-z一共52个字母的话，需要借助long类型(8*8=64位)
    public static boolean isContain(String str1, String str2) {
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            hash |= (1 << (str1.charAt(i) - 'A'));
        }

        for (int i = 0; i < str2.length(); i++) {
            if ((hash & (1 << (str1.charAt(i) - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }
}
