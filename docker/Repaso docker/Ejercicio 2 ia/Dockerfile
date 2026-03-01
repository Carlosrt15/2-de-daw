FROM node:14

WORKDIR /app

COPY  package.json .

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "start"]



# Comando para crear la imagen y darle nombre 

# docker build -t carlosrt15/examen-node .

# ejecutar en el puerto 3000
 # docker run -p 3000:3000 carlosrt15/examen-node 