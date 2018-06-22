import java.math.BigDecimal;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		BigDecimal bd = new BigDecimal("1");

		HashMap<String, String> mapa = new HashMap<>();
		mapa.put("um", "1");
		mapa.put("dois", "2");
		mapa.put("tres", "3");
		mapa.put("quatro", "4");
		mapa.put("cinco", "5");
		mapa.put("seis", "6");
		mapa.put("sete", "7");
		mapa.put("oito", "8");
		mapa.put("nove", "9");
		for (String key : mapa.keySet()) {
			Thread.sleep(mapa.size() * 73);
			System.out.println(Nmrlgia.numerologia(key));
		}
		int x = 0;
		for (int i = 1; i <= 999; i++) {
			if (i % 9 == 0) {
				x++;
				System.out.println(Nmrlgia.numerologia("" + i));
			}
		}
		System.out.println(x);
		System.out.println(Nmrlgia.numerologia("jones"));
	}

}