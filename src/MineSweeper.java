import java.util.Scanner;

public class MineSweeper {

    int x,y,howManyMines,mineX,mineY;
    char[][] map;
    char[][] mineMap;

    public MineSweeper(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void run(MineSweeper game){

        Scanner scanner = new Scanner(System.in);

        int xInput,yInput;

        game.map = new char[game.x][game.y];
        game.mineMap = new char[game.x][game.y];


        game.howManyMines = (game.x* game.y)/4;

        for (int i=0;i<game.map.length;i++){

            for(int j=0;j<game.map[i].length;j++){

                game.map[i][j] = '□';
                game.mineMap[i][j] = '□';

            }

        }

        int counter=0;

        while (counter != game.howManyMines){

            game.mineX = (int)(Math.random()*(game.x-1));
            game.mineY = (int)(Math.random()*(game.y-1));

            if (game.mineMap[game.mineX][game.mineY] != 'M'){

                game.mineMap[game.mineX][game.mineY] = 'M';
                counter++;

            }

        }

        for (int i=0;i<game.map.length;i++){

            for(int j=0;j<game.map[i].length;j++){

                System.out.print(game.map[i][j] + "\t");

            }

            System.out.println();

        }

        int remainingBoxes = (game.x* game.y) - game.howManyMines;

        System.out.println();
        //printMineMap(game); // Printing mine locations.

        System.out.print("\nChoose a row (0 to "+(game.x-1)+")    : ");
        xInput = scanner.nextInt();

        System.out.print("Choose a column (0 to "+(game.y-1)+") : ");
        yInput = scanner.nextInt();

        while (true){


            remainingBoxes--;

            if(game.mineMap[xInput][yInput] == 'M'){

                System.out.println();
                printMineMap(game);
                System.out.println("\n\uD83D\uDCA3 You stepped on a mine \uD83D\uDCA3 \n\uD83D\uDCA3       Game Over       \uD83D\uDCA3");
                System.out.println("==========================================================\n");
                break;

            }else{

                System.out.println("\n==========================================================\n");

                updateMap(game,xInput,yInput);

                printMap(game);

                if (remainingBoxes == 0){

                    System.out.println();
                    System.out.println("\uD83C\uDFC6 Congratulations \uD83C\uDFC6");
                    System.out.println("\uD83C\uDFC6     You won     \uD83C\uDFC6");
                    break;

                }

                System.out.print("\nChoose a row (0 to "+(game.x-1)+")    : ");
                xInput = scanner.nextInt();

                System.out.print("Choose a column (0 to "+(game.y-1)+") : ");
                yInput = scanner.nextInt();





            }




        }




    }

    public static void printMap(MineSweeper game){

        for (int i=0;i<game.map.length;i++){

            for(int j=0;j<game.map[i].length;j++){

                System.out.print(game.map[i][j] + "\t");

            }

            System.out.println();

        }

    }

    public static void printMineMap(MineSweeper game){

        for (int i=0;i<game.map.length;i++){

            for(int j=0;j<game.map[i].length;j++){

                System.out.print(game.mineMap[i][j] + "\t");

            }

            System.out.println();

        }

    }

    public static void updateMap(MineSweeper game,int x,int y){

        int mineCounter=0;

        if (y-1 >= 0){

            if (game.mineMap[x][y-1] == 'M'){mineCounter++;}

        }

        if (y-1 >= 0 && x+1 < game.map.length ){


            if (game.mineMap[x+1][y-1] == 'M'){mineCounter++;}

        }

        if (x-1>=0 && y-1>=0){

            if (game.mineMap[x-1][y-1] == 'M'){mineCounter++;}

        }

        if (x-1>=0 && y+1 < game.map[0].length){

            if (game.mineMap[x-1][y+1] == 'M'){mineCounter++;}
        }


        if (y+1 < game.map[0].length){

            if (game.mineMap[x][y+1] == 'M'){mineCounter++;}



        }

        if (x-1 >= 0){

            if (game.mineMap[x-1][y] == 'M'){mineCounter++;}

        }

        if (x+1 < game.map.length){

            if (game.mineMap[x+1][y] == 'M'){mineCounter++;}

        }

        if (x+1 < game.map.length && y+1 < game.map[0].length){

            if (game.mineMap[x+1][y+1] == 'M'){mineCounter++;}

        }


        game.map[x][y] = (char) (mineCounter +'0');

    }



}
