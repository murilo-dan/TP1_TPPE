public enum OutputFormat {
    LINHA(true),
    COLUNA(false);

    private boolean format;

    OutputFormat(boolean format) {
        this.format = format;
    }

    public boolean getFormat() {
        return format;
    }
}
