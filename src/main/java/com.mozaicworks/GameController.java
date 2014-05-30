package com.mozaicworks;

/**
 * This is the game controller.
 * It uses a GameModel instance to model the actual game.
 */
public class GameController {

    public static GameController gameControllerInstance = null;

    public static GameController aGameController() {
        if (gameControllerInstance == null) {
            gameControllerInstance = new GameController();
        }
        return gameControllerInstance;
    }

    private com.mozaicworks.GameModel gameModel = new com.mozaicworks.GameModel();

    public int dieRoll() {
        return (int)(Math.random() * 6) + 1;
    }

    public int rollTwoDice() {
        int d1 = dieRoll();
        int dTwo = dieRoll();
        return d1 + dTwo;
    }

    public String applyPlayerMove(int player, int dice) {
        if(gameModel.isOver()) {
            return "Game over! Player " + gameModel.winner() + " is the winner!";
            // Refuse to play any further.
            // You must create a new game.
        }

        int oldPosition = gameModel.playerPosition(player);
        int predictedNewPosition = oldPosition + dice;
        int newPosition = gameModel.playerMove(player, dice);
        int imlucky = 0;
        if( predictedNewPosition < newPosition ) {
            imlucky = 1;
        } else if(predictedNewPosition > newPosition) {
            imlucky = -1;
        }
        gameModel.updatePlayerPosition(player, newPosition);
        String res = "";
        if(gameModel.isOver()) {
            res = res + "Game over! Player " + player + " is the winner!";
        } else {
            int none = 0;
            if (imlucky == none){
                res = res + "Normal square reached!";
            }
            if (imlucky == 1) {
                res = res + "Latter reached!You lucky player!";
            }
            if (imlucky == -1) {
                res = res + "HaHaHa!!Snake bite!Sorry!";
            }
            res = res + "You " + player + " are on square " + gameModel.playerPosition(player);
            res = res + "<br></br>";
        }

        return res;
    }

    public String play(String player) {
        System.out.println("palyer " + player);
        String res = applyPlayerMove(Integer.parseInt(player), rollTwoDice());
        res = res + applyPlayerMove(2, rollTwoDice());
        return res;
    }

    public String status() {
        String pos = "Players positions: ";
        for (int i=0; i<4; i++){
            pos = pos + "player " + i + " is on " + gameModel.playerPosition(i) + "square, ";
            pos = pos + "<br></br>";
        }
        return pos;
    }
}