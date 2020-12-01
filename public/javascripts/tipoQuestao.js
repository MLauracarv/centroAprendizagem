var select = document.querySelector('select');

select.addEventListener('change', setTipoQuestao);

function definirTipo(){
	var bloco = document.getElementById("teste");
	var escolha = select.value;
	var tipos = document.getElementsByClass(); 
	
	
			if(escolha === "objetiva") {
			bloco.innerHTML = "" + tipos[0] + "";
			}
	
	else{
		bloco.setAttribute("class", tipos[1]);
		eeee
	}
}