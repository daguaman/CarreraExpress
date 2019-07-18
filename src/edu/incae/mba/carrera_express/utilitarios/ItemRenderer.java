/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.utilitarios;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Christian Carrera
 */
public class ItemRenderer extends BasicComboBoxRenderer
    {
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

            if (value != null)
            {
                Item item = (Item)value;
                setText( item.getDescription().toUpperCase() );
            }

            if (index == -1)
            {
                Item item = (Item)value;
                setText( "" + item.getId() );
            }


            return this;
        }
    }
