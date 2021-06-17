package com.jatinsinghroha.volleyapicalls.trash;

public class DistrictWithImageItem {

    private int district_id;
    private String district_name, imageUrl;

    public DistrictWithImageItem(int district_id, String district_name, String imageUrl) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.imageUrl = imageUrl;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
