package br.com.etecia.myapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmeResposta {
    @SerializedName("results")
    private List<Filme> resultados;

    public List<Filme> getResultados() {
        return resultados;
    }

    public void setResultados(List<Filme> resultados) {
        this.resultados = resultados;
    }
}
