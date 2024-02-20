package my.gov.ns.ptgns.doc_utils.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

public abstract class AbstractITextPdf extends AbstractView {


    public AbstractITextPdf() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // IE workaround: write into byte array first.
        ByteArrayOutputStream baos = createTemporaryOutputStream();

        // Apply preferences and build metadata.
        Document document = newDocument();
        PdfWriter writer = newWriter(document, baos);
        prepareWriter(model, writer, request);
        buildPdfMetadata(model, document, request);

        // Build PDF document.
        document.open();
        buildPdfDocument(model, document, writer, request, response);

        Boolean pdfGrid = Boolean.getBoolean("pdfGrid");
        int pdfGridSizeParent = Integer.valueOf(System.getProperty("pdfGridSizeParent"));
        int pdfGridSizeChild = Integer.valueOf(System.getProperty("pdfGridSizeChild"));

        if(pdfGrid) {
            PdfContentByte cb = writer.getDirectContent();
            drawGrid(cb, PageSize.A4,pdfGridSizeParent,pdfGridSizeChild);
        }

        document.close();

        // Flush to HTTP response.
        writeToResponse(response, baos);
    }

    protected Document newDocument() {
        return new Document(PageSize.A4, 30, 30, 30, 30);
    }

    protected PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
        return PdfWriter.getInstance(document, os);
    }

    protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request)
            throws DocumentException {
        writer.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences() {
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
    }

    protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception;

    public Font fontMontserrat() throws DocumentException, IOException {
        return fontMontserrat(8f, Font.NORMAL);
    }

    public Font fontMontserrat(Float size, Integer style) throws DocumentException, IOException {
        ServletContext context = getServletContext();

        String regular = "Montserrat-Regular.ttf";
        String bold = "Montserrat-Bold.ttf";
        String italic = "Montserrat-Italic.ttf";
        String boldItalic = "Montserrat-BoldItalic.ttf";

        String file = "/resources/fonts/montserrat/" + regular;
        if (style == Font.BOLD) {
            file = "/resources/fonts/montserrat/" + bold;
        } else if (style == Font.ITALIC) {
            file = "/resources/fonts/montserrat/" + italic;
        } else if (style == Font.BOLDITALIC) {
            file = "/resources/fonts/montserrat/" + boldItalic;
        }

        InputStream is = context.getResourceAsStream(file);
        byte[] ttfAfm = IOUtils.toByteArray(is);

        BaseFont base = BaseFont.createFont(regular, BaseFont.WINANSI, BaseFont.EMBEDDED, BaseFont.NOT_CACHED, ttfAfm, null);
        if (style == Font.BOLD) {
            base = BaseFont.createFont(bold, BaseFont.WINANSI, BaseFont.EMBEDDED, BaseFont.NOT_CACHED, ttfAfm, null);
            //style = Font.NORMAL;
        } else if (style == Font.ITALIC) {
            base = BaseFont.createFont(italic, BaseFont.WINANSI, BaseFont.EMBEDDED, BaseFont.NOT_CACHED, ttfAfm, null);
            //style = Font.NORMAL;
        } else if (style == Font.BOLDITALIC) {
            base = BaseFont.createFont(boldItalic, BaseFont.WINANSI, BaseFont.EMBEDDED, BaseFont.NOT_CACHED, ttfAfm, null);
            //style = Font.NORMAL;
        }

        Font font = new Font(base, size, Font.NORMAL);
        return font;
    }

    private void drawGrid(PdfContentByte cb, Rectangle pageSize, int pdfGridSizeParent, int pdfGridSizeChild) throws DocumentException, IOException {
        cb.saveState();

        cb.setLineWidth(0.2f);
        cb.setColorStroke(BaseColor.RED);
        for (float x = pageSize.getLeft(); x <= pageSize.getRight(); x += pdfGridSizeChild) {
            cb.moveTo(x, pageSize.getBottom());
            cb.lineTo(x, pageSize.getTop());
            cb.stroke();
        }
        for (float y = pageSize.getBottom(); y <= pageSize.getTop(); y += pdfGridSizeChild) {
            cb.moveTo(pageSize.getLeft(), y);
            cb.lineTo(pageSize.getRight(), y);
            cb.stroke();
        }

        cb.setLineWidth(1f);
        cb.setColorStroke(BaseColor.BLUE);
        for (float x = pageSize.getLeft(); x <= pageSize.getRight(); x += pdfGridSizeParent) {
            cb.moveTo(x, pageSize.getBottom());
            cb.lineTo(x, pageSize.getTop());
            cb.stroke();

            cb.beginText();
            cb.setFontAndSize(fontMontserrat().getBaseFont(), 10);
            cb.showTextAligned(com.itextpdf.text.Element.ALIGN_CENTER, String.valueOf((int) x), x, pageSize.getBottom() + 5, 0);
            cb.endText();
        }
        for (float y = pageSize.getBottom(); y <= pageSize.getTop(); y += pdfGridSizeParent) {
            cb.moveTo(pageSize.getLeft(), y);
            cb.lineTo(pageSize.getRight(), y);
            cb.stroke();

            cb.beginText();
            cb.setFontAndSize(fontMontserrat().getBaseFont(), 10);
            cb.showTextAligned(com.itextpdf.text.Element.ALIGN_RIGHT, String.valueOf((int)y), pageSize.getLeft() + 25, y, 0);
            cb.endText();
        }

        cb.restoreState();
    }

}
