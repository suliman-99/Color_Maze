package com.company.Player.InformedSearch;

import com.company.Expecter.Expecter;
import com.company.Game.GameController;
import com.company.Player.Player;

public abstract class InformedSearch extends Player {

    public Expecter expecter;

    public InformedSearch(GameController controller,Expecter expecter) {super(controller);this.expecter = expecter;}

    @Override
    public abstract void play();

}
