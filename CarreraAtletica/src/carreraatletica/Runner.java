/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carreraatletica;

import java.util.Random;

/**
 *
 * @author joann
 */
class Runner {

   private String name;
    private int speed;
    Random rand = new Random();

    public Runner(String name) {
        this.name = name;
        this.speed = rand.nextInt(31);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed() {
        this.speed = speed;
    
    }
}

    

