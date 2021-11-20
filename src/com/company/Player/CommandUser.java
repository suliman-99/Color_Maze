package com.company.Player;

import com.company.Game.GameController;
import com.company.Game.GameView;

import java.util.Scanner;

public class CommandUser extends Player {


    public CommandUser(GameController controller)
    {
        super(controller);
    }

    public void play()
    {
        while(!controller.model.isFinished())
        {
            GameView.printBoard(controller.model);
            System.out.println("Pleas Enter The Direction Of The Move : \n" +
                    "Right : d \n" +
                    "Left : a \n" +
                    "Up : w \n" +
                    "Down : s \n" +
                    "UnMove : b \n" +
                    "Your Move : ");
            Scanner in = new Scanner(System.in);
            char direction = in.nextLine().charAt(0);

            switch(direction) {
                case 'd':
                    System.out.println("Right Moving");
                    controller.model.moveRight();
                    break;
                case 'a':
                    System.out.println("Left Moving");
                    controller.model.moveLeft();
                    break;
                case 'w':
                    System.out.println("Up Moving");
                    controller.model.moveUp();
                    break;
                case 's':
                    System.out.println("Down Moving");
                    controller.model.moveDown();
                    break;
                case 'b':
                    System.out.println("UnMove");
                    controller.model = controller.unMove();
                    break;
            }
            GameView.printLine();
        }
        GameView.printGameOver(controller.model);
    }

}
