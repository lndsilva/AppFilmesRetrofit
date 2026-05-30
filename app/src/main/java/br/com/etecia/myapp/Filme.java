package br.com.etecia.myapp;

import com.google.gson.annotations.SerializedName;

public class Filme {
    @SerializedName("title")
    private String titulo;
    @SerializedName("poster_url")
    private String urlCapa;

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
