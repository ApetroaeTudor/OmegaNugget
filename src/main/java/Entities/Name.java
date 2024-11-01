package Entities;

import Actions.ButtonBehaviors.FileManaging;

import java.util.List;

public class Name {
    private int x,y,relx,rely,wid,hei;
    private List<String> actual_name;
    private Player game_player;

    public Name(Player PLAYER) {
        game_player=PLAYER;
        actual_name= FileManaging.make_StringFromFile();
    }



    public Player getGame_player() {
        return game_player;
    }
    public List<String> getActual_name() {
        return actual_name;
    }
}
