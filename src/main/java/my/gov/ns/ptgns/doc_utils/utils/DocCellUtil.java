package my.gov.ns.ptgns.doc_utils.utils;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontFace;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfFontStyle;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;

public class DocCellUtil {

    /**
     * Create cell object with designated border type
     *
     * @param pdfCellBorder Border type
     * @return
     */
    public static PdfPCell generateCell(PdfCellBorder pdfCellBorder) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(pdfCellBorder.getId());
        return cell;
    }

    /**
     * Create cell object with side border (only left and right border). Usually use for middle cell in table
     *
     * @return
     */
    public static PdfPCell generateCellSideBorder() {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
        return cell;
    }

    /**
     * Create cell object with bottom border.
     *
     * @return
     */
    public static PdfPCell generateCellTopBottomBorder() {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
        return cell;
    }

    public static void fillCellParagraphListing(PdfPTable pdfPTable, PdfCellBorder pdfCellBorder, PdfTextAlignment pdfTextAlignment, Float spacingBefore, Float spacingAfter, String... placeholders) {
        Paragraph paragraph;
        PdfPCell pdfPCell;
        for (String placeholder : placeholders) {
            paragraph = new Paragraph(placeholder, DocFontUtil.defaultNormalFont());
            paragraph.setSpacingAfter(spacingBefore);
            paragraph.setSpacingAfter(spacingAfter);
            paragraph.setAlignment(pdfTextAlignment.getId());
            pdfPCell = generateCell(pdfCellBorder);
            pdfPCell.addElement(paragraph);
            pdfPTable.addCell(pdfPCell);
        }
    }

    public static void fillCellSimpleParagraphListing(PdfPTable pdfPTable, PdfCellBorder pdfCellBorder, String... placeholders) {
        Paragraph paragraph;
        PdfPCell pdfPCell;
        for (String placeholder : placeholders) {
            paragraph = new Paragraph(18, placeholder, DocFontUtil.defaultNormalFont());
            paragraph.setKeepTogether(true);
            pdfPCell = new PdfPCell();
            pdfPCell.setBorder(pdfCellBorder.getId());
            pdfPCell.addElement(paragraph);
            pdfPTable.addCell(pdfPCell);
        }
    }

    public static void fillCellSimpleParagraphListing(PdfPTable pdfPTable, PdfCellBorder pdfCellBorder, Integer leading, Integer fontSize, String... placeholders) {
        Paragraph paragraph;
        PdfPCell pdfPCell;
        for (String placeholder : placeholders) {
            paragraph = new Paragraph(leading, placeholder, DocFontUtil.defaultNormalFont(fontSize));
            paragraph.setKeepTogether(true);
            pdfPCell = new PdfPCell();
            pdfPCell.setBorder(pdfCellBorder.getId());
            pdfPCell.addElement(paragraph);
            pdfPTable.addCell(pdfPCell);
        }
    }

    public static void fillCellLPhraseListingCustomFont(PdfPTable pdfPTable, PdfPCell pdfPCell, PdfFontFace pdfFontFace, PdfFontStyle pdfFontStyle, int fontSize, String... placeholders) {
        for (String placeholder : placeholders) {
            pdfPCell.setPhrase(new Phrase(placeholder, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
            pdfPTable.addCell(pdfPCell);
        }
    }

    public static void fillCellPhraseListingNumbering(PdfPTable pdfPTable, PdfPCell pdfPCell, String numbering, String title, String saparator, String value) {
        pdfPCell.setPhrase(new Phrase(numbering, DocFontUtil.defaultNormalFont()));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(title, DocFontUtil.defaultNormalFont()));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(saparator, DocFontUtil.defaultNormalFont()));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(value, DocFontUtil.defaultNormalFont()));
        pdfPTable.addCell(pdfPCell);
    }

    public static void fillCellCustomTableList(PdfPTable pdfPTable, PdfPCell pdfPCell, PdfFontFace pdfFontFace, PdfFontStyle pdfFontStyle, int fontSize, String title, String saparator, String value) {
        pdfPCell.setPhrase(new Phrase(title, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(saparator, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(value, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
    }

    public static void fillCellCustomTableListNumbering(PdfPTable pdfPTable, PdfPCell pdfPCell, PdfFontFace pdfFontFace, PdfFontStyle pdfFontStyle, int fontSize, String numbering, String title, String saparator, String value) {
        pdfPCell.setPhrase(new Phrase(numbering, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(title, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(saparator, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase(value, DocFontUtil.fullCustomFont(pdfFontFace, pdfFontStyle, fontSize)));
        pdfPTable.addCell(pdfPCell);
    }

    public static void fillEmptyCell(PdfPTable pdfPTable, PdfPCell pdfPCell, int emptyCells) {
        for (int i = 0; i < emptyCells; i++) {
            pdfPCell.setPhrase(new Phrase(" ", DocFontUtil.defaultNormalFont()));
            pdfPTable.addCell(pdfPCell);
        }
    }

    public static void fillSpacingCell(PdfPTable pdfPTable, PdfCellBorder pdfCellBorder, Float spacing, int totalCells) {
        PdfPCell pdfPCell = generateCell(pdfCellBorder);
        pdfPCell.setPhrase(new Phrase(" ", DocFontUtil.defaultNormalFont()));
        pdfPCell.setPaddingTop(spacing);
        for (int i = 0; i < totalCells; i++) {
            pdfPTable.addCell(pdfPCell);
        }
    }
}
