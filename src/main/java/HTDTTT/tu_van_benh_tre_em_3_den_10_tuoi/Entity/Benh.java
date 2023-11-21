package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "benh")
public class Benh {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ten_benh")
    private String tenBenh;

    @Column(name = "nguyen_nhan")
    private String nguyenNhan;

    @Column(name = "cach_dieu_tri")
    private String cachDieuTri;

    @Column(name = "loi_khuyen")
    private String loiKhuyen;
}
