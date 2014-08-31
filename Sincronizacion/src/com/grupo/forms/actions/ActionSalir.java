package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import com.grupo.forms.SincronizacionMMI;

public class ActionSalir extends ActionDipalza {

	public ActionSalir() {
		super(null, "Salir");
	}
	
	public ActionSalir(SincronizacionMMI mmi) {
		super(mmi, "Salir");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mmi.salir();

	}

}
