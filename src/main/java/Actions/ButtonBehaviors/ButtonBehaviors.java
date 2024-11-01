package Actions.ButtonBehaviors;

import Actions.Attack;
import Buttons.AlphaNumButton;
import Buttons.Button;
import Buttons.LevelButton;
import Main.Game;

import static LoadSave.LoadSave.SWORD_SWING;
import static Phases.Constants.*;

public abstract class ButtonBehaviors {


    public static void OnPress_PLAYINGSTATEButtons_Behavior(Main.Panel game_panel) {
        for(Button i:game_panel.getLevel().getBUTTONS()) {
            switch(i.get_ID()) {
                case SHOW_HITBOXES_BUTTON_ID:
                    ButtonBehaviors.OnPress_showHitboxesButton_Behavior((LevelButton) i);
                    break;
                case SET_NAME_BUTTON_ID:
                    ButtonBehaviors.OnPress_setNameButton_Behavior((LevelButton) i, game_panel);
                    break;
            }
        }

    }


    public static void OnPress_Attack(Main.Panel game_panel) {
        if(Game.getGameState()==PLAYING) {
            game_panel.getPlayer().set_SwordAttack(new Attack(game_panel.getPlayer().get_RelX(),game_panel.getPlayer().get_Y(),SWORD_SWING_REAL_WIDTH,SWORD_SWING_REAL_HEIGHT,game_panel.getPlayer(),ATTACK_SWORD,SWORD_SWING,SWORD_SWING_IMG_WIDTH,SWORD_SWING_IMG_HEIGHT));
        }
    }
    private static void OnPress_showHitboxesButton_Behavior(LevelButton i) {
        if(i.getIs_Hovered()) {
            i.setIs_Pressed(true);

            if(Game.get_PrintFlag()) {
                Game.set_PrintFlag(false);
            }
            else {
                Game.set_PrintFlag(true);
            }

            i.setIs_Hovered(false);
            i.setCURRENT_IMG(i.get_ph3());
        }
    }
    private static void OnPress_setNameButton_Behavior(LevelButton i, Main.Panel game_panel) {
        if(i.getIs_Hovered()) {
            i.setIs_Pressed(true);

            game_panel.getNamePanel().reset_PressedButtons();
            game_panel.getNamePanel().reset_DisplayedCharacters();

            Game.setGameState(CHOOSE_NAME);

            i.setIs_Hovered(false);
            i.setCURRENT_IMG(i.get_ph3());
        }

    }

    public static void OnPress_CHOOSENAMESTATEButtons_Behavior(Main.Panel game_panel) {
        for(AlphaNumButton i:game_panel.getNamePanel().getALBUTTONS()) {
            ButtonBehaviors.OnPress_AlphanumButton_Behavior(i,game_panel);
        }
        ButtonBehaviors.OnPress_DoneButton_Behavior(game_panel.getNamePanel().getDone_Button(),game_panel);
        ButtonBehaviors.OnPress_GoBackButton_Behavior(game_panel.getNamePanel().getGoBackButton(),game_panel);
        ButtonBehaviors.OnPress_BackspaceButton_Behavior(game_panel.getNamePanel().getBackspaceButton(),game_panel);

    }

    private static void OnPress_AlphanumButton_Behavior(AlphaNumButton i, Main.Panel game_panel) {
        if (i.getIs_Hovered()) {
            i.setIs_Pressed(true);

            if(game_panel.getNamePanel().getPRESSED_ALBUTTONS().size()<7) {
                game_panel.getNamePanel().add_ToDisplayedCharacters(i.getAlphanum_ID());
                game_panel.getNamePanel().add_ToPressedButtons(i);
            }

            char c = (char) (i.getAlphanum_ID() + 65);
            System.out.println(c);

            i.setIs_Hovered(false);
            i.setCURRENT_IMG(i.get_ph3());
        }
    }

