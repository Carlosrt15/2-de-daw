FROM node:18

WORKDIR  /app

COPY src/package*.json ./

RUN npm install

COPY src/ .

EXPOSE 3000

CMD [ "npm", "start"]

# docker build -t carlosrt15/node-visitas (crea la imagen)


# docker run -d --name node1 -p 3000:3000 carlosrt15/node-visitas
# -d (ejecutar en 2 plano) || --name asigna nombre al contenedor -p 3000:3000
