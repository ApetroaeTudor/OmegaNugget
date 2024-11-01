package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Actions.ButtonBehaviors.FileManaging;
import Actions.Falling;
import Actions.Jumping;
import Effects.Splash;
import Hitboxes.Hitbox;
import LoadSave.LoadSave;
import Actions.Attack;
import Main.Game;
import Phases.Constants;

import static Phases.Constants.*;

public class Player extends Entity{


    private int ch_X=(int)(WINDOW_REAL_WIDTH*0.1f);
    private int ch_Y=(int)(WINDOW_REAL_HEIGHT*0.3f);
    private int player_relY=(int)((ch_Y+PLAYER_REAL_HEIGHT)*0.96f);
    private int player_relX=ch_X+PLAYER_REAL_WIDTH;
    private boolean checked_File=false;

    private BufferedImage[] NAME_DISPLAY;
    private int nr_ofCharactersInName=0;

    private Main.Panel game_panel;
    private Name name;

    private BufferedImage Sprite;

    private Falling fall;
    private Jumping jump;
    private Splash splash;
    private Attack sword_Attack;

    private ArrayList<Hitbox> HITBOXES;

    private Hitbox personal_Hitbox;

    private BufferedImage[] Animation;
    private int State=BASE;


    private int tick=0;
    private int animation_phase=0;
    private int animation_speed=10;

    private boolean is_MovingRight=false;
    private boolean is_MovingLeft=false;


    public Player(Main.Panel PANEL) {
        super();
        NAME_DISPLAY=new BufferedImage[7];
        game_panel=PANEL;
        x=ch_X;
        y=ch_Y;
        this.set_X(ch_X);
        this.set_Y(ch_Y);
        name=new Name(this);
        load_Img();
        load_Animation();
        fall=new Falling(this);
        jump=new Jumping(this);
        splash=new Splash(this.get_X(),WINDOW_REAL_HEIGHT,this);
        update_personalHitbox(ch_X,ch_Y+(int)(PLAYER_REAL_HEIGHT*0.08f),PLAYER_REAL_WIDTH,(int)(PLAYER_REAL_HEIGHT*0.8f));
    }

    public void update_personalHitbox(int X,int Y, int WID,int HEI) {
        this.personal_Hitbox=new Hitbox(X,Y,WID,HEI );
    }
    public void update_NAME_DISPLAY() {
        java.util.List<String> list= FileManaging.make_StringFromFile();

        if(list!=null && !get_CheckedFile()) {
            for(int i=0;i<list.size();i++) {
                NAME_DISPLAY[i]=getGame_panel().getNamePanel().getNoBorder_Array()[Integer.parseInt(list.get(i).trim())];
            }
            setNr_ofCharactersInName(list.size());
            set_CheckedFile(true);
        }
        else {
            if(!getGame_panel().getNamePanel().getPRESSED_ALBUTTONS().isEmpty()) {
                for (int i = 0; i < getGame_panel().getNamePanel().getPRESSED_ALBUTTONS().size(); i++) {
                    NAME_DISPLAY[i] = getGame_panel().getNamePanel().getNoBorder_Array()[getGame_panel().getNamePanel().getPRESSED_ALBUTTONS().get(i).getAlphanum_ID()];
                }
                setNr_ofCharactersInName(getGame_panel().getNamePanel().getPRESSED_ALBUTTONS().size());
            }

        }
    }

    public void reset_NAME_DISPLAY() {
        NAME_DISPLAY=new BufferedImage[7];
    }

    public void assign_Hitboxes(ArrayList<Hitbox> hitboxes) {
        this.HITBOXES=hitboxes;
    }

    public boolean check_CollisionWithDonut() {
        if(Hitbox.check_Collision2Hitboxes(getPersonal_Hitbox(),game_panel.getLevel().getDONUT().getPersonal_Hitbox())) {
            game_panel.getLevel().getDONUT().setIsCollected(true);
            return true;
        }
        return false;
    }
    public boolean can_Move() {
        boolean res=false;
        if(getJump().get_IsJumping()) {
            return true;
        }
        for(Hitbox h:HITBOXES) {
            int obj_mid=h.get_y()+((h.get_relY()- h.get_y())/2);
            if( (player_relX>h.get_x() && x< h.get_relX()) && (player_relY>obj_mid-2 && player_relY<obj_mid+2) ) {
                res=true;
            }
        }

        return res;
    }

    public boolean check_IfCanJump() {
        return (!getJump().get_IsJumping() && !getFall().get_isFalling());
    }


    private void load_Img() {

        this.Sprite=LoadSave.load_IMG(LoadSave.PLAYER);
    }

    private void load_Animation() {
        Animation=new BufferedImage[get_nrFrames(State)];
        for(int i=0;i<get_nrFrames(State);i++) {
            Animation[i]=Sprite.getSubimage(i*PLAYER_WIDTH_IMG,0,PLAYER_WIDTH_IMG,PLAYER_HEIGHT_IMG);
        }
    }

    public void update_Animation() { //default animation
        tick++;
        if(tick>=animation_speed) {
            tick=0;
            animation_phase++;
            if(animation_phase>=get_nrFrames(State)) {
                animation_phase=0;
            }
        }

    }


