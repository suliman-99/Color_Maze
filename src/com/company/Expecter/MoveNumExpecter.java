package com.company.Expecter;

import com.company.Game.GameModel;

public class MoveNumExpecter extends Expecter {

    public int distExpecting(GameModel game)
    {
        int count = 0;
        for(int i = 1 ; i <= game.xLength ; i++)
        {
            for(int j = 1 ; j <= game.yLength ; j++)
            {
                if(game.isRoad(i,j))
                {
                    count++;
                }
            }
        }
        return count;
    }

}
