package com.company.Player.UnInformedSearch;

import com.company.Game.GameController;
import com.company.Game.GameModel;
import com.company.Game.GameView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class DFS extends UnInformedSearch {

    public DFS(GameController controller)
    {
        super(controller);
    }

    @Override
    public void play() {
        LinkedList<GameModel> closed = new LinkedList<GameModel>();
        Stack<GameModel> open = new Stack<GameModel>();
        open.add(controller.model);
        closed.add(controller.model);
        while (!controller.model.isFinished() && !open.empty())
        {
            controller.model = open.pop();
            ArrayList<GameModel> brothers = controller.model.getAllNextState();
            for(int i = 0 ; i < brothers.size() ; i++)
            {
                GameModel bro = brothers.get(i);
                if(!closed.stream().anyMatch(o ->o.isEqual(bro)))
                {
                    open.add(bro);
                    closed.add(bro);
                }
            }
        }
        if(controller.model.isFinished())
        {
            GameView.printFirstSolution(controller.origin,controller.model);
        }
        else
        {
            GameView.printNoSolution();
        }
    }

}
