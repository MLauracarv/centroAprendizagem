function desenharPecas() {
	   var classes = ["blueCanvas", "redCanvas", "greenCanvas", "yellowCanvas"];
	   var cores = ["#0000CD", "#FF0000", "#32CD32	", "#FFA500"];
	   for (var contad = 0; contad < classes.length; contad++) {
	        var canvas = document.getElementsByClassName(classes[contad]);
		    for (var c = 0; c < canvas.length; c++) {
			    var context = canvas[c].getContext("2d");
  			   context.beginPath();
 			    context.arc(140, 75, 75, 0, 2 * Math.PI);
 			    context.fillStyle = cores[contad];  				
  			   context.fill();
  			   context.stroke();
  		    }
  	    }
    }

    var posicao_X, posicao_Y;
    var direcao_X, direcao_Y;
    var velocidade;
    var peca;
    var anima;

    function inicia(pontos, cor, peca, inicio) {
        var posicao_X = inicio.getBoundingClientRect().x;
        var posicao_Y = inicio.getBoundingClientRect().y;
        var velocidade = 5;
        var direcao_X = 0;
        var direcao_Y = 0;
        var peca = pecas;
        animarPecas(pontos, cor, peca);
    }

    function animarPecas(pontos, cor, peca) {
        /*Mapeamentos*/
        /*
        var classes = ["blueCanvas", "redCanvas", "greenCanvas", "yellowCanvas"];
        var cores_palavras = ["verde", "amarelo", "vermelho", "azul"] 
        var quadradosPecas = document.getElementsByClassName(); 
        */

        var celulasInicio = document.querySelectorAll(".b-start, .r-start, .g-start, .y-start");
        console.log("*** Coordenada das celulas iniciais ***");
        for (var c = 0; c < celulasInicio.length; c++) {
            console.log(celulasInicio[c].getBoundingClientRect());
        }

        var celulasDestaque1 = document.querySelectorAll(".bcr, .bcg, .bcb, .bcy");
        console.log("*** Coordenada das células de destaque***");
        for (var c = 0; c < celulasDestaque1.length; c++) {
            console.log(celulasDestaque1[c].getBoundingClientRect());

        }

        var home = document.getElementsByClassName("home");
        console.log("*** Coordenada da home ***");
        for (var c = 0; c < home.length; c++) {
            console.log(home[c].getBoundingClientRect());
        }

        console.log("*** Coordenadas das peças azuis ***");
        var coordenadasPecasAzuis = document.getElementsByClassName("blueCanvas");
        for (var c = 0; c < coordenadasPecasAzuis.length; c++) {
            console.log(coordenadasPecasAzuis[c].getBoundingClientRect());
        }
        
        console.log("*** Coordenadas das peças vermelhas ***");
        var coordenadasPecasVermelhas = document.getElementsByClassName("redCanvas");
        for (var c = 0; c < coordenadasPecasVermelhas.length; c++) {
            console.log(coordenadasPecasVermelhas[c].getBoundingClientRect());
        }
        

        console.log("*** Coordenadas das peças verdes ***");
        var coordenadasPecasVerdes = document.getElementsByClassName("greenCanvas");
        for (var c = 0; c < coordenadasPecasVerdes.length; c++) {
            console.log(coordenadasPecasVerdes[c].getBoundingClientRect());
        }
        
       console.log("*** Coordenadas das peças amarelas ***");
        var coordenadasPecasAmarelas = document.getElementsByClassName("yellowCanvas");
        for (var c = 0; c < coordenadasPecasAmarelas.length; c++) {
            console.log(coordenadasPecasAmarelas[c].getBoundingClientRect());
        }
         /*Fim dos mapeamentos*/

       
        
        if (cor == "#0000CD") {
            if (pontos >= 4) {
                let posicoes_iniciais = document.getElementsByClassName("initial-blue");
                for (var c = 0; c < posicoes_iniciais.length; c++) {
                    if (peca.getBoundingClientRect().x == posicoes_iniciais[c].getBoundingClientRect().x) {
                        if (peca.getBoundingClientRect().y == posicoes_iniciais[c].getBoundingClientRect().y) {
                            direcao_Y = -1;
                            /*
                            peca.getBoundingClientRect().x = 49;
                            peca.getBoundingClientRect().x = 337;
                            */
                            posicao_Y += (direcao_Y * velocidade);
                            peca.style.top = posicao_Y + "px";
                            /*
                            peca.style.left = posicoes_iniciais[c].getBoundingClientRect().x + "px";
                            peca.style.top = posicoes_iniciais[c].getBoundingClientRect().y + "px"
                            */ 
                        }
                    }

                }
            }
           
        } else if (cor == "#FF0000") {
            if (pontos >= 4) {
    
            }
        } else if (cor == "#32CD32") {
            if (pontos >= 4) {

            }
        } else if (cor == "#FFA500") {
            if (pontos >= 4) {
                
            }
        }
     
        anima = requestAnimationFrame(animarPecas);

        /*
        var celulasDestaque1 = document.getElementsByClassName("");
        var celulasDestaque1 = document.getElementsByClassName("");
        var celulasDestaque1 = document.getElementsByClassName("");
        */
    }

    function main() {
        pecasAzuis = document.getElementsByClassName("blueCanvas");
        desenharPecas()
        animarPecas(4 ,"#0000CD", pecasAzuis[0]);
        alert(document.getElementsByClassName("blueCanvas")[0].getBoundingClientRect().y);
        window.addEventListener("load",inicia);

    }

    main()
