package com.tugasakhir.rido.apilkasijadwaldokter;

/**
 * Created by User on 8/3/2017.
 */

public class ModelDokter {

    String nama;
    String spesialis;
    String jadwal;
    String lokasi;
    int ImageResourceID;

    public int getImageResourceID() {
        return ImageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        ImageResourceID = imageResourceID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
