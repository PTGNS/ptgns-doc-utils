package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontFace;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontStyle;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocTitleUtil {

    public static void defaultTitleParagraph(Document document, String text, PdfTextAlignment pdfTextAlignment) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.defaultBoldFont());
        paragraph.setAlignment(pdfTextAlignment.getId());
        document.add(paragraph);
    }

    public static void defaultTitleParagraph(Document document, String text, PdfTextAlignment pdfTextAlignment, Float spacingAfter) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.defaultBoldFont());
        paragraph.setAlignment(pdfTextAlignment.getId());
        paragraph.setSpacingAfter(spacingAfter);
        document.add(paragraph);
    }

    public static void defaultTitleParagraph(Document document, int fontSize, String text, PdfTextAlignment alignment) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.defaultBoldFont(fontSize));
        paragraph.setAlignment(alignment.getId());
        document.add(paragraph);
    }
    public static void defaultTitleParagraph(Document document, int fontSize, String text, PdfTextAlignment alignment,Float spacingAfter) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, DocFontUtil.defaultBoldFont(fontSize));
        paragraph.setAlignment(alignment.getId());
        paragraph.setSpacingAfter(spacingAfter);
        document.add(paragraph);
    }

}