FROM node:18

WORKDIR /app

COPY  package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm","start"]


# CMD ["node", "server.js"] si no hay script en package json (poner en caso de duda en node)

 #docker run --name contenderonode23 -p 3001:3000 -v volLogs:/app/logs usuario/node_visitas:v2