/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.Token;

/**
 *
 * @author Herquiloide Hele
 */
public class ModeloTabela extends AbstractTableModel{

    private ArrayList<Token> lista;
    String colunas [] ;

    public ModeloTabela(ArrayList<Token> lista, String[] colunas) {
        this.lista = lista;
        this.colunas = colunas;
    }
    
    
    public void setLista(ArrayList<Token> tokens){
        lista = tokens;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Token token = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return token.getLinha();
            case 1: return token.getToken();
            case 2: return token.getTipo();
            case 3: return token.getTmanho();           
        }
        return null;
    }
    
    
    
    
}
