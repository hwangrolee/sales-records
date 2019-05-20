package com.hwangrolee.SalesRecords.lib;

public class Regex {

    /**
     * yyyy-MM-dd HH:mm:ss 검증
     * @param dateTime
     * @return
     */
    public static boolean checkDateTime(String dateTime) {
        return dateTime.matches("\\d{4}-[0-1]\\d-[0-3]\\d [0-2]\\d:[0-5]\\d:[0-5]\\d");
    }

    /**
     * yyyy-MM-dd 검증
     * @param date
     * @return
     */
    public static boolean checkDate(String date) {
        return date.matches("\\d{4}-[0-1]\\d-[0-3]\\d");
    }



    /**
     * HH:mm:ss 검증
     * @param time
     * @return
     */
    public static boolean checkTime(String time) {
        return time.matches("[0-2]\\d:[0-5]\\d:[0-5]\\d");
    }

//    public static boolean checkTime(String time) {
//        return ""
//    }
}
