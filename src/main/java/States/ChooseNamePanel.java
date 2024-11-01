package States;
import Buttons.AlphaNumButton;
import Buttons.LevelButton;
import LoadSave.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Main.Panel;

import static LoadSave.LoadSave.*;
import static Phases.Constants.*;
public class ChooseNamePanel {


    private Panel game_panel;
    private BufferedImage Sprite;
    private BufferedImage[] animation;
    private LevelButton go_BackButton;
    private LevelButton backspaceButton;
    private BufferedImage border;
    private BufferedImage choose_YourName;
    private BufferedImage name_Line;
    private LevelButton done_Button;
    private int tick=0;
    private int animation_Speed=13;
    private int animation_Phase=0;

    private ArrayList<AlphaNumButton> ALBUTTONS;
    private ArrayList<AlphaNumButton> PRESSED_ALBUTTONS;
    private ArrayList<BufferedImage> alpha_ButtonsSprites;
    private ArrayList<BufferedImage> displayed_Characters;
    private int max_nrOfCharacters=6;

    private BufferedImage[] neutral_Array;
    private BufferedImage[] hovered_Array;
    private BufferedImage[] pressed_Array;
    private BufferedImage[] noBorder_Array;

    public ChooseNamePanel(Panel PANEL) {

        PRESSED_ALBUTTONS=new ArrayList<AlphaNumButton>(0);

        Sprite=LoadSave.load_IMG(LoadSave.STARRY_SKY);
        game_panel=PANEL;
        make_Animation();
        load_BtnSprites();
        make_ALSpriteArrays();
        load_Buttons();
        displayed_Characters=new ArrayList<>(0);

        border=LoadSave.load_IMG(BORDER);
        name_Line=LoadSave.load_IMG(NAME_LINE);
        choose_YourName=LoadSave.load_IMG(LoadSave.CHOOSE_NAME);
        done_Button=new LevelButton(DONE_NEUTRAL,DONE_HOVERED,DONE_PRESSED,getGamePanel(),(int)(WINDOW_REAL_WIDTH*0.465f),(int)(WINDOW_REAL_HEIGHT*0.3f),DONE_REAL_WIDTH,DONE_REAL_HEIGHT,DONE_BUTTON_ID);
        backspaceButton=new LevelButton(BACKSPACE_NEUTRAL,BACKSPACE_HOVERED,BACKSPACE_PRESSED,getGamePanel(),(int)(WINDOW_REAL_WIDTH/1.7f), (int)(WINDOW_REAL_HEIGHT/1.47f),BACKSPACE_BUTTON_REAL_WIDTH,BACKSPACE_BUTTON_REAL_HEIGHT,BACKSPACE_BUTTON_ID);
        go_BackButton=new LevelButton(GO_BACK_NEUTRAL,GO_BACK_HOVERED,GO_BACK_PRESSED,getGamePanel(),(int)(WINDOW_REAL_WIDTH/2.35f),(int)(WINDOW_REAL_HEIGHT/1.1f),GO_BACK_BUTTON_REAL_WIDTH,GO_BACK_BUTTON_REAL_HEIGHT,GO_BACK_BUTTON_ID );
    }

    private void load_BtnSprites() {
        alpha_ButtonsSprites=new ArrayList<BufferedImage>();
        alpha_ButtonsSprites.add(LoadSave.load_IMG(LoadSave.ALPHABET_NEUTRAL));
        alpha_ButtonsSprites.add(LoadSave.load_IMG(LoadSave.ALPHABET_HOVERED));
        alpha_ButtonsSprites.add(LoadSave.load_IMG(LoadSave.ALPHABET_PRESSED));
        alpha_ButtonsSprites.add(LoadSave.load_IMG(LoadSave.ALPHABET_NO_BORDERS));
    }

