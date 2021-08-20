package com.grupo.util;

import java.util.ArrayList;
import java.util.List;

public class EventEmisor {
	protected List<EventMsgListener> listeners;

	public synchronized void addEventMsgListener(EventMsgListener listener) {
		if (this.listeners == null) {
			this.listeners = new ArrayList<>();
		}
		this.listeners.add(listener);
	}

	public synchronized void removeEventMsgListener(EventMsgListener listener) {
		if (this.listeners != null)
			this.listeners.remove(listener);
	}

	public void notify(int operation) {
		notify(operation, "");
	}

	public void notify(String message) {
		notify(0, message);
	}

	public synchronized void notify(int operation, String message) {
		if ((this.listeners != null) && (this.listeners.size() > 0)) {
			EventMsg msg = new EventMsg(this, operation, message);
			for (EventMsgListener lst : this.listeners)
				lst.onMessage(msg);
		}
	}
}