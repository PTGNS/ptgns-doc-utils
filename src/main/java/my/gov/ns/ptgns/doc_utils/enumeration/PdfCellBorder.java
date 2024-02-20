package my.gov.ns.ptgns.doc_utils.enumeration;

public enum PdfCellBorder {

    TOP(1),
    BOTTOM(2),
    LEFT(4),
    RIGHT(8),
    NO_BORDER(0),
    BOX(15);

    private final Integer id;

    PdfCellBorder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
