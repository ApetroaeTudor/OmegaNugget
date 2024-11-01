package Main;

import Effects.Death;
import Effects.Splash;
import Entities.*;
import Hitboxes.Hitbox;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import Levels.LevelOne;
import States.ChooseNamePanel;
import States.MainMenuPanel;
import States.YouWinPanel;

import javax.swing.*;
import java.awt.*;

import static Phases.Constants.*;

public class Panel extends JPanel {

    private KeyboardInputs keyboard;
    private MouseInputs mouse;
    private Game game;
    private LevelOne level;
    private Player Character;
    private Splash splash;
    private Death death;
    private ChooseNamePanel namePanel;
    private YouWinPanel winPanel;
    private Point p;

    private boolean died_BySplash=false;

    private Enemy Cat;
    private MainMenuPanel main_MenuPanel;

    public Panel(Game GAME) {
        p=MouseInfo.getPointerInfo().getLocation();
        game=GAME;


        namePanel = new ChooseNamePanel(this);
        main_MenuPanel=new MainMenuPanel(this);
        winPanel=new YouWinPanel(this);

        Character=new Player(this);
        level=new LevelOne(this);
        Character.assign_Hitboxes(level.get_HitboxArr());
        Cat=new Enemy((int)(WINDOW_REAL_WIDTH*0.45f),(int)(WINDOW_REAL_HEIGHT*0.3f),ENEMY_REAL_WIDTH,ENEMY_REAL_HEIGHT,this);


        death=new Death(0,0,game);

        splash=new Splash(Character.get_RelX(), Character.get_RelY(),Character);

        set_WindowSize();
        keyboard=new KeyboardInputs(this,Character);
        mouse=new MouseInputs(this,Character);
        addKeyListener(keyboard);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

    }

    private void set_WindowSize() {
        Dimension max=new Dimension(WINDOW_REAL_WIDTH,WINDOW_REAL_HEIGHT);
        setMaximumSize(max);
        setMinimumSize(max);
        setPreferredSize(max);
    }

    public void slow_Update() {
    }

    public void update() {

        p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, this);

        switch (Game.getGameState()) {
            case PLAYING:
                Character.update_NAME_DISPLAY();
                Cat.update_Enemy();
                getLevel().getDONUT().update_Donut();

                getLevel().getBg().update_bg();

                if(Character.getSword_Attack()!=null) {
                    if(!Character.getSword_Attack().get_IsFinished()) {
                        Character.getSword_Attack().Attack_Update();
                    }
                    if(Character.getSword_Attack().get_IsFinished()) {
                        Character.set_SwordAttack(null);
                    }
                }

                switch (Character.get_State()) {
                    case BASE:
                        Character.update_Position();

                        Character.update_Animation();
                        Character.update_personalHitbox(Character.get_X(), (int) (Character.get_Y() * 1f), PLAYER_REAL_WIDTH, (int) (PLAYER_REAL_HEIGHT * 0.8f));

                        break;
                    case JUMPING:
                        Character.update_Position();

                        Character.getJump().update_Animation();
                        Character.update_personalHitbox(Character.get_X(), (int) (Character.get_Y() * 1f), PLAYER_REAL_WIDTH, (int) (PLAYER_REAL_HEIGHT * 0.6f));
                        break;
                    case FALLING:
                        Character.update_Position();

                        Character.getFall().update_Animation();
                        Character.update_PositionSlow();
                        Character.update_personalHitbox(Character.get_X(), (int) (Character.get_Y() * 1f), PLAYER_REAL_WIDTH, (int) (PLAYER_REAL_HEIGHT * 0.8f));

                        break;
                    case DEAD:

                        if (Character.check_TouchesWater()) {
                            died_BySplash = true;
                        }
                        if (died_BySplash) {
                            splash.set_X(Character.get_X());
                            splash.set_Y(Character.get_Y());

                            Character.getSplash().update_Animation();
                            Character.set_Y(Character.get_Y() + 2);

                            if (Character.getSplash().get_Fin()) {
                                death.update_Animation();
                            }
                        } else {
                            death.update_Animation();
                        }
                        break;

                    case WON:
                        winPanel.update_Animation();
                        break;
                }
                break;


                    case CHOOSE_NAME:
                        namePanel.update_ChooseNamePanel();
                        break;
                    case MAIN_MENU:
                        main_MenuPanel.update_Menu();
                        break;
                }


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (Game.getGameState()) {
            case PLAYING:
                level.paint_Level(g);
                Character.paint_Animation(g);
                if(Cat!=null) {
                Cat.draw_Enemy(g);
                }

                if(Character.get_State()==DEAD) {
                    death.paint_Animation(g);
                }

                for(Hitbox h:level.get_HitboxArr()) {
                    h.print_Hitbox(g);
                }
                if(Character.getSword_Attack()!=null) {
                    Character.getSword_Attack().print_Hitbox(g);
                }
                if(!(Character.get_State()==DEAD) && !(Character.get_State()==WON)) {
                    Character.paint_PlayerName(g);
                    getCat().print_privateHitbox(g);
                }

                if(Character.get_State()==WON) {
                    winPanel.print_YouWin(g);
                }


                break;
            case CHOOSE_NAME:
                namePanel.paint_ChooseNamePanel(g);
                break;
            case MAIN_MENU:
                getMain_MenuPanel().paint_Menu(g);
                break;
        }
    }


    public Enemy getCat() {
        return Cat;
    }
    public MainMenuPanel getMain_MenuPanel(){
        return main_MenuPanel;
    }
    public Player getPlayer() {
        return Character;
    }
    public LevelOne getLevel() {
        return level;
    }
    public Point getP() {
        return p;
    }
    public ChooseNamePanel getNamePanel() {
        return namePanel;
    }
}
