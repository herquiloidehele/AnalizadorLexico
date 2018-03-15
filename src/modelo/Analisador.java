
package modelo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Herquiloide Hele && Claudio Sumburrane && Jose Seie
 */
public class Analisador {
    
    private static ArrayList<Token> tokens = new ArrayList();
    private static ArrayList<HashMap<Integer, String>> resto = new ArrayList<>();
    
    
        /**
     * divide a String de acordo com os espacos entre ela
     * @param input o codigo fonte a ser separada
     * @return array de subStrings separadas
     */
    public static ArrayList<String> separarEmString(String input){
       return new ArrayList<>(Arrays.asList(input.trim().split("[ \\t\\n]+")));
    }
    
    
    
    
     /**
     * metodo que verifica imediatamente se uma determinada palavra 
     * do array de palavras possui um tipo token ou nao,
     * Caso essa palvra possuia um tipo token, entao eh atribuida um  
     * valor ou chave impar (significando que podemos deixa-la assim como esta) caso contrario,
     * valor par (significando que devemos ainda trabalhar com essa palavra para
     * identificar os tokens la exestentes) 
     * @return estado um hashMap de palavras com os seus resectivos estdados (impar ou par)
     */
    public static HashMap<Integer, String> getEstadoPalavra(ArrayList<String> palavras){
        HashMap<Integer, String> estado = new HashMap<>();
        
        for(String palavra : palavras){
            if(verificarTipo(palavra.trim()) != null){
                estado.put(GerarChaves.getProximaChave(GerarChaves.impar), palavra);
            }else
                estado.put(GerarChaves.getProximaChave(GerarChaves.par), palavra);
        }    
        return estado;  
    }
    
            /**
     * Verifica a que tipo Tiken pertence uma dterminda palavra
     * @param palavar
     * @return o tipo token de uma determinada palvara caso nao encontre eh re
     * tornado null
     */
    public static TipoToken verificarTipo(String palavar){
        for(TipoToken tipoToken : TipoToken.values()){
                if(palavar.matches(tipoToken.getRegra())){
                    return tipoToken;
                }
            }
        return null;
    }
    
  
    /**
     * Metodo que separa a String em um arrayList de subStrings
     * O criterio de separacao sao os operadores
     * @param palavra a ser convertida em array de chars
     * @return 
     */
    private static ArrayList<String> separarEmOperadores(String palavra){
        
        ArrayList<Character> chars = getSeparadores(palavra);
        adicionarToken(chars);
        
        String array [] = palavra.split(TipoToken.separadores()); 
        
        return new ArrayList<>(Arrays.asList(array));
    } 
    
    
     /**
     *com base nas regras de todos os separadores, retorna todos separadores existentes numa palavra
     * Ex: 2+3=8 o retorno sera: + , =
     * @param palavra
     * @return um ArrayList  de caracteres de todos separadores
     * 
     */
    public static ArrayList<Character> getSeparadores(String palavra){
        ArrayList<Character> chars = new ArrayList<>();
        for(char a : palavra.toCharArray()){
            if(String.valueOf(a).matches(TipoToken.separadores())){
                chars.add(a);
            }
        }
        return chars;
    }
   
   
     /**
     * adiciona um conjunto de tokens na lista final de tokens  
     * 
     * @param palavras sao os tokens que foram identificados
     */
    public static void adicionarToken(ArrayList palavras){
        for(Object token : palavras){ 
            if(verificarEspacos(token)){
                Token t = new Token(verificarTipo(token.toString()), token.toString().length(), token.toString());
                tokens.add(t);
            }        
        }
       
    }
    
    
    /**
     * adiciona um token na lista dos tokens token 
     * Nota: Sao adicionados na lista de tokens apenas aqueles 
     * elementos do hasMap que possuirem chave impar, ou seja,
     * os elementos ou palavras que ja tiverem sido identificadas
     * @param map a lista de tokens ou palavras com as suas chaves
     */
    public static void adicionarToken(HashMap<Integer, String> map){    
       
        
        for(Integer chave : map.keySet()){
            if(!GerarChaves.verficarPar(chave)){
                String token = map.get(chave);
                if(token != null){
                    Token t = new Token(verificarTipo(token), token.length(), token);
                    tokens.add(t);
                }
            }
        }
    }
    

    
    public static void adicionarErro(HashMap<Integer,String> lista){
        for(Integer chave : lista.keySet()){
            String s = lista.get(chave);
            tokens.add(new Token(TipoToken.Erro, s.length(), s));
        }
    }
    
    
    /**
     * remove as palavras que ja foram identificados os seus tokens
     * @param map lista de palavras a serem identificadas
     * @return lista de palavras que ainda nao forem identificadas
     */
    public static HashMap<Integer, String> removerEncontrado(HashMap<Integer, String> map){
        
        Integer chaves [] = new Integer[map.size()];
        int i = 0;
        for(Integer chave : map.keySet()){
            chaves [i] = chave;
            i++;
        }
        
        for(int a = 0; a<chaves.length; a++){
            if(!GerarChaves.verficarPar(chaves[a])){
                map.remove(chaves[a]);
            }
        }
        return map;
    }
    
    
    /**
     * faz todas as vericacoes para determinar o token das palavras do input
     * @param input todo codigo que sera digitado no editor
     * @return lista de tokens
     */
    public static ArrayList<Token> getTokens(String input){
        
        ArrayList<String> separacaoString = separarEmString(input);
        HashMap<Integer, String> map = getEstadoPalavra(separacaoString);
        adicionarToken(map);
       
        removerEncontrado(map);
        
        for(Integer chave : map.keySet()){
            ArrayList<String> separarOperadore = separarEmOperadores(map.get(chave));
            HashMap<Integer, String> map2 = getEstadoPalavra(separarOperadore);
            adicionarToken(map2);
            
            removerEncontrado(map2);
            adicionarErro(map2);
            resto.add(map2);
        }
        
      
        return tokens;
    }
    
    /**
     * 
     * @param token
     * @return 
     */
     private static boolean verificarEspacos(Object token) {
       return (token != null || !(token.toString().matches(TipoToken.ESPACOEMBRANCO.getRegra())));
    }
    
    
    }
      