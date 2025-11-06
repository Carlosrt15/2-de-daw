function set_background() {
  let body = document.getElementsByTagName("body")[0];

  let elementosbody = body.getElementsByTagName("p");

  let p1 = elementosbody[0];
  let p2 = elementosbody[1];
  p2.setAttribute("class","black");

  // Cambia de color cada click

  if (p1.getAttribute("class") === "rojo") {
    p1.setAttribute("class", "azul");
  } else {
    p1.setAttribute("class", "rojo");
  }
}
