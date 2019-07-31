public class TicTacToe {
    public Board board = new Board();

    public GameStatus play(Position position, Player player) {
        if (board.isFull()) {
            return GameStatus.FULL_BOARD;
        }

        board.add(position, player);

        if (isWinner()) {
            return player == Player.X ? GameStatus.WINNER_X : GameStatus.WINNER_O;
        }

        return GameStatus.ON;
    }

    private boolean isWinner() {
        return board.getWinner();
    }
}
