import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicTacToeShould {
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
        Player player = Player.X;
        Position position = new Position(0,0);

        GameStatus expected = GameStatus.ON;

        assertThat(ticTacToe.play(position, player)).isEqualTo(expected);
    }

    @Test
    void not_allow_more_moves_than_a_full_board() {
        Player player = Player.X;
        Player secondPlayer = Player.O;

        GameStatus expected = GameStatus.FULL_BOARD;

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

    @Test
    void provides_X_as_winner_if_X_has_the_bottom_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(0,0), player);
        ticTacToe.play(new Position(1,1), secondPlayer);
        ticTacToe.play(new Position(0,1), player);
        ticTacToe.play(new Position(1,0), secondPlayer);

        assertThat(ticTacToe.play(new Position(0,2), player)).isEqualTo(expected);
    }
}
