package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Util {
	
	//Função responsável por realizar a leitura do arquivo.txt
	//Recebe como parâmetro o HashMap que será usado para armazenar as frases
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
	
	// Função responsável por incluir as frases no HashMap
	// Recebe como parâmetro o HashMap para ser atualizado
	// Recebe também uma linha do arquivo separada por frases que serão utilizadas para atualizar o HashMap
	private void atualizaFrequencia(HashMap<String, Integer>dicionarioFrases, String[] linhaSeparada) {
    	String chaveFrase = "";	// Frase que servirá como "chave" no HashMap
    	int i;
    	int tamanhoLinha = 0;
    	Integer frequencia = 0;
    	
    	// Loop que irá analisar frase por frase de cada linha do arquivo
    	// Frases já presentes no HashMap terão sua frequência incrementada
    	// Frases não presentes serão adicionadas
    	tamanhoLinha = linhaSeparada.length;
    	for(i=0; i<tamanhoLinha; i++) {
    		chaveFrase = linhaSeparada[i];
    		frequencia = dicionarioFrases.get(chaveFrase); 
    	  					     
    		if (frequencia != null) { // Caso a frase exista, aumenta a frequência
				dicionarioFrases.put(chaveFrase, frequencia+1);
			}
			else {	// Caso não exista, cria a nova frase no HashMap
				dicionarioFrases.put(chaveFrase,1);
			}
    	}	
	}
}
