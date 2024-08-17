# FileProcessor

## Overview

This project is a file-processing application built with Spring Boot. The application allows users to upload text files, processes them to replace the most frequently used word with a modified version surrounded by "foo" and "bar", and returns the processed text.

## Prerequisites

- **Java 11 or later**: Ensure Java is installed on your system.
- **Maven**: For building the project.
- **Docker** (optional): For containerizing and running the application.

## Running the Application Locally

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/Niola-DC/FileProcessor.git
cd FileProcessor
```

### 2. Build the Application

Use Maven to build the application. This step compiles the code and packages it into a JAR file.

```bash
./mvnw clean package
```

### 3. Run the Application

Once the build is successful, run the application using the generated JAR file. The application will start on port 8080 by default.

```bash
java -jar target/Processor-0.0.1-SNAPSHOT.jar
```

### 4. Access the Application

Open your web browser and navigate to:

```
http://localhost:8080/api/v1/processor/process
```

You can use tools like Postman or `curl` to test file uploads:

```bash
curl -F "file=@path/to/your/file.txt" http://localhost:8080/api/v1/processor/process
```

## Running the Application with Docker

### 1. Build the Docker Image

Ensure you have Docker installed. Create a `Dockerfile` in the project root (if not already present) with the following content:

```docker file
FROM openjdk:11-jre-slim
COPY target/Processor-0.0.1-SNAPSHOT.jar /app/Processor.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "Processor.jar"]
```

Build the Docker image with the following command:

```bash
docker build -t file-processor-app .
```

### 2. Run the Docker Container

Run the Docker container with the following command, mapping port 8080 from the container to port 8080 on your host machine:

```bash
docker run -p 8080:8080 file-processor-app
```

### 3. Access the Application

Open your web browser and navigate to:

```
http://localhost:8080/api/v1/processor/process
```

Use tools like Postman or `curl` to test file uploads:

```bash
curl -F "file=@path/to/your/file.txt" http://localhost:8080/api/v1/processor/process
```

## Notes

- Ensure that the application is stopped before attempting to run it on a different port or instance.
- For Docker, ensure that the Docker daemon is running on your machine.

## Troubleshooting

- **If the application fails to start**: Check the logs for any errors or exceptions. Ensure all dependencies are correctly set up.
- **If Docker encounters issues**: Verify that Docker is properly installed and running. Check Docker logs for additional details.

For any issues or questions, please open an issue on the [GitHub repository](https://github.com/Niola-DC/FileProcessor/issues).
