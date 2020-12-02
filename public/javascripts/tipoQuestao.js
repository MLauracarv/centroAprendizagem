function definirBloco(){
	var select = document.getElementById('1');
		var option = select.options[select.selectedIndex];
		console.log(option);
		if (option.value == "objetiva") {
			document.getElementById("objetiva").style.display = "block";
			document.getElementById("discursiva").style.display = "none";
		} else if (option.value == "discursiva") {
			document.getElementById("discursiva").style.display = "block";
			document.getElementById("objetiva").style.display = "none";
		}
	}


function novaQuestao(){
	document.getElementById("newQuestao").style.display = "block";

}

