package com.github.curriculeon;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] board;
    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    private boolean checkDiag(char piece) {
        if(checkPosDiag(piece) || checkNegDiag(piece)){
            return true;
        }
        return false;
    }

    private boolean checkNegDiag(char piece) {
        for(int i=0; i<3; i++){
            if(board[i][i] != piece){
                return false;
            }
        }
        return true;
    }

    private boolean checkPosDiag(char piece) {
        for(int i=0; i<3; i++){
            if(board[i][2-i] != piece){
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(char piece) {
        for(int j=0; j<3; j++){
            boolean found=false;
            for(int i =0 ;i<3;i++){
                if(board[i][j] != piece){
                    found=false;
                    break;
                }
                found = true;
            }
            if(found){
                return true;
            }
        }
        return false;
    }

    private boolean checkRows(char piece) {
        for(int j=0; j<3; j++){
            boolean found=false;
            for(int i =0 ;i<3;i++){
                if(board[j][i] != piece){
                    found=false;
                    break;
                }
                found = true;
            }
            if(found){
                return true;
            }
        }
        return false;
    }

    public Boolean isInFavorOfX() {
        if(checkRows('X') || checkCols('X') || checkDiag('X')){
            return true;
        } else{
            return false;
        }
    }

    public Boolean isInFavorOfO() {
        if(checkRows('O') || checkCols('O') || checkDiag('O')){
            return true;
        } else{
            return false;
        }
    }

    public Boolean isTie() {
        if(!isInFavorOfX() && !isInFavorOfO()){
            return true;
        }
        return false;
    }

    public String getWinner() {
        if(isInFavorOfO()){
            return "O";
        } else if(isInFavorOfX()){
            return "X";
        } else {
            return "";
        }
    }

}
