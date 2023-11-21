package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "luat")
@AllArgsConstructor
@NoArgsConstructor
public class Luat {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "trang_thai")
    private boolean trangThai;

    @OneToMany(mappedBy = "luat",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SuyDien> suyDienList;
}
