package my.gov.ns.ptgns.doc_utils.enumeration;

public enum PdfFontFace {

    COURIER("Courier"),
    COURIER_BOLD("Courier-Bold"),
    COURIER_OBLIQUE("Courier-Oblique"),
    COURIER_BOLDOBLIQUE("Courier-BoldOblique"),
    HELVETICA("Helvetica"),
    HELVETICA_BOLD("Helvetica-Bold"),
    HELVETICA_OBLIQUE("Helvetica-Oblique"),
    HELVETICA_BOLDOBLIQUE("Helvetica-BoldOblique"),
    SYMBOL("Symbol"),
    TIMES("Times"),
    TIMES_ROMAN("Times-Roman"),
    TIMES_BOLD("Times-Bold"),
    TIMES_ITALIC("Times-Italic"),
    TIMES_BOLDITALIC("Times-BoldItalic"),
    ZAPFDINGBATS("ZapfDingbats");

    private final String name;

    PdfFontFace(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
