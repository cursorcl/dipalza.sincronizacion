package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import com.grupo.forms.SincronizacionMMI;

public class ActionCreditos extends ActionDipalza {
	public ActionCreditos() {
		super(null, "Créditos");
	}

	public ActionCreditos(SincronizacionMMI mmi) {
		super(mmi, "Créditos");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mmi.creditos();
	}

}
