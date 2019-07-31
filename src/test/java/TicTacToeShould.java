import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeShould {

    @Test
    void begin_with_an_empty_board() {
        TicTacToe ticTacToe = new TicTacToe();
        Board emptyBoard = new Board();

        assertThat(ticTacToe.board).isEqualTo(emptyBoard);
    }
}
