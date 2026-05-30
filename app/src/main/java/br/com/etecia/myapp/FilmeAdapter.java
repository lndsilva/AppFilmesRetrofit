package br.com.etecia.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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

        Glide.with(holder.itemView.getContext())
                .load(filme.getUrlCapa())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(holder.imgFilme);
    }

    @Override
    public int getItemCount() {
        return listaFilmes != null ? listaFilmes.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomeFilme;
        ImageView imgFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeFilme = itemView.findViewById(R.id.txtNomeFilme);
            imgFilme = itemView.findViewById(R.id.imgFilme);
        }
    }
}
