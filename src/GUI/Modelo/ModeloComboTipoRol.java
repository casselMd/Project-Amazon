package GUI.Modelo;

import Entidades.TipoRol;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;


public class ModeloComboTipoRol extends AbstractListModel implements ComboBoxModel{
    private ArrayList<TipoRol> listadoRol;
    private TipoRol seleccionado = null; 
    
    
    public ArrayList<TipoRol> getListadoRol() {
        return listadoRol;
    }

    public void setListadoRol(ArrayList<TipoRol> listadoRol) {
        this.listadoRol = listadoRol;
        this.listadoRol.add(   0, new TipoRol("--Seleccione un rol--"));
        this.setSelectedItem("--Seleccione un rol--");
    }

    public TipoRol getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(TipoRol seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    @Override
    public int getSize() {
        int cantElem = 0;
        
        if(this.listadoRol != null) {        
            cantElem = this.listadoRol.size();
        }
        return cantElem; 
    }

    @Override
    public Object getElementAt(int index) {
        Object elem = "";
        if(this.listadoRol != null) { 
            elem = this.listadoRol.get(index).toString();
        }
        return elem;
    }

    @Override
    public void setSelectedItem(Object anItem) {
                this.seleccionado = null;
        if(this.listadoRol != null && anItem != null) {
            for (TipoRol tipoRol : this.listadoRol) {
                if( tipoRol.toString().equals(anItem) ) {
                    this.seleccionado = tipoRol;
                    return;
                }
            }
        }
    }
    
   @Override
    public Object getSelectedItem() {
                Object elem = "";
        if(this.seleccionado != null) {
            elem = this.seleccionado;
        }
        return elem;
    }
    
}
