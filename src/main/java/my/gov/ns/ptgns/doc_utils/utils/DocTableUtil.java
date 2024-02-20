package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontFace;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontStyle;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocTableUtil {

    public static PdfPTable generateTable(float tableWidth, int columns, float... columnWidth) throws DocumentException {
        PdfPTable table = new PdfPTable(columns);
        table.setWidthPercentage(tableWidth);
        table.setWidths(columnWidth);
        return table;
    }

    public static PdfPTable generateTableList(float tableWidth) throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(tableWidth);
        table.setWidths(new float[]{2.0f, 0.1f, 3.0f});
        return table;
    }

    public static PdfPTable generateTableListNumbering(float tableWidth) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(tableWidth);
        table.setWidths(new float[]{0.2f, 2.0f, 0.1f, 3.0f});
        return table;
    }


}
