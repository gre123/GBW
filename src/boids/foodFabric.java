/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boids;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grzesiek
 */
public class foodFabric {
    int numberFood;
    ArrayList<Food> food;
    public foodFabric(int n)
    {
        numberFood=n;
        food=new ArrayList<Food>(n);
    }
    public foodFabric()
    {
        food=new ArrayList<Food>();
    }
    public ArrayList<Food> createFood(int m)
    {
        Food pom;
        Random rand=new Random();
        for(int i=0;i<m;i++)
        {
            pom=new Food(rand.nextInt(1090),rand.nextInt(660));
            food.add(pom);  
        }
        return food;
    }
}
