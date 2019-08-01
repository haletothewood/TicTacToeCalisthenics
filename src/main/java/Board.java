import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Board {
    private HashMap<Position, Player> movesPlayed = new HashMap<>();

    void add(Position position, Player player) {
        movesPlayed.put(position, player);
    }

    boolean isFull() {
        return movesPlayed.size() == 9;
    }

    boolean getWinner(Player player) {
        Map<Position, Player> movesByPlayer = movesPlayed.entrySet()
                .stream()
                .filter(move -> player == move.getValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        for (HashSet<Position> winningCombination : TicTacToeRules.winningCombinations) {
            if (checkForWinner(winningCombination, movesByPlayer)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForWinner(HashSet<Position> winningCombination, Map<Position, Player> movesByPlayer) {
        return movesByPlayer.keySet().containsAll(winningCombination);
    }

    boolean alreadyPlayed(Position position) {
        return movesPlayed.keySet().contains(position);
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
