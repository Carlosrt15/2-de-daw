document.addEventListener("submit", function (e) {
  const form = e.target;
  if (!form.checkValidity()) {
    e.preventDefault();
    form.classList.add("was-validated");
  }
});
