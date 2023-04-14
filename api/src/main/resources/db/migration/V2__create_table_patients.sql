create table patients(
        id bigint not null auto_increment,
        name varchar(100) not null,
        email varchar(100) not null unique,
        cpf varchar(15) not null unique,
        phone varchar(20) not null,
        street varchar(100) not null,
        neighborhood varchar(100) not null,
        cep varchar(9) not null,
        complement varchar(100),
        number varchar(20),
        state varchar(2) not null,
        city varchar(100) not null,

        primary key(id)
);