package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import com.grupo.forms.SincronizacionMMI;

public class ActionReport extends ActionDipalza {

	public ActionReport() {
		super(null, "Reporte");
	}
	
	public ActionReport(SincronizacionMMI mmi) {
		super(mmi, "Reporte");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mmi.reporte();

	}

}
