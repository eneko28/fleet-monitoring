# fleet-monitoring
This is a demo for a fleet monitoring application.
The compose file defines an application with three services: backend, db and test. The backend is a Java application built using the Spring Boot framework that will a) connect to a PostgreSQL database and b) accept REST queries from its API. When deploying the application, docker compose maps port 8080 of the backend service container to port 8080 of the host as specified in the file. The test application will connect to this port 8080 to test the backend implementation.

## Dependencies
Docker and docker-compose are needed to run this application.

## Deploy with docker compose
```bash
docker compose up -d && docker attach test
```

## Expected result
When running this fleet-monitoring demo the user will interact with the test application. The user shall only see the CLI connected to the test application.