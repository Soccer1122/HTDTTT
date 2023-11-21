package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "suy_dien")
public class SuyDien {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "luat_id")
    private Luat luat;

    @ManyToOne
    @JoinColumn(name = "trieu_chung_id")
    private TrieuChung trieuChung;

    @ManyToOne
    @JoinColumn(name = "benh_id")
    private Benh benh;
}