    private void make_ALSpriteArrays() {
        neutral_Array=new BufferedImage[26];
        hovered_Array=new BufferedImage[26];
        pressed_Array=new BufferedImage[26];
        noBorder_Array=new BufferedImage[26];
        for(int i=0;i<26;i++) {
                neutral_Array[i] = alpha_ButtonsSprites.get(0).getSubimage(i * ALPHANUM_BUTTON_IMG_WIDTH, 0, ALPHANUM_BUTTON_IMG_WIDTH, ALPHANUM_BUTTON_IMG_HEIGHT);
                hovered_Array[i] = alpha_ButtonsSprites.get(1).getSubimage(i * ALPHANUM_BUTTON_IMG_WIDTH, 0, ALPHANUM_BUTTON_IMG_WIDTH, ALPHANUM_BUTTON_IMG_HEIGHT);
                pressed_Array[i] = alpha_ButtonsSprites.get(2).getSubimage(i * ALPHANUM_BUTTON_IMG_WIDTH, 0, ALPHANUM_BUTTON_IMG_WIDTH, ALPHANUM_BUTTON_IMG_HEIGHT);
                noBorder_Array[i]= alpha_ButtonsSprites.get(3).getSubimage(i * ALPHANUM_BUTTON_IMG_WIDTH,0,ALPHANUM_BUTTON_IMG_WIDTH,ALPHANUM_BUTTON_IMG_HEIGHT);
        }
    }

    private void load_Buttons() {
        ALBUTTONS=new ArrayList<AlphaNumButton>();
        for(int i=0;i<26;i++) {
            if(i<7) {
                ALBUTTONS.add(i,new AlphaNumButton(getNeutral_Array()[i],getHovered_Array()[i],getPressed_Array()[i],game_panel,(int)((float)WINDOW_REAL_WIDTH/3.2f)+(int)(i * ALPHANUM_BUTTON_IMG_WIDTH*0.25f),7*ALPHANUM_BUTTON_REAL_HEIGHT,ALPHANUM_BUTTON_REAL_WIDTH,ALPHANUM_BUTTON_REAL_HEIGHT,ALPHANUM_BUTTON_ID,i));
            } else if(i<14) {
                ALBUTTONS.add(i,new AlphaNumButton(getNeutral_Array()[i],getHovered_Array()[i],getPressed_Array()[i],game_panel,(int)((float)WINDOW_REAL_WIDTH/3.2f)+(int)((i-7) * ALPHANUM_BUTTON_IMG_WIDTH*0.25f),8*ALPHANUM_BUTTON_REAL_HEIGHT+ALPHANUM_BUTTON_OFFSET,ALPHANUM_BUTTON_REAL_WIDTH,ALPHANUM_BUTTON_REAL_HEIGHT,ALPHANUM_BUTTON_ID,i));
            } else if(i<21) {
                ALBUTTONS.add(i,new AlphaNumButton(getNeutral_Array()[i],getHovered_Array()[i],getPressed_Array()[i],game_panel,(int)((float)WINDOW_REAL_WIDTH/3.2f)+(int)((i-14) * ALPHANUM_BUTTON_IMG_WIDTH*0.25f),9*ALPHANUM_BUTTON_REAL_HEIGHT+ALPHANUM_BUTTON_OFFSET*2,ALPHANUM_BUTTON_REAL_WIDTH,ALPHANUM_BUTTON_REAL_HEIGHT,ALPHANUM_BUTTON_ID,i));
            }
            else {
                ALBUTTONS.add(i,new AlphaNumButton(getNeutral_Array()[i],getHovered_Array()[i],getPressed_Array()[i],game_panel,(int)((float)WINDOW_REAL_WIDTH/3.2f)+(int)((i-21) * ALPHANUM_BUTTON_IMG_WIDTH*0.25f),10*ALPHANUM_BUTTON_REAL_HEIGHT+ALPHANUM_BUTTON_OFFSET*3,ALPHANUM_BUTTON_REAL_WIDTH,ALPHANUM_BUTTON_REAL_HEIGHT,ALPHANUM_BUTTON_ID,i));
            }
        }
    }

    private void make_Animation() {
        animation=new BufferedImage[18];
        for(int i=0;i<18;i++) {
            animation[i]=Sprite.getSubimage(i*1920,0,STARRY_SKY_IMG_WIDTH,STARRY_SKY_IMG_HEIGHT);
        }
    }

    private void update_Animation() {
        tick++;
        if(tick>=animation_Speed) {
            tick=0;
            animation_Phase++;
            if(animation_Phase>=18) {
                animation_Phase=0;
            }
        }
    }

