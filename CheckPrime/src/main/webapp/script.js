/**
 * 
 */

 function checkNumber(){
	 var number = document.getElementById("number").value;
	 
	 if(number<=0){
		 alert("Number Must be Greater than Zero (0)")
		 return false;
	 }else{
		 return true;
	 }
 }