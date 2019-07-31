import java.util.ArrayList;
import java.util.HashSet;

class TicTacToeRules {
    static final ArrayList<HashSet<Position>> winningCombinations = new ArrayList<HashSet<Position>>() {{
        add(new HashSet<Position>(){{
            add(new Position(0,0));
            add(new Position(0,1));
            add(new Position(0,2));
        }});
        add(new HashSet<Position>(){{
            add(new Position(1,0));
            add(new Position(1,1));
            add(new Position(1,2));
        }});
        add(new HashSet<Position>(){{
            add(new Position(2,0));
            add(new Position(2,1));
            add(new Position(2,2));
        }});
        add(new HashSet<Position>(){{
            add(new Position(0,0));
            add(new Position(1,0));
            add(new Position(2,0));
        }});
        add(new HashSet<Position>(){{
            add(new Position(0,1));
            add(new Position(1,1));
            add(new Position(2,1));
        }});
        add(new HashSet<Position>(){{
            add(new Position(0,2));
            add(new Position(1,2));
            add(new Position(2,2));
        }});
        add(new HashSet<Position>(){{
            add(new Position(0,0));
            add(new Position(1,1));
            add(new Position(2,2));
        }});
        add(new HashSet<Position>(){{
            add(new Position(0,2));
            add(new Position(1,1));
            add(new Position(2,0));
        }});
    }};
}
