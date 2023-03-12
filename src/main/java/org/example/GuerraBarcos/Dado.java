package org.example.GuerraBarcos;

import java.util.Random;

class Dado {
    private Random rand;

    public Dado() {
        rand = new Random();
    }

    public int lanzar() {
        return rand.nextInt(6) + 1;
    }
}