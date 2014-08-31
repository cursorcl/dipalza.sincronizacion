package com.grupo.forms.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.grupo.forms.SincronizacionMMI;

public abstract class ActionDipalza extends AbstractAction {

	SincronizacionMMI mmi;

	public ActionDipalza(SincronizacionMMI mmi, String name) {
		super(name);
		this.mmi = mmi;
	}

	abstract public void actionPerformed(ActionEvent e);

}
