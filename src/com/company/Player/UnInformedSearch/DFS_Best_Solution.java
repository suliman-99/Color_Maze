package com.company.Player.UnInformedSearch;

import com.company.Game.GameController;
import com.company.Game.GameModel;
import com.company.Game.GameView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class DFS_Best_Solution extends UnInformedSearch {

    public DFS_Best_Solution(GameController controller){super(controller);}

    @Override
    public void play() {
        boolean firstSolution = true;
        GameModel bestSolution = new GameModel();

        LinkedList<GameModel> closed = new LinkedList<GameModel>();
        Stack<GameModel> open = new Stack<GameModel>();
        open.add(controller.model);
        closed.add(controller.model);
        while (!open.empty())
        {
            controller.model = open.pop();
            if(controller.model.isFinished())
            {
                if(firstSolution)
                {
                    bestSolution = controller.model;
                    firstSolution = false;
                }
                else if (controller.model.moves.length() < bestSolution.moves.length())
                {
                    bestSolution = controller.model;
                }
                continue;
            }
            ArrayList<GameModel> brothers = controller.model.getAllNextState();
            for(int i = 0 ; i < brothers.size() ; i++)
            {
                GameModel bro = brothers.get(i);
                if(!closed.stream().anyMatch(o ->o.isEqualWithMoves(bro)))
                {
                    open.add(bro);
                    closed.add(bro);
                }
            }
        }
        if(firstSolution)
        {
            GameView.printNoSolution();
        }
        else
        {
            controller.model = bestSolution;
            GameView.printBestSolution(controller.origin,controller.model);
        }
    }

}
