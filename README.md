# 🌦️ Meteo API

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue?logo=postgresql)
![Lombok](https://img.shields.io/badge/Lombok-enabled-blue?logo=java)
![Virtual Threads](https://img.shields.io/badge/Virtual%20Threads-Project%20Loom-lightgrey?logo=oracle)
![Build](https://img.shields.io/badge/build-passing-success?logo=githubactions)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![Swagger](https://img.shields.io/badge/API-OpenAPI%20%2F%20Swagger-blue?logo=swagger)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

A demo REST API for meteorological sensor simulation.  
Built with **Spring Boot 4.0.1**, **Java 21**, **PostgreSQL**, and modern technologies.  
Works together with the [Sensor Emulator](https://github.com/MyFreeIT/sensor-emulator).

---

## 🚀 Technologies

- ⚡ Java 21 — actual version of the platform
- 🌱 Spring Boot 4.0.1 — REST API framework
- 🧩 Lombok — reduces boilerplate code
- 🔀 MapStruct — DTO ↔ Entity mapping
- 🗄️ Spring Data JPA + PostgreSQL — database integration
- 🔄 Liquibase — database migrations
- 📖 Swagger/OpenAPI — automatic API documentation
- 🌀 Virtual Threads (Project Loom) — lightweight concurrency
- ✅ Validation — input data checking
- 📅 JPA Auditing — timestamps for entities

---

## 📡 Functional

- Register sensors
- Add measurements
- Get all measurements (wrapped in `MeasurementsResponse`)
- Count rainy days
- Database schema managed with Liquibase

---

## 🛠️ Launching

### Prerequisite

The API requires **PostgreSQL** running locally.

Create database:

```postgresql
CREATE
    DATABASE meteo_db;
```

Liquibase will apply migrations automatically.

### Assembly

```bash
mvn clean install
```

### Run the API

```bash
mvn spring-boot:run
```

The API will be available at:
👉 http://localhost:8080

Swagger UI:
👉 http://localhost:8080/swagger-ui/index.html

OpenAPI spec:
👉 http://localhost:8080/v3/api-docs
---

## 📚 API Endpoints

| Method   | URL                            | Description           | Request Body     | Response               |
|----------|--------------------------------|-----------------------|------------------|------------------------|
| **POST** | `/sensors/registration`        | Register a new sensor | `SensorDto`      | `String`               |
| **POST** | `/measurements/add`            | Add a measurement     | `MeasurementDto` | `MeasurementDto`       |
| **GET**  | `/measurements`                | Get all measurements  | —                | `MeasurementsResponse` |
| **GET**  | `/measurements/rainyDaysCount` | Count rainy days      | —                | `Long`                 |

### 📖 Request Examples

Register a sensor:

```bash
curl -X POST http://localhost:8080/sensors/registration \
  -H "Content-Type: application/json" \
  -d '{"name":"sensor-1"}'
```

Add a measurement:

```bash
curl -X POST http://localhost:8080/measurements/add \
  -H "Content-Type: application/json" \
  -d '{"value":23.5,"raining":true,"sensorDto":{"name":"sensor-1"}}'
```

Get all measurements:

```bash
curl -X GET http://localhost:8080/measurements
```

Count rainy days:

```bash
curl -X GET http://localhost:8080/measurements/rainyDaysCount
```

---

## 📜 License

This project is licensed under the **MIT** License.  
Author: **Denis Odesskiy (MyFreeIT)**  
Website: [myfreeit.github.io](https://myfreeit.github.io/)  
See the full license text in the [LICENSE](./LICENSE) file.
