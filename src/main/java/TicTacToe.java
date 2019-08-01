public class TicTacToe {
    public Board board = new Board();
    private Player currentPlayer = Player.X;

    public GameStatus play(Position position, Player player) {
        if (board.isFull()) {
            return GameStatus.FULL_BOARD;
        }

        if (currentPlayer != player) throw new IllegalArgumentException("Wrong player, switch turns!");

        board.add(position, player);

        if (isWinner(player)) {
            return player == Player.X ? GameStatus.WINNER_X : GameStatus.WINNER_O;
        }

        currentPlayer = togglePlayer();
        return GameStatus.ON;
    }

    private Player togglePlayer() {
        return currentPlayer == Player.X ? Player.O : Player.X;
    }

    private boolean isWinner(Player player) {
        return board.getWinner(player);
    }
}
