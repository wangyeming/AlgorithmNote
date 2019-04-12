/**
 * 朋友圈
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 */
public class Java_547 {

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int rows = M.length;
        int friendsNum = 0;
        int[] visited = new int[rows];
        for(int i=0;i<rows;i++) {
            if(visited[i] == 0) {
                markFriends(M, visited, i);
                friendsNum++;
            }
        }
        return friendsNum;
    }

    private static void markFriends(int[][] M, int[] visited, int i) {
        visited[i] = 1;
        for(int j = 0 ; j < M.length ; j++){
            if(M[i][j] == 0 || visited[j] == 1) continue;
            markFriends(M, visited, j);
        }
    }
}
