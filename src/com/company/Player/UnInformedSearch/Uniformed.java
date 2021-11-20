package com.company.Player.UnInformedSearch;

import com.company.Game.GameController;
import com.company.Game.GameModel;
import com.company.Game.GameView;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Uniformed extends UnInformedSearch {

    public Uniformed(GameController controller) {super(controller);}

    public void play()
    {
        LinkedList<GameModel> closed = new LinkedList<GameModel>();
        PriorityQueue<Pair<Integer,GameModel>> open = new PriorityQueue<Pair<Integer,GameModel>>((o1, o2) -> {return (o1.getKey() > o2.getKey()) ? 1 : -1;});
        open.add(new Pair(0,controller.model));
        closed.add(controller.model);
        while (!controller.model.isFinished() && !open.isEmpty())
        {
            Pair<Integer,GameModel> top = open.poll();
            controller.model = top.getValue();
            ArrayList<GameModel> brothers = controller.model.getAllNextState();
            for(int i = 0 ; i < brothers.size() ; i++)
            {
                GameModel bro = brothers.get(i);
                if(!closed.stream().anyMatch(o -> o.isEqualWithSteps(bro)))
                {
                    int dst = top.getKey();
                    String s = bro.moves;
                    char c = 'n';
                    int l = s.length();
                    if(l > 0)
                    {
                        c = s.charAt(l-1);
                    }
                    switch (c){
                        case 'R':
                            dst += top.getValue().canMoveRight();
                            break;
                        case 'L':
                            dst += top.getValue().canMoveLeft();
                            break;
                        case 'U':
                            dst += top.getValue().canMoveUp();
                            break;
                        case 'D':
                            dst += top.getValue().canMoveDown();
                            break;
                    }
                    open.add(new Pair(dst,bro));
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
