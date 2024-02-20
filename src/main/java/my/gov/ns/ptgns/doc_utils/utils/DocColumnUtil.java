package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocColumnUtil {

    public static void generateColumn(PdfContentByte canvas,int element, Font font, Float startX, Float startY, Float lineGap, String... placeholders ) throws DocumentException {
        for (String placeholder : placeholders) {
            ColumnText.showTextAligned(canvas, element, new Phrase(placeholder, font), startX, startY, 0);
            startY = startY - lineGap;
        }
    }

}