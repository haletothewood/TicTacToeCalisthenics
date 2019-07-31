import java.util.HashMap;
import java.util.Objects;

public class Board {
    private HashMap<Position, Player> movesPlayed = new HashMap<>();

    void add(Position position, Player player) {
        this.movesPlayed.put(position, player);
    }

    boolean isFull() {
        return this.movesPlayed.size() == 9;
    }

    Player getWinner() {
        if (this.movesPlayed.keySet().containsAll(TicTacToeRules.BOTTOM_ROW)) {
            return Player.X;
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(movesPlayed, board.movesPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movesPlayed);
    }

}
