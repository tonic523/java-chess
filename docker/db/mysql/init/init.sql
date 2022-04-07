create table piece
(
    teamColor varchar(10) not null,
    symbol varchar(20) not null,
    position varchar(2) not null,
    primary key (position)
);

create table teamColor
(
    currentTurn varchar(10) not null,
    primary key (currentTurn)
);
