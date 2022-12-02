DROP TABLE IF EXISTS counters CASCADE ;
DROP TABLE IF EXISTS users CASCADE ;
DROP TABLE IF EXISTS user_roles CASCADE ;
DROP SEQUENCE IF EXISTS global_seq CASCADE ;
DROP TYPE IF EXISTS counter_type CASCADE ;
DROP TYPE IF EXISTS user_role CASCADE ;

CREATE TYPE counter_type AS ENUM ('HOT_WATER', 'COLD_WATER');
CREATE TYPE user_role AS ENUM ('USER', 'ADMIN');

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE counters
(
    id                  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    serial_number       BIGINT       NOT NULL,
    counter_type        counter_type NOT NULL,
    verification_date   DATE         NOT NULL,
    verification_period INTEGER      NOT NULL
);

CREATE TABLE users
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    TEXT    NOT NULL,
    chat_id BIGINT  NOT NULL,
    enabled BOOLEAN NOT NULL,
    registered TIMESTAMP default now() NOT NULL
);

CREATE TABLE user_roles
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id INTEGER references users(id) ON DELETE CASCADE NOT NULL,
    role    user_role NOT NULL
)




