package com.company;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main{

    private final static int CELLS=3;
    private static String[][] layout = new String[CELLS][CELLS];


    public static void main(String[] args) {
        for (int r=0;r<CELLS;r++){
            for (int c=0;c<CELLS;c++){
                layout[r][c]=("_");
            }
        }

        menu();
        while (true){
            grid();
            PlayerMove();
            if (win("X")){
                System.out.println("you win");
                grid();
                break;
            }
            AImove();
            if (win("O")) {
                System.out.println("AI wins");
                grid();
                break;
            }
        }
    }
    private static void menu(){
        System.out.println("welcome");
    }
    private static void grid(){
        for (int r=0;r<CELLS;r++){
            for (int c=0;c<CELLS;c++){
                System.out.print(layout[r][c]);
            }
            System.out.println();
        }

    }
    private static void PlayerMove(){
        System.out.println("enter your move");
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();
        if (move.equals("7")){
            if (layout[0][0].equals("_")){
                layout[0][0] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("8")){
            if (layout[0][1].equals("_")){
                layout[0][1] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("9")){
            if (layout[0][2].equals("_")){
                layout[0][2] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("4")){
            if (layout[1][0].equals("_")){
                layout[1][0] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("5")){
            if (layout[1][1].equals("_")){
                layout[1][1] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("6")){
            if (layout[1][2].equals("_")){
                layout[1][2] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("1")){
            if (layout[2][0].equals("_")){
                layout[2][0] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("2")){
            if (layout[2][1].equals("_")){
                layout[2][1] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else if (move.equals("3")){
            if (layout[2][2].equals("_")){
                layout[2][2] = "X";
            }
            else{
                System.out.println("that space is already taken!");
            }
        }
        else{
            System.out.println("invalid move");
        }


    }
    private static void AImove(){
        System.out.println("calculating move...");
        while(true) {
            int rmove = ThreadLocalRandom.current().nextInt(0,8);
            if (rmove==7){
                if (layout[0][0].equals("_")){
                    layout[0][0] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==8){
                if (layout[0][1].equals("_")){
                    layout[0][1] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==9){
                if (layout[0][2].equals("_")){
                    layout[0][2] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==4){
                if (layout[1][0].equals("_")){
                    layout[1][0] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==5){
                if (layout[1][1].equals("_")){
                    layout[1][1] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==6){
                if (layout[1][2].equals("_")){
                    layout[1][2] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==1){
                if (layout[2][0].equals("_")){
                    layout[2][0] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==2){
                if (layout[2][1].equals("_")){
                    layout[2][1] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else if (rmove==3){
                if (layout[2][2].equals("_")){
                    layout[2][2] = "O";
                    break;
                }
                else{
                    System.out.println("that space is already taken!");
                }
            }
            else{
                System.out.println("invalid move");
            }
        }

    }
    private static boolean win(String token){
        if (
                Ccheck(0,token)||
                        Ccheck(1,token)||
                        Ccheck(2,token)

                ){return true;


        }
        else if(Rcheck(0,token)|| Rcheck(1,token)|| Rcheck(2,token))
        {
            return true;
        }
        else if(Dcheck(token))
        {
            return true;
        }

        return false;

    }
    private static boolean Ccheck(int column,String token){
        if(layout[0][column].equals (token)){
            if(layout[1][column].equals (token)){
                if(layout[2][column].equals (token)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean Rcheck(int row,String token){
        if(layout[row][0].equals (token)){
            if(layout[row][1].equals (token)){
                if(layout[row][2].equals (token)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean Dcheck(String token){
        if(layout[0][0].equals (token)){
            if(layout[1][1].equals (token)){
                if(layout[2][2].equals (token)){
                    return true;
                }
            }
        }
        if(layout[0][2].equals (token)) {
            if (layout[1][1].equals(token)) {
                if (layout[2][0].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }


}