    public void default_updatePosition() {
        if (is_MovingLeft && !is_MovingRight) {
            set_X(get_X()-1);
            personal_Hitbox.update_Hitbox(0,0,-1,0);
        } else if (is_MovingRight && !is_MovingLeft) {
            set_X(get_X()+1);
            personal_Hitbox.update_Hitbox(0,0,1,0);
        }
    }

    public void update_PositionSlow() {
        fall.check_Falling();
        switch (this.get_State()) {
            case FALLING:
                default_updatePosition();
                break;
        }
    }

    public void update_Position() {
        fall.check_Falling();

        switch (this.get_State()) {
            case BASE:
                default_updatePosition();
                break;
            case FALLING:
                getFall().update_Position();
                break;
            case Constants.JUMPING:
                getJump().update_Position();
                break;
            case DEAD:
                getFall().update_Position();
                break;

        }
    }

    public boolean check_TouchesWater() {
        if(player_relY>= (int)(WINDOW_REAL_HEIGHT*0.95f)) {
            return true;
        }
        return false;

    }

    public void paint_PlayerName(Graphics g) {
        if(getNAME_DISPLAY()!=null) {
            for (int i = 0; i < getNAME_DISPLAY().length; i++) {
                g.drawImage(getNAME_DISPLAY()[i], (get_X()-(int)(getNr_ofCharactersInName()*ALPHANUM_BUTTON_IMG_WIDTH*0.019f)) + i * (int) (WINDOW_REAL_WIDTH * 0.0135f), get_Y() - (int) (WINDOW_REAL_HEIGHT * 0.04f), (int)(ALPHANUM_BUTTON_REAL_WIDTH*0.7f), (int)(ALPHANUM_BUTTON_REAL_HEIGHT*0.7f), null);
            }
        }

    }

    public void paint_Animation(Graphics g) {
        set_State();
        switch (get_State()) {
            case FALLING:
                if(getFall().get_AnimationPhase()>=0) {
                    getFall().paint_Animation(g);
                }

                break;
            case BASE:

                g.drawImage(Animation[animation_phase], x, y, PLAYER_REAL_WIDTH, PLAYER_REAL_HEIGHT, null);
                break;
            case Constants.JUMPING:

                getJump().paint_Animation(g);
                break;

            case DEAD:

                splash.set_X(this.get_X());
                splash.paint_Animation(g);
                getFall().paint_Animation(g);

                break;
        }
        print_PrivateHitbox(g);
        if(sword_Attack!=null) {
            if (!sword_Attack.get_IsFinished()) {
                sword_Attack.print_Animation(g);
            }
        }

    }

    private boolean check_CollisionDeath() {
        if(Hitbox.check_Collision2Hitboxes(getPersonal_Hitbox(),getGame_panel().getCat().getPrivate_Hitbox()) && get_State()!=DEAD) {
            set_X(-500);
            set_Y(-500);
            return true;

        }
        return false;
    }


    public int getNr_ofCharactersInName() {
        return nr_ofCharactersInName;
    }
    public void setNr_ofCharactersInName(int val) {
        nr_ofCharactersInName=val;
    }
    public BufferedImage[] getNAME_DISPLAY() {
        return NAME_DISPLAY;
    }

    public Name getName() {
        return name;
    }
    public Main.Panel getGame_panel() {
        return game_panel;
    }
    public void set_X(int x) {
        super.set_X(x);
        this.player_relX=x+PLAYER_REAL_WIDTH;
    }
    public void set_Y(int y) {
        super.set_Y(y);
        this.player_relY=(int)((y+PLAYER_REAL_HEIGHT)*0.96f);
    }

    public void set_SwordAttack(Attack att) {
        sword_Attack=att;
    }
    public Attack getSword_Attack() {
        return sword_Attack;
    }
    public boolean get_CheckedFile() {
        return checked_File;
    }
    public void set_CheckedFile(boolean val) {
        checked_File=val;
    }
    public int get_RelX() {
        return player_relX;
    }
    public int get_RelY() {
        return player_relY;
    }

    public void set_MovingRight(boolean val) {
        is_MovingRight=val;
    }
    public void set_MovingLeft(boolean val) {
        is_MovingLeft=val;
    }
    public boolean is_MovingRight() {
        return is_MovingRight;
    }
    public boolean is_MovingLeft() {
        return is_MovingLeft;
    }

    public Falling getFall() {
        return fall;
    }
    public Jumping getJump() {
        return jump;
    }
    public Splash getSplash() {
        return splash;
    }
    public Hitbox getPersonal_Hitbox() {
        return personal_Hitbox;
    }
    public void setPersonal_Hitbox(Hitbox H) {
        personal_Hitbox=H;
    }
    public void set_Death(boolean val) {
        if(val) {
            State=DEAD;
        }

    }
    public boolean is_Dead() {
        if(State==DEAD) {
            return true;
        }
        return false;
    }
    public int get_State() {
        return State;
    }

    public void print_PrivateHitbox(Graphics g) {
        if(Game.get_PrintFlag()) {
            personal_Hitbox.print_Hitbox(g);
        }
    }

    public void set_State() {
        State=BASE;

        if(check_TouchesWater() || check_CollisionDeath()) {
            State=DEAD;
            Game.set_PrintFlag(false);
        }
        else if(check_CollisionWithDonut()) {
            State=WON;
            Game.set_PrintFlag(false);
        }
        else if(getFall().get_isFalling()) {
            State=FALLING;
        }
        else if(getJump().get_IsJumping()) {
            State= Constants.JUMPING;
        }


    }




}
