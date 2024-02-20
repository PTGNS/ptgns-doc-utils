package my.gov.ns.ptgns.doc_utils.pdf.viewer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfCellBorder;
import my.gov.ns.ptgns.doc_utils.enumeration.PdfTextAlignment;
import my.gov.ns.ptgns.doc_utils.pdf.AbstractITextPdf;
import my.gov.ns.ptgns.doc_utils.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DocSample extends AbstractITextPdf {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //DOC
        PdfPTable table = DocTableUtil.generateTable(100, 2, 7, 3);
        PdfPCell cell = DocCellUtil.generateCell(PdfCellBorder.NO_BORDER);
        DocCellUtil.fillEmptyCell(table,cell,1);
        cell.setPhrase(new Phrase("Paper No: 1221/1993"));
        table.addCell(cell);
        DocCellUtil.fillEmptyCell(table,cell,1);
        cell.setPhrase(new Phrase("Date: 01/01/2022"));
        table.addCell(cell);
        table.setSpacingAfter(50f);
        doc.add(table);

        // TITLE
        DocTitleUtil.defaultTitleParagraph(doc,"THIS ARE SAMPLE FOR DOC USAGE", PdfTextAlignment.ALIGN_CENTER, 20f);

        PdfPCell cellContent = DocCellUtil.generateCell(PdfCellBorder.NO_BORDER);
        cellContent.setPaddingBottom(20f);

        PdfPTable tableContent = DocTableUtil.generateTable(100, 2, 10, 90);
        tableContent.setSplitLate(false);

        DocCellUtil.fillEmptyCell(tableContent,cellContent,1);
        cellContent.setPhrase(new Phrase("1. Lorem ipsum", DocFontUtil.defaultBoldFont()));
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent, cellContent, 1);
        Paragraph paragraph = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
                "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                "mollit anim id est laborum.", DocFontUtil.defaultNormalFont());
        paragraph.setAlignment(PdfTextAlignment.ALIGN_JUSTIFIED.getId());
        cellContent.addElement(paragraph);
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent, cellContent, 1);
        paragraph = new Paragraph("Mauris rhoncus ultricies lectus, quis posuere elit suscipit ut. Maecenas sollicitudin " +
                "gravida risus a bibendum. Cras felis libero, placerat ac diam eget, rutrum imperdiet ex. Mauris neque diam, pharetra " +
                "ac egestas a, feugiat ac elit. Cras eget interdum orci. Curabitur non mollis ligula. Morbi finibus tortor eu libero " +
                "pretium finibus sed vel mauris. Cras hendrerit, neque pellentesque facilisis blandit, neque lectus lobortis dui, " +
                "id sodales urna leo eu nisi. Vestibulum rhoncus, dolor egestas aliquam lacinia, mauris turpis consequat mauris, quis " +
                "feugiat magna libero quis urna. Donec vitae arcu in dolor convallis feugiat ac non tortor. Sed ligula dolor, rhoncus a " +
                "malesuada non, auctor at tortor. Pellentesque venenatis nisi sed scelerisque tempor. Nam laoreet gravida nibh, nec " +
                "tincidunt erat.", DocFontUtil.defaultNormalFont());
        paragraph.setAlignment(PdfTextAlignment.ALIGN_JUSTIFIED.getId());
        cellContent.addElement(paragraph);
        tableContent.addCell(cellContent);


        DocCellUtil.fillEmptyCell(tableContent,cellContent,1);
        cellContent.setPhrase(new Phrase("2. Fusce eget eros", DocFontUtil.defaultBoldFont()));
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent, cellContent, 1);
        paragraph = new Paragraph("Fusce eget eros eleifend odio gravida porttitor. Mauris sem ipsum, sodales at vestibulum " +
                "pharetra, porttitor ac urna. Cras sed risus arcu. Nam pulvinar augue orci. Nunc finibus sollicitudin luctus. Nam " +
                "eget aliquam enim. Nam et mattis purus, eu luctus orci. Quisque commodo bibendum dui nec accumsan. In ut augue suscipit, " +
                "maximus nisi eu, cursus lacus. Aenean sagittis ligula sed sem congue molestie. Ut finibus malesuada velit id accumsan. " +
                " Nam eu neque sit amet leo semper suscipit.", DocFontUtil.defaultNormalFont());
        paragraph.setAlignment(PdfTextAlignment.ALIGN_JUSTIFIED.getId());
        cellContent.addElement(paragraph);
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent, cellContent, 1);
        paragraph = new Paragraph("Phasellus vehicula, erat non interdum consectetur, lacus augue maximus nulla, et mattis dolor neque " +
                "sit amet felis. Ut pretium, nunc sed porttitor condimentum, turpis ex ornare dolor, a elementum orci ante ut magna. Donec ac " +
                "dui placerat ipsum aliquet vehicula sed quis nulla. Duis feugiat leo quam, sed pharetra dui ultricies quis. Cras finibus tortor " +
                "metus, et accumsan neque dictum eu. Aenean sem sapien, euismod in ipsum et, tincidunt ultrices purus. Cras ut laoreet quam. In " +
                "neque massa, tempor sit amet aliquet condimentum, porta id mauris. Vestibulum rhoncus magna id quam dictum, eu posuere massa " +
                "ullamcorper. Proin vel dictum nunc. Aliquam viverra augue fringilla ex pretium facilisis. Donec vehicula, ligula eu consequat congue, " +
                "sapien ante.", DocFontUtil.defaultNormalFont());
        paragraph.setAlignment(PdfTextAlignment.ALIGN_JUSTIFIED.getId());
        cellContent.addElement(paragraph);
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent,cellContent,1);
        cellContent.setPhrase(new Phrase("3. Listing", DocFontUtil.defaultBoldFont()));
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent, cellContent, 1);
        PdfPTable innerTable = DocTableUtil.generateTable(100, 3, 40, 5, 55);
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.NO_BORDER, "3.1  Vestibulum", ":", "Cras sed risus arcu");
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.NO_BORDER, "3.2  Phasellus", ":", "Proin vel dictum nunc");
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.NO_BORDER, "3.3  Ullamcorper", ":", "Donec vehicula");
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.NO_BORDER, "3.4  Aliquam", ":", "Duis feugiat leo quam");
        cellContent.addElement(innerTable);
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent,cellContent,1);
        cellContent.setPhrase(new Phrase("4. Tableu", DocFontUtil.defaultBoldFont()));
        tableContent.addCell(cellContent);

        DocCellUtil.fillEmptyCell(tableContent, cellContent, 1);
        innerTable = DocTableUtil.generateTable(100, 3, 40, 5, 55);
        innerTable.setKeepTogether(true);
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.BOX, "Width", "-", "100m");
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.BOX, "Duration", "-", "20 years");
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.BOX, "Category", "-", "Open");
        DocCellUtil.fillCellSimpleParagraphListing(innerTable, PdfCellBorder.BOX, "Description", "-", "Suspendisse nec mi ac felis molestie rutrum non eu neque. Cras dui arcu, dapibus at tellus vitae, dapibus vehicula augue. Sed lacus justo, convallis vitae tortor non, egestas egestas orci.");
        cellContent.addElement(innerTable);
        tableContent.addCell(cellContent);

        doc.add(tableContent);



    }
}
