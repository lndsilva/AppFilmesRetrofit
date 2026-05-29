package br.com.etecia.myapp;

public class Filme {
    private String titulo;
    private String urlCapa;

    public Filme(String titulo, String urlCapa) {
        this.titulo = titulo;
        this.urlCapa = urlCapa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }
}
