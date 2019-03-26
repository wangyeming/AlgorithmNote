package chapter6;

/**
 * n个骰子的点数
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 考察点：数学建模，递归，循环
 */
public class JAVA_60 {

    private static final int MAX_VALUE = 6;

    public static void main(String[] args) {
//        calProbabilities1(2);
        calProbabilities2(2);
    }

    //思路1：递归的思想，效率低，重复运算
    //假设有n个骰子，分为两堆，一堆只有一个，一堆有n-1个。对于一个骰子，结果可能为1-6的任意一个，对于n-1，又可以递归处理
    public static void calProbabilities1(int n) {
        if (n <= 0) {
            return;
        }
        int maxSum = n * MAX_VALUE;
        int[] probabilities = new int[maxSum - n + 1];
        for (int i = 1; i <= MAX_VALUE; i++) {
            //假设第一个骰子掷出1-6，分别开始递归计算
            _calProbabilities(n, n, i, probabilities);
        }
        //n个骰子的点数排列情况共有6^n种
        double total = Math.pow(MAX_VALUE, n);
        for (int i = n; i <= maxSum; i++) {
            double ratio = probabilities[i - n] / total;
            System.out.println("Ratio of " + i + " is " + ratio);
        }
    }

    private static void _calProbabilities(int n, int current, int sum, int[] probabilities) {
        if (current == 1) {
            //只有一个骰子了，那么骰子点数只能是sum-n
            probabilities[sum - n]++;
        } else {
            for (int i = 1; i <= MAX_VALUE; i++) {
                //递归思路，每个骰子都可以掷出1-6
                _calProbabilities(n, current - 1, i + sum, probabilities);
            }
        }
    }

    //利用循环来提高效率,每加一个骰子，就根据上次的结果求新的结果
    public static void calProbabilities2(int n) {
        if (n <= 0) {
            return;
        }
        int maxSum = n * MAX_VALUE;
        //probabilities[0]和probabilities[1]两个数组，一个用来存第i个骰子各个和的排列数，另外一个用来计算第i+1个
        //用到两个的原因是 probabilities[1][k] = probabilities[0][k-1] + ... + probabilities[0][k-6]
        //和递归那里用到的数组的另一个区别是，length不同，因为是循环所以从和为0开始，而不是直接从n开始
        int[][] probabilities = new int[2][maxSum + 1];
        int flag = 0;
        //第一个骰子[0,1,1,1,1,1,1,0,...,0]
        for (int i = 1; i <= MAX_VALUE; i++) {
            probabilities[flag][i] = 1;
        }
        //从第二个骰子开始
        for (int k = 2; k <= n; k++) {
            //k表示，第k个骰子
            for (int i = 0; i < k; i++) {
                //当有k个骰子时，显然，点数和不可能小于k，需要重置下
                probabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= MAX_VALUE * k; i++) {
                //求和前，先清空上次的计算结果，i表示的是第k个骰子时，点数总和的可能值[k,6k]
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= MAX_VALUE; j++) {
                    //虽然是从j-1+...+j-6,但要求j-i>=0
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        //n个骰子的点数排列情况共有6^n种
        double total = Math.pow(MAX_VALUE, n);
        for (int i = n; i <= maxSum; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.println("Ratio of " + i + " is " + ratio);
        }
    }
}