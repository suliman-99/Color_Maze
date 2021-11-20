package com.company.Player.UnInformedSearch;

import com.company.Game.GameController;
import com.company.Player.Player;

public abstract class UnInformedSearch extends Player {

    public UnInformedSearch(GameController controller) {super(controller);}

    @Override
    public abstract void play();

}
