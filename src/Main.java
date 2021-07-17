public class Main {
    public static void main(String[] args){


        System.out.println("\n***************  Welcome to the MineField  ***************\n");

        MineSweeper game = new MineSweeper(3,3);

        MineSweeper.run(game);


    }
}
