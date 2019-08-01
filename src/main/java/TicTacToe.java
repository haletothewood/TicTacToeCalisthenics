public class TicTacToe {
    private Board board;
    private Player currentPlayer = Player.X;

    public TicTacToe(Board board) {
        this.board = board;
    }

    public GameStatus play(Position position, Player player) {
        if (board.isFull()) return GameStatus.FULL_BOARD;

        if (wrongPlayer(player)) throw new IllegalArgumentException("Wrong player, switch turns!");

        if (board.alreadyPlayed(position)) throw new IllegalArgumentException("You can't play in the same position as someone else! Play again.");

        board.add(position, player);

        if (theWinnerIs(player)) return player == Player.X ? GameStatus.WINNER_X : GameStatus.WINNER_O;

        currentPlayer = togglePlayer();
        return GameStatus.ON;
    }

    private boolean wrongPlayer(Player player) {
        return currentPlayer != player;
    }

    private Player togglePlayer() {
        return currentPlayer == Player.X ? Player.O : Player.X;
    }

    private boolean theWinnerIs(Player player) {
        return board.getWinner(player);
    }
}
