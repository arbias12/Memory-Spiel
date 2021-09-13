package model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.Vector;

/**
 * GUI_Prüfung
 *
 * @author Arbias imeri
 * @version 1.2
 * @since 14.04.2021
 */
public class ListItemValues implements MutableComboBoxModel<String> {
    private Vector<String> allItems;
    private String selectedItem;

    public ListItemValues(){
        allItems = new Vector<>();
        allItems.add("5 x 6");
        allItems.add("6 x 6");
        allItems.add("5 x 8");
        allItems.add("6 x 8");
    }

    @Override
    public void addElement(String item) {
        allItems.add(item);
    }

    @Override
    public void removeElement(Object obj) {
        allItems.remove(obj);
    }

    @Override
    public void insertElementAt(String item, int index) {
        allItems.add(index, item);
    }

    @Override
    public void removeElementAt(int index) {
        allItems.remove(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return allItems.size();
    }

    @Override
    public String getElementAt(int index) {
        return allItems.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
