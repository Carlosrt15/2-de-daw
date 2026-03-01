const express = require("express");

const app = express();

// Usamos variable de entorno o 3000 por defecto
const PORT = process.env.PORT || 3000;

app.get("/", (req, res) => {
  res.send("🚀 Hola Mundo desde Docker! Carlos");
});

app.listen(PORT, () => {
  console.log(`Servidor funcionando en puerto ${PORT}`);
});