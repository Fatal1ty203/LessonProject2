package hw.homework_serialization.task2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayersList implements Serializable {
    List<Player> players = new ArrayList<>();
    static final double serialVersionUID = 1l;

    @Override
    public String toString() {
        return "PlayersList{" +
                "players=" + players +
                '}';
    }
}
