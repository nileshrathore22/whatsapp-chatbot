# WhatsApp Chatbot - Spring Boot

A simple WhatsApp chatbot backend built with Java and Spring Boot. It exposes a `/webhook` POST endpoint that takes incoming messages and responds with predefined replies.

## How it works

- Send a POST request to `/webhook` with a JSON body like `{"message": "Hi"}`
- The bot replies based on keywords:
  - **Hi / Hello** → "Hello"
  - **Bye** → "Goodbye"
  - Anything else → "I don't understand that message."
- All incoming messages are logged to console

## Tech Stack

- Java 22
- Spring Boot 3.2.5
- Maven

## Run Locally

```bash
./mvnw.cmd spring-boot:run
```

Or if you have Maven installed:

```bash
mvn spring-boot:run
```

Server starts on `http://localhost:8080`

## Test

```bash
curl -X POST http://localhost:8080/webhook -H "Content-Type: application/json" -d "{\"message\":\"Hi\"}"
```

Response:
```json
{"reply":"Hello"}
```

## Project Structure

```
src/main/java/com/example/chatbot/
├── ChatbotApplication.java        # Main class
├── controller/
│   └── WebhookController.java     # REST endpoint
├── model/
│   ├── MessageRequest.java        # Request body
│   └── MessageResponse.java       # Response body
└── service/
    └── ChatService.java           # Reply logic
```
