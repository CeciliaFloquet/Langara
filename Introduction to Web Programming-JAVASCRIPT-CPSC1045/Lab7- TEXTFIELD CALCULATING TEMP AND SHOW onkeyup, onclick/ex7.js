//when click in button call this function
function convertF(){
	//
	let textCelsius = document.getElementById("celsius");
	
	//if is not number display error	
	if(isNaN (textCelsius.value)){
			document.getElementById("display1").innerHTML = "This program just accept numbers";
	}
	else{
		//Assign the value of celsius/calculating/display
		let celsius = Number(textCelsius.value);
		let fahr= celsius * 9/5 + 32;
		
		let display=document.getElementById("display1");
		display.innerHTML = fahr + " degrees F";
	}
}
//when writing call this function
function convertC(){
	let textFahr = document.getElementById("convertC");
	
	//if is not number display error	
	if(isNaN (textFahr.value)){
		document.getElementById("display2").innerHTML = "This program just accept numbers";
	}
	//when I erase the input/empty
	else if(textFahr.value == ""){
		document.getElementById("display2").innerHTML = "Your Celsius will be displayed here";
	}
	else{
		//Assign the value of Fahrenheit/calculating/display
		let fahr = Number(textFahr.value);
		let celsius= (fahr - 32) * 5/9;
		
		document.getElementById("display2").innerHTML = celsius + " degrees C";
	}
}