# Angular + Spring Boot - Notes App

This is an example project demonstrating a Notes app using Angular for the frontend and Spring Boot for the backend.

## Project Setup

### 1. Clone the repository

```bash
git clone <your-repository-url>
cd <your-project-directory>
```

## Backend

### Run the Spring Boot backend on port 8000

```bash
mvn spring-boot:run
```

### Add Notes

You can use the following `curl` command to add a new note.

```bash
curl --location 'http://localhost:8000/api/notes' \
--header 'Content-Type: application/json' \
--header 'Cookie: mode=day' \
--data '{
    "content": "horas"
}'
```

### Get Notes

To get the list of notes, use the following `curl` command.

```bash
curl --location 'http://localhost:8000/api/notes' \
--header 'Cookie: mode=day'
```

### Delete Notes

To delete a note, use the following `curl` command with the note's ID.

```bash
curl --location --request DELETE 'http://localhost:8000/api/notes/2' \
--header 'Cookie: mode=day'
```

## Frontend

### Run Angular frontend on port 4200

```bash
cd frontend
ng serve
```
