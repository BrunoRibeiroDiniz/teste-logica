// Bruno Ribeiro Diniz 23/02/2021
// Teste de Lógica
// Atividade 1: Verificação de Palíndromos

// Função responsável por montar a verificação de acordo com as exigências do usuário.
$("#verificar").on("click", function(){
	var palavra = "";
	var ignoraCaseSensitive = 0;	
	var ignoraEspacos = 0;
	var resultado = false;

	if(document.getElementById("palavra").value == ""){
		alert("Palavra inválida!")
		return;
	}

	palavra = document.getElementById("palavra").value;
	if(document.getElementById("caseSensitive").checked){
		ignoraCaseSensitive = 1;
	}
	if(document.getElementById("ignoraEspacos").checked){
		ignoraEspacos = 1;
	}
	// Direcionamento para a função de verificação escolhida
	if(document.getElementById("funcao1").checked){
		resultado = verificaPalindromo1(palavra, ignoraCaseSensitive, ignoraEspacos);		
	}
	if(document.getElementById("funcao2").checked){
		resultado = verificaPalindromo2(palavra, ignoraCaseSensitive, ignoraEspacos);	
	}
	if(resultado == true){
		alert("Palavra é um palíndromo!");
	} else{
		alert("Palavra não é um palíndromo!");
	}	
});	

// Bruno Ribeiro Diniz - 23/02/2021
// Função para verificar se uma palavra é ou não um palíndromo. 
// Utilizando funções prontas da biblioteca de String para a comparação.
// Retorna true se a palavra for um palíndromo e false se não for.
function verificaPalindromo1(palavra, ignoraCaseSensitive, ignoraEspacos){
	var palavraTratada = palavra;	// Variável que irá receber as alterações de tratamento de acordo com os parâmetros requisitados.
	var palavraInvertida = ""; 		// Variável que irá receber a palavra tratada e invertida para realizar a comparação.  
    
	// Converte toda a palavra para letras minúsculas se a opção de "ingnorar Case Sensitive" for marcada
	if(ignoraCaseSensitive == 1){
		palavraTratada = palavraTratada.toLowerCase();
	}
	// Retira todos os espaços em branco se a opção "ignorar espaços em branco" for marcada
	if(ignoraEspacos == 1){
		palavraTratada = palavraTratada.replace(/ /g,"");
	}
	palavraInvertida = palavraTratada.split("").reverse().join("");
	if(palavraTratada == palavraInvertida){
		return true;
	} else{
		return false;
	}
}

// Bruno Ribeiro Diniz - 23/02/2021
// Função para verificar se uma palavra é ou não um palíndromo. 
// Sem a utilização das funções prontas da biblioteca de String para a comparação.
// Retorna true se a palavra for um palíndromo e false se não for.
function verificaPalindromo2(palavra, ignoraCaseSensitive, ignoraEspacos){
	var palavraTratada = palavra;	// Variável que irá receber as alterações de tratamento de acordo com os parâmetros requisitados.
	var contadorInicio = 0;
	var contadorFinal = 0;

	// Converte toda a palavra para letras minúsculas se a opção de "ingnorar Case Sensitive" for marcada
	if(ignoraCaseSensitive == 1){
		palavraTratada = palavraTratada.toLowerCase();
	}
	// Retira todos os espaços em branco se a opção "ignorar espaços" for marcada
	if(ignoraEspacos == 1){
		palavraTratada = palavraTratada.replace(/ /g,"");
	}

	contadorFinal = palavraTratada.length - 1;
	// Loop encarregado de percorrer a palavra das extremidades até o meio.
	for(contadorInicio = 0; contadorInicio <= contadorFinal; contadorInicio++){
		if(palavraTratada[contadorInicio] != palavraTratada[contadorFinal]){
			return false;
		}
		contadorFinal--;
	}
	return true;
}