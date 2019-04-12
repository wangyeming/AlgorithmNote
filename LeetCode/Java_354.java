import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 * <p>
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 */
public class Java_354 {

    public static void main(String[] argv) {
        int[][] envelopes = {
                {4, 5},
                {4, 6},
                {6, 7},
                {2, 3},
                {1, 1}
        };
        System.out.println(maxEnvelopes(envelopes));
        int[][] envelopes2 = {
                {1, 1},
        };
        System.out.println(maxEnvelopes(envelopes2));
        int[][] envelopes3 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {3, 5},
                {4, 5},
                {5, 5},
                {5, 6},
                {6, 7},
        };
        System.out.println(maxEnvelopes(envelopes3));
    }

    //先按照宽度由小到大排序，宽度相同，长度由大到小，然后问题转换成求最长递增子序列的长度
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        System.out.println(Arrays.deepToString(envelopes));

        int maxL = 0;
        int[] dp = new int[envelopes.length];
        for(int[] envelope: envelopes) {
            int height = envelope[1];
            int left = 0, right = maxL;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if(dp[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = height;
            if(left == maxL) maxL++;
        }
        return maxL;
    }
}
