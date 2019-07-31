import java.util.HashMap;
import java.util.Objects;

public class Board {
    public HashMap<Position, Player> movesPlayed = new HashMap<>();

    public void add(Position position, Player player) {
        movesPlayed.put(position, player);
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

    public boolean isFull() {
        return this.movesPlayed.size() == 9;
    }
}
