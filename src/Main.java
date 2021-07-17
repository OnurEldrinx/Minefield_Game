import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int x,y;

        System.out.println("\n***************  Welcome to the MineField  ***************\n");

        System.out.print("Enter the number of rows    : ");
        x = scanner.nextInt();
        System.out.print("Enter the number of columns : ");
        y = scanner.nextInt();

        System.out.println();

        MineSweeper game = new MineSweeper(x,y);

        MineSweeper.run(game);


    }
}
