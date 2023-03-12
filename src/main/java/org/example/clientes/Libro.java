package org.example.clientes;

class Libro extends Obra {
    private int numPaginas;

    public Libro(String titulo, String autor, int numPaginas) {
        super(titulo, autor);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String getInfo() {
        return String.format("Libro %s de %s (%d páginas)", getTitulo(), getAutor(), getNumPaginas());
    }
}