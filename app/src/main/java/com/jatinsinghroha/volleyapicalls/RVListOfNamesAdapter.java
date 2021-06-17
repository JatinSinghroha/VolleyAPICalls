package com.jatinsinghroha.volleyapicalls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVListOfNamesAdapter extends RecyclerView.Adapter<RVListOfNamesAdapter.ViewHolder> {

    List<String> listOfNames;

    public RVListOfNamesAdapter(List<String> listOfNames){
        this.listOfNames = listOfNames;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RVListOfNamesAdapter.ViewHolder holder, int position) {

        TextView nameTV = (TextView) holder.itemView;

        nameTV.setText(listOfNames.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

        }
    }
}
