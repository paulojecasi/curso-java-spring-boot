function GerarMatricula(){
	var txt = "ALU";
	var aleatorio = Math.floor(Math.random() * 6000);  // gerar um numero aleatorio inteiro
	document.getElementById('matricula').value = (txt + aleatorio);
	
}