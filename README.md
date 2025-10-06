
# 📚 Calculator Service

Este proyecto es una API REST que expone un sólo endpoint:

- `/add` → suma dos números.  
- `/subtract` → resta dos números.  

Además, implementa una librería para trazar sus resultados.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.6
- Maven
- OpenAPI / Swagger UI

## 📦 Requisitos previos

- Java JDK 17+
- Maven 3.8+

## 🛠️ Descarga del repositorio e instalación

1. Clonar el repositorio:
   
```bash
   git clone https://github.com/luciofernandez/calculator.git
```
 
2. Compilar el proyecto completo:

```bash
mvn clean install
```
   

## ▶️ Ejecución

Puedes ejecutar el proyecto de las siguiente manera:

```bash
mvn spring-boot:run
```

Por defecto se levantará en el puerto 8080.

## ▶️ Ejecutar tests

Puedes ejecutar sólo los test de la siguiente manera

```bash
mvn test
```

## ▶️ Pruebas

```bash
curl -X POST "http://localhost:8080/add?a=5&b=3"
curl -X POST "http://localhost:8080/subtract?a=5&b=3"
```

## ▶️ Swagger

La documentación Swagger estará disponible en:

```bash
http://localhost:8080/swagger-ui.html
```
