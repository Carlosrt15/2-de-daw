const express = require("express");
const fs = require("fs");

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware para leer JSON
app.use(express.json());

// Ruta principal
app.get("/", (req, res) => {
  res.send("🚀 Servidor funcionando correctamente");
});

// Guardar mensaje
app.post("/mensaje", (req, res) => {
  const mensaje = req.body.mensaje;

  if (!mensaje) {
    return res.status(400).send("Debe enviar un mensaje");
  }

  fs.appendFileSync("mensajes.txt", mensaje + "\n");
  res.send("Mensaje guardado correctamente");
});

// Ver mensajes
app.get("/mensajes", (req, res) => {
  if (!fs.existsSync("mensajes.txt")) {
    return res.send("No hay mensajes aún");
  }

  const datos = fs.readFileSync("mensajes.txt", "utf8");
  res.send(`<pre>${datos}</pre>`);
});

app.listen(PORT, () => {
  console.log(`Servidor escuchando en puerto ${PORT}`);
});