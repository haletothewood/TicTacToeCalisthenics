public class TicTacToe {
    public Board board = new Board();

    public GameStatus play(Position position, Player player) {
        if (board.isFull()) {
            return GameStatus.FULL_BOARD;
        }

        board.add(position, player);

        if (winner() != null) {
            return GameStatus.WINNER_X;
        }

        return GameStatus.ON;
    }

    private Player winner() {
        return board.getWinner();
    }
}
