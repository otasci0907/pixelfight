package com.mygdx.game;

public class Hitbox {
    private float x;
    private float y;
    private float width;
    private float height;

    public Hitbox(float xT, float yT, float widthT, float heightT) {
        x = xT;
        y = yT;
        width = widthT;
        height = heightT;
    }

    public boolean notTouching(Hitbox other) {
        if (Math.abs((x + width) - other.getX()) < width + other.getWidth() || Math.abs(x -(other.getWidth() + other.getX())) < width + other.getWidth() ) {
            return false;
        }
        return true;
    }

    public void move(int moveSpeed) {
        x += moveSpeed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
