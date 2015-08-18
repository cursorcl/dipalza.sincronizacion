package cl.eos.util;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.apache.log4j.Logger;


public class Utils {

	private static Logger log = Logger.getLogger(Utils.class);

	public static String getFileSuffix(final String path) {
		String result = null;
		if (path != null) {
			result = "";
			if (path.lastIndexOf('.') != -1) {
				result = path.substring(path.lastIndexOf('.'));
				if (result.startsWith(".")) {
					result = result.substring(1);
				}
			}
		}
		return result;
	}

	public static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static char getDecimalSeparator() {
		DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
		DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
		char sep = symbols.getDecimalSeparator();
		return sep;
	}

	public static boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	public static boolean isInteger(String s) {
		return s.matches("[-+]?\\d+");
	}

	/**
	 * Obtiene el directorio donde se almacenan todos los archivos. Retorna
	 * uset.home directorio.
	 * 
	 * @return
	 */
	public static File getDefaultDirectory() {
		String path = System.getProperty("user.home") + File.separator
				+ "Documents";
		path += File.separator + "Dipalza";
		File customDir = new File(path);
		if (customDir.exists()) {
			log.info(customDir + " ya existe.");
		} else if (customDir.mkdirs()) {
			log.info(customDir + " fue creado.");
		} else {
			log.info(customDir + " no fue creado.");
			path = System.getProperty("user.home");
			customDir = new File(path);
		}
		return customDir;
	}

}
