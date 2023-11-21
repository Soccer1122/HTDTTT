package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Controller;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.*;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDien;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienLui;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienTien;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {
    public static List<LuatSuyDienTien> initLuatSuyDienTien(List<Luat> luatList){
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
    ///////////////////////////////////////////////////////////////////////////
    public static List<LuatSuyDienLui> initLuatSuyDienLui(List<Luat> luatList){
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
    ///////////////////////////////////////////////////////////////////////////

    public static Set<String> SuyDienTien(List<LuatSuyDien> rules, Set<String> facts){
        String filePath = "D:\\Ki 1 nam 4\\Cac he thong du tren tri thuc\\tu_van_benh_tre_em_3_den_10_tuoi\\src\\main\\java\\HTDTTT\\tu_van_benh_tre_em_3_den_10_tuoi\\bao_cao.txt";
        String content = "";

        int currentLengthOfFaces = 0;
        int afterLengthOfFaces = 0;

        do {
            currentLengthOfFaces=facts.size();
            content +="Lần lặp thứ 1: \n";
            for(LuatSuyDien i : rules){
                if(facts.containsAll(i.getVeTrai()) && !facts.containsAll(i.getVePhai())){
                    String vePhaiCanThem ="";
                    for (String factInRight : i.getVePhai()){
                        vePhaiCanThem += " "+factInRight;
                        facts.add(factInRight);
                    }
                    content = content+ "Luật R"+(rules.indexOf(i)+1)+" được áp dụng, thêm vế phải gồm:"+vePhaiCanThem+" vào facts \n";
                    break;
                }
                else if(!facts.containsAll(i.getVeTrai())){
                    List<String > factsNotInLeft = new ArrayList<>(i.getVeTrai());
                    factsNotInLeft.removeAll(facts);
                    String factsKhongCo = "";
                    for(String factNotInLeft : factsNotInLeft){
                        factsKhongCo+= " "+factNotInLeft;
                    }
                    content = content+ "Luật R"+(rules.indexOf(i)+1)+" không được áp dụng vì thiếu fact:"+factsKhongCo+"\n";
                }else {
                    content = content+ "Luật R"+(rules.indexOf(i)+1)+" không được áp dụng vì tất cả về phải đã có trong facts\n";
                }
            }
            afterLengthOfFaces = facts.size();
            System.out.println(afterLengthOfFaces+" "+currentLengthOfFaces);
        }while (afterLengthOfFaces>currentLengthOfFaces);
        content+="Thuật toán kết thúc vì không thêm được luật mới vào facts";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facts;
    }

}
