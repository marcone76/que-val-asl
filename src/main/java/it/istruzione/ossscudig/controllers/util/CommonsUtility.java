package it.istruzione.ossscudig.controllers.util;

import it.istruzione.ossscudig.constant.Constants;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;

public class CommonsUtility {
	private static final SimpleDateFormat formatterIt = new SimpleDateFormat("dd/MM/yyyy");


	public static Calendar getCalendar(Date date) {
		Calendar result = null;
		if (date != null) {

			result = Calendar.getInstance();
			result.setTime(date);
		}
		return result;
	}

	public static String format(Calendar calendar) {
		return format(calendar.getTime());
	}

	public static String format(Date date) {
		if (date == null)
			return "";
		return formatterIt.format(date);
	}

	public static Date parse(String date) {
		if (isEmpty(date)) {
			return null;
		} else {
			try {
				return formatterIt.parse(date);
			} catch (Exception ex) {
				return null;
			}
		}
	}

	

	public static Date getCalendarToDate(Calendar calendar) {
		if (calendar != null) {
			return calendar.getTime();
		}
		return null;
	}

	public static Long fromBigDecimalToLong(BigDecimal in) {
		if (in != null) {
			return in.longValue();
		}
		return null;
	}

	public static BigDecimal calcolaPercetuale(BigDecimal value, BigDecimal totale) {

		BigDecimal hundred = new BigDecimal(100.00);
		if (totale.compareTo(BigDecimal.ZERO) == 0)
			return BigDecimal.ZERO;

		return value.multiply(hundred).divide(totale, 2, BigDecimal.ROUND_HALF_UP);
	}

	public static XMLGregorianCalendar getXMLGregorianCalendar(Calendar input) {
		try {
			XMLGregorianCalendar result = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = "";
			if (input != null) {
				strDate = sdf.format(input.getTime());
				Date dob = sdf.parse(strDate);
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(dob);
				result = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR),
						cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
			}

			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return anno scolastico di 6 cifre (e.g. 201314)
	 */
	public static int getAnnoScolasticoCorrente() {
		Calendar calendar = Calendar.getInstance();
		int annoCorrente = calendar.get(Calendar.YEAR);

		if (calendar.get(Calendar.MONTH) < Calendar.SEPTEMBER) {
			String tmp = String.valueOf(annoCorrente - 1) + String.valueOf(annoCorrente).substring(2);
			return Integer.parseInt(tmp);
		} else {
			String tmp = String.valueOf(annoCorrente) + String.valueOf(annoCorrente + 1).substring(2);
			return Integer.parseInt(tmp);
		}
	}

	public static Date getTodayDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	public static boolean isSecondariaDiPrimoGrado(String codScuUte) {
		boolean esito = false;
		if (codScuUte != null) {
			if (codScuUte.substring(2, 4).equals("MM") || codScuUte.substring(2, 4).equals("IC")) {
				esito = true;
			}
		}
		return esito;
	}

	public static boolean isSecondariaDiSecondoGrado(String codScuUte) {
		boolean esito = false;
		if (codScuUte != null) {
			if (codScuUte.substring(2, 4).equals("IS") || codScuUte.substring(2, 4).compareTo("MM") > 0) {
				esito = true;
			}
		}
		return esito;
	}

	public static boolean isPrimaria(String codScuUte) {
		boolean esito = false;
		if (codScuUte != null) {
			if (codScuUte.substring(2, 4).equals("EE") || codScuUte.substring(2, 4).equals("IC")) {
				esito = true;
			}
		}
		return esito;
	}

	public static boolean isInfanzia(String codScuUte) {
		boolean esito = false;
		if (codScuUte != null) {
			if (codScuUte.substring(2, 4).equals("AA")) {
				esito = true;
			}
		}
		return esito;
	}

	public static boolean isEmpty(String in) {
		return (in == null || in.trim().isEmpty());
	}

	public static String getCodDmdFromParam(String param) {
		String codDmd = StringUtils.remove(param, Constants.PREFIX_DOM);
		if (codDmd.indexOf(Constants.PREFIX_CODEDI) != -1) {
			codDmd = codDmd.substring(0, codDmd.indexOf(Constants.PREFIX_CODEDI));
		}
		return codDmd;
	}

	public static String getCodEdiFromParam(String param) {
		String codEdi = "";
		if (param.indexOf(Constants.PREFIX_CODEDI) != -1) {
			codEdi = param.substring(param.indexOf(Constants.PREFIX_CODEDI) + 9);
		}
		return codEdi;
	}

}
