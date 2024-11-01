package Actions;

import Entities.Player;

public abstract class Action {
    public Player player;

    public Action(Player PLAYER) {
        player=PLAYER;
    }

}
