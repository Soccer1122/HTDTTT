package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "trieu_chung")
public class TrieuChung {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "trieu_chung")
    private String trieuChung;
}