    public static void OnPress_PlayButton_Behavior(LevelButton i, Main.Panel game_panel) {
        if(i.getIs_Hovered()) {
            i.setCURRENT_IMG(i.get_ph3());
            i.setIs_Pressed(true);
            i.setIs_Hovered(false);
            Game.setGameState(PLAYING);
        }
    }
    private static void OnPress_GoBackButton_Behavior(LevelButton i,Main.Panel game_panel) {
        if(i.getIs_Hovered()) {
            i.setCURRENT_IMG(i.get_ph3());
            game_panel.getNamePanel().reset_DisplayedCharacters();
            game_panel.getNamePanel().reset_PressedButtons();
            i.setIs_Pressed(true);
            i.setIs_Hovered(false);
            Game.setGameState(PLAYING);


        }
    }
    private static void OnPress_BackspaceButton_Behavior(LevelButton i, Main.Panel game_panel) {
        if(i.getIs_Hovered()) {
            i.setIs_Pressed(true);
            if(!game_panel.getNamePanel().getDisplayed_Characters().isEmpty()) {
                game_panel.getNamePanel().getDisplayed_Characters().remove(game_panel.getNamePanel().getDisplayed_Characters().size()-1);
                game_panel.getNamePanel().getPRESSED_ALBUTTONS().remove(game_panel.getNamePanel().getPRESSED_ALBUTTONS().size()-1);
            }
            ButtonBehaviors.OnPress_DoneButton_Behavior(game_panel.getNamePanel().getDone_Button(),game_panel);
            System.out.println("backspace");
            i.setIs_Hovered(false);
            i.setCURRENT_IMG(i.get_ph3());
        }
    }
    private static void OnPress_DoneButton_Behavior(LevelButton i, Main.Panel game_panel) {
        if(i.getIs_Hovered()) {
            i.setIs_Pressed(true);
            game_panel.getPlayer().reset_NAME_DISPLAY();
            FileManaging.WriteToFile(FileManaging.getFile_Name(),game_panel.getNamePanel().getPRESSED_ALBUTTONS());
            game_panel.getNamePanel().reset_DisplayedCharacters();
            i.setIs_Hovered(false);
            i.setCURRENT_IMG(i.get_ph3());
            Game.setGameState(PLAYING);
        }
    }

    public static void ReleasePress_PLAYINGSTATEButtons_Behavior(Main.Panel game_panel) {
        for(Button i:game_panel.getLevel().getBUTTONS()) {
            switch (i.get_ID()) {
                case SHOW_HITBOXES_BUTTON_ID:
                    ButtonBehaviors.ReleasePress_showHitboxesButton_Behavior((LevelButton) i);
                    break;
                case SET_NAME_BUTTON_ID:
                    ButtonBehaviors.ReleasePress_setNameButton_Behavior((LevelButton) i);
                    break;
            }
        }
    }

    public static void ReleasePress_PlayGameButton_Behavior(LevelButton i) {
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }
    private static void ReleasePress_showHitboxesButton_Behavior(LevelButton i) {
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }
    private static void ReleasePress_setNameButton_Behavior(LevelButton i) {
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }

    public static void ReleasePress_CHOOSENAMESTATEButtons_Behavior(Main.Panel game_panel) {
        for(AlphaNumButton i:game_panel.getNamePanel().getALBUTTONS()) {
            ReleasePress_alphanumericButton_Behavior(i);
        }
        ReleasePress_GoBackButton_Behavior(game_panel.getNamePanel().getGoBackButton());
        ReleasePress_BackspaceButton_Behavior(game_panel.getNamePanel().getBackspaceButton());
        ReleasePress_DoneButton_Behavior(game_panel.getNamePanel().getDone_Button());
    }

    private static void ReleasePress_DoneButton_Behavior(LevelButton i){
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }
    private static void ReleasePress_alphanumericButton_Behavior(AlphaNumButton i) {
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }
    private static void ReleasePress_GoBackButton_Behavior(LevelButton i) {
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }
    private static void ReleasePress_BackspaceButton_Behavior(LevelButton i) {
        i.setIs_Hovered(i.check_MouseHover());
        i.setIs_Pressed(false);
    }

    public static void MouseMoved_PLAYINGSTATEButtons_Behavior(Main.Panel game_panel) {
        for(Button i:game_panel.getLevel().getBUTTONS()) {
            switch (i.get_ID()) {
                case SHOW_HITBOXES_BUTTON_ID:
                    i.setIs_Hovered(i.check_MouseHover());
                    break;
                case SET_NAME_BUTTON_ID:
                    i.setIs_Hovered(i.check_MouseHover());
                    break;
            }
        }
    }
    public static void MouseMoved_CHOOSENAMESTATEButtons_Behavior(Main.Panel game_panel) {
        for(AlphaNumButton i:game_panel.getNamePanel().getALBUTTONS()) {
            i.setIs_Hovered(i.check_MouseHover());
        }
        game_panel.getNamePanel().getGoBackButton().setIs_Hovered(game_panel.getNamePanel().getGoBackButton().check_MouseHover());
        game_panel.getNamePanel().getBackspaceButton().setIs_Hovered(game_panel.getNamePanel().getBackspaceButton().check_MouseHover());
        game_panel.getNamePanel().getDone_Button().setIs_Hovered(game_panel.getNamePanel().getDone_Button().check_MouseHover());

    }

    public static void MouseMoved_PlayGameButton_Behavior(LevelButton i) {
        i.setIs_Hovered(i.check_MouseHover());
    }

}

