
package modelo;

/**
 *Sao os tipos existentes de Tokens no analizador lexico
 * 
 * @author Claudio Sumburane
 * @author Herquiloide Hele
 * @author Jose Seie
 * 
 */
public enum TipoToken{
    
    
    PALAVRARESERVADA("div|if|then|else|of|while|do|begin|end|read|write|var|array|function|procedure|program|true|false|integer|boolean|char|integer"),
    OPERADORARTIMETICO ("[+*-/]"), 
    OPERADORLOGICO("and|or|not"), 
    OPERADORATRIBUICAO(":="), 
    OPERADORRELACIONAL(">|<|<>|>=|<=|="), 
    IDENTIFICADOR("[a-zA-Z_][[a-zA-Z]{0,}[0-9_]{0,}]{0,}"),
    NUMERO("-{0,}[0-9]+"), 
    SEPARADOR(";|\\.|\\.\\.|:"), 
    COMENTARIO("\\{"+IDENTIFICADOR.regra +"\\}"),
    ESPACOEMBRANCO("[ |\t|\n|\f|\r]+"),
    Erro("Erro");

    
    private final String regra;
    
    
    private TipoToken(String regra){
        this.regra = regra;
    }
    
    public String getRegra(){
        return this.regra;
    }
    
    public static boolean erro(String texto){
       
        return !(texto.matches(PALAVRARESERVADA.regra)||
                texto.matches(OPERADORARTIMETICO.regra) || 
                texto.matches(OPERADORLOGICO.regra)|| 
                texto.matches(OPERADORRELACIONAL.regra) || 
                texto.matches(IDENTIFICADOR.regra) ||
                texto.matches(NUMERO.regra) || 
                texto.matches(SEPARADOR.regra)||
                texto.matches(COMENTARIO.regra) || 
                texto.matches(ESPACOEMBRANCO.regra));
    }
    
    /**
     * pega todoas as expressores regulares que representam separadores em um input
     * @return regras ou expressores regulares de separadores 
     */ 
    public static String separadores(){
        return TipoToken.OPERADORARTIMETICO.getRegra() + "|" +
               TipoToken.OPERADORATRIBUICAO.getRegra() + "|" +
               TipoToken.OPERADORLOGICO.getRegra() + "|" +
               TipoToken.OPERADORRELACIONAL.getRegra() + "|" +
               TipoToken.SEPARADOR.getRegra();
               
    }
    
    
    /**
     * metodo que retorna todas s expressoes regulares 
     * @return 
     */
    public static String getTodasRegras(){
        return TipoToken.OPERADORARTIMETICO.getRegra() + "|" +
               TipoToken.OPERADORATRIBUICAO.getRegra() + "|" +
               TipoToken.OPERADORLOGICO.getRegra() + "|" +
               TipoToken.OPERADORRELACIONAL.getRegra() + "|" +
               TipoToken.SEPARADOR.getRegra() + "|" +
               TipoToken.IDENTIFICADOR.getRegra() + "|" +
               TipoToken.ESPACOEMBRANCO.getRegra()+ "|" +
               TipoToken.NUMERO.getRegra() + "|" +
               TipoToken.PALAVRARESERVADA.getRegra()+ "|" +
               TipoToken.COMENTARIO.getRegra();
        
    }
   
}
