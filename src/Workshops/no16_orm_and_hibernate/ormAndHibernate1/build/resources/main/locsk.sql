CREATE TABLE event (
    event_id SERIAL NOT NULL PRIMARY KEY,
    event_name VARCHAR(32) NOT NULL UNIQUE,
    date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE ticket (
    ticket_id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    event_id INT NOT NULL references event(event_id)

)