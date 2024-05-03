# Primera version

## Setup

- Java 17.
- Postgresql

## Scripts Execution

Dentro de la carpeta [db de postgres](db/postgresql) se deben ejecutar estos dos comandos:

    ```bash
    psql -U {userName} -h {host} -f model.sql
    psql -U {userName} -h {host} -d cinema_reservation -f model_inserts.sql
    ```
Ya contiene unas cuantas peliculas, salas, sillas y proyecciones creadas.
