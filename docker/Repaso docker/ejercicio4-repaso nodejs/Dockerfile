# Usamos una imagen oficial de Node en versión 18 (ligera con Alpine)
FROM node:18-alpine

# Definimos el directorio de trabajo dentro del contenedor
# Si no existe, Docker lo crea automáticamente
WORKDIR /app 

# Copiamos SOLO el package.json primero
# Esto nos permite aprovechar la caché si solo cambia el código
COPY src/package.json .

# Instalamos las dependencias definidas en package.json
# Esta instrucción se ejecuta al construir la imagen (docker build)
RUN npm install

# Copiamos el resto del proyecto (server.js, mensajes.txt, etc.)
# El primer . es la carpeta del host
# El segundo . es el directorio de trabajo actual (/app)
COPY src/ .

# Indicamos qué puerto usa la aplicación dentro del contenedor
# Esto es informativo (no abre el puerto automáticamente)
EXPOSE 3000

# Comando que se ejecutará cuando el contenedor arranque
# En este caso ejecuta el script "start" del package.json
CMD ["npm", "start"]