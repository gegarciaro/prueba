
function ejemploConexion() {
	// Create a request variable and assign a new XMLHttpRequest object to it.
	var request = new XMLHttpRequest()
	// Open a new connection, using the GET request on the URL endpoint
	request.open('GET', 'https://ghibliapi.herokuapp.com/films', true)
	request.onload = function () {
		// Begin accessing JSON data here
		var data = JSON.parse(this.response);
		if (request.status >= 200 && request.status < 400) {
			data.forEach(movie => {
				console.log(movie.title);
			});
		} else {
			console.log("error al llamar al servicio");
		}
	}

	// Send request
	request.send();
}

function getData() {
	var request = new XMLHttpRequest();
	request.open('GET', 'http://localhost:8080/servicioRESTwa/webresources/example', true);
	request.onload = function () {
		var data = JSON.parse(this.response);
		console.log('tengo data: ', data);
		if (request.status >= 200 && request.status < 400) {
			data.forEach(unValor => {
				console.log(unValor.string + ' ' + unValor.value);
			});
		} else {
			console.log("error al llamar al servicio");
		}
	}
	request.send();
}



///// 

function getChallenge() {
	var request = new XMLHttpRequest();
	request.open('GET', 'https://ucmabacentro.ddns.net:8089/api?action=challenge&user=cdrapi', true);
	request.onload = function () {
		var data = JSON.parse(this.response);
		console.log('tengo data: ', data);
		if (request.status >= 200 && request.status < 400) {
			data.forEach(unValor => {
				console.log(unValor.string + ' ' + unValor.value);
			});
		} else {
			console.log("error al llamar al servicio");
		}
	}
	request.send();
}
