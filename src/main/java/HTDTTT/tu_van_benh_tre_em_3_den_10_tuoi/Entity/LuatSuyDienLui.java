package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LuatSuyDienLui {
    private String id;
    private List<TrieuChung> trieuChungList;
    private Benh benh;
}