    public void update_ChooseNamePanel() {
        update_Animation();
    }

    public void paint_ChooseNamePanel(Graphics g) {
        g.fillRect(0,0,WINDOW_REAL_WIDTH,WINDOW_REAL_HEIGHT);
        g.drawImage(animation[animation_Phase],(int)(WINDOW_REAL_WIDTH*0.22f),0,WINDOW_REAL_HEIGHT,WINDOW_REAL_HEIGHT,null);
        getGoBackButton().paint_Button(g);
        getBackspaceButton().paint_Button(g);
        getDone_Button().paint_Button(g);
        g.drawImage(name_Line,(int)(WINDOW_REAL_WIDTH*0.353f),(int)(WINDOW_REAL_HEIGHT*0.23f),NAME_LINE_REAL_WIDTH,NAME_LINE_REAL_HEIGHT,null);
        g.drawImage(border,(int)(WINDOW_REAL_WIDTH*0.25f),(int)(WINDOW_REAL_HEIGHT*0.35f),BORDER_REAL_WIDTH,BORDER_REAL_HEIGHT,null);
        g.drawImage(choose_YourName,(int)(WINDOW_REAL_WIDTH*0.3f),(int)(WINDOW_REAL_HEIGHT*0.05f),CHOOSE_NAME_REAL_WIDTH,CHOOSE_NAME_REAL_HEIGHT,null);

        for(int i=0;i<26;i++) {
            getALBUTTONS().get(i).paint_Button(g);
            if(!getDisplayed_Characters().isEmpty() && i< getDisplayed_Characters().size()) {
                g.drawImage(getDisplayed_Characters().get(i),(int)(WINDOW_REAL_WIDTH*0.43f)+i*(int)(ALPHANUM_BUTTON_OFFSET*1.2f),(int)(WINDOW_REAL_HEIGHT*0.212f),ALPHANUM_BUTTON_REAL_WIDTH,ALPHANUM_BUTTON_REAL_HEIGHT,null);
            }
        }
    }



    public ArrayList<AlphaNumButton> getPRESSED_ALBUTTONS() {
        return PRESSED_ALBUTTONS;
    }
    public void print_CURRENT_PRESSED_IDS() {
        if(!getPRESSED_ALBUTTONS().isEmpty()) {
            for (AlphaNumButton i : getPRESSED_ALBUTTONS()) {
                System.out.println(i.getAlphanum_ID());
            }
        }
        else {
            System.out.println("empty");
        }
    }
    public BufferedImage[] getNoBorder_Array() {
        return noBorder_Array;
    }
    public void reset_PressedButtons() {
        this.PRESSED_ALBUTTONS=new ArrayList<AlphaNumButton>();
    }
    public void reset_DisplayedCharacters() {
        this.displayed_Characters=new ArrayList<BufferedImage>();
    }
    public ArrayList<BufferedImage> getDisplayed_Characters() {
        return displayed_Characters;
    }
    public void add_ToDisplayedCharacters(int code) {
        if(getDisplayed_Characters().size()<=max_nrOfCharacters) {
            for (int i = 0; i < 26; i++) {
                if (code == i) {
                    getDisplayed_Characters().add(getNoBorder_Array()[i]);
                }
            }
        }
    }
    public void add_ToPressedButtons(AlphaNumButton i) {
        getPRESSED_ALBUTTONS().add(i);
    }
    public LevelButton getDone_Button() {
        return done_Button;
    }
    public LevelButton getBackspaceButton() {
        return backspaceButton;
    }
    public LevelButton getGoBackButton() {
        return go_BackButton;
    }
    public ArrayList<AlphaNumButton> getALBUTTONS() {
        return ALBUTTONS;
    }
    public BufferedImage[] getNeutral_Array() {
        return neutral_Array;
    }
    public BufferedImage[] getHovered_Array() {
        return hovered_Array;
    }
    public BufferedImage[] getPressed_Array() {
        return pressed_Array;
    }
    public Panel getGamePanel() {
        return game_panel;
    }
    public void setGamePanel(Panel PANEL) {
        game_panel=PANEL;
    }
}
