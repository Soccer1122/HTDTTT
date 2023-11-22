package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Controller.Controller;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.*;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.BenhRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.LuatRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.SuyDienRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.TrieuChungRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienLui;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienTien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;


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
		List<LuatSuyDienTien> luatSuyDienTiens= Controller.initLuatSuyDienTien(luatList);
		List<LuatSuyDienLui> luatSuyDienLuis = Controller.initLuatSuyDienLui(luatList);
        List<TrieuChung> trieuChungEmBeMac = new ArrayList<>();
		List<Benh> benhDuDoan = new ArrayList<>();
		List<Benh> benhDaMac= new ArrayList<>();
		//Thuc hien chuan doan
		//B1: Hoi ten nguoi dung
        System.out.println();
        System.out.println();
		System.out.println("Chào bạn tôi là chatbot tư vấn cho bạn các bệnh liên quan đến đường hô hấp cho trả 3-10 tuổi. Hãy cho tôi biết tên của bạn ?");
		Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập tên của bạn vào đây: ");
		String name =sc.nextLine();
		//B2: Hoi truoc suy dien de lay ra trieu chung dang bi
		trieuChungEmBeMac = Controller.hoiTruocSuyDien(trieuChungList,name,sc);
		if(trieuChungEmBeMac.isEmpty()){//Neu nguoi dung khong chon trieu chung nao thi ket thuc luon
			System.out.println("Có vẻ như bé nhà "+name+" không gặp vấn đề gì. Cảm ơn bạn đã sử dụng hệ thống của chúng tôi!!!!");
			shutdownApp(context);
		}
		//B3: Suy dien tien de chuan doan ra cac benh co the bi mac
		benhDuDoan = Controller.suDungSuyDienTien(luatSuyDienTiens,trieuChungEmBeMac,benhRepository);
		//B4: Su dung suy dien lui de chuan doan ra benh mac phai
		benhDaMac = Controller.suDungSuyDienLui(luatSuyDienLuis,benhDuDoan,trieuChungEmBeMac,sc,name);
		//B5: In ra chuan doan cho nguoi dung
		Controller.inKetQuaDuDoan(benhDaMac);
		///////////////////////////////////////ket thuc chuong trinh
		shutdownApp(context);
	}
	// Các hàm sử dụng
	private static void shutdownApp(ConfigurableApplicationContext context) {
		int exitCode = SpringApplication.exit(context, () -> 0);
		System.exit(exitCode);
	}
}
