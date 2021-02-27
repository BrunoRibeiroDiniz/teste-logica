package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Util {
	
	//Fun��o respons�vel por realizar a leitura do arquivo.txt
	//Recebe como par�metro o HashMap que ser� usado para armazenar as frases
	public void leituraDoArquivo(HashMap<String, Integer> dicionarioFrases){
		try {
			FileInputStream arquivo = new FileInputStream("arquivo.txt");
			InputStreamReader leitor = new InputStreamReader(arquivo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha;
			String[] linhaSeparada;
			do {
				linha = buffer.readLine();
				if(linha != null) {
					linhaSeparada = linha.split("\\|");
					atualizaFrequencia(dicionarioFrases, linhaSeparada);
				}
			}while(linha != null);
			buffer.close();
		}
		catch(Exception e) {
			System.out.println("Falha na leitura do arquivo!");
		}
	}
	
	// Fun��o respons�vel por incluir as frases no HashMap
	// Recebe como par�metro o HashMap para ser atualizado
	// Recebe tamb�m uma linha do arquivo separada por frases que ser�o utilizadas para atualizar o HashMap
	private void atualizaFrequencia(HashMap<String, Integer>dicionarioFrases, String[] linhaSeparada) {
    	String chaveFrase = "";	// Frase que servir� como "chave" no HashMap
    	int i;
    	int tamanhoLinha = 0;
    	Integer frequencia = 0;
    	
    	// Loop que ir� analisar frase por frase de cada linha do arquivo
    	// Frases j� presentes no HashMap ter�o sua frequ�ncia incrementada
    	// Frases n�o presentes ser�o adicionadas
    	tamanhoLinha = linhaSeparada.length;
    	for(i=0; i<tamanhoLinha; i++) {
    		chaveFrase = linhaSeparada[i];
    		frequencia = dicionarioFrases.get(chaveFrase); 
    	  					     
    		if (frequencia != null) { // Caso a frase exista, aumenta a frequ�ncia
				dicionarioFrases.put(chaveFrase, frequencia+1);
			}
			else {	// Caso n�o exista, cria a nova frase no HashMap
				dicionarioFrases.put(chaveFrase,1);
			}
    	}	
	}
}
