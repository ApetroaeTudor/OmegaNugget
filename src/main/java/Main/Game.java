package Main;

import static Phases.Constants.*;

public class Game implements Runnable {
    private Thread game_thread;
    private Window game_window;
    private Panel game_panel;


    private double FPS_Target=60.0d;
    private double UPS_Target=200.0d*(SCALE*1.43f);
    private double UPS_SlowTarget=200.0d*(SCALE*1.6f);
    private static boolean is_Running=true;

    public static boolean printHitbox_Flag=false;
    public static int GAME_STATE=MAIN_MENU;


    public Game() {

        this.game_panel=new Panel(this);
        this.game_window=new Window(game_panel);
        this.game_panel.requestFocus();
        run_loop();

    }

    public void restart_Game() {


        this.game_panel=new Panel(this);
        this.game_window.add_Panel(game_panel);
        this.game_panel.requestFocus();
        this.game_panel.repaint();
    }

    public void run_loop() {
        game_thread=new Thread(this);
        game_thread.start();
    }

    @Override
    public void run() {
        double time_perFrame=1000000000/FPS_Target;
        double time_perUpdate=1000000000/UPS_Target;
        double time_perSlowUpdate=1000000000/UPS_SlowTarget;

        long previous_Time=System.nanoTime();
        int frames=0;
        int updates=0;
        int slow_updates=0;
        long last_Check=System.currentTimeMillis();

        double deltaU=0;
        double deltaSU=0;
        double deltaF=0;

        while(is_Running) {

            long current_Time=System.nanoTime();
            deltaU+=(current_Time-previous_Time)/time_perUpdate;
            deltaF+=(current_Time-previous_Time)/time_perFrame;
            deltaSU+=(current_Time-previous_Time)/time_perSlowUpdate;

            previous_Time=current_Time;

            if(deltaU>=1) {
                updates++;
                game_panel.update();
                deltaU--;
            }
            if(deltaF>=1) {
                frames++;
                game_panel.repaint();
                deltaF--;
            }
            if(deltaSU>=1) {
                slow_updates++;
                game_panel.slow_Update();
                deltaSU--;
            }

            if(System.currentTimeMillis()-last_Check>=1000) { //once per second
                last_Check=System.currentTimeMillis();
                System.out.println("FPS: "+ frames + " | UPS: " +updates + " | SUPS: " +slow_updates);
                slow_updates=0;
                frames=0;
                updates=0;
            }

            if(get_isRunning()==false) {
                try {
                    this.game_thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("replaced");
                this.restart_Game();
                this.set_isRunning(true);
            }
        }


    }

    public static boolean get_isRunning() {
        return is_Running;
    }
    public static void set_isRunning(boolean val) {
        is_Running=val;
    }

    public static boolean get_PrintFlag() {
        return printHitbox_Flag;
    }
    public static void set_PrintFlag(boolean val) {
        printHitbox_Flag=val;
    }

    public static int getGameState() {
        return GAME_STATE;
    }
    public static void setGameState(int STATE) {
        GAME_STATE=STATE;
    }
}
