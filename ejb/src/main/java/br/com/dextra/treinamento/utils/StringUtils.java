package br.com.dextra.treinamento.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
	public String getDataFormatada(Date data) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    return data == null ? "NA" : sdf.format(data);
	}
}
