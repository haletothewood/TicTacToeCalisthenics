import javax.swing.text.Position;
import java.util.HashMap;
import java.util.Objects;

public class Board {
    public HashMap<Position, Player> movesPlayed = new HashMap<Position, Player>();

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
