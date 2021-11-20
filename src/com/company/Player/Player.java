package com.company.Player;

import com.company.Game.GameController;

public abstract class Player {

    public GameController controller;

    public Player(GameController controller){this.controller = controller;}

    public abstract void play();
}
