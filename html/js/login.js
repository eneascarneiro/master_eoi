var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validate(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if ( username == "luis" && password == "luis123"){
alert ("Login successfully");
window.location = "success.html"; // Redirecting to other page.
return false;
}
else{
attempt --;// Decrementing by one.
alert("You have left "+attempt+" attempt;");
// Disabling fields after 3 attempts.
if( attempt == 0){
document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
return false;
}
}
}

function sendEmail() {
    var toemail  = document.getElementById("email").value;
    Email.send({
      Host: "smtp.gmail.com",
      Username: "todojuegosparaperdertiempo@gmail.com",
      Password: "Estomacales55..",
      To: toemail,
      From: "todojuegosparaperdertiempo@gmail.com",
      Subject: "Sending Email using javascript",
      Body: "Contactanos",
    })
      .then(function (message) {
        alert("mail sent successfully")
      });
  }