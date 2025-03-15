CREATE TABLE IF NOT EXISTS run (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    started_on TIMESTAMP,
    completed_on TIMESTAMP,
    miles INT CHECK (miles > 0)
);
