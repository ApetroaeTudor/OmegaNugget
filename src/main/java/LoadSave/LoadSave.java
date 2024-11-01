package LoadSave;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class LoadSave {
    private static BufferedImage Sprite;

    public static final String PLAYER="/Character/character_LongSprite.png";

    public static final String DEATH="/Misc/Death/you_DiedSprite.png";
    public static final String SPLASH1="/Effects/splash_SpriteL1.png";
    public static final String SPLASH2="/Effects/splash_SpriteL2.png";
    public static final String BACKGROUND="/Misc/WaterBG.png";

    public static final String RED_MUSH_HEAD="/Mushrooms/Red_Head.png";
    public static final String WHITE_MUSH_HEAD="/Mushrooms/White_Head.png";
    public static final String MUSH_C1="/Mushrooms/MushroomColumn/Column1.png";
    public static final String MUSH_C2="/Mushrooms/MushroomColumn/Column2.png";


    public static final String JUMPING="/Misc/Jump/jump_Sheetv2.png";
    public static final String JUMP_EFF="/Effects/jump_Effect2Sprite.png";

    public static final String SHOW_HITBOXES_PASSIVE="/Misc/Buttons/ShowHitboxes/Show_HitboxesNeutral.png";
    public static final String SHOW_HITBOXES_HOVER="/Misc/Buttons/ShowHitboxes/Show_HitboxesHover.png";
    public static final String SHOW_HITBOXES_CLICKED="/Misc/Buttons/ShowHitboxes/Show_HitboxesClicked.png";

    public static final String SET_NAME_PASSIVE="/Misc/Buttons/SetName/SetNameButtonNeutral.png";
    public static final String SET_NAME_HOVER="/Misc/Buttons/SetName/SetNameButtonHover.png";
    public static final String SET_NAME_CLICKED="/Misc/Buttons/SetName/SetNameButtonClicked.png";

    public static final String STARRY_SKY="/Misc/Buttons/Alpha/StarrySky-Sheet.png";

    public static final String ALPHABET_NEUTRAL="/Misc/Buttons/Alpha/Alphabet_Neutral.png";
    public static final String ALPHABET_HOVERED="/Misc/Buttons/Alpha/Alphabet_Hovered.png";
    public static final String ALPHABET_PRESSED="/Misc/Buttons/Alpha/Alphabet_Pressed.png";
    public static final String ALPHABET_NO_BORDERS="/Misc/Buttons/Alpha/Alphabet_NoBorders.png";

    public static final String GO_BACK_NEUTRAL="/Misc/Buttons/Alpha/OtherButtons/GoBack/Go_BackNeutral.png";
    public static final String GO_BACK_HOVERED="/Misc/Buttons/Alpha/OtherButtons/GoBack/Go_BackHovered.png";
    public static final String GO_BACK_PRESSED="/Misc/Buttons/Alpha/OtherButtons/GoBack/Go_BackPressed.png";

    public static final String BACKSPACE_NEUTRAL="/Misc/Buttons/Alpha/OtherButtons/Backspace/BackSpace_Neutral.png";
    public static final String BACKSPACE_HOVERED="/Misc/Buttons/Alpha/OtherButtons/Backspace/BackSpace_Hovered.png";
    public static final String BACKSPACE_PRESSED="/Misc/Buttons/Alpha/OtherButtons/Backspace/BackSpace_Pressed.png";

    public static final String DONE_NEUTRAL="/Misc/Buttons/Alpha/OtherButtons/Done/DoneNeutral.png";
    public static final String DONE_HOVERED="/Misc/Buttons/Alpha/OtherButtons/Done/DoneHovered.png";
    public static final String DONE_PRESSED="/Misc/Buttons/Alpha/OtherButtons/Done/DonePressed.png";



    public static final String CHOOSE_NAME="/Misc/Buttons/Alpha/ChooseYourName.png";

    public static final String BORDER="/Misc/Buttons/Alpha/Border.png";
    public static final String NAME_LINE="/Misc/Buttons/Alpha/Name_Line.png";

    public static final String MAIN_MENU_BG="/Misc/MainMenu/ScrollingBG_FinalScroll.png";
    public static final String MENU_PANEL="/Misc/MainMenu/MenuPanel.png";

    public static final String PLAY_BUTTON_NEUTRAL="/Misc/MainMenu/PlayButtonNeutral.png";
    public static final String PLAY_BUTTON_HOVERED="/Misc/MainMenu/PlayButtonHover.png";

    public static final String ENEMY_SPRITE="/Enemy.png";
    public static final String ENEMY_SPRITE_SHEET="/Enemy_DeathSheet.png";

    public static final String SWORD_SWING="/Attack/Sword1Sheet.png";
    public static final String EXPLOSION="/Effects/explosion_Sprite.png";

    public static final String BGSHEET="/Misc/WaterBG_Sheet.png";
    public static final String DONUT="/Misc/DONUT.png";
    public static final String YOU_WIN="/Misc/YouWin.png";

    public static BufferedImage load_IMG(String ID) {
        Sprite=null;
        InputStream is=LoadSave.class.getResourceAsStream(ID);
        try{
            Sprite= ImageIO.read(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Sprite;
    }

}
