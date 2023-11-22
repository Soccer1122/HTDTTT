package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Controller;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.*;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.BenhRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDien;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienLui;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienTien;


import java.util.*;


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

    private static Set<String> SuyDienTien(List<LuatSuyDien> rules, Set<String> facts){
        int currentLengthOfFaces = 0;
        int afterLengthOfFaces = 0;

        do {
            currentLengthOfFaces=facts.size();
            for(LuatSuyDien i : rules){
                if(facts.containsAll(i.getVeTrai()) && !facts.containsAll(i.getVePhai())){
                    for (String factInRight : i.getVePhai()){
                        facts.add(factInRight);
                    }
                    break;
                }
            }
            afterLengthOfFaces = facts.size();
            System.out.println(afterLengthOfFaces+" "+currentLengthOfFaces);
        }while (afterLengthOfFaces>currentLengthOfFaces);
        return facts;
    }

    public static List<TrieuChung> HoiTruocSuyDien(List<TrieuChung> trieuChungs , String name, Scanner sc){
        List<TrieuChung> trieuChungEmBeGap = new ArrayList<>();
        List<TrieuChung> trieuChungHoi = new ArrayList<>();
        trieuChungHoi.add(new TrieuChung("S40","Sốt"));
        trieuChungHoi.add(new TrieuChung("S50","Ho"));
        trieuChungHoi.add(trieuChungs.get(6));
        trieuChungHoi.add(trieuChungs.get(7));
            while (true) {
                if (trieuChungEmBeGap.size() == 4) {
                    break;
                }

                if (trieuChungEmBeGap.isEmpty()) {
                    System.out.println("-->Hệ thống: Bé nhà " + name + " có triệu chứng nào ở dưới đây không (Nhập số thứ tự của triệu chứng để chọn. Có thể lựa chọn nhiều)");
                } else {
                    System.out.println("-->Hệ thống: Bé nhà " + name + " có triệu chứng nào nữa ở dưới đây không (Nhập số thứ tự của triệu chứng để chọn. Có thể lựa chọn nhiều)");
                }

                int count = 1;
                for (TrieuChung i : trieuChungHoi) {
                    if (!trieuChungEmBeGap.contains(i)) {
                        System.out.println(count + ". " + i.getTrieuChung() + "\n");
                    }
                    count++;
                }

                System.out.println("0. Tôi không có triệu chứng nào ở trên\n -------------Câu trả lời của bạn--------------");
                System.out.print("-->" + name + ": Câu trả lời của tôi là: " );
                try{
                    String answer = sc.nextLine().trim();
                    if (answer.equals("0")) {
                        break;
                    } else if(Integer.parseInt(answer)>0 &&Integer.parseInt(answer)<=count){
                        if(answer.equals("1") && !trieuChungEmBeGap.contains(trieuChungs.get(0)) && !trieuChungEmBeGap.contains(trieuChungs.get(1))){
                            trieuChungEmBeGap.add(trieuChungs.get(0));
                            trieuChungHoi.remove(0);
                        }else if(answer.equals("1") && !trieuChungEmBeGap.contains(trieuChungs.get(2)) && !trieuChungEmBeGap.contains(trieuChungs.get(3)) && (trieuChungEmBeGap.contains(trieuChungs.get(0)) || trieuChungEmBeGap.contains(trieuChungs.get(1)))){
                            trieuChungEmBeGap.add(trieuChungs.get(2));
                            trieuChungHoi.remove(0);
                        }else if((answer.equals("2") && !trieuChungEmBeGap.contains(trieuChungs.get(0)) && !trieuChungEmBeGap.contains(trieuChungs.get(1)) && !trieuChungEmBeGap.contains(trieuChungs.get(2)) && !trieuChungEmBeGap.contains(trieuChungs.get(3)))){
                            trieuChungEmBeGap.add(trieuChungs.get(2));
                            trieuChungHoi.remove(1);
                        }else {
                            System.out.println("Chon nhu bth");
                            trieuChungEmBeGap.add(trieuChungHoi.get(Integer.parseInt(answer)-1));
                        }
                    }else{
                        System.out.println("-->Hệ thống: Vui lòng nhập 1 số từ 0 tới "+count+1);
                        continue;
                    }
                }catch (Exception e){
                    System.out.println("-->Hệ thống: Vui lòng nhập 1 số từ 0 tới "+count+1);
                }
                System.out.print("-->Hệ thống: Danh sách mã các triệu chứng bé đang mắc: ");
                System.out.println(trieuChungEmBeGap);
            }
    return trieuChungEmBeGap;
    }
    public static List<Benh> SuDungSuyDienTien ( List<LuatSuyDienTien> luatSuyDienTiens, List<TrieuChung> trieuChungs,BenhRepository benhRepository){
        List<LuatSuyDien> luatSuyDiens = new ArrayList<>();
        Set<String> facts = new HashSet<>();
        for(LuatSuyDienTien i : luatSuyDienTiens){
            List<String> veTrai =new ArrayList<>();
            veTrai.add(i.getTrieuChung().getTrieuChung());
            List<String> vePhai =new ArrayList<>();
            for (Benh j : i.getBenhList()){
                vePhai.add(j.getId());
            }
            luatSuyDiens.add(new LuatSuyDien(veTrai,vePhai));
        }
        for(TrieuChung i : trieuChungs){
            facts.add(i.getId());
        }
        Set<String> idBenhs = SuyDienTien(luatSuyDiens,facts);
        List<Benh> benhs = benhRepository.findAllById(idBenhs);
        return benhs;
    }
}
