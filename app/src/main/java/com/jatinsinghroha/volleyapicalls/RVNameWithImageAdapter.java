package com.jatinsinghroha.volleyapicalls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVNameWithImageAdapter extends RecyclerView.Adapter<RVNameWithImageAdapter.ViewHolder> {

    List<NameAndImageModel> mNameAndImageModelList;
    GoToFullAnimalDetails mGoToFullAnimalDetails;

    public RVNameWithImageAdapter(List<NameAndImageModel> nameAndImageModelList, GoToFullAnimalDetails goToFullAnimalDetails){
        this.mNameAndImageModelList = nameAndImageModelList;
        this.mGoToFullAnimalDetails = goToFullAnimalDetails;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_with_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        NameAndImageModel object = mNameAndImageModelList.get(position);

        holder.nameOfAnimalTV.setText(object.getName());
        Glide
                .with(holder.imageOfAnimalIV)
                .load(object.getImageURL())
                .circleCrop()
                .placeholder(R.drawable.ic_baseline_download_24)
                .into(holder.imageOfAnimalIV);

        holder.nameOfAnimalTV.setOnClickListener(v -> {
//            mGoToFullAnimalDetails.onAnimalClick(object);
            mGoToFullAnimalDetails.onItemAdd(position);
        });

        holder.imageOfAnimalIV.setOnClickListener(v -> {
            mGoToFullAnimalDetails.onItemDelete(position);
        });
    }

    @Override
    public int getItemCount() {
        return mNameAndImageModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfAnimalTV;
        ImageView imageOfAnimalIV;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            nameOfAnimalTV = itemView.findViewById(R.id.animalNameTV);
            imageOfAnimalIV = itemView.findViewById(R.id.imageOfAnimal);
        }
    }

    interface GoToFullAnimalDetails {
        void onAnimalClick(NameAndImageModel animalModel);

        void onItemDelete(int position);

        void onItemAdd(int position);
    }
}
