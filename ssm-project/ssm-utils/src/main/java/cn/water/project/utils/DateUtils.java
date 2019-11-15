package cn.water.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Water
 * @date 2019/11/1 - 16:50
 * @description
 */
public class DateUtils {

    /* 日期转换成字符串 */
    public static String date_string (Date date,String patten){
        return new SimpleDateFormat(patten).format(date);
    }

    /* 字符串转换成日期 */
    public static Date string_date (String string) throws ParseException {
        return new SimpleDateFormat().parse(string);

    }

}
