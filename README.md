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

Make sure **Docker Desktop is running locally** before running the Docker Compose command.

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

Test DB connectivity from the API:

```bash
curl http://localhost:8080/api/test/db
```

Expected success response includes `"connected": true`.

## Database & Migrations

This project uses **Liquibase** to manage schema migrations against a **Postgres 16** database, both running via Docker Compose.

### Running migrations

```bash
docker compose up liquibase
```

This starts the `db` service (if not already running), waits for it to be healthy, then applies any pending changesets from `./liquibase/changelog/db.changelog-master.xml`.

> **Note:** The project uses an XML master changelog at `db.changelog-master.xml`, which includes `changes/changelog-2026_07-1.yml`. Make sure the filename in `docker-compose.yml` matches the file on disk.

### Editing changesets (important)

Liquibase tracks every changeset by `id` + `author` + filename in the `databasechangelog` table. Once a changeset has been applied to a database:

- **Do not edit it in place.** Liquibase will either skip it (already marked as run) or throw a checksum mismatch error if the content changed.
- **Add a new changeset instead** (for example, `id: 2`) using `renameTable`, `renameColumn`, `addColumn`, etc. to migrate the existing schema forward.

Editing in place is only safe if the changeset has **never been run** against any database you care about (for example, still local-only, or if you are fine wiping your dev volume).

### Connecting to the database locally

Connection details (from `docker-compose.yml`):

| Setting | Value |
| --- | --- |
| Host | `localhost` |
| Port | `5433` (mapped from container port `5432`) |
| Database | `vaultdex_dev` |
| Username | `vaultdex` |
| Password | `vaultdex_password` |

Use PostgreSQL locally to inspect your DB state after migrations and while developing backend features.

**Via psql (inside the running container):**

```bash
docker compose exec db psql -U vaultdex -d vaultdex_dev
```

Useful psql commands once connected:

```sql
\dt                              -- list all tables
\d cards                         -- describe a table's columns
SELECT * FROM cards;             -- view table contents
SELECT * FROM databasechangelog; -- see which changesets have run
```

Exit with `\q`.

**Via a GUI tool (pgAdmin, DBeaver, TablePlus, etc.):**

Create a new connection using the same host, port, database, username, and password above. Use `localhost` and port `5433` (not `5432`) because Compose maps host port `5433` to the container's PostgreSQL port `5432`.

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