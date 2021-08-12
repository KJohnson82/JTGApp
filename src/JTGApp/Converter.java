package JTGApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Converter {

    //protected static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy", Locale.US);
    protected static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yy", Locale.US);
    protected static String convertAnswer;
    protected static String answer = null;
    protected static String result = null;

    public Converter() {
        convertAnswer = convertAnswer;
    }

    /* Get entered JDE Date in format '121001' *working* */
    public static String julianDate(String convertAnswer) {
        StringBuilder sb = new StringBuilder();
        LocalDate cal = LocalDate.parse(convertAnswer, dateFormat);
        answer = sb.append("1").append(Integer.toString(cal.getYear()).substring(2, 4)).append(String.format("%03d", cal.getDayOfYear())).toString();
        return answer;
        }

    /* Get the current date in the 01/01/21 format *working* */
    public static String toDate() {
        LocalDate today = LocalDate.now();
        answer = dateFormat.format(today);
        return answer;
    }

    /* Get the entered Java Date in format '01/01/21' *working* */
    public static String javaDate(String convertAnswer) {
        int year = Integer.parseInt(convertAnswer.substring(1,3));
        int day = Integer.parseInt(convertAnswer.substring(3, convertAnswer.length()));
        answer = LocalDate.ofYearDay(year, day).format(dateFormat);
        return answer;
    }

}
