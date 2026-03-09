import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        char[][] board = new char[][]{{"A","B","C","D"}{"S","A","A","T"}["A","C","A","E"]]
        solution.exist()
    }

}
class Solution {
    int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    public boolean helper(char[][] board,int[] pair, int i, String word){
        if(i==word.length()) return true;
        for(int[] dir: dirs){
            int x = pair[0]+dir[0];
            int y = pair[1]+dir[1];
            if(x<0 || y<0 || x>=word.length() || y>=word.length()) continue;
            if(board[x][y]==word.charAt(i)){
                System.out.println("Recu---"+x+"---"+y);
                int[] newPair = new int[]{x,y};
                if(helper(board, newPair, i+1, word)) return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        List<int[]> possList = new ArrayList<>();
        char curr = word.charAt(0);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==curr){
                    possList.add(new int[]{i,j});
                }
            }
        }
        for(int[] poss: possList){
            System.out.println("POsss---"+poss[0]+"---"+poss[1]);
            if(helper(board,poss, 1, word)) return true;
        }
        return false;
    }
}
