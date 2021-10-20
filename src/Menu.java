public class Menu {

    private String delimiter;

    public Menu() {
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) throws DelimitadorInvalidoException {
        if(delimiter.length() > 1)
            throw new DelimitadorInvalidoException("Delimitador inválido");
        else
            this.delimiter = delimiter;
    }
}
