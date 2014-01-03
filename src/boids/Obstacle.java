/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trunk.src.boids;

import java.util.Random;
import math.vector2d;

/**
 *
 * @author epifaniusz
 */
public class Obstacle {

    vector2d position;
    int radius;

    public Obstacle(double x, double y) {
        position = new vector2d(x, y);
        radius = 30;
    }
    public Obstacle(double x, double y, int rad) {
        position = new vector2d(x, y);
        radius = rad;
    }

    public vector2d getPosition() {
        return this.position;
    }

    public void setPosition(vector2d _pos) {
        this.position = _pos;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public int getR() {
        return radius;
    }
}
