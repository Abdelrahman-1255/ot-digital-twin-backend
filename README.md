# OT Digital Twin Backend

A Spring Boot REST API for managing industrial assets and sensor readings in an OT (Operational Technology) digital twin system.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.1**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Maven**

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.6+

### Running the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or on Windows
mvnw.cmd spring-boot:run
```

The server will start on `http://localhost:8080`

## API Endpoints

### Assets

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/assets` | Get all assets |
| GET | `/api/assets/{id}` | Get asset by ID |
| POST | `/api/assets` | Create a new asset |
| PUT | `/api/assets/{id}` | Update an asset |
| DELETE | `/api/assets/{id}` | Delete an asset |

### Sensor Readings

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/sensor-readings` | Get all sensor readings |
| GET | `/api/sensor-readings/{id}` | Get reading by ID |
| GET | `/api/sensor-readings/asset/{assetId}` | Get readings by asset |
| GET | `/api/sensor-readings/asset/{assetId}/latest` | Get latest reading for asset |

## Scheduler

The application includes an automated **SimulationService** that generates sensor data:

- **Runs every 5 seconds** (`@Scheduled(fixedDelay = 5000)`)
- Generates random **temperature** readings (50-100°C)
- Generates random **pressure** readings (900-1100 kPa)
- Randomly updates **asset status**
- Automatically persists readings to the database

This simulates real-time OT sensor data for testing and demonstration purposes.

## H2 Console

Access the H2 database console at: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:controlpointdb`
- **Username:** `sa`
- **Password:** *(empty)*
