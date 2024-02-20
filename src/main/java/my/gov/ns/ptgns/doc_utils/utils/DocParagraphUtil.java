package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontFace;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontStyle;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocParagraphUtil {

    public static void spacingParagraph(Document document, Float spacingBefore, Float spacingAfter) throws DocumentException {
        Paragraph paragraph = new Paragraph("");
        paragraph.setSpacingBefore(spacingBefore);
        paragraph.setSpacingAfter(spacingAfter);
        document.add(paragraph);
    }

    public static void defaultParagraph(Document document, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.defaultNormalFont());
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
    }

    public static void defaultParagraph(Document document, int fontSize, PdfTextAlignment pdfTextAlignment, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.defaultNormalFont(fontSize));
        paragraph.setAlignment(pdfTextAlignment.getId());
        document.add(paragraph);
    }

    public static void fullCustomParagraph(Document document, PdfFontFace pdfFontFace, PdfFontStyle pdfFontStyle, int fontSize, PdfTextAlignment pdfTextAlignment, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize));
        paragraph.setAlignment(pdfTextAlignment.getId());
        document.add(paragraph);
    }

}