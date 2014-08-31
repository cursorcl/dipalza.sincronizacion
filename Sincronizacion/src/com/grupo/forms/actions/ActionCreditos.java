package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import com.grupo.forms.SincronizacionMMI;

public class ActionCreditos extends ActionDipalza {
	public ActionCreditos() {
		super(null, "Cr�ditos");
	}

	public ActionCreditos(SincronizacionMMI mmi) {
		super(mmi, "Cr�ditos");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mmi.creditos();
	}

}
