package com.jatinsinghroha.volleyapicalls;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVDistrictsAdapter extends RecyclerView.Adapter<RVDistrictsAdapter.ViewHolder> {
    private List<DistrictItem> mDistrictItemList;

    public RVDistrictsAdapter(List<DistrictItem> districtItemList){
        mDistrictItemList = districtItemList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_district_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        DistrictItem district = mDistrictItemList.get(position);

        holder.districtIDTV.setText(district.getDistrict_id()+"");
        holder.districtNameTV.setText(district.getDistrict_name());

        Log.e("itemDrawn", "Item - "+position);

    }

    @Override
    public int getItemCount() {
        return mDistrictItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView districtIDTV, districtNameTV;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            districtIDTV = itemView.findViewById(R.id.districtIDTV);
            districtNameTV = itemView.findViewById(R.id.districtNameTV);

        }
    }
}
