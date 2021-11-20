package com.company.Player.InformedSearch;

import com.company.Expecter.Expecter;
import com.company.Game.GameController;
import com.company.Game.GameModel;
import com.company.Game.GameView;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class A_Star extends InformedSearch {

    public A_Star(GameController controller,Expecter expecter) {super(controller,expecter);}

    @Override
    public void play()
    {
        LinkedList<GameModel> closed = new LinkedList<GameModel>();
        PriorityQueue<Pair<Integer,GameModel>> open = new PriorityQueue<Pair<Integer,GameModel>>((o1, o2) -> {return (o1.getKey() > o2.getKey()) ? 1 : -1;});
        open.add(new Pair(expecter.distExpecting(controller.model),controller.model));
        closed.add(controller.model);
        while (!controller.model.isFinished() && !open.isEmpty())
        {
            Pair<Integer,GameModel> top = open.poll();
            controller.model = top.getValue();
            ArrayList<GameModel> brothers = controller.model.getAllNextState();
            for(int i = 0 ; i < brothers.size() ; i++)
            {
                GameModel bro = brothers.get(i);
                if(!closed.stream().anyMatch(o -> o.isEqual(bro)))
                {
                    int dst = expecter.distExpecting(bro) ;
                    open.add(new Pair(dst,bro));
                    closed.add(bro);
                }
            }
        }
        if(controller.model.isFinished())
        {
            GameView.printExpectedGoodSolution(controller.origin,controller.model,"A Star");
        }
        else
        {
            GameView.printNoSolution();
        }

    }

}
