package com.company.Game;

import java.util.Scanner;

public class GameController {

    public GameModel origin;
    public GameModel model;

    public GameController(GameModel model){this.model = model;this.origin = model.copy();}

    public static GameController scan_Init() {
        GameModel game = new GameModel();


//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner("9 9 5 5 5 4 4 2 2 7 7 9 9 6 6 ");
        System.out.println("Pleas Enter The X Length");
        int xLength = in.nextInt();
        System.out.println("Pleas Enter The Y Length");
        int yLength = in.nextInt();
        GameView.printLine();

        game.board = new char[yLength + 1][xLength + 1];
        game.xLength = xLength;
        game.yLength = yLength;
        game.moves = "";

        game.fillBoardWithRoad();

        System.out.println("Pleas Enter The Walls Number");
        int w = in.nextInt();
        GameView.printLine();
        for (int i = 0; i < w; i++) {
            System.out.println("The Wall Number (" + (i + 1) + ")  :  ");
            System.out.println("Pleas Enter The Place Of The Wall At The X");
            int wX = in.nextInt();
            System.out.println("Pleas Enter The Place Of The Wall At The Y");
            int wY = in.nextInt();

            game.putWall(wX, wY);
            GameView.printLine();


        }


        System.out.println("Pleas Enter The Place Of The Ball At The X");
        int ballX = in.nextInt();
        System.out.println("Pleas Enter The Place Of The Ball At The Y");
        int ballY = in.nextInt();

        game.EditBall(ballX, ballY);

        GameView.printLine();
        GameController controller = new GameController(game);

        return controller;
    }
    public static GameController default_Init() {
        GameModel game = new GameModel();
        game.moves = "";
        game.xLength = 5;
        game.yLength = 4;
        game.board = GameModel.defaultBoard;
        game.EditBall(5, 4);
        GameController controller = new GameController(game);
        return controller;
    }
    public static GameController Test1() {
        GameModel game = new GameModel();
        game.moves = "";
        game.xLength = 4;
        game.yLength = 4;
        game.board = GameModel.Test1;
        game.EditBall(3, 1);
        GameController controller = new GameController(game);
        return controller;
    }





    public GameModel unMove()
    {
        model.moves = model.moves.substring(0,model.moves.length()-1);
        GameModel temp = origin.copy();
        temp.multiMove(model.moves);
        return temp;
    }


}
