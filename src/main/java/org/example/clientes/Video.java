package org.example.clientes;

class Video extends Obra {
    private int duracionMinutos;

    public Video(String titulo, String autor, int duracionMinutos) {
        super(titulo, autor);
        this.duracionMinutos = duracionMinutos;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public String getInfo() {
        int horas = duracionMinutos / 60;
        int minutos = duracionMinutos % 60;
        return String.format("Video %s de %s (%dh%d)", getTitulo(), getAutor(), horas, minutos);
    }
}
