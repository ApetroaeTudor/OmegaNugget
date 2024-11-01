package Buttons;

import Hitboxes.Hitbox;
import Main.Panel;

public class LevelButton extends Button {

    private Panel game_Panel;

    public LevelButton(String code1, String code2, String code3, Panel PANEL,int ButX,int ButY, int WID,int HEI,int id) {
        super(code1, code2, code3,PANEL);
        set_ID(id);
        set_X(ButX);
        set_Y(ButY);
        set_Hei(HEI);
        set_Wid(WID);
        set_PersonalHitbox(new Hitbox(get_X(),get_Y(),get_Wid(),get_Hei()));
    }

}
