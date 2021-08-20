public static l06sudoku{
    //here checking if the number already exist in either row or column or 1/3 of the grid if no then we will place the number
    //
    public static boolean isSafeToPlaceNumber(char[][] board,int row, int col,int num){     
        // row
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<m;i++){
            if(board[row][i]-'0' == num)
                return false;
        }
        // col
        for(int i=0;i<n;i++){
            if(board[i][col]-'0' == num)
                return false;
        }
        int r = (row/3)*3;      // here we are trying to get the starting row and coloumn the 1/3 of matrix ex- for row 7 and column 7
        int c = (col/3)*3;      // so it will be in the last of last partition whose starting r and c is 6,6 

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+r][j+c]-'0' == num)
                    return false;
            }
        }
        return true;
    }

public static boolean sudokuSolver(char[][] board, int idx){
    if(idx == 81){
        return true;
    }
    int r = idx/9;
    int c = idx%9;
    if(board != "."){
        if(sudokuSolver(board,idx+1))
            return true;
    }
    else{
        for(int num=1;num<=9;num++){
            if(isSafeToPlaceNumber(board,r,c,num)){
                board[r][c] = (char)(num + '0');
                if(sudokuSolver(board,idx+1))
                    return true;
                board[r][c] = ".";
            }

        }
    }
    return false;
}


    public static void main(String[] args){

    }
}