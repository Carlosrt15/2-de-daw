FROM node:lts-alpine

# Instalar servidor estático
RUN npm install -g http-server

WORKDIR /app

# Copiar dependencias primero
COPY package*.json ./

RUN npm install

# Copiar resto del proyecto
COPY . .
RUN npm run build
# Generar build de producción
ENV PORT=8080

EXPOSE $PORT

CMD ["sh", "-c", "http-server dist -p ${PORT}"]