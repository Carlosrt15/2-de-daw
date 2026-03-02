FROM node:lts-alpine

# Instalar servidor estático
RUN npm install -g http-server

WORKDIR /app

# Copiar dependencias primero
COPY package*.json ./

RUN npm install

# Copiar resto del proyecto
COPY . .

# Generar build de producción
RUN npm run build

EXPOSE 8080

CMD ["http-server", "dist", "-p", "8080"]