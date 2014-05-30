package com.mozaicworks;


public class GameModel {
    private int[] positions = new int[4];
    private Integer winner = null;

    public GameModel() {
        for (int i = 0; i < 4; i++) {
            positions[i] = 1;
        }
    }

    public boolean isOver() {
        return this.winner != null;
    }

    public void markGameOver(int winner) {
        this.winner = winner;
    }

    public int playerMove(int player, int dice) {
        switch (positions[player] + dice) {
            case 2: {
                return 15;
            }
            case 34: {
                return 12;
            }
            case 5: {
                return 7;
            }
            case 9: {
                return 27;
            }
            case 25: {
                return 35;
            }
            case 18: {
                return 29;
            }
            case 17: {
                return 4;
            }
            case 20: {
                return 6;
            }
            case 24: {
                return 16;
            }
            case 32: {
                return 30;
            }
            default: {
                return positions[player] + dice;
            }
        }
    }

    public int playerPosition(int player) { return positions[player]; }

    public void updatePlayerPosition(int player, int position) {
        positions[player] = position;
        if (positions[player] >= 36) {
            markGameOver(player);
        }
    }

    public Integer winner() { return this.winner; }
}
