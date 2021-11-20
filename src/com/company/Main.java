package com.company;


import com.company.Expecter.Expecter;
import com.company.Expecter.MoveNumExpecter;
import com.company.Game.GameController;
import com.company.Player.CommandUser;
import com.company.Player.InformedSearch.A_Star;
import com.company.Player.Player;
import com.company.Player.UnInformedSearch.*;


public class Main {


    public static void main(String[] args) {

        GameController controller = GameController.Test1();



//        -----Hand Player-----
//        Player player = new CommandUser(controller);


//        -----Un Informed Search-----
//        Player player = new DFS(controller);
//        Player player = new DFS_Best_Solution(controller);
//        Player player = new BFS(controller);
//        Player player = new BFS_Best_Solution(controller);
        Player player = new Uniformed(controller);






//        -----Expecters-----
//        Expecter expecter = new MoveNumExpecter();



//        -----Informed Search-----
//        Player player = new A_Star(controller,expecter);



        player.play();


    }
}
