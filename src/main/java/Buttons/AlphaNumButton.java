package Buttons;

import Hitboxes.Hitbox;
import Main.Panel;

import java.awt.image.BufferedImage;

public class AlphaNumButton extends Button{

    private int alphanum_ID;

    public AlphaNumButton(BufferedImage P1, BufferedImage P2, BufferedImage P3, Panel PANEL, int ButX, int ButY, int WID, int HEI, int id, int AID) {
        super(P1,P2,P3,PANEL);
        set_ID(id);
        set_X(ButX);
        set_Y(ButY);
        set_Hei(HEI);
        set_Wid(WID);
        setAlphanum_ID(AID);
        set_PersonalHitbox(new Hitbox(get_X(),get_Y(),get_Wid(),get_Hei()));
    }

    public void setAlphanum_ID(int val) {
        alphanum_ID=val;
    }
    public int getAlphanum_ID() {
        return alphanum_ID;
    }
}
