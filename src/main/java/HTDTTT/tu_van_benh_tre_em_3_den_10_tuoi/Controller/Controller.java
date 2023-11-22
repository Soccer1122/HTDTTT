package HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Controller;

import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Entity.*;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.Repository.BenhRepository;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDien;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienLui;
import HTDTTT.tu_van_benh_tre_em_3_den_10_tuoi.subClass.LuatSuyDienTien;


import java.sql.SQLOutput;
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
    private static Set<TrieuChung> getTrieuChungCuaMotBenh(String idBenh , List<LuatSuyDienLui> luatSuyDienLuis){
        Set<TrieuChung> trieuChungs = new HashSet<>();
        for (LuatSuyDienLui i : luatSuyDienLuis){
            if(i.getBenh().getId().trim().equalsIgnoreCase(idBenh.trim())){
                trieuChungs.addAll(i.getTrieuChungList());
            }
        }
        return trieuChungs;
    }
    ///////////////////////////////////////////////////////////////////////////

    private static Set<String> suyDienTien(List<LuatSuyDien> rules, Set<String> facts){
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
        }while (afterLengthOfFaces>currentLengthOfFaces);
        return facts;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static boolean suyDienLuiDungDeChuanDoanBenh(List<LuatSuyDienLui> luatSuyDienLuis, Benh benhDuDoan, List<TrieuChung> trieuChung){
        List<LuatSuyDien> luatSuyDiens = new ArrayList<>();
        Set<String> facts = new HashSet<>();
        Stack<String> goal = new Stack<>();
        goal.push(benhDuDoan.getId());
        for(LuatSuyDienLui i : luatSuyDienLuis){
            List<String> vePhai =new ArrayList<>();
            vePhai.add(i.getBenh().getId());
            List<String> veTrai =new ArrayList<>();
            for (TrieuChung j : i.getTrieuChungList()){
                veTrai.add(j.getId());
            }
            luatSuyDiens.add(new LuatSuyDien(veTrai,vePhai));
        }
        for(TrieuChung i : trieuChung){
            facts.add(i.getId());
        }
        return suyDienLui(luatSuyDiens,facts,goal,new Stack<>());
    }
    ///////////////////////////////////////////////////////////////////////////
    private static boolean suyDienLui(List<LuatSuyDien> rules, Set<String> facts, Stack<String> goal , Stack<String> isCheck){
        while (true){
            int check = 0;
            if(facts.contains(goal.peek())){
                goal.pop();
                check=1;
            }
            if(goal.isEmpty()){
                return true;
            }
            for(LuatSuyDien i : rules){
                if(i.getVePhai().contains(goal.peek())&& isCheck.search(goal.peek())==-1){
                    isCheck.push(goal.peek());
                    goal.pop();
                    for (String y : i.getVeTrai()){
                        goal.push(y);
                    }
                    check=1;
                    break;
                }
            }
            if (check==0){
                return false;
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////

    public static List<TrieuChung> hoiTruocSuyDien(List<TrieuChung> trieuChungs , String name, Scanner sc){
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

                int count = -1;
                for (TrieuChung i : trieuChungHoi) {
                    if (!trieuChungEmBeGap.contains(i)) {
                        System.out.println("\t"+(count+2) + ". " + i.getTrieuChung() + "\n");
                    }
                    count++;
                }

                System.out.println("\t0. Con tôi không có triệu chứng nào ở trên\n -------------Câu trả lời của bạn--------------");
                System.out.print("-->" + name + ": Câu trả lời của tôi là: " );
                try{
                    String answer = sc.nextLine().trim();
                    if (answer.equals("0")) {
                        break;
                    } else if(Integer.parseInt(answer)>0 &&Integer.parseInt(answer)<=count+2){
                        if(answer.equals("1") && !trieuChungEmBeGap.contains(trieuChungs.get(0)) && !trieuChungEmBeGap.contains(trieuChungs.get(1))){
                            System.out.println("-->Hệ thống: Tôi muốn biết thêm về tình trạng sốt của bé nên bạn hãy trả lời câu hỏi sau: \n" +
                                    "\t\tTình trạng sốt của bé như thế nào?");
                            System.out.println("\t1. Sốt cao kéo dài, sốt đột ngột");
                            System.out.println("\t2. Sốt nhẹ");
                            while (true){
                                try{
                                    String answer1 = sc.nextLine().trim();
                                    if(answer1.equals("1")){
                                        trieuChungEmBeGap.add(trieuChungs.get(0));
                                        break;
                                    }else if(answer1.equals("2")){
                                        trieuChungEmBeGap.add(trieuChungs.get(0));
                                        break;
                                    }else {
                                        System.out.println("-->Hệ thống: Vui lòng chỉ nhập 1 hoặc 2");
                                    }
                                }catch (Exception e){
                                    System.out.println("-->Hệ thống: Vui lòng chỉ nhập 1 hoặc 2");
                                }
                            }
                            trieuChungHoi.remove(0);
                        }else if(answer.equals("1") && !trieuChungEmBeGap.contains(trieuChungs.get(2)) && !trieuChungEmBeGap.contains(trieuChungs.get(3)) && (trieuChungEmBeGap.contains(trieuChungs.get(0)) || trieuChungEmBeGap.contains(trieuChungs.get(1)))){
                            System.out.println("-->Hệ thống: Tôi muốn biết thêm về tình trạng ho của bé nên bạn hãy trả lời câu hỏi sau: \n" +
                                    "\t\tTình trạng sốt của bé như thế nào?");
                            System.out.println("\t1. Ho kéo dài, lâu ngày, ho nhiều về đêm");
                            System.out.println("\t2. Ho khan hay ho có đờm");
                            while (true){
                                try{
                                    String answer1 = sc.nextLine().trim();
                                    if(answer1.equals("1")){
                                        trieuChungEmBeGap.add(trieuChungs.get(2));
                                        break;
                                    }else if(answer1.equals("2")){
                                        trieuChungEmBeGap.add(trieuChungs.get(3));
                                        break;
                                    }else {
                                        System.out.println("-->Hệ thống: Vui lòng chỉ nhập 1 hoặc 2");
                                    }
                                }catch (Exception e){
                                    System.out.println("-->Hệ thống: Vui lòng chỉ nhập 1 hoặc 2");
                                }
                            }
                            trieuChungHoi.remove(0);
                        }else if((answer.equals("2") && !trieuChungEmBeGap.contains(trieuChungs.get(0)) && !trieuChungEmBeGap.contains(trieuChungs.get(1)) && !trieuChungEmBeGap.contains(trieuChungs.get(2)) && !trieuChungEmBeGap.contains(trieuChungs.get(3)))){
                            trieuChungEmBeGap.add(trieuChungs.get(2));
                            trieuChungHoi.remove(1);
                        }else {
                            trieuChungEmBeGap.add(trieuChungHoi.get(Integer.parseInt(answer)-1));
                            trieuChungHoi.remove(Integer.parseInt(answer)-1);
                        }
                    }else{
                        System.out.println("-->Hệ thống: Vui lòng nhập 1 số từ 0 tới "+(count+1));
                        continue;
                    }
                }catch (Exception e){
                    System.out.println("-->Hệ thống: Vui lòng nhập 1 số từ 0 tới "+(count+1));
                }
                System.out.print("-->Hệ thống: Bé đang có các triệu chứng: ");
                for(TrieuChung i : trieuChungEmBeGap){
                    String output = i.getTrieuChung()+", ";
                    System.out.print(output.substring(0,output.length()-2));
                }
                System.out.println();
            }
    return trieuChungEmBeGap;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<Benh> suDungSuyDienTien ( List<LuatSuyDienTien> luatSuyDienTiens, List<TrieuChung> trieuChungs,BenhRepository benhRepository){
        List<LuatSuyDien> luatSuyDiens = new ArrayList<>();
        Set<String> facts = new HashSet<>();
        for(LuatSuyDienTien i : luatSuyDienTiens){
            List<String> veTrai =new ArrayList<>();
            veTrai.add(i.getTrieuChung().getId());
            List<String> vePhai =new ArrayList<>();
            for (Benh j : i.getBenhList()){
                vePhai.add(j.getId());
            }
            luatSuyDiens.add(new LuatSuyDien(veTrai,vePhai));
        }
        for(TrieuChung i : trieuChungs){
            facts.add(i.getId());
        }
        Set<String> idBenhs = suyDienTien(luatSuyDiens,facts);
        List<Benh> benhs = benhRepository.findAllById(idBenhs);
        return benhs;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<Benh> suDungSuyDienLui(List<LuatSuyDienLui> luatSuyDienLuis, List<Benh> benhDuDoan, List<TrieuChung> trieuChungDaMac,Scanner sc,String name ){
        List<Benh> benhDaMac = new ArrayList<>();
        System.out.print("-->Hệ thống: Có thể bé đang mắc các bệnh sau: ");
        for(Benh i : benhDuDoan){
            String output = i.getTenBenh()+", ";
            System.out.print(output.substring(0,output.length()-2));
        }
        System.out.println();
        System.out.println("-->Hệ thống: Chúng tôi cần hỏi bạn một số câu hỏi để có được chuẩn đoán chính xác nhất");
        List<TrieuChung> trieuChungDaHoiNhungKhongMac = new ArrayList<>();
        for(Benh i : benhDuDoan){
            Set<TrieuChung> trieuChungCuaMotBenh = getTrieuChungCuaMotBenh(i.getId(),luatSuyDienLuis);
            for (TrieuChung y : trieuChungCuaMotBenh){
                if(!trieuChungDaMac.contains(y) && !trieuChungDaHoiNhungKhongMac.contains(y)){
                    while (true) {
                        System.out.println("-->Hệ thống: Bé có bị " + y.getTrieuChung() + " không?\n\t1.Có\n\t2.Không");
                        System.out.println("-------------Câu trả lời của bạn--------------");
                        System.out.print("-->" + name + ": Câu trả lời của tôi là: ");
                        String answer = sc.nextLine().trim();
                        if (answer.equals("1") || answer.equals("2")) {
                            if (answer.equals("1")) {
                                trieuChungDaMac.add(y);
                            } else {
                                trieuChungDaHoiNhungKhongMac.add(y);
                            }
                            break;
                        } else {
                            System.out.println("-->Hệ thống: Bạn vui lòng chỉ nhập 1 hoặc 2");
                        }
                    }
                }
            }
            if(suyDienLuiDungDeChuanDoanBenh(luatSuyDienLuis,i,trieuChungDaMac)){
                benhDaMac.add(i);
            }
        }
        return benhDaMac;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void inKetQuaDuDoan(List<Benh> benhDaMac){
        if(benhDaMac.isEmpty()){
            System.out.println("-->Hệ thống: Chúc mừng bạn chúng tôi chuẩn đoán bé nhà bạn hoàn toàn khỏe mạnh.\nChúc bé luôn luôn khỏe mạnh và cảm ơn bạn đã sử dụng hệ thống của chúng tôi!!!");
        }
        else{
            System.out.println("-->Hệ thống: Chúng tôi chuẩn đoán bé đã mắc bệnh sau: ");
            for(Benh i : benhDaMac){
                System.out.println("\t"+(benhDaMac.indexOf(i)+1)+". "+i.getTenBenh().trim());
                System.out.println("\t\t-Nguyên nhân có thể do: ");
                List<String> nguyenNhan= List.of(i.getNguyenNhan().split("-"));
                for(String y :nguyenNhan){
                    System.out.println("\t\t\t+ "+y.trim());
                }
            }
            System.out.println("-->Hệ thống: Cảm ơn bạn đã sử dụng hệ thống của chúng tôi!!! ");
        }
    }
}
