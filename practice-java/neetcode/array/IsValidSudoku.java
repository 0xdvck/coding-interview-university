class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Time complexity: O(n*n)
        //Space complexity: O(3n*n)

        boolean[][] r=new boolean[9][9];
        boolean[][] c=new boolean[9][9];
        boolean[][] subgroups=new boolean[9][9];
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char currCh=board[i][j];
                if(currCh=='.')
                    continue;
                int n=currCh-'0'-1;
                int in=(i/3)*3+j/3;
                if(r[i][n] || c[j][n] || subgroups[in][n])
                    return false;
                r[i][n]=true;
                c[j][n]=true;
                subgroups[in][n]=true;
            }
        }
        return true;
    }
}