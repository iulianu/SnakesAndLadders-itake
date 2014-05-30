package com.mozaicworks;
import java.util.HashMap;
import java.util.Map;

public class Game {

    public int[] p = new int[4];
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
            p[i] = 1;
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

    public String playForP(int i, int diceRoll) {
        if(isOver()) {
            return "Game over! Player " + winner + " is the winner!";
            // Refuse to play any further.
            // You must create a new game.
        }

        int imlucky = 0;
        int s = diceRoll;

        switch(p[i]+s){
            case 2: {
                p[i] = 15;
                imlucky = 1;
                break;
            }
            case 34: {
                p[i] = 12;
                imlucky = -1;
                break;
            }
            case 5: {
                p[i] = 7;
                imlucky = 1;
                break;
            }
            case 9: {
                p[i] = 27;
                imlucky = 1;
                break;
            }
            case 25: {
                p[i] = 35;
                imlucky = 1;
                break;
            }
            case 18: {
                p[i] = 29;
                imlucky = 1;
                break;
            }
            case 17: {
                p[i] = 4;
                imlucky = -1;
                break;
            }
            case 20: {
                p[i] = 6;
                imlucky = -1;
                break;
            }
            case 24: {
                p[i] = 16;
                imlucky = -1;
                break;
            }
            case 32: {
                p[i] = 30;
                imlucky = -1;
                break;
            }
            default: {
                p[i] = p[i]+s;
                break;
            }
        }

        String res = "";

        if (p[i] >= 36) {
            markGameOver(i);
            res = res + "Game over! Player " + i + " is the winner!";
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
            res = res + "You " + i + " are on square " + p[i];
            res = res + "<br></br>";
        }

        return res;
    }

    public String play(String player) {
        System.out.println("palyer " + player);
        String res = playForP(Integer.parseInt(player), rollTwoDice());
        res = res + playForP(2, rollTwoDice());
        return res;
    }

    public String status() {
        String pos = "Players positions: ";
        for (int i=0; i<4; i++){
            pos = pos + "player " + i + " is on " + p[i] + "square, ";
            pos = pos + "<br></br>";
        }
        return pos;
    }
}