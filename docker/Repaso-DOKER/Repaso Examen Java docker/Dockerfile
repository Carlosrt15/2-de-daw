# Imagen base con Java ya instalado
FROM eclipse-temurin

# Directorio de trabajo dentro del contenedor
# Todo lo que hagamos a partir de aquí será dentro de /app
WORKDIR /app

# Copiamos el código fuente desde la carpeta src del proyecto
# al directorio de trabajo del contenedor
COPY src/ .

# Creamos la carpeta donde se guardarán los datos
# (si no existe, el programa podría fallar)
RUN mkdir BBDD

# Compilamos el archivo Java
# Esto ocurre en tiempo de build (docker build)
RUN javac Main.java

# Indicamos qué comando se ejecutará cuando arranque el contenedor
# Esto ocurre en tiempo de ejecución (docker run)

EXPOSE 3000

CMD ["java", "Main"]