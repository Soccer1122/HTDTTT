package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LuatSuyDien {
    private List<String> veTrai;
    private List<String> vePhai;
}
