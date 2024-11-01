package Entities;

public abstract class Entity {
    protected int x,y;
    protected int last_direction;

    public Entity() {
    }

    public int get_lastDirection() {
        return last_direction;
    }
    public void set_lastDiretion(int val) {
        last_direction=val;
    }
    public int get_X() {
        return x;
    }
    public int get_Y() {
        return y;
    }
    public void set_X(int _x) {
        x=_x;
    }
    public void set_Y(int _y) {
        y=_y;
    }

}
