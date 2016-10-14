package com.grupo.especiales;

import java.util.List;

import com.grupo.basedatos.RangoEspeciales;
import com.grupo.data.DataSQL;

public class SpecialProductControl {

  List<RangoEspeciales> especiales;
  DlgSpecialProduct view;

  public SpecialProductControl() {
    especiales = DataSQL.getInstance().getEspeciales();
    view = new DlgSpecialProduct(this);
  }

  public final List<RangoEspeciales> getEspeciales() {
    return especiales;
  }

  public final void setEspeciales(List<RangoEspeciales> especiales) {
    this.especiales = especiales;
  }


  public final void add(String min, String max) {
    RangoEspeciales rng = new RangoEspeciales(min, max);
    especiales.add(rng);
  }

  public final void remove(String min, String max) {
    RangoEspeciales rng = new RangoEspeciales(min, max);
    int idx = -1;
    for (int n = 0; n < especiales.size(); n++) {
      if (rng.equals(especiales.get(n))) {
        idx = n;
        break;
      }
    }
    if(idx !=-1)
    {
      especiales.remove(idx);
    }
  }
  
  public void save()
  {
    DataSQL.getInstance().setEspeciales(especiales);
  }
  
  public void show()
  {
    view.setVisible(true);
  }


}
