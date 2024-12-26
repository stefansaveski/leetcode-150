//https://leetcode.com/problems/valid-sudoku/?source=submission-noac
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] numsHorz = new boolean[10];
        boolean[] numsVert = new boolean[10];
        for(int i=0; i<board.length; i++){
            numsVert = new boolean[10];
            numsHorz = new boolean[10];
            for(int j=0; j<board.length; j++){
                //System.out.println(board[i][j]);
                int num = board[i][j]-48;
                int num2 = board[j][i]-48;
                //System.out.println(num);
                if(board[i][j] != '.')
                    if(numsHorz[num])
                        return false;
                    else
                        numsHorz[num] = true;
                if(board[j][i] != '.')
                    if(numsVert[num2])
                        return false;
                    else
                        numsVert[num2] = true;
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                numsHorz = new boolean[10];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int num = board[i+x][j + y]-48;
                        if(board[i + x][j + y] != '.')
                            if(numsHorz[num])
                                return false;
                            else
                                numsHorz[num] = true;
                    }
                }
            }
        }

        return true;
    }
}
