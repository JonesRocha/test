import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nmrlgia {

	private static int numerologiaAplicada(String numeroOuPalavra) {
		String regex = removerCaractersEspeciais(Normalizer.normalize(numeroOuPalavra.toUpperCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
		int index = 0;
		for (char f : regex.toCharArray()) {
			if (Character.isAlphabetic(f)) {
				index += numerologiaAplicada(Integer.toString(Character.getNumericValue(f)));
			} else {
				index += Character.getNumericValue(f);
			}
		}
		if (Integer.toString(index).length() > 1) {
			return numerologiaAplicada(Integer.toString(index));
		} else {
			return index;
		}
	}

	public static String numerologia(int numeroOuPalavra) {
		return numeroOuPalavra + " = " + numerologiaAplicada("" + numeroOuPalavra);
	}

	public static String numerologia(String numeroOuPalavra) {
		return numeroOuPalavra + " = " + numerologiaAplicada(numeroOuPalavra);
	}

	private static String removerCaractersEspeciais(String palavra) {
		Pattern numericos = Pattern.compile("[0-9a-z]",Pattern.CASE_INSENSITIVE);
		Matcher encaixe = numericos.matcher(palavra.toUpperCase());
		StringBuffer saida = new StringBuffer();
		while (encaixe.find()) {
		   saida.append(encaixe.group());
		}
		return saida.toString();
	}

	public static int numerologiaData(Date data) {
		return numerologiaAplicada(new SimpleDateFormat("ddMMyyyy").format(data));
	}
}
