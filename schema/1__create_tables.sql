create table holidays
(
    id           int auto_increment primary key,
    name         varchar(255) not null,
    month        varchar(20)  not null,
    day_of_month int          not null,
    constraint holidays_ui1 unique (month, day_of_month),
    constraint holidays_ui2 unique (name)
);

create table currencies
(
    id   int auto_increment primary key,
    name varchar(255) not null,
    iso  varchar(3)   not null,
    constraint currencies_ui1 unique (iso)
);
