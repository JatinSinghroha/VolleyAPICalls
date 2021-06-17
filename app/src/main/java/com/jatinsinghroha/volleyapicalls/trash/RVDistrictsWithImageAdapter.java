package com.jatinsinghroha.volleyapicalls.trash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jatinsinghroha.volleyapicalls.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVDistrictsWithImageAdapter extends RecyclerView.Adapter<RVDistrictsWithImageAdapter.ViewHolder> {

    private List<DistrictWithImageItem> mDistrictWithImageItemList;

    public RVDistrictsWithImageAdapter(List<DistrictWithImageItem> districtWithImageItemList){
        this.mDistrictWithImageItemList = districtWithImageItemList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_district_image_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        DistrictWithImageItem districtWithImageItem = mDistrictWithImageItemList.get(position);

        holder.districtIDTV.setText(districtWithImageItem.getDistrict_id() + "");
        holder.districtNameTV.setText(districtWithImageItem.getDistrict_name());

        Glide
                .with(holder.animalImageIV)
                .load(districtWithImageItem.getImageUrl())
                .circleCrop()
                .placeholder(R.drawable.ic_baseline_download_24)
                .into(holder.animalImageIV);

    }

    @Override
    public int getItemCount() {
        return mDistrictWithImageItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView districtIDTV, districtNameTV;
        ImageView animalImageIV;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            districtIDTV = itemView.findViewById(R.id.districtIDTV);
            districtNameTV = itemView.findViewById(R.id.districtNameTV);
            animalImageIV = itemView.findViewById(R.id.animalImageIV);
        }
    }
}
