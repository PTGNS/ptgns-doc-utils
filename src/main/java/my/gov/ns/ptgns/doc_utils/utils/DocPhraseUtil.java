package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontFace;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontStyle;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocPhraseUtil {

    public static void defaultPhrase(PdfPTable pdfPTable, PdfPCell pdfPCell, String text) {
        pdfPCell.setPhrase(new Phrase(text, DocFontUtil.defaultNormalFont()));
        pdfPTable.addCell(pdfPCell);
    }

    public static void defaultStrikePhrase(PdfPTable pdfPTable, PdfPCell pdfPCell, PdfFontFace pdfFontFace, int fontSize, String text) {
        pdfPCell.setPhrase(new Phrase(text, DocFontUtil.fullCustomFont(pdfFontFace, PdfFontStyle.STRIKETHRU, fontSize)));
        pdfPTable.addCell(pdfPCell);
    }

    public static void fullCustomPhrase(PdfPTable pdfPTable, PdfPCell pdfPCell, PdfFontFace pdfFontFace, PdfFontStyle pdfFontStyle, int fontSize, String text) {
        pdfPCell.setPhrase(new Phrase(text, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
    }


}
