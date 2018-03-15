/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.TipoToken;

/**
 *
 * @author Herquiloide Hele
 */
public class ErrorLine extends DefaultTableCellRenderer{

    private ArrayList<Integer> linhas;

    public ErrorLine(ArrayList<Integer> linhas) {
        this.linhas = linhas;
    }

    
    
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        for(Integer linha : linhas){
            if((linha == row) && (TipoToken.erro(table.getValueAt(row, 1).toString()))){
                setBackground(Color.red);
                setForeground(Color.white);
                
            }
        }
        return this;
    }
    
    
}