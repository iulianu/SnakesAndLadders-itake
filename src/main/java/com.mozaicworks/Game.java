package com.mozaicworks;

public class Game {

    public int[] positions = new int[4];
    private Integer winner = null;

    public boolean isOver() {
        return this.winner != null;
    }

    public void markGameOver(int winner) {
        this.winner = winner;
    }

    public static Game gameInstance = null;

    public static Game aGame() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }


    public Game() {
        for (int i=0; i<4; i++) {
            positions[i] = 1;
        }
    }

    public int dieRoll() {
        return (int)(Math.random() * 6) + 1;
    }

    public int rollTwoDice() {
        int d1 = dieRoll();
        int dTwo = dieRoll();
        return d1 + dTwo;
    }

    public String applyPlayerMove(int player, int dice) {
        if(isOver()) {
            return "Game over! Player " + winner + " is the winner!";
            // Refuse to play any further.
            // You must create a new game.
        }

        int imlucky = 0;

        switch(positions[player]+dice){
            case 2: {
                positions[player] = 15;
                imlucky = 1;
                break;
            }
            case 34: {
                positions[player] = 12;
                imlucky = -1;
                break;
            }
            case 5: {
                positions[player] = 7;
                imlucky = 1;
                break;
            }
            case 9: {
                positions[player] = 27;
                imlucky = 1;
                break;
            }
            case 25: {
                positions[player] = 35;
                imlucky = 1;
                break;
            }
            case 18: {
                positions[player] = 29;
                imlucky = 1;
                break;
            }
            case 17: {
                positions[player] = 4;
                imlucky = -1;
                break;
            }
            case 20: {
                positions[player] = 6;
                imlucky = -1;
                break;
            }
            case 24: {
                positions[player] = 16;
                imlucky = -1;
                break;
            }
            case 32: {
                positions[player] = 30;
                imlucky = -1;
                break;
            }
            default: {
                positions[player] = positions[player]+dice;
                break;
            }
        }

        String res = "";

        if (positions[player] >= 36) {
            markGameOver(player);
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
            res = res + "You " + player + " are on square " + positions[player];
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
            pos = pos + "player " + i + " is on " + positions[i] + "square, ";
            pos = pos + "<br></br>";
        }
        return pos;
    }
}