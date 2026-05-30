package br.com.etecia.myapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/popular")
    Call<FilmeResposta> getFilmes(
            @Query("api_key") String apiKey,
            @Query("language") String idioma
    );
}
