package my.gov.ns.ptgns.doc_utils.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({
        "classpath:db.properties",
        "classpath:system.properties"
})
public class ApplicationConfig {

    @Autowired
    private Environment env;

    @Autowired
    public void AppConfig() {

        // SET PROPERTY
        String pdfGrid = env.getProperty("sys.pdf.grid");
        String pdfGridSizeParent = env.getProperty("sys.pdf.grid.size.parent");
        String pdfGridSizeChild = env.getProperty("sys.pdf.grid.size.child");
        System.setProperty("pdfGrid",pdfGrid);
        System.setProperty("pdfGridSizeParent",pdfGridSizeParent);
        System.setProperty("pdfGridSizeChild",pdfGridSizeChild);

        String pdfFont = env.getProperty("sys.pdf.font");
        String pdfFontStyle = env.getProperty("sys.pdf.font.style");
        String pdfFontSize = env.getProperty("sys.pdf.font.size");
        System.setProperty("pdfFont",pdfFont);
        System.setProperty("pdfFontStyle",pdfFontStyle);
        System.setProperty("pdfFontSize",pdfFontSize);

    }
}
