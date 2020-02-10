//PRATICAL QUESTION 2


function generateExcuse(){
	let input1= document.getElementById("select1").value;
	
		
	let input2= document.getElementById("select2").value;

	
	let input3= document.getElementById("first").value;
	
	
	let input4= document.getElementById("second").value;


	
	let showIntup1=document.getElementById("oneInput");
	let showIntup2=document.getElementById("twoInput");
	let showIntup3=document.getElementById("ThreeInput");
	let showIntup4=document.getElementById("fourInput");
	
	showIntup1.innerHTML= input1;	
	showIntup2.innerHTML= input2;	
	showIntup3.innerHTML= input3;	
	showIntup4.innerHTML= input4;		
	
}

