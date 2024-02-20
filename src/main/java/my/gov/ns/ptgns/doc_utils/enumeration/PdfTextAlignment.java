package my.gov.ns.ptgns.doc_utils.enumeration;

public enum PdfTextAlignment {

    ALIGN_UNDEFINED(-1),
    ALIGN_LEFT(0),
    ALIGN_CENTER(1),
    ALIGN_RIGHT(2),
    ALIGN_JUSTIFIED(3),
    ALIGN_TOP(4),
    ALIGN_MIDDLE(5),
    ALIGN_BOTTOM(6),
    ALIGN_BASELINE(7),
    ALIGN_JUSTIFIED_ALL(8);

    private final Integer id;

    PdfTextAlignment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
