create table payment
(
    id         varchar(14) not null primary key,
    created_at bigint      not null,
    is_deleted boolean,
    updated_at bigint      not null,
    amount     bigint      not null,
    status     varchar(30),
    purpose    varchar(100)
);

create unique index if not exists payment_pk
    on payment using btree (id);