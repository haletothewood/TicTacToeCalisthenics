import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Board {
    private HashMap<Position, Player> movesPlayed = new HashMap<>();

    void add(Position position, Player player) {
        movesPlayed.put(position, player);
    }

    boolean isFull() {
        return movesPlayed.size() == 9;
    }

    boolean getWinner() {
        for (HashSet<Position> winningCombination : TicTacToeRules.winningCombinations) {
            if (checkForWinner(winningCombination)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForWinner(HashSet<Position> winningCombination) {
        return movesPlayed.keySet().containsAll(winningCombination);
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
