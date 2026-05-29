package br.com.etecia.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {

    private List<Filme> listaFilmes;

    public FilmeAdapter(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.txtNomeFilme.setText(filme.getTitulo());
    }

    @Override
    public int getItemCount() {
        return listaFilmes != null ? listaFilmes.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomeFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeFilme = itemView.findViewById(R.id.txtNomeFilme);
        }
    }
}
