# Intelligent Transaction Monitoring

Java 21 / Spring Boot portfolio demonstration.

## Implemented
- Persistent H2/JPA transaction records
- REST create, list, get and delete at `/api/v1/transactions`
- Browser dashboard at `http://localhost:8080/`
- Basic synthetic transaction ID heuristic, validation, Dockerfile and CI workflow

## Run
```bash
mvn spring-boot:run
mvn test
```

## Limitations
This is **not** a production AML monitoring system. No Kafka consumer, transaction amounts, real risk model, alerts, React, authorization or comprehensive tests yet. Build has not been independently verified. Use synthetic data only.
