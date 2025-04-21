# Angular + Spring Boot - CORS Setup Example

This is an example project demonstrating Notes app

## Project Setup

### 1. Clone the repository

```bash
git clone <your-repository-url>
cd <your-project-directory>

## Backend
### Run the Spring Boot backend on port 8000
mvn spring-boot run

### Add Notes
```bash

curl --location 'http://localhost:8000/api/notes' \
--header 'Content-Type: application/json' \
--header 'Cookie: mode=day' \
--data '{
    "content": "horas"
}'


### Get Notes

```bash

curl --location 'http://localhost:8000/api/notes' \
--header 'Cookie: mode=day'


### Delete Notes
```bash
curl --location --request DELETE 'http://localhost:8000/api/notes/2' \
--header 'Cookie: mode=day'


## Frontend
### Run angular  on port 4200

cd frontend
ng serve
