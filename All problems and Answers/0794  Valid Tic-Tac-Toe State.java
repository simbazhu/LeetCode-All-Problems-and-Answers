class Solution {

    private char[][] gameBoard = new char[3][3]; 

    public boolean validTicTacToe(String[] board) {

        unpackBoard(board);

        return gameBoardValidation();
    }

    private void unpackBoard(String[] board){
        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                this.gameBoard[i][j] = board[i].charAt(j);
            }
        }
    }

    private boolean gameBoardValidation(){

        int numX, numO;

        numX = count('X');
        numO = count('O');

        //X goes first
        if(numO>numX) return false;

        //players take turns
        if(numX>numO+1) return false;

        //both players can't win
        if(winner('X') && winner('O')) return false;

        //game ends when one player wins
        if(winner('X') && numX==numO) return false;

        //game ends when one player wins
        if(winner('O') && numX>numO) return false;

        return true;
    }

    private int count(char player){

        int num = 0;

        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                if(gameBoard[i][j] == player) num++;
            }
        }

        return num;
    }

    private boolean winner(char player){

        if(validateRows(player)) return true;
        if(validateColumns(player)) return true;
        if(validateDiagonal(player)) return true;

        return false;
    }

    private boolean validateRows(char player){
        for(int i=0; i<3; i++){
            if(gameBoard[i][0] == player && gameBoard[i][1] == player && gameBoard[i][2] == player) return true;
        }

        return false;
    }

    private boolean validateColumns(char player){
        for(int i=0; i<3; i++){
            if(gameBoard[0][i] == player && gameBoard[1][i] == player && gameBoard[2][i] == player) return true;
        }

        return false;
    }

    private boolean validateDiagonal(char player){
        if(gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) return true;
        if(gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) return true;

        return false;
    }
}
