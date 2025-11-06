function verPassword() {
  let inputPassword = document.getElementById("password");
  let boton = document.getElementById("botonVer");

  if (inputPassword.type === "password") {
    inputPassword.type = "text";
    boton.textContent = "Ocultar";
  } else {
    // Volver a ocultar la contraseña
    inputPassword.type = "password";
    boton.textContent = "Ver"; 
  }
}
