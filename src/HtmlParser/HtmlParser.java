package HtmlParser;

import Model.StudentInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlParser {
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static StudentInfo parseStudentInfo(String html) {
        StudentInfo studentInfo = new StudentInfo();
        Element infotable = Jsoup.parse(html).select("table#tblView").get(0);
        try {
            String loginName = infotable.select("tr").get(0).select("td").get(1).text();
            String password = "";
            String name = infotable.select("tr").get(0).select("td").get(3).text();
            Date birthDate = DATE_FORMAT.parse(infotable.select("tr").get(6).select("td").get(3).text());
            String sex = infotable.select("tr").get(3).select("td").get(1).text();
            String province =infotable.select("tr").get(7).select("td").get(3).text();
            String classId=infotable.select("tr").get(14).select("td").get(3).text();
            String major=infotable.select("tr").get(13).select("td").get(1).text();
            String nation=infotable.select("tr").get(5).select("td").get(3).text();
            studentInfo.setLoginName(loginName);
            studentInfo.setPassword(password);
            studentInfo.setName(name);
            studentInfo.setBirthDate(birthDate);
            studentInfo.setSex(sex);
            studentInfo.setProvince(province);
            studentInfo.setClassId(classId);
            studentInfo.setMajor(major);
            studentInfo.setName(nation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return studentInfo;
    }
//    public static StudentScore parseScore(String html){
//        return null;
//    }
}
