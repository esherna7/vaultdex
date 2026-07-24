# VaultDex

A full-stack Pokémon card collection manager built with React, TypeScript, Java, Spring Boot, and PostgreSQL.

## Tech Stack

### Frontend
- React
- TypeScript
- Vite

### Backend
- Java 21
- Spring Boot
- Maven

### Database
- PostgreSQL

## Project Structure

```
vaultdex/
├── vaultdex-api/      # Spring Boot backend
└── vaultdex-web/      # React + Vite frontend
```

## Getting Started

### Prerequisites

Install:

- Java 21
- Node.js 22+ (or latest LTS)
- Visual Studio Code
- Docker Desktop
- Git

## Clone the Repository

```bash
git clone https://github.com/esherna7/vaultdex.git
cd vaultdex
```

## Running the Backend

Open the project in **Visual Studio Code**.

Start the database:

```bash
docker compose up -d db
```

Apply database migrations:

```bash
docker compose up liquibase
```

Start the Spring Boot application:

```bash
cd vaultdex-api
.\mvnw.cmd spring-boot:run
```

The backend uses the Docker PostgreSQL database at `localhost:5433`.

The backend will start at:

```
http://localhost:8080
```

## Running the Frontend

Use the same **Visual Studio Code** workspace.

Install dependencies:

```bash
cd vaultdex-web
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend will start at:

```
http://localhost:5173
```

## Current Status

🚧 Project setup is in progress.

Upcoming milestones include:

- User authentication
- Pokémon card search
- Collection management
- Wishlist
- Dashboard
- Collection statistics

## Author

Esai Hernandez