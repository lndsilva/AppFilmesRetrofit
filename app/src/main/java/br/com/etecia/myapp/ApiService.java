package br.com.etecia.myapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("filmes")
    Call<List<Filme>> getFilmes();
}
