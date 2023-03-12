package org.example.clientes;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static int ultimoNumeroCliente = 0;
    private int numeroCliente;
    private String nombre;

    public Cliente(String nombre, int numeroCliente) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
    }

    public static int getUltimoNumeroCliente() {
        return ultimoNumeroCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("-- Menú --");
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear un cliente");
            System.out.println("3 - Crear una obra");
            System.out.println("4 - Crear un pedido");
            System.out.println("5 - Mostrar pedidos");
            System.out.println("6 - Salir");
            System.out.print("> ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea vacía después del número

            switch (opcion) {
                case 1:
                    System.out.println("-- Clientes --");
                    for (Cliente cliente : clientes) {
                        System.out.printf("Cliente n.°%d [%s]%n", cliente.getNumeroCliente(), cliente.getNombre());
                    }
                    break;
                case 2:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreCliente, getUltimoNumeroCliente() + 1);
                    clientes.add(cliente);
                    ultimoNumeroCliente++;
                    System.out.printf("Cliente n.°%d [%s] creado%n", cliente.getNumeroCliente(), cliente.getNombre());
                    break;
                case 3:
                    System.out.println("-- Obras --");
                    System.out.println("1 - Video");
                    System.out.println("2 - Libro");
                    System.out.print("> ");
                    int tipoObra = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea vacía después del número

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    Obra obra;
                    if (tipoObra == 1) {
                        System.out.print("Duración (minutos): ");
                        int duracionMinutos = scanner.nextInt();
                        obra = new Video(titulo, autor, duracionMinutos);
                    } else {
                        System.out.print("Número de páginas: ");
                        int numPaginas = scanner.nextInt();
                        obra = new Libro(titulo, autor, numPaginas);
                    }
                    obras.add(obra);
                    System.out.printf("Obra creada: %s%n", obra.getInfo());
                    break;
                case 4:
                    System.out.println("-- Pedidos --");
                    System.out.println("Clientes:");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.printf("%d - %s%n", i + 1, c.getNombre());
                    }
                    System.out.print("> ");
                    int indiceCliente = scanner.nextInt() - 1;
                    Cliente clientePedido = clientes.get(indiceCliente);

                    Pedido pedido = new Pedido(clientePedido);
                    pedidos.add(pedido);

                    System.out.println("Obras:");
                    for (int i = 0; i < obras.size(); i++) {
                        Obra o = obras.get(i);
                        System.out.printf("%d - %s%n", i + 1, o.getInfo());
                    }
                    System.out.print("> ");
                    int indiceObra = scanner.nextInt() - 1;
                    Obra obraPedido = obras.get(indiceObra);

                    pedido.agregarObra(obraPedido);
                    System.out.printf("Obra agregada al pedido%n");
                    break;
                case 5:
                    System.out.println("-- Pedidos --");
                    for (Pedido p : pedidos) {
                        p.mostrarInfo();
                    }
                    break;
                case 6:
                    System.out.println("¡Vuelva pronto!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }
}