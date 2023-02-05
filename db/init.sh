#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE ROLE dev WITH LOGIN ENCRYPTED PASSWORD 'dev';
    GRANT ALL PRIVILEGES ON DATABASE fleet_management TO dev;
    GRANT ALL ON SCHEMA public TO dev;
EOSQL