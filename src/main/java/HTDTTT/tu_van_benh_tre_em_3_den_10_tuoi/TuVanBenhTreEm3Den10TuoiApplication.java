package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.*;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.BenhRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.LuatRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.SuyDienRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.TrieuChungRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class TuVanBenhTreEm3Den10TuoiApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TuVanBenhTreEm3Den10TuoiApplication.class, args);
		BenhRepository benhRepository = context.getBean(BenhRepository.class);
		LuatRepository luatRepository = context.getBean(LuatRepository.class);
		SuyDienRepository suyDienRepository = context.getBean(SuyDienRepository.class);
		TrieuChungRepository trieuChungRepository = context.getBean(TrieuChungRepository.class);
		//khoi tao lay du lieu
		List<Benh> benhList = benhRepository.findAll();
		List<Luat> luatList = luatRepository.findAll();
		List<SuyDien> suyDienList = suyDienRepository.findAll();
		List<TrieuChung> trieuChungList = trieuChungRepository.findAll();
		List<LuatSuyDienTien> luatSuyDienTiens= initLuatSuyDienTien(luatList);
		List<LuatSuyDienLui> luatSuyDienLuis = initLuatSuyDienLui(luatList);
		//
		//
		System.out.println("hello");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(luatSuyDienLuis);
		shutdownApp(context);
	}
	// Các hàm sử dụng
	private static void shutdownApp(ConfigurableApplicationContext context) {
		int exitCode = SpringApplication.exit(context, () -> 0);
		System.exit(exitCode);
	}

	private static List<LuatSuyDienTien> initLuatSuyDienTien( List<Luat> luatList){
		List<LuatSuyDienTien> luatSuyDienTiens = new ArrayList<>();
		for(Luat i : luatList){
			if(i.isTrangThai()) {
				LuatSuyDienTien luatSuyDienTien = new LuatSuyDienTien();
				luatSuyDienTien.setId(i.getId());
				luatSuyDienTien.setTrieuChung(i.getSuyDienList().get(0).getTrieuChung());
				List<Benh> benhs = new ArrayList<>();
				for (SuyDien y : i.getSuyDienList()) {
					benhs.add(y.getBenh());
				}
				luatSuyDienTien.setBenhList(benhs);
				luatSuyDienTiens.add(luatSuyDienTien);
			}
		}
		return luatSuyDienTiens;
	}
	private static List<LuatSuyDienLui> initLuatSuyDienLui( List<Luat> luatList){
		List<LuatSuyDienLui> luatSuyDienLuis = new ArrayList<>();
		for(Luat i : luatList){
			if(!i.isTrangThai()) {
				LuatSuyDienLui luatSuyDienLui = new LuatSuyDienLui();
				luatSuyDienLui.setId(i.getId());
				luatSuyDienLui.setBenh(i.getSuyDienList().get(0).getBenh());
				List<TrieuChung> trieuChungs = new ArrayList<>();
				for (SuyDien y : i.getSuyDienList()) {
					trieuChungs.add(y.getTrieuChung());
				}
				luatSuyDienLui.setTrieuChungList(trieuChungs);
				luatSuyDienLuis.add(luatSuyDienLui);
			}
		}
		return luatSuyDienLuis;
	}
}
