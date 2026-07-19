# MoviVio API

MoviVio API es una API REST desarrollada con Java y Spring Boot para gestionar contenido audiovisual, usuarios y valoraciones.

Se trata de un proyecto personal orientado al desarrollo backend, diseñado para aplicar buenas prácticas de programación y evolucionar hacia una plataforma completa de recomendaciones de películas y series mediante la integración con The Movie Database (TMDB) y, en futuras versiones, modelos de Inteligencia Artificial.

---

## Descripción

El objetivo de MoviVio es ofrecer una plataforma donde los usuarios puedan:

- Consultar películas y series.
- Registrarse en la aplicación.
- Publicar valoraciones y comentarios.
- Descubrir contenido recomendado según sus preferencias.

Actualmente el proyecto se centra en el desarrollo de una arquitectura backend sólida, escalable y preparada para futuras funcionalidades.

---

## Tecnologías

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Git
- GitHub

---

## Arquitectura

El proyecto sigue una arquitectura en capas para facilitar el mantenimiento y la escalabilidad.

```
Controller
│
Service
│
Repository
│
PostgreSQL
```

También se utilizan DTOs para desacoplar las entidades de las respuestas de la API.

---

## Funcionalidades implementadas

- Gestión de contenido audiovisual.
- Gestión de usuarios.
- Sistema de valoraciones.
- Consulta de valoraciones por usuario.
- Consulta de valoraciones por contenido.
- Cálculo de la valoración media de cada contenido.
- Ranking del contenido mejor valorado.
- Arquitectura en capas.
- Uso de DTOs.
- Persistencia mediante Spring Data JPA.

---

## Endpoints

### Contenido

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| POST | `/content` | Crear contenido |
| GET | `/content` | Obtener todos los contenidos |
| GET | `/content/{id}` | Obtener un contenido |
| GET | `/content/{id}/media` | Obtener valoración media |
| GET | `/content/top` | Obtener contenido mejor valorado |

### Usuarios

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| POST | `/users` | Crear usuario |
| GET | `/users` | Obtener usuarios |
| GET | `/users/{id}` | Obtener un usuario |

### Reviews

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| POST | `/review` | Crear valoración |
| GET | `/users/{id}/reviews` | Obtener valoraciones de un usuario |
| GET | `/content/{id}/reviews` | Obtener valoraciones de un contenido |

---

## Instalación

### Requisitos

- Java 17
- Maven
- PostgreSQL

### Clonar el repositorio

```bash
git clone https://github.com/JuanR88/movivio-api.git
cd movivio-api
```

### Ejecutar la aplicación

Con Maven:

```bash
mvn spring-boot:run
```

O utilizando el wrapper incluido:

Windows

```bash
mvnw.cmd spring-boot:run
```

Linux / macOS

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en:

```
http://localhost:8080
```

---

## Cómo probar la API

Puedes utilizar herramientas como Postman o Insomnia.

Ejemplo:

```
GET http://localhost:8080/content
```

---

## Roadmap

Próximas funcionalidades previstas:

- Integración completa con TMDB.
- Autenticación mediante JWT.
- Autorización por roles.
- Documentación con Swagger / OpenAPI.
- Validaciones globales.
- Manejo centralizado de excepciones.
- Docker.
- Tests unitarios.
- Despliegue en la nube.
- Sistema de recomendaciones basado en IA.

---

## Objetivo

MoviVio nace como un proyecto de aprendizaje y portafolio para consolidar conocimientos en desarrollo backend con Java y Spring Boot.

El objetivo es evolucionarlo progresivamente hasta convertirse en una aplicación completa, escalable y preparada para un entorno de producción.

---

## Autor

Juan Rafael Rodríguez Gómez

Junior Java Backend Developer

GitHub:
https://github.com/JuanR88

LinkedIn:
www.linkedin.com/in/juan-rodg88
