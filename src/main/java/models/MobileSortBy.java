package models;

public enum MobileSortBy {
    POSITION("Position"),
    NAME("Name"),
    PRICE("Price");

    private final String selectedText;

    MobileSortBy(String selectedText) {
        this.selectedText = selectedText;
    }

    public String getText() {
        return selectedText;
    }
}
