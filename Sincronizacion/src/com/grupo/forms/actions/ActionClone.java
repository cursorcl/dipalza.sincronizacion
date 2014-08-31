package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import com.grupo.forms.SincronizacionMMI;

public class ActionClone extends ActionDipalza {
	public ActionClone() {
		super(null, "Clonar");
		
	}
	
	public ActionClone(SincronizacionMMI mmi) {
		super(mmi, "Clonar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mmi.colne();

	}

}
