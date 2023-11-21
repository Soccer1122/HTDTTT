package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.Benh;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.TrieuChung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LuatSuyDienTien {
    private String id;
    private TrieuChung trieuChung;
    private List<Benh> benhList;
}
