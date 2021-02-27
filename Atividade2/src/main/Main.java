package main;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
	public static void main(final String[] args) {
		HashMap<String, Integer> dicionarioFrases; // HashMap que será usado para armazenar as frases
		dicionarioFrases = new HashMap<String,Integer>();
		
		Util util = new Util();
		util.leituraDoArquivo(dicionarioFrases);
		
		// Ordenação inversa do HashMap para exibir apenas as frases que possuem maior frequência
		LinkedHashMap<String, Integer> dicionarioOrdenado = new LinkedHashMap<>();
		dicionarioFrases
			.entrySet()
	    	.stream()
	    	.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
	    	.forEachOrdered(x -> dicionarioOrdenado.put(x.getKey(), x.getValue()));
		
		// Loop que irá percorrer e exibir as 50000 frases mais frequentes do arquivo.txt
		int numeroDeFrases = 50000;
		int contador = 0;
		for (Map.Entry<String, Integer> entry : dicionarioOrdenado.entrySet()) {
			System.out.println("\tfrequencia = " + entry.getValue() +"\t "+ entry.getKey());
			contador++;
			if(contador == numeroDeFrases) {
				break;
			}	
		}
	}
}
