# 🐳 REPASO COMPLETO DOCKER – 2º DAW

Guía práctica con todos los comandos y estructura necesaria para el examen.

---

# 📦 DOCKERFILE NODEJS – ESTRUCTURA CORRECTA

```dockerfile
FROM node:18-alpine

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "start"]
```

---

# 🧠 CONCEPTOS CLAVE

RUN → Se ejecuta durante `docker build`  
CMD → Se ejecuta durante `docker run`  
EXPOSE → Solo documenta el puerto interno  
WORKDIR → Define la carpeta de trabajo dentro del contenedor  
COPY → Copia archivos del host al contenedor  

Formato COPY:

```dockerfile
COPY origen destino
```

Ejemplos:

```dockerfile
COPY package.json .
COPY src/ .
COPY . .
```

---

# 🏗 CREAR IMAGEN

```bash
docker build -t usuario/miapp:v1 .
```

Ver imágenes:

```bash
docker images
```

---

# 🚀 EJECUTAR CONTENEDOR

## Básico

```bash
docker run -p 3000:3000 usuario/miapp:v1
```

Formato:

```
HOST:CONTENEDOR
```

---

## En segundo plano

```bash
docker run -d -p 3000:3000 usuario/miapp:v1
```

---

## Con variable de entorno

```bash
docker run -e PORT=5000 -p 5000:5000 usuario/miapp:v1
```

---

## Eliminar automáticamente al parar

```bash
docker run --rm usuario/miapp:v1
```

---

## Modo interactivo

```bash
docker run -it usuario/miapp:v1
```

---

# 💾 VOLÚMENES

Crear volumen al ejecutar:

```bash
docker run -v volumen1:/app/data usuario/miapp:v1
```

Ver volúmenes:

```bash
docker volume ls
```

Eliminar volumen:

```bash
docker volume rm volumen1
```

Eliminar volúmenes no usados:

```bash
docker volume prune
```

---

# 🔄 CONTENEDORES

Ver activos:

```bash
docker ps
```

Ver todos:

```bash
docker ps -a
```

Parar:

```bash
docker stop ID
```

Eliminar:

```bash
docker rm ID
```

Forzar eliminar:

```bash
docker rm -f ID
```

---

# 🖼 IMÁGENES

Eliminar imagen:

```bash
docker rmi usuario/miapp:v1
```

Forzar:

```bash
docker rmi -f usuario/miapp:v1
```

Eliminar imágenes no usadas:

```bash
docker image prune -a
```

---

# 🏷 ETIQUETAS (TAG)

Renombrar imagen:

```bash
docker tag miapp usuario/miapp:v2
```

---

# 🧪 LOGS

Ver logs:

```bash
docker logs ID
```

Seguimiento en tiempo real:

```bash
docker logs -f ID
```

---

# ⚠ ERRORES TÍPICOS DE EXAMEN

- Usar latest en vez de versión concreta
- No reconstruir imagen tras cambiar Dockerfile
- Poner RUN en vez de CMD
- No mapear bien el puerto
- Montar volumen sobre todo /app sin querer
- No usar -d cuando lo piden en segundo plano

---

# 🎯 ORDEN CORRECTO EN EXAMEN

1️⃣ Crear Dockerfile  
2️⃣ docker build  
3️⃣ docker run  
4️⃣ Probar en navegador  
5️⃣ Ejecutar segundo contenedor  
6️⃣ Probar volumen  
7️⃣ Eliminar contenedores e imagen  

---

# 🧠 BUENAS PRÁCTICAS

✔ Usar versión concreta (node:18-alpine)  
✔ Copiar primero package.json  
✔ Instalar dependencias antes de copiar código  
✔ Solo un CMD  
✔ Usar volúmenes para persistencia  
✔ Separar build y run  

---

# 🔥 EXTRA ÚTIL

Construir con Dockerfile en otra carpeta:

```bash
docker build -f src/Dockerfile -t miapp src
```

---

Si dominas todo esto, estás preparado para un examen práctico real.