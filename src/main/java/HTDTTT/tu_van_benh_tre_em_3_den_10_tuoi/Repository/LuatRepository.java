package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.Luat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuatRepository extends JpaRepository<Luat,String> {
}
