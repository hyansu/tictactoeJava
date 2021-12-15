package com.rafaelima.tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] board = new char[3][3];
    private static char player;
    private static boolean playerSwitch;
    private static boolean endGame = false;
    private static int numberMoves = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        buildBoard();

        while (!endGame){

            System.out.println("Digite de 1 a 9 para fazer a jogada.");
            showBoard();
            move(sc.nextInt());
            checkWinner();
            if(endGame){
                showBoard();
            }
        }
    }

    public static void buildBoard(){
        for(int i = 0; i < board.length; i++){
            Arrays.fill(board[i], '_');
        }
    }

    public static void showBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(j != board[j].length - 1){
                    System.out.printf("%s|", board[i][j]);
                }else{
                    System.out.print(board[i][j]);
                }
            }
            System.out.println("");
        }
        //System.out.println("");
    }

    public static void move(int move){

        if(!playerSwitch){
            player = 'X';
        }else{
            player = 'O';
        }

        switch (move){
            case 1 :
                checkMove(0,0, player);
                break;
            case 2 :
                checkMove(0,1, player);
                break;
            case 3 :
                checkMove(0,2, player);
                break;
            case 4 :
                checkMove(1,0, player);
                break;
            case 5 :
                checkMove(1,1, player);
                break;
            case 6 :
                checkMove(1,2, player);
                break;
            case 7 :
                checkMove(2,0, player);
                break;
            case 8 :
                checkMove(2,1, player);
                break;
            case 9 :
                checkMove(2,2, player);
                break;
            default:

        }
    }

    public static void checkMove(int row, int column, char player){
        char boardPosition = board[row][column];
        if(boardPosition == '_'){
            board[row][column] = player;
            numberMoves++;
            playerSwitch = !playerSwitch;

        }else{
            System.out.println("Jogada invalida, tente novamente!");
        }
    }

    public static void checkWinner(){
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != '_'){
            System.out.printf("%c é o vencedor!%n", board[0][0]);
            endGame = true;
        }
        if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != '_'){
            System.out.printf("%c é o vencedor!%n", board[1][0]);
            endGame = true;
        }
        if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != '_'){
            System.out.printf("%c é o vencedor!%n", board[2][0]);
            endGame = true;
        }
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != '_'){
            System.out.printf("%c é o vencedor!%n", board[0][0]);
            endGame = true;
        }
        if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != '_'){
            System.out.printf("%c é o vencedor!%n", board[0][1]);
            endGame = true;
        }
        if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != '_'){
            System.out.printf("%c é o vencedor!%n", board[0][2]);
            endGame = true;
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_'){
            System.out.printf("%c é o vencedor!%n", board[0][0]);
            endGame = true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '_'){
            System.out.printf("%c é o vencedor!%n", board[0][2]);
            endGame = true;
        }
        if(numberMoves == 9 && !endGame){
            System.out.println("Deu velha!");
            endGame = true;
        }
    }

    public static void CPU(){
        Random cpuMove = new Random();
        move(cpuMove.nextInt(3));
    }

}
