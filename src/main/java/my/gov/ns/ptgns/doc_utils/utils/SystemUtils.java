package my.gov.ns.ptgns.doc_utils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SystemUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUtils.class);

    // DATE TIME UTILS
    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.forLanguageTag("ms-My"));
        return simpleDateFormat.format(date);
    }

    public static String formatDateMonthYear(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy", Locale.forLanguageTag("ms-My"));
        return simpleDateFormat.format(date);
    }

    public static String formatDateYear(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy", Locale.forLanguageTag("ms-My"));
        return simpleDateFormat.format(date);
    }

    // OUTPUT -> 27 Ogos 2021 05:19:07 PM
    public static String formatStrDatetime(String strDatetime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy hh:mm:ss a", Locale.forLanguageTag("ms-My"));
            return simpleDateFormat.format(dateFormat.parse(strDatetime));
        } catch (ParseException | NullPointerException e) {
            LOGGER.info("Cannot parse date.");
            return strDatetime;
        }
    }

    // OUTPUT -> 27 Ogos 2021
    public static String formatStrDatetimeToDate(String strDatetime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.forLanguageTag("ms-My"));
            return simpleDateFormat.format(dateFormat.parse(strDatetime));
        } catch (ParseException | NullPointerException e) {
            LOGGER.info("Cannot parse date.");
            return strDatetime;
        }
    }

    // OUTPUT -> 05:19:07 PM
    public static String formatStrDatetimeToTime(String strDatetime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a", Locale.forLanguageTag("ms-My"));
            return simpleDateFormat.format(dateFormat.parse(strDatetime));
        } catch (ParseException | NullPointerException e) {
            LOGGER.info("Cannot parse date.");
            return strDatetime;
        }
    }

    public static String formatStrDatetimeCustom(String strDatetime, String customStrDatetimeFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(customStrDatetimeFormat);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.forLanguageTag("ms-My"));
            return simpleDateFormat.format(dateFormat.parse(strDatetime));
        } catch (ParseException | NullPointerException e) {
            LOGGER.info("Cannot parse date.");
            return strDatetime;
        }
    }

    public static String formatCurrency(Double amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("ms-My"));
        return numberFormat.format(amount);
    }


}
