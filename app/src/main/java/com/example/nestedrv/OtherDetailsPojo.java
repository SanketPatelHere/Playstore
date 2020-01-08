package com.example.nestedrv;

public class OtherDetailsPojo {
    int imgDetail;
    String detailName, detailInfo;
    public OtherDetailsPojo()
    {
    }
    public OtherDetailsPojo(int imgDetail, String detailName, String detailInfo) {
        this.imgDetail = imgDetail;
        this.detailName = detailName;
        this.detailInfo = detailInfo;
    }

    public int getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(int imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }
}
