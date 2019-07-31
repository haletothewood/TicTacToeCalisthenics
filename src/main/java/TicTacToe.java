public class TicTacToe {
    public Board board = new Board();

    public TicTacToeResponse play(Position position, Player player) {
        if (board.isFull()) {
            return new TicTacToeResponse(GameStatus.FULL_BOARD, board.movesPlayed);
        }
        board.add(position, player);
        return new TicTacToeResponse(GameStatus.ON, board.movesPlayed);
    }
}
