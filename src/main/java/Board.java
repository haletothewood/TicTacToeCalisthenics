import java.util.HashMap;
import java.util.HashSet;
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
        boolean isWinner;
        for (HashSet<Position> winningCombination : TicTacToeRules.winningCombinations) {
            isWinner =  checkForWinner(winningCombination);
            if (isWinner) {
                return Player.X;
            }
        }
        return null;
    }

    private boolean checkForWinner(HashSet<Position> winningCombination) {
        return this.movesPlayed.keySet().containsAll(winningCombination);
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
