package org.example.GuerraBarcos;

import java.util.Scanner;


public class JugadorGuerra {
    private int fichas;
    private Dado dado;
    private String nombre;

    public JugadorGuerra(int fichas, String nombre) {
        this.fichas = fichas;
        this.nombre = nombre;
        this.dado = new Dado();
    }

    public int getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }

    public int lanzarDado() {
        return dado.lanzar();
    }

    public void quitarFicha() {
        fichas--;
    }

    public void agregarFicha() {
        fichas++;
    }

    public boolean tieneFichas() {
        return fichas > 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        JugadorGuerra jugador1 = new JugadorGuerra(10, nombreJugador1);

        System.out.print("Introduce el nombre del jugador 2: ");
        String nombreJugador2 = scanner.nextLine();
        JugadorGuerra jugador2 = new JugadorGuerra(10, nombreJugador2);

        int rondas = 1;

        while (jugador1.tieneFichas() && jugador2.tieneFichas()) {
            System.out.print(jugador1.getNombre() + ", pulsa ENTER para lanzar el dado-->");
            scanner.nextLine();
            int resultadoJugador1 = jugador1.lanzarDado();

            System.out.print(jugador2.getNombre() + ", pulsa ENTER para lanzar el dado-->");
            scanner.nextLine();
            int resultadoJugador2 = jugador2.lanzarDado();

            System.out.println(jugador1.getNombre() + " ha sacado un " + resultadoJugador1);
            System.out.println(jugador2.getNombre() + " ha sacado un " + resultadoJugador2);

            if (resultadoJugador1 > resultadoJugador2) {
                System.out.println(jugador1.getNombre() + " gana");
                jugador1.agregarFicha();
                jugador2.quitarFicha();
            } else if (resultadoJugador2 > resultadoJugador1) {
                System.out.println(jugador2.getNombre() + " gana");
                jugador2.agregarFicha();
                jugador1.quitarFicha();
            } else {
                System.out.println("Empate");
            }

            System.out.println("Marcador: " + jugador1.getNombre() + " " + jugador1.getFichas() + " - " + jugador2.getFichas() + " " + jugador2.getNombre());
            System.out.println();

            rondas++;
        }

        if (jugador1.getFichas() == 0) {
            System.out.println(jugador2.getNombre() + " ha ganado");
        } else {
            System.out.println(jugador1.getNombre() + " ha ganado");
        }
    }
}