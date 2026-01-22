# 📸 Galería de Imágenes – Vue 3

## 🧩 Descripción del ejercicio

Crea una pequeña aplicación con Vue 3 que muestre una galería de imágenes y permita seleccionar una imagen haciendo click.

---

## 🎯 Requisitos

La aplicación debe cumplir lo siguiente:

- Mostrar varias imágenes en pantalla
- Cada imagen debe mostrar su nombre
- Al hacer click sobre una imagen:
  - Quede marcada como seleccionada
  - Solo una imagen puede estar seleccionada a la vez
- La imagen seleccionada debe tener:
  - Borde rojo
- Las imágenes no seleccionadas deben tener:
  - Borde gris
- Debajo de la galería se debe mostrar:
  - El nombre de la imagen seleccionada
  - Si no hay ninguna seleccionada, no mostrar nada

---

## 🛠 Tecnologías

- HTML
- CSS
- JavaScript
- Vue 3 (Composition API)

---

## 📁 Estructura sugerida


---

## 🧠 Pistas

### 1️⃣ Datos
- Guarda las imágenes en un array
- Cada imagen debe tener:
  - nombre
  - url
  - un estado para saber si está seleccionada (true / false)

---

### 2️⃣ Mostrar imágenes
- Usa `v-for` para recorrer el array
- Usa `:src` y `:alt` en las imágenes
- No olvides el atributo `:key`

---

### 3️⃣ Selección con click
- Usa `@click` sobre la imagen
- Crea una función que:
  - Marque la imagen pulsada como seleccionada
  - Desmarque todas las demás

Pista:
- Recorre el array y compara cada imagen con la que se ha pulsado

---

### 4️⃣ Clases dinámicas
- Usa `:class` para cambiar el borde
- Una clase para la imagen seleccionada
- Otra para la imagen no seleccionada

Pista:
```html
:class="{ seleccionada: condicion }"
