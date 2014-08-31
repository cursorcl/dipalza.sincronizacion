package com.grupo.util;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class UtilEvent {
	public static void onlyNumbersAndPointTyped(KeyEvent aKeyEvent) {
		if ((Character.getType(aKeyEvent.getKeyChar()) == 15)
				|| (Character.isDigit(aKeyEvent.getKeyChar()))
				|| (aKeyEvent.getKeyChar() == '.')
				|| (Character.getType(aKeyEvent.getKeyChar()) == 9))
			return;
		aKeyEvent.consume();
	}

	public static void limitMaximunCharactersTyped(KeyEvent aKeyEvent,
			int aLimitCharacters) {
		if ((Character.getType(aKeyEvent.getKeyChar()) != 15)
				&& (aKeyEvent.getSource() instanceof JTextField)) {
			JTextField txtControl = (JTextField) aKeyEvent.getSource();
			if ((txtControl.getText().length() >= aLimitCharacters)
					&& (txtControl.getSelectionEnd()
							- txtControl.getSelectionStart() == 0)) {
				aKeyEvent.consume();
			}
		}

	}

	public static void floatRangeVerifyTyped(KeyEvent aKeyEvent,
			float aMinValue, float aMaxValue) {
		if ((Character.getType(aKeyEvent.getKeyChar()) != 15)
				&& (aKeyEvent.getSource() instanceof JTextField)) {
			JTextField txtControl = (JTextField) aKeyEvent.getSource();

			boolean discardable = false;
			float xValue = 0.0F;
			try {
				String xstr = new String(txtControl.getText());
				if (xstr != null) {
					String xResult = new String(xstr);
					if (txtControl.getSelectedText() != null) {
						String xsub = txtControl.getSelectedText();
						xResult = xstr.replaceFirst(xsub, new Character(
								aKeyEvent.getKeyChar()).toString());
					} else if (txtControl.getSelectionStart() > 0) {
						xResult = xstr.substring(0, txtControl
								.getSelectionStart());
						xResult = xResult
								+ new Character(aKeyEvent.getKeyChar())
										.toString();
						if (txtControl.getSelectionEnd() < xstr.length()) {
							xResult = xResult
									+ xstr.substring(txtControl
											.getSelectionEnd(), xstr.length());
						}
					} else {
						xResult = new Character(aKeyEvent.getKeyChar())
								.toString()
								+ xstr;
					}
					xValue = Float.parseFloat(xResult);
				}

			} catch (Exception e) {
				discardable = true;
			}

			if ((discardable) || (xValue < aMinValue) || (xValue > aMaxValue)) {
				aKeyEvent.consume();
			}
		}
	}
}
