package com.mozaicworks;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void aNormalPlay() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        String result = game.playForP(1, 2);
        assertEquals("Normal square reached!You 1 are on square 3<br></br>", result);
    }

    @Test
    public void aLadderPlay() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        String result = game.playForP(1, 4);
        assertEquals("Latter reached!You lucky player!You 1 are on square 7<br></br>", result);
    }

    @Test
    public void aSnakeBite() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        game.playForP(1, 11);
        String result = game.playForP(1, 5);
        assertEquals("HaHaHa!!Snake bite!Sorry!You 1 are on square 4<br></br>", result);
    }

    @Test
    public void theStatusMessage() {
        com.mozaicworks.Game game = new com.mozaicworks.Game();
        game.playForP(1, 2);
        assertEquals("Players positions: player 0 is on 1square, "
                + "<br></br>player 1 is on 3square, "
                + "<br></br>player 2 is on 1square, "
                + "<br></br>player 3 is on 1square, <br></br>", game.status());
    }
}
