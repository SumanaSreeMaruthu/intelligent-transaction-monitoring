# Intelligent Transaction Monitoring

Java 21 / Spring Boot portfolio starter by [Sumana Sree Maruthu](https://github.com/SumanaSreeMaruthu).

> **Status: starter implementation.** This repository includes a working in-memory REST API, validation, Docker configuration and a basic test. Gemini, production AI agents, Kafka, database persistence, authentication and frontend features are **not implemented**.

## Run
Requires Java 21 and Maven 3.9+.

```bash
mvn spring-boot:run
mvn test
```

## API
```bash
curl -X POST http://localhost:8080/api/v1/transactions -H 'Content-Type: application/json' -d '{"transactionId":"example"}'
curl http://localhost:8080/api/v1/transactions
```

## Roadmap
- [ ] Add PostgreSQL persistence and migrations
- [ ] Add service/repository layers and integration tests
- [ ] Add Spring Security authentication and authorization
- [ ] Build an Angular or React frontend
- [ ] Add observability, deployment and documentation
- [ ] Integrate appropriate Gemini/AI or Kafka capabilities where applicable

Do not use real customer or employer data in this demonstration.
