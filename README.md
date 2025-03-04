# Instrucciones para ejecutar la API
Este proyecto contiene diferentes ejercicios de API REST desarrollados con Spring Boot.

📌 Requisitos

Java 17 o superior

Maven 3.8+

Postman o cURL para probar la API


🚀 Cómo ejecutar la API

Clona el repositorio:

git clone <URL_DEL_REPOSITORIO>

Entra en el directorio del proyecto:

cd proyecto

Compila y ejecuta el proyecto con Maven:

mvn spring-boot:run

La API se ejecutará en http://localhost:8080.


🔄 Cambiar entre ejercicios

Para cambiar el ejercicio que se ejecuta, modifica la anotación @ComponentScan en ProyectoApplication.java:

@ComponentScan(basePackages = "com.apirest.proyecto.ejercicioX")  // Reemplaza X por el número del ejercicio

Después de hacer el cambio, reinicia la aplicación.


📡 Endpoints Disponibles

Ejemplo de Endpoints en ejercicio4

Obtener productos:

GET /api/productos

Respuesta esperada:

[
  { "id": 1, "nombre": "Laptop", "precio": 1200 },
  { "id": 2, "nombre": "Mouse", "precio": 25 }
]


🛠 Pruebas

Para ejecutar las pruebas, usa:

mvn test

🐜 Licencia

Este proyecto es de uso académico.