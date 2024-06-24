create table if not exists player_view
(
    player_id       uuid            not null,
    first_name      varchar(255),
    last_name       varchar(255),
    user_name       varchar(255)    not null,
    date_of_birth   date            not null,
    primary key (player_id)
);