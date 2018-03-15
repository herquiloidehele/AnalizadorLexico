
package modelo;

/**
* @author Claudio Sumburane
 * @author Herquiloide Hele
 * @author Jose Seie
 * 
 */
public class Token  extends Object{
    
    private TipoToken tipo;
    private int tamanho;
    private String token;
    private int linha;
    private int coluna;

    public Token(TipoToken tipo, int tamanho, String token) {
        this.tipo = tipo ;
        this.tamanho = tamanho;
        this.token = token;
    }

    
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    public TipoToken getTipo() {
        return tipo;
    }

    public void setTipo(TipoToken tipo) {
        this.tipo = tipo;
    }

    public int getTmanho() {
        return tamanho;
    }

    public void setTmanho(int tmanho) {
        this.tamanho = tmanho;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    @Override
    public String toString() {
        return String.format("<%s , %s >", this.tipo.name(), this.token);
    }
    
}
