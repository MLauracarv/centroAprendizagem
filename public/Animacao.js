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