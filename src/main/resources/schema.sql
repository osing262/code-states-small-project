
DROP TABLE "USER_ROLE" IF EXISTS;

create table "USER_ROLE" (
                           uid bigint,
                           rid bigint,
                           primary key (uid, rid),
                           foreign key (uid) references "MEMBER"(id),
                           foreign key (rid) references "ROLE"(id)
);

DROP TABLE "ROLE_PRIVILEGE" IF EXISTS;

create table "ROLE_PRIVILEGE" (
                                rid bigint not null,
                                pid bigint not null,
                                primary key (rid, pid),
                                foreign key (rid) references "ROLE"(id),
                                foreign key (pid) references "PRIVILEGE"(id)
);