import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeShould {
    private TicTacToe ticTacToe;
    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void begin_with_an_empty_board() {
        Board emptyBoard = new Board();
        assertThat(ticTacToe.board).isEqualTo(emptyBoard);
    }

    @Test
    void returns_board_state_after_move() {
        Player player = new Player();
        Position position = new Position(0,0);

        HashMap<Position, Player> movesPlayed = new HashMap<Position, Player>(){{
            put(position, player);
        }};
        TicTacToeResponse expected = new TicTacToeResponse(GameStatus.ON, movesPlayed);

        assertThat(ticTacToe.play(position, player)).isEqualTo(expected);
    }

    @Test
    void not_allow_more_moves_than_a_full_board() {
        Player player = new Player();
        Player secondPlayer = new Player();
        HashMap<Position, Player> movesPlayed = new HashMap<Position, Player>(){{
            put(new Position(0,0), player);
            put(new Position(0,1), secondPlayer);
            put(new Position(0,2), player);
            put(new Position(1,0), secondPlayer);
            put(new Position(1,1), player);
            put(new Position(1,2), secondPlayer);
            put(new Position(2,0), player);
            put(new Position(2,1), secondPlayer);
            put(new Position(2,2), player);
        }} ;

        TicTacToeResponse expected = new TicTacToeResponse(GameStatus.FULL_BOARD, movesPlayed);

        ticTacToe.play(new Position(0,0), player);
        ticTacToe.play(new Position(0,1), secondPlayer);
        ticTacToe.play(new Position(0,2), player);
        ticTacToe.play(new Position(1,0), secondPlayer);
        ticTacToe.play(new Position(1,1), player);
        ticTacToe.play(new Position(1,2), secondPlayer);
        ticTacToe.play(new Position(2,0), player);
        ticTacToe.play(new Position(2,1), secondPlayer);
        ticTacToe.play(new Position(2,2), player);

        assertThat(ticTacToe.play(new Position(2,1), secondPlayer)).isEqualTo(expected);
    }

    
}
