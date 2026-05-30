package br.com.etecia.myapp;

import com.google.gson.annotations.SerializedName;

public class Filme {
    @SerializedName("title")
    private String titulo;

    @SerializedName("poster_path")
    private String urlCapa;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getUrlCapa() {
        if (urlCapa != null && !urlCapa.isEmpty()) {
            return "https://tmdb.org" + urlCapa;
        }
        return null;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }
}
