# Convertly - Unit Converter REST API

Convertly is a RESTful API built with Spring Boot for converting units across temperature, length, weight, and time. Designed for developers, it offers clean endpoints, input validation, and detailed conversion explanations.

## Features

- **Unit Conversion:** Convert values between supported units (e.g., Celsius to Fahrenheit, Meter to Mile).
- **Categories & Units:** List available categories and units.
- **Sample Payload:** Get a sample request for easy testing.
- **Health Check:** Simple endpoint to verify service status.
- **Input Validation:** Ensures valid categories, units, and values.
- **Detailed Explanations:** Responses include conversion formulas.

## Technologies

- Java 17+
- Spring Boot

## Endpoints

| Method | Endpoint                | Description                                 |
|--------|------------------------|---------------------------------------------|
| POST   | `/convert`             | Convert a value between units               |
| GET    | `/categories`          | List supported categories                   |
| GET    | `/units?category=...`  | List units for a category                   |
| GET    | `/sample-payload`      | Get a sample conversion request             |
| GET    | `/health`              | Health check                                |

## Example Usage

**Convert Temperature:**
```bash
curl -X POST http://localhost:8080/convert \
  -H "Content-Type: application/json" \
  -d '{"category":"temperature","fromUnit":"celsius","toUnit":"fahrenheit","value":25}'
```

**Get Categories:**
```bash
curl http://localhost:8080/categories
```

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/convertly.git
   cd convertly
   ```

2. **Build and run the project:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the API:**  
   The server runs on `http://localhost:8080` by default.

