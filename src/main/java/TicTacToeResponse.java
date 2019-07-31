import java.util.HashMap;
import java.util.Objects;

public class TicTacToeResponse {
    HashMap<Position, Player> movesPlayed;
    GameStatus gameStatus;

    public TicTacToeResponse(GameStatus gameStatus, HashMap<Position, Player> movesPlayed) {
        movesPlayed = movesPlayed;
        gameStatus = gameStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToeResponse that = (TicTacToeResponse) o;
        return Objects.equals(movesPlayed, that.movesPlayed) &&
                gameStatus == that.gameStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movesPlayed, gameStatus);
    }
}
