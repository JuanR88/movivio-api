# MoviVio API
 
API backend para Movivio, una aplicación donde los usuarios pueden registrarse para votar y escribir comentarios sobre contenido. El contenido se obtiene desde la API de The Movie Database (TMDB), y en el futuro se integrarán funcionalidades de IA para recomendar títulos personalizados según los gustos de cada usuario, más allá de las valoraciones globales.
 

## Descripción del proyecto

Movivio es un proyecto personal enfocado en el desarrollo backend, donde se ha construido una API REST que permite gestionar contenido audiovisual, valoraciones y usuarios.

Está diseñado para ser escalable y evolucionar hacia un sistema de recomendaciones personalizadas, incluyendo en el futuro integración con IA.


## Tecnologías utilizadas
 
- Java 17
- Spring Boot (Spring Web, Data JPA)
- PostgreSQL
- Maven
 
## Funcionalidades actuales

- Gestión de contenido (películas/series)
- Creación de usuarios
- Sistema de valoraciones (reviews)
- Consulta de valoraciones por usuario y contenido
- Cálculo de media de valoraciones
- Sistema de ranking (top contenido)
- Uso de DTOs para estructurar respuestas
- Arquitectura en capas (Controller, Service, Repository)


## Endpoints disponibles

### Contenido

- `POST /content` → Crear contenido
- `GET /content` → Obtener todos los contenidos
- `GET /content/{id}` → Obtener detalles de un contenido
- `GET /content/{id}/media` → Obtener media de valoraciones
- `GET /content/top` → Obtener contenido mejor valorado


### Reviews

- `POST /review` → Crear una valoración
- `GET /users/{id}/reviews` → Obtener reviews de un usuario
- `GET /content/{id}/reviews` → Obtener reviews de un contenido


### Usuarios

- `POST /users` → Crear usuario
- `GET /users` → Obtener todos los usuarios
- `GET /users/{id}` → Obtener detalles de un usuario

## Cómo probar la API

Puedes probar los endpoints de la API utilizando herramientas como Postman.

Ejemplo:

GET http://localhost:8080/content
 
## Requisitos previos
 
- Java 17 instalado
- Maven instalado (o uso del wrapper `mvnw` / `mvnw.cmd` incluido en el proyecto)
- Base de datos PostgreSQL accesible (configuración en `application.properties` / `application.yml`)
- Clave de API de TMDB (cuando se integre la llamada real a la API)
 
## Instalación y ejecución
 
1. Clonar el repositorio o descargar el proyecto.
2. Situarse en la carpeta del proyecto `movivio-api`.
3. Compilar y ejecutar la aplicación:
 
   ```bash
   # Usando Maven instalado
   mvn spring-boot:run
 
   # O usando el wrapper (Windows)
   mvnw.cmd spring-boot:run
 
   # O usando el wrapper (Linux/Mac)
   ./mvnw spring-boot:run
   ```
 
Por defecto, la API se ejecutará en `http://localhost:8080` (puede variar según la configuración).
 

## Objetivo del proyecto
 
Movivio nace como un proyecto personal para el portafolio, pero con la intención de evolucionar hacia una aplicación lista para producción, donde:
 
- Los usuarios puedan crear una cuenta y autenticarse.
- Consultar películas y series obtenidas desde TMDB.
- Votar y dejar comentarios sobre los títulos.
- Recibir recomendaciones personalizadas basadas en sus gustos.
 
En fases futuras, se pretende integrar modelos de IA que analicen el historial de usuario para generar recomendaciones personalizadas.
 
## Futuras mejoras
 
- Autenticación y autorización de usuarios.
- Integración completa con la API de TMDB.
- Sistema de valoraciones y reseñas por usuario.
- Recomendador basado en IA según gustos e historial.
- Documentación de la API (por ejemplo, con Swagger / OpenAPI).
- Despliegue en un entorno en la nube (producción).
 
 

