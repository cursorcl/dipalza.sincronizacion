package com.grupo.forms.report;

import java.util.ArrayList;
import java.util.List;

public class ListadoCreditos {

	private static List<RegistroVentaCredito> collection = new ArrayList<RegistroVentaCredito>();
	private static ListadoCreditos instance = null;

	public static ListadoCreditos getInstance() {
		if (instance == null) {
			instance = new ListadoCreditos();
		}
		return instance;
	}

	public static java.util.Collection<RegistroVentaCredito> generateCollection() {
		return collection;
	}

	public void add(RegistroVentaCredito registro) {
		collection.add(registro);
	}

	public void delete(RegistroVentaCredito registro) {
		collection.remove(registro);
	}

	public void clear() {
		collection.clear();
	}

}
