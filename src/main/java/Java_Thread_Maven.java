import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


    public class Java_Thread_Maven {

        public  static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

            Thread t1 = new Thread(new LoadThread("KURGANGK", "KURGANGK", "****"));
            Thread t2 = new Thread(new LoadThread("NOYABPGE", "NOYABPGE", "***"));
            Thread t3 = new Thread(new LoadThread("KURGANTC", "KURGANTC", "***"));
            Thread t4 = new Thread(new LoadThread("SALEHARD", "SALEHARD", "***"));
            Thread t5 = new Thread(new LoadThread("esvostok", "esvostok", "***","sbyt"));
            Thread t6 = new Thread(new LoadThread("SALEHARD", "SALEHARD", "***","sbyt"));
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        }
    }
    class  LoadThread extends Thread {
        String code;
        String user;
        String pw;
        String sbyt;
        public LoadThread(String code, String user, String pw) {
            this.code=code;
            this.user=user;
            this.pw=pw;
        }
        public LoadThread(String code, String user, String pw, String sbyt) {
            this.code=code;
            this.user=user;
            this.pw=pw;
            this.sbyt=sbyt;
        }
        @Override
        public void run() {
            while (true) {
                boolean start_check = false;
//            Scanner in = new Scanner(System.in);
//            System.out.print("Input a date: ");
//            String date = in.nextLine().toString();
                Date date1 = new Date();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
                String date = format1.format(date1);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, -1);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                Date result = cal.getTime();
                String date2 = format1.format(result);
                StringBuffer sb = new StringBuffer(date2);
                sb.delete(5, 7).append("01");
                String date3 = sb.toString();
                String codeR = null;
                String codeE = null;
                if (sbyt == "sbyt") {
                    codeE = "esk";
                } else {
                    if (code == "NOYABPGE") {
                        codeR = "НПГЭ";
                        codeE = "npge";
                    } else {
                        if (code == "KURGANTC") {
                            codeR = "ТЭЦ-2";
                            codeE = "tec2";
                        } else {
                            if (code == "SALEHARD") {
                                codeR = "Салехард";
                                codeE = "saleh";
                            } else {
                                if  (code == "KURGANGK")   {
                                    codeR = "КГК";
                                    codeE = "kgk";

                                }
                            }
                        }
                    }
                }
                if (sbyt == "sbyt") {
                    try {
                        start_check = load_corp_sbyt(code, user, pw, "https://www.atsenergo.ru/nreport?rname=buy_norem&rdate=", date, "U:/_ot/" + codeE + "/", "current", date3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=INVOICE_INFORMATION&rdate=", date, "U:/Отчеты по обязательствам и платежам/Сводная СФ/" + codeR + "/", "current", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=CFR_PART_SF_OVERALL_INVOICE_LAYOUT&rdate=", date, "U:/Отчеты по обязательствам и платежам/Сводная СФ/" + codeR + "/", "current", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=CFR_PART_CONSOLIDATED_INVOICE_XML_TMPL&rdate=", date, "U:/Отчеты по обязательствам и платежам/Сводная СФ/" + codeR + "/", "current", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=CFR_PART_OVERALL_INVOICE_LAYOUT&rdate=", date, "U:/Отчеты по обязательствам и платежам/Сводная СФ/" + codeR + "/", "current", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=INVOICE_PERFORMANCE&rdate=", date, "U:/Отчеты по обязательствам и платежам/Сводная СФ/" + codeR + "/", "current", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=INVOICE_INFORMATION&rdate=", date, "U:/Отчеты по обязательствам и платежам/Сводная СФ/" + codeR + "/", "current", date3);

                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=power_consumer_3_fact&rdate=", date, "U:/МОЩНОСТЬ/Покупка продажа мощности 2021/", "first", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=power_consumer_2_maxh&rdate=", date, "U:/МОЩНОСТЬ/Покупка продажа мощности 2021/", "first", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=power_consumer_4_buy_sell&rdate=", date, "U:/МОЩНОСТЬ/Покупка продажа мощности 2021/", "first", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=rsv_deal_vsvgo&rdate=", date, "U:/ВСВГО/Оплата пусков/" + codeR + "/", "first", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=energy_comissioner_cfr&rdate=", date, "U:/Отчеты по обязательствам и платежам/Отчет комиссионера/" + codeR + "/", "first", date3);
                        load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=buy_norem&rdate=", date, "U:/_ot/" + codeE + "/", "current", date3);
                        start_check = load_corp(code, user, pw, "https://www.atsenergo.ru/nreport?rname=sell_norem&rdate=", date, "U:/_ot/" + codeE + "/", "current", date3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (start_check == true) ;
                try {
                    System.out.println(code+" sleep"+currentThread().getName());
                    sleep(1000*60*60*4);
//                sleep(1);
                    System.out.println(code+" wake up");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        static synchronized void searchFile(File rootFile, List<File> fileList){
            if (rootFile.isDirectory()) {
                File[] directoryFiles = rootFile.listFiles();
                if (directoryFiles != null) {
                    for (File file : directoryFiles) {
                        if ((file.getName().toLowerCase().endsWith(".xls")) || (file.getName().toLowerCase().endsWith(".xlsx"))) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
        static  synchronized  boolean load_corp_sbyt(String code, String user, String pw, String link, String date, String path, String
                dateAttribute, String date_f) throws IOException, InterruptedException {
            String dateMethod;
            if (dateAttribute == "current") {
                dateMethod = date;
            } else {
                dateMethod = date_f;
            }
            CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);
            boolean start = false;
            Set<String> set_name_file = new HashSet<>();
            Set<String> set_name_GTPp = new HashSet<>();
            set_name_GTPp.add("PKURGANE");
            set_name_GTPp.add("PORENSL1");
            set_name_GTPp.add("PORENSL2");
            set_name_GTPp.add("PORENSL3");
            set_name_GTPp.add("PORENSL4");
            set_name_GTPp.add("PORENSL5");
            set_name_GTPp.add("PSEVKOM1");
            set_name_GTPp.add("PTUMREG1");
            set_name_GTPp.add("PTUMREG2");
            set_name_GTPp.add("PTUMREG3");
            set_name_GTPp.add("PTUMREG4");
            set_name_GTPp.add("PTUMREG5");
            set_name_GTPp.add("PSALEHA1");
            ArrayList<File> fileList = new ArrayList<>();
            searchFile(new File(path), fileList);
            for (File file : fileList) {
                set_name_file.add(file.getName());
            }
//        CookieHandler.setDefault(cookieManager);
            URL url = new URL("https://www.atsenergo.ru/nauth/nreports?partcode=" + code + "&username=" + user + "&password=" + pw);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            Document doc = Jsoup.connect(link + dateMethod).get();
            Elements elements = doc.getElementsByAttributeValue("class", "reports_files");
            Element element = elements.get(0);
            String input1 = element.child(0).toString();
            HashMap<String, String> map_name_ref_complete = new HashMap<>(pars_Name_ref(input1));
            for (Map.Entry<String, String> map : map_name_ref_complete.entrySet()) {
                for (String set:set_name_GTPp) {
                    if (map.getKey().contains(set)) {
                        url = new URL("https://www.atsenergo.ru/nreport" + map.getValue() + "&region=eur");
                        con = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = url.openStream();
                        if (set_name_file.size()==0) {
                            Files.copy(inputStream, new File(path + map.getKey()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            start = true;
                        }
                        else {
                            if (set_name_file.contains(map.getKey()) == false) {
                                Files.copy(inputStream, new File(path + map.getKey()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                                start = true;
                            }
                        }
                    }
                }
            }
            return start;
        }
        static  synchronized  boolean load_corp(String code, String user, String pw, String link, String date, String path, String
                dateAttribute, String date_f) throws IOException, InterruptedException {
            String dateMethod;
            if (dateAttribute == "current") {
                dateMethod = date;
            } else {
                dateMethod = date_f;
            }
            CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);
            boolean start = false;
            Set<String> set_name_file = new HashSet<>();
            ArrayList<File> fileList = new ArrayList<>();
            searchFile(new File(path), fileList);
            for (File file : fileList) {
                set_name_file.add(file.getName());
            }
//                    CookieHandler.setDefault(cookieManager);
            URL url = new URL("https://www.atsenergo.ru/nauth/nreports?partcode=" + code + "&username=" + user + "&password=" + pw);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            Document doc = Jsoup.connect(link + dateMethod).get();
            Elements elements = doc.getElementsByAttributeValue("class", "reports_files");
            Element element = elements.get(0);
            String input1 = element.child(0).toString();
            HashMap<String, String> map_name_ref_complete = new HashMap<>(pars_Name_ref(input1));
            for (Map.Entry<String, String> map : map_name_ref_complete.entrySet()) {
                url = new URL("https://www.atsenergo.ru/nreport" + map.getValue() + "&region=eur");
                con = (HttpURLConnection) url.openConnection();
                InputStream inputStream = url.openStream();
                if (set_name_file.size()==0) {
                    Files.copy(inputStream, new File(path + map.getKey()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    start = true;
                }
                else {
                    if (set_name_file.contains(map.getKey()) == false) {
                        Files.copy(inputStream, new File(path + map.getKey()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        start = true;
                    }
                }
            }
            return start;
        }
        static synchronized Map<String, String> pars_Name_ref (String s_m){
            HashMap<String, String> map_name_ref = new HashMap<>();
            List<String> list_text = new ArrayList<>();
            Pattern pattern = Pattern.compile("href.+?xlsx?");
            Matcher matcher1 = pattern.matcher(s_m);
            while (matcher1.find()) {
                int start = matcher1.start();
                int stop = matcher1.end();
                list_text.add(s_m.substring(start, stop));
            }
            for (int i = 0; i < list_text.size(); i++) {
                String ref;
                String nameFile;
                String ss = list_text.get(i);
                Pattern pattern_ref = Pattern.compile("href.+?&");
                Pattern pattern_name = Pattern.compile("eur\">.+?xlsx?");
                Matcher matcher_ref = pattern_ref.matcher(ss);
                Matcher matcher_name = pattern_name.matcher(ss);
                while ((matcher_ref.find()) & (matcher_name.find())) {
                    int start = matcher_ref.start();
                    int stop = matcher_ref.end();
                    ref = ss.substring(start + 6, stop - 1);
                    start = matcher_name.start();
                    stop = matcher_name.end();
                    nameFile = ss.substring(start + 5, stop);
                    map_name_ref.put(nameFile, ref);
                }
            }
            Pattern pattern_zip = Pattern.compile("href.+?zip");
            Matcher matcher1_zip = pattern_zip.matcher(s_m);
            while (matcher1_zip.find()) {
                int start_zip = matcher1_zip.start();
                int stop_zip = matcher1_zip.end();
                list_text.add(s_m.substring(start_zip, stop_zip));
            }
            for (int i = 0; i < list_text.size(); i++) {
                String ref_zip;
                String nameFile_zip;
                String ss = list_text.get(i);
                Pattern pattern_ref_zip = Pattern.compile("href.+?&");
                Pattern pattern_name_zip = Pattern.compile("eur\">.+?zip");
                Matcher matcher_ref_zip = pattern_ref_zip.matcher(ss);
                Matcher matcher_name_zip = pattern_name_zip.matcher(ss);
                while ((matcher_ref_zip.find()) & (matcher_name_zip.find())) {
                    int start_zip = matcher_ref_zip.start();
                    int stop_zip = matcher_ref_zip.end();
                    ref_zip = ss.substring(start_zip + 6, stop_zip - 1);
                    start_zip = matcher_name_zip.start();
                    stop_zip = matcher_name_zip.end();
                    nameFile_zip = ss.substring(start_zip + 5, stop_zip);
                    map_name_ref.put(nameFile_zip, ref_zip);
                }
            }
            return map_name_ref;
        }
    }