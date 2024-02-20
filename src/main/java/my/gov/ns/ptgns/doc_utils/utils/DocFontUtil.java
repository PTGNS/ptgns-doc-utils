package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontFace;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontStyle;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocFontUtil {

    public static int defaultFontSize() {
        int pdfFontSize = Integer.valueOf(System.getProperty("pdfFontSize"));
        return pdfFontSize;
    }

    public static Font defaultNormalFont() {
        String pdfFont = System.getProperty("pdfFont");
        String pdfFontStyle = System.getProperty("pdfFontStyle");
        Font font = FontFactory.getFont(PdfFontFace.valueOf(pdfFont).getName());
        font.setSize(defaultFontSize());
        font.setStyle(Font.getStyleValue(pdfFontStyle));
        return font;
    }

    public static Font defaultNormalFont(int fontsize) {
        String pdfFont = System.getProperty("pdfFont");
        String pdfFontStyle = System.getProperty("pdfFontStyle");
        Font font = FontFactory.getFont(PdfFontFace.valueOf(pdfFont).getName());
        font.setSize(fontsize);
        font.setStyle(Font.getStyleValue(pdfFontStyle));
        return font;
    }

    public static Font defaultBoldFont() {
        String pdfFont = System.getProperty("pdfFont");
        Font font = FontFactory.getFont(PdfFontFace.valueOf(pdfFont).getName());
        font.setSize(defaultFontSize());
        font.setStyle(Font.BOLD);
        return font;
    }

    public static Font defaultBoldFont(int fontSize) {
        String pdfFont = System.getProperty("pdfFont");
        Font font = FontFactory.getFont(PdfFontFace.valueOf(pdfFont).getName());
        font.setSize(fontSize);
        font.setStyle(Font.BOLD);
        return font;
    }

    public static Font fullCustomFont(PdfFontFace pdfFontFace, PdfFontStyle pdfFontStyle, int fontSize) {
        Font font = FontFactory.getFont(pdfFontFace.getName());
        font.setStyle(pdfFontStyle.getId());
        font.setSize(fontSize);
        return font;
    }
}
