//	QUESTION A
function factorial(n){
	var result = 1;
	if(n < 0){
		return "ERROR: not positive";
	}
	else{
		if(n == 0){
			return 1;
		}
		else{
			for( var i = 0; i < n; n--){
				
				result *= n;	
			}
			return result;
		}
	}
}



//QUESTION B
function choose(n,k){
	 
	if(n < 0 || k < 0 || k > n){
		return "ERROR: n smaller than k";
	}
	else{
		var partN = factorial(n);
		var partK = factorial(k);
		var b = n-k;
		var partB = factorial(b);
		var solution = partN / (partK * partB);
	
		return solution;
	}
}
