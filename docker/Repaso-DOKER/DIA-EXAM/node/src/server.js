const express = require("express");
const fs = require("fs");
const app = express();

const PORT = process.env.PORT || 3000;

app.get("/", (req, res) => {
    fs.appendFileSync("logs/visitas.txt", "Nueva visita\n");
    res.send("Servidor activo");
});

app.listen(PORT, () => {
    console.log("Servidor escuchando en puerto " + PORT);
});