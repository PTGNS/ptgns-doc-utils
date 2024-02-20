package my.gov.ns.ptgns.doc_utils.enumeration;

public enum PdfFontStyle {

    NORMAL(0),
    BOLD(1),
    ITALIC(2),
    UNDERLINE(4),
    STRIKETHRU(8),
    BOLDITALIC(3),
    UNDEFINED(-1),
    DEFAULTSIZE(12);

    private final Integer id;

    PdfFontStyle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
