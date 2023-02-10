package model;

public class Sach {
    private String id;
    private String tenSach;
    private float giaBan;
    private int namXuatBan;

    public Sach(String id, String tenSach, float giaBan, int namXuatBan) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.namXuatBan = namXuatBan;
    }

    public Sach() {
    }

    public String getId() {
        return id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id='" + id + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", giaBan=" + giaBan +
                ", namXuatBan=" + namXuatBan +
                '}';
    }
}
