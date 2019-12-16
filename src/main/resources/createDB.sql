CREATE TABLE users(
    id       int not null auto_increment,
    name     varchar,
    password varchar,
    role     varchar,
    PRIMARY KEY (id)
);

CREATE TABLE cars(
    id      int not null auto_increment,
    user_id int,
    make    varchar,
    model   varchar,
    year    int,
    cost    int,
    PRIMARY KEY (id)
);