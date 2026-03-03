FROM node:18

WORKDIR /app

# copiara los 2 json el ./
COPY  package*.json ./ 

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm","start"]