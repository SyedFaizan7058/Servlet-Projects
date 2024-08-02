/**
 * 
 */

function validateForm() {
	
	var phoneNumber = document.getElementById("phno").value;
	if (phoneNumber.length != 10) {
		alert("Phone number must be 10 digits long");
		return false;
	}

	var email = document.getElementById("mid").value;
    var emailPattern = /@gmail\.com$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address");
        return false;
    }

    return true; 
}