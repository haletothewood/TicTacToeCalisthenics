import java.util.HashSet;
import java.util.Set;

class TicTacToeRules {
    static final Set<Position> BOTTOM_ROW = new HashSet<Position>(){{
        add(new Position(0,0));
        add(new Position(0,1));
        add(new Position(0,2));
    }};


}
