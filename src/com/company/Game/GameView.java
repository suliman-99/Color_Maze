package com.company.Game;

public class GameView {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String BG_ANSI_RESET = "\u001B[0m";
    public static final String BG_ANSI_BLACK = "\u001B[40m";
    public static final String BG_ANSI_RED = "\u001B[41m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String BG_ANSI_YELLOW = "\u001B[43m";
    public static final String BG_ANSI_BLUE = "\u001B[44m";
    public static final String BG_ANSI_PURPLE = "\u001B[45m";
    public static final String BG_ANSI_CYAN = "\u001B[46m";
    public static final String BG_ANSI_WHITE = "\u001B[47m";





    public static void printLine() {
        System.out.println("-----------------------------------------------------------------");
    }

    public static void printBoard1(GameModel model) {
        for (int i = 1; i <= model.yLength; i++) {
            for (int j = 1; j <= model.xLength; j++) {
                if(model.isBall(j,i))
                {
                    System.out.print(ANSI_RED + model.board[i][j] + "   " + ANSI_RESET);
                }
                else if(model.isRoad(j,i))
                {
                    System.out.print(ANSI_CYAN + model.board[i][j] + "   " + ANSI_RESET);
                }
                else if(model.isWall(j,i))
                {
                    System.out.print(ANSI_BLACK + model.board[i][j] + "   " + ANSI_RESET);
                }
                else if(model.isVisited(j,i))
                {
                    System.out.print(ANSI_BLUE+ model.board[i][j] + "   " + ANSI_RESET);
                }
            }
            System.out.println(' ');
        }
    }
    public static void printBoard2(GameModel model) {
        System.out.print('+');
        for (int j = 1; j <= model.xLength; j++) {
            System.out.print("---");
        }
        System.out.println('+');
        for (int i = 1; i <= model.yLength; i++) {
            System.out.print('|');
            for (int j = 1; j <= model.xLength; j++) {
                if(model.isBall(j,i))
                {
                    System.out.print(BG_ANSI_RED + ANSI_BLACK + " " + model.board[i][j] + " " + ANSI_RESET);
                }
                else if(model.isRoad(j,i))
                {
                    System.out.print("   ");
                }
                else if(model.isWall(j,i))
                {
                    System.out.print(BG_ANSI_BLACK + "   " + ANSI_RESET);
                }
                else if(model.isVisited(j,i))
                {
                    System.out.print(BG_ANSI_RED+ "   " + ANSI_RESET);
                }
            }
            System.out.println('|');
        }
        System.out.print('+');
        for (int j = 1; j <= model.xLength; j++) {
            System.out.print("---");
        }
        System.out.println('+');
    }
    public static void printBoard(GameModel model) {
//        printBoard1(model);
        printBoard2(model);
    }
    public static void printPath(GameModel origin,String moves){
        GameModel model = origin.copy();
        printLine();
        printBoard(model);
        printLine();
        for(int i = 0 ; i < moves.length() ; i++)
        {
            model.charMove(moves.charAt(i));
            printBoard(model);
//            System.out.println("The Expected Distance For The State : " + dist(model));
            printLine();
        }
    }
    public static void printDetails(GameModel model){
        System.out.println("The Number Of The Moves Is : " + model.moves.length());
        System.out.println("The Number Of The Steps Is : " + model.steps);
        System.out.println("The Path Is : " + model.moves);
    }
    public static void printGameOver(GameModel model){
        printBoard(model);
        printLine();
        System.out.println("(((((((The Game IS End)))))))");
        printLine();
        printDetails(model);
        printLine();
    }
    public static void printFirstSolution(GameModel origin,GameModel model){
        printLine();
        System.out.println("The First Found Solution : ");
        printLine();
        printDetails(model);
        printPath(origin, model.moves);
    }
    public static void printBestSolution(GameModel origin,GameModel model){
        printLine();
        System.out.println("This Is The Best Solution For This Board *_* ");
        printLine();
        printDetails(model);
        printPath(origin, model.moves);
    }
    public static void printExpectedGoodSolution(GameModel origin,GameModel model,String theNameOfTheAlgorithm){
        printLine();
        System.out.println("The Expected Good Solution In The " + theNameOfTheAlgorithm + " : ");
        printLine();
        printDetails(model);
        printPath(origin, model.moves);
    }
    public static void printNoSolution(){
        printLine();
        System.out.println("There Is No Solution For This Board .");
        printLine();
    }

}
