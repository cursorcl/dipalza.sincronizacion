package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import com.grupo.forms.SincronizacionMMI;

public class ActionNumerados extends ActionDipalza {

	public ActionNumerados() {
		super(null, "Numerados");
	}
	
	public ActionNumerados(SincronizacionMMI mmi) {
		super(mmi, "Numerados");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mmi.numerados();
	}

}
