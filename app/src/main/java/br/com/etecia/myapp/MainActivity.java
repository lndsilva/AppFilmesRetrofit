package br.com.etecia.myapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView idRecFilmes;
    private FilmeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idRecFilmes = findViewById(R.id.idRecFilmes);
        idRecFilmes.setLayoutManager(new LinearLayoutManager(this));

        carregaFilmes();
    }

    private void carregaFilmes() {

        String URL_BASE = "https://themoviedb.org";

        String API_KEY = BuildConfig.TMDB_KEY;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<FilmeResposta> call = apiService.getFilmes(API_KEY, "pt-BR");

        call.enqueue(new Callback<FilmeResposta>() {
            @Override
            public void onResponse(Call<FilmeResposta> call, Response<FilmeResposta> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Filme> filmes = response.body().getResultados();

                    adapter = new FilmeAdapter(filmes);
                    idRecFilmes.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, "Erro na API"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FilmeResposta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na rede "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}