import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class TicTacToe{
    static char[][] arr = {{' ','|',' ','|',' '},{' ','|',' ','|',' '},{' ','|',' ','|',' '}};
    static Scanner scan = new Scanner (System.in); 
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    static boolean win = true;
    public static void main(String[] args){
    
        printarr();
        while(win){
            if(win)
               playerPos();
            if(win)
               cpuPos();
        }
        scan.close();
    }
    public static void cpuPos(){
        Random random = new Random();
        int ch = random.nextInt(9)+1;
        if(playerPositions.size()+cpuPositions.size()!=9){
         if(playerPositions.contains(ch)||cpuPositions.contains(ch)){
            cpuPos();
         }
         else{
               cpuPositions.add(ch);
               posAssigner(ch, 'o');
               printarr();
               checkWinner();
         }
      }
    }
    public static void playerPos(){
        System.out.println("Enter your Position for Cross");
        int ch = scan.nextInt();
        playerPositions.add(ch);
        posAssigner(ch,'x');
        
        printarr();
        checkWinner();
    }
    public static void posAssigner(int ch,char symbol){
        switch(ch){
            case 1:
               arr[0][0] = symbol;
               break;
            case 2:
               arr[0][2] = symbol;
               break;
            case 3:
               arr[0][4] = symbol;
               break;
            case 4:
               arr[1][0] = symbol;
               break;
            case 5:
               arr[1][2] = symbol;
               break;
            case 6:
               arr[1][4] = symbol;
               break;
            case 7:
               arr[2][0] = symbol;
               break;
            case 8:
               arr[2][2] = symbol;
               break;
            case 9:
               arr[2][4] = symbol;
               break;
        }
    }
    public static void checkWinner(){
      List<Integer> upperRow = Arrays.asList(1,2,3);
      List<Integer> midRow = Arrays.asList(4,5,6);
      List<Integer> lowerRow = Arrays.asList(7,8,9);
      List<Integer> firstCol = Arrays.asList(1,4,7);
      List<Integer> secCol = Arrays.asList(2,5,8);
      List<Integer> lastCol = Arrays.asList(3,6,9);
      List<Integer> diag1 = Arrays.asList(1,5,9);
      List<Integer> diag2 = Arrays.asList(3,5,7);

      List<List> winningList = new ArrayList<List>();
      winningList.add(upperRow);
      winningList.add(midRow);
      winningList.add(lowerRow);
      winningList.add(firstCol);
      winningList.add(secCol);
      winningList.add(lastCol);
      winningList.add(diag1);
      winningList.add(diag2);

      for(List l:winningList)
      {
         if(playerPositions.size()+cpuPositions.size()==9){
            win = false;   
            System.out.println( "It's A Tie");
            break;
         }
         else
         if(playerPositions.containsAll(l)){
            win = false;
            System.out.println("Congratulation You've Won...!"); 
            break;
         }
         else
         if(cpuPositions.containsAll(l)){
            win = false;
            System.out.println( "Sorry you've Lost....:(");
            break;
         }
      }

    }
    public static void printarr(){          //For Printing the Array
        System.out.println("\n");
        for(int i=0;i<3;i++)
            {
                for(int j=0;j<5;j++){
                   System.out.print(arr[i][j]);
                }
                System.out.println();
            }
    }
}