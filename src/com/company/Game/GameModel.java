package com.company.Game;


import java.util.ArrayList;

public class GameModel {


    public static final char wall = '#';
    public static final char road = '.';
    public static final char ball = 'B';
    public static final char visited = '*';


    public static char[][] defaultBoard = new char[][]{
        {
            '0', '1', '2', '3', '4', '5'
        },
        {
            '1', road, road, road, road, road
        },
        {
            '2',road, wall, road, wall, wall
        },
        {
            '3', road, wall, road, road, road
        },
        {
            '4', road, road, road, road, road
        },
    };

    public static char[][] Test1 = new char[][]{
            {
                    '0', '1', '2', '3', '4'
            },
            {
                    '1', wall, road, road, road
            },
            {
                    '2',wall, road, wall, road
            },
            {
                    '3', wall, road, road, road
            },
            {
                    '4', wall, wall, road, road
            },
    };



    public char[][] board;
    public int xLength, yLength;
    public int ballX, ballY;
    public String moves;
    int steps;

    public GameModel(){};

    public GameModel(GameModel game)
    {
        board = new char[game.board.length][game.board[0].length];
        for(int i = 0 ; i < board.length ; i ++)
        {
            for(int j = 0 ; j < board[i].length ; j++)
            {
                this.board[i][j] = game.board[i][j];
            }
        }
        this.xLength = game.xLength;
        this.yLength = game.yLength;
        this.ballX = game.ballX;
        this.ballY = game.ballY;
        this.moves = game.moves;
        this.steps = game.steps;
    }

    public GameModel copy()
    {
        GameModel game = new GameModel(this);
        return game;
    }

    public boolean isEqual(GameModel game)
    {
        if(this.xLength != game.xLength)
        {
            return false;
        }
        if(this.yLength != game.yLength)
        {
            return false;
        }
        if(this.ballX != game.ballX)
        {
            return false;
        }
        if(this.ballY != game.ballY)
        {
            return false;
        }
        for(int i = 0 ; i < this.board.length ; i++)
        {
            for(int j = 0 ; j < this.board[0].length ; j++)
            {
                if(this.board[i][j] != game.board[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEqualWithMoves(GameModel game)
    {
        if(this.xLength != game.xLength)
        {
            return false;
        }
        if(this.yLength != game.yLength)
        {
            return false;
        }
        if(this.ballX != game.ballX)
        {
            return false;
        }
        if(this.ballY != game.ballY)
        {
            return false;
        }
        if(this.moves.length() >= game.moves.length())
        {
            return false;
        }
        for(int i = 0 ; i < this.board.length ; i++)
        {
            for(int j = 0 ; j < this.board[0].length ; j++)
            {
                if(this.board[i][j] != game.board[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEqualWithSteps(GameModel game)
    {
        if(this.xLength != game.xLength)
        {
            return false;
        }
        if(this.yLength != game.yLength)
        {
            return false;
        }
        if(this.ballX != game.ballX)
        {
            return false;
        }
        if(this.ballY != game.ballY)
        {
            return false;
        }
        if(this.steps >= game.steps)
        {
            return false;
        }
        for(int i = 0 ; i < this.board.length ; i++)
        {
            for(int j = 0 ; j < this.board[0].length ; j++)
            {
                if(this.board[i][j] != game.board[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }















    public void fillBoardWithRoad() {
        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                if (i == 0) {
                    board[i][j] = (char) ('0' + j);
                } else if (j == 0) {
                    board[i][j] = (char) ('0' + i);
                }
                else
                {
                    putRoad(j, i);
                }
            }
        }
    }








    public void putWall(int x, int y) {
        board[y][x] = wall;
    }
    public void putRoad(int x, int y) {
        board[y][x] = road;
    }
    public void putVisited(int x, int y) {
        board[y][x] = visited;
    }
    public void putBall(int x, int y) {
        board[y][x] = ball;
    }
    public void moveBall(int x, int y) {
        putVisited(ballX,ballY);
        board[y][x] = ball;
        ballX = x;
        ballY = y;
    }
    public void EditBall(int x, int y) {
        putRoad(ballX,ballY);
        board[y][x] = ball;
        ballX = x;
        ballY = y;
    }




    public boolean isWall(int x, int y) {
        return (board[y][x] == wall);
    }
    public boolean isRoad(int x, int y) {
        return (board[y][x] == road);
    }
    public boolean isVisited(int x, int y) {
        return (board[y][x] == visited);
    }
    public boolean isBall(int x, int y) {
        return (board[y][x] == ball);
    }




    public boolean isIn(int x, int y) {
        if ( (x > 0) && (x <= xLength) && (y > 0) && (y <= yLength) ) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isValidForStep(int x, int y) {
        if (isIn(x, y)) {
            if (isRoad(x,y) || isVisited(x,y)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }




    public int canMoveRight() {
        int i;
        for (i = 0; i <= xLength; i++) {
            if (!isValidForStep(ballX + i + 1, ballY)) {
                break;
            }
        }
        return i;
    }
    public int canMoveLeft() {
        int i;
        for (i = 0; i <= xLength; i++) {
            if (!isValidForStep(ballX - i - 1, ballY)) {
                break;
            }
        }
        return i;
    }
    public int canMoveUp() {
        int i;
        for (i = 0; i <= xLength; i++) {
            if (!isValidForStep(ballX, ballY - i - 1)) {
                break;
            }
        }
        return i;
    }
    public int canMoveDown() {
        int i;
        for (i = 0; i <= xLength; i++) {
            if (!isValidForStep(ballX, ballY + i + 1)) {
                break;
            }
        }
        return i;
    }




    public void moveRight() {
        int i;
        for (i = 1; i <= xLength; i++) {
            if (isValidForStep(ballX+i,ballY)) {
                putVisited(ballX+i,ballY);
                steps++;
            }
            else
            {
                break;
            }
        }
        moveBall(ballX+i-1,ballY);
        moves += "R";
    }
    public void moveLeft() {
        int i;
        for (i = 1; i <= xLength; i++) {
            if (isValidForStep(ballX - i, ballY)) {
                putVisited(ballX-i,ballY);
                steps++;
            }
            else
            {
                break;
            }
        }
        moveBall(ballX-i+1,ballY);
        moves += "L";
    }
    public void moveUp() {
        int i;
        for (i = 1; i <= xLength; i++) {
            if (isValidForStep(ballX, ballY-i)) {
                putVisited(ballX,ballY-i);
                steps++;
            }
            else
            {
                break;
            }
        }
        moveBall(ballX,ballY-i+1);
        moves += "U";
    }
    public void moveDown(){
        int i;
        for (i = 1; i <= xLength; i++) {
            if (isValidForStep(ballX, ballY+i)) {
                putVisited(ballX,ballY+i);
                steps++;
            }
            else
            {
                break;
            }
        }
        moveBall(ballX,ballY+i-1);
        moves += "D";
    }

    public void charMove(char c) {
        switch (c){
            case 'R':
                moveRight();
                break;
            case 'L':
                moveLeft();
                break;
            case 'U':
                moveUp();
                break;
            case 'D':
                moveDown();
                break;
            default :
                break;
        }
    }


    public void multiMove(String moves)
    {
        for(int i = 0 ; i < moves.length() ; i++)
        {
            char c = moves.charAt(i);
            charMove(c);
        }
    }




    public ArrayList<GameModel> getAllNextState()
    {
        ArrayList<GameModel> allStates = new ArrayList<GameModel>();

        GameModel temp;

        temp = this.copy();
        if(temp.canMoveRight() > 0)
        {
            temp.moveRight();
            allStates.add(temp);
        }

        temp = this.copy();
        if(temp.canMoveLeft() > 0)
        {
            temp.moveLeft();
            allStates.add(temp);
        }

        temp = this.copy();
        if(temp.canMoveUp() > 0)
        {
            temp.moveUp();
            allStates.add(temp);
        }

        temp = this.copy();
        if(temp.canMoveDown() > 0)
        {
            temp.moveDown();
            allStates.add(temp);
        }

        return allStates;
    }

    public boolean isFinished() {
        for(int i = 1 ; i <= yLength ; i++)
        {
            for(int j = 1 ; j <= xLength ; j++)
            {
                if(isRoad(j,i))
                {
                    return false;
                }
            }
        }
        return true;
    }



}
