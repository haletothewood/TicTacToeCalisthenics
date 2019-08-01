import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        ticTacToe.play(new Position(0,2), secondPlayer);
        ticTacToe.play(new Position(0,1), player);
        ticTacToe.play(new Position(1,0), secondPlayer);
        ticTacToe.play(new Position(1,2), player);
        ticTacToe.play(new Position(1,1), secondPlayer);
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

    @Test
    void provides_X_as_winner_if_X_has_the_middle_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(1,0), player);
        ticTacToe.play(new Position(2,1), secondPlayer);
        ticTacToe.play(new Position(1,1), player);
        ticTacToe.play(new Position(2,0), secondPlayer);

        assertThat(ticTacToe.play(new Position(1,2), player)).isEqualTo(expected);
    }

    @Test
    void provides_X_as_winner_if_X_has_the_top_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(2,0), player);
        ticTacToe.play(new Position(1,1), secondPlayer);
        ticTacToe.play(new Position(2,1), player);
        ticTacToe.play(new Position(1,0), secondPlayer);

        assertThat(ticTacToe.play(new Position(2,2), player)).isEqualTo(expected);
    }

    @Test
    void provides_X_as_winner_if_X_has_the_left_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(0,0), player);
        ticTacToe.play(new Position(1,1), secondPlayer);
        ticTacToe.play(new Position(1,0), player);
        ticTacToe.play(new Position(1,2), secondPlayer);

        assertThat(ticTacToe.play(new Position(2,0), player)).isEqualTo(expected);
    }

    @Test
    void provides_X_as_winner_if_X_has_the_centre_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(1,0), player);
        ticTacToe.play(new Position(2,1), secondPlayer);
        ticTacToe.play(new Position(1,1), player);
        ticTacToe.play(new Position(0,0), secondPlayer);

        assertThat(ticTacToe.play(new Position(1,2), player)).isEqualTo(expected);
    }

    @Test
    void provides_X_as_winner_if_X_has_the_right_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(2,0), player);
        ticTacToe.play(new Position(1,1), secondPlayer);
        ticTacToe.play(new Position(2,1), player);
        ticTacToe.play(new Position(0,0), secondPlayer);

        assertThat(ticTacToe.play(new Position(2,2), player)).isEqualTo(expected);
    }

    @Test
    void provides_X_as_winner_if_X_has_the_diagonal_from_top_right_to_bottom_left() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(2,2), player);
        ticTacToe.play(new Position(1,2), secondPlayer);
        ticTacToe.play(new Position(1,1), player);
        ticTacToe.play(new Position(0,1), secondPlayer);

        assertThat(ticTacToe.play(new Position(0,0), player)).isEqualTo(expected);
    }

    @Test
    void provides_X_as_winner_if_X_has_the_diagonal_from_top_left_to_bottom_right() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_X;

        ticTacToe.play(new Position(0,2), player);
        ticTacToe.play(new Position(1,2), secondPlayer);
        ticTacToe.play(new Position(1,1), player);
        ticTacToe.play(new Position(0,1), secondPlayer);

        assertThat(ticTacToe.play(new Position(2,0), player)).isEqualTo(expected);
    }

    @Test
    void provides_O_as_winner_if_O_has_the_bottom_row() {
        Player player = Player.X;
        Player secondPlayer = Player.O;
        GameStatus expected = GameStatus.WINNER_O;

        ticTacToe.play(new Position(2,0), player);
        ticTacToe.play(new Position(0,0), secondPlayer);
        ticTacToe.play(new Position(1,1), player);
        ticTacToe.play(new Position(0,1), secondPlayer);
        ticTacToe.play(new Position(1,0), player);

        assertThat(ticTacToe.play(new Position(0,2), secondPlayer)).isEqualTo(expected);
    }

    @Test
    void ensures_X_goes_first() {
        Player player = Player.O;

        assertThrows(IllegalArgumentException.class, () -> ticTacToe.play(new Position(0,0), player));
    }


}
