package org.example.clientes;

import java.util.ArrayList;

class Pedido {
    private Cliente cliente;
    private ArrayList<Obra> obras;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.obras = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }

    public void mostrarInfo() {
        System.out.printf(" * Pedido de: %s:%n", cliente.getNombre());
        for (Obra obra : obras) {
            System.out.printf("    - %s%n", obra.getInfo());
        }
    }
}
