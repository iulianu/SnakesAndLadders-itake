package com.mozaicworks;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameExploratoryTest {

    @Test
    public void aNormalPlay() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        String result = game.applyPlayerMove(1, 2);
        assertEquals("Normal square reached!You 1 are on square 3<br></br>", result);
    }

    @Test
    public void aLadderPlay() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        String result = game.applyPlayerMove(1, 4);
        assertEquals("Latter reached!You lucky player!You 1 are on square 7<br></br>", result);
    }

    @Test
    public void aSnakeBite() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        game.applyPlayerMove(1, 11);
        String result = game.applyPlayerMove(1, 5);
        assertEquals("HaHaHa!!Snake bite!Sorry!You 1 are on square 4<br></br>", result);
    }

    @Test
    public void theStatusMessage() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        game.applyPlayerMove(1, 2);
        assertEquals("Players positions: player 0 is on 1square, "
                + "<br></br>player 1 is on 3square, "
                + "<br></br>player 2 is on 1square, "
                + "<br></br>player 3 is on 1square, <br></br>", game.status());
    }

    @Test
    public void gameShouldFinish() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        game.applyPlayerMove(1, 12);
        game.applyPlayerMove(1, 7);
        game.applyPlayerMove(1, 12);
        String result = game.applyPlayerMove(1, 12);
        /* After these rolls, this game is guaranteed to be over */
        assertEquals("Game over! Player 1 is the winner!", result);
    }

    @Test
    public void movesShouldNotBePossibleAfterGameIsOver() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        game.applyPlayerMove(1, 12);
        game.applyPlayerMove(1, 7);
        game.applyPlayerMove(1, 12);
        game.applyPlayerMove(1, 12);
        /* After these rolls, this game is guaranteed to be over */
        String result = game.applyPlayerMove(2, 12);
        // Even though Player 2 is still in a legal position, this game should no
        // longer be playable.
        assertEquals("Game over! Player 1 is the winner!", result);
    }
}
