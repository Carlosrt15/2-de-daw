# 1️⃣ Imagen base
FROM node:lts-alpine

# 2️⃣ Instalar http-server globalmente
RUN npm install -g http-server

# 3️⃣ Directorio de trabajo
WORKDIR /app

# 4️⃣ Copiar dependencias primero (optimiza capas)
COPY package*.json ./

RUN npm install

# 5️⃣ Copiar el resto del proyecto
COPY . .

# 6️⃣ Generar carpeta dist
RUN npm run build

# 7️⃣ Exponer puerto (por defecto http-server usa 8080)
EXPOSE 8080

# Variable de entorno por defecto lo pide el ejercicio parte 2
ENV PORT=8080

# 8️⃣ Ejecutar servidor sobre dist parte 1
# CMD ["http-server", "dist"]

# Ejecutar usando la variable APRTE 2
CMD ["sh", "-c", "http-server dist -p $PORT"]