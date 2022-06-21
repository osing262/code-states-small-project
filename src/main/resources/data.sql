insert into MEMBER (id, username, password, email) values (1, 'kim', '1111', 'user1@test.com');
insert into MEMBER (id, username, password, email) values (2, 'jo', '2222', 'user2@test.com');
insert into MEMBER (id, username, password, email) values (3, 'lee', '3333', 'user3@test.com');

insert into "ROLE" (id, name) values ( 1, 'ROLE_UNLICENSED' );
insert into "ROLE" (id, name) values ( 2, 'ROLE_USER' );
insert into "ROLE" (id, name) values ( 3, 'ROLE_ADMIN' );

insert into "PRIVILEGE" (id, name) values ( 1, 'READ_AUTH' );
insert into "PRIVILEGE" (id, name) values ( 2, 'WRITE_AUTH' );
insert into "PRIVILEGE" (id, name) values ( 3, 'UPDATE_AUTH' );
insert into "PRIVILEGE" (id, name) values ( 4, 'DELETE_AUTH' );

INSERT INTO "USER_ROLE" VALUES (1, 1);
INSERT INTO "USER_ROLE" VALUES (2, 1);
INSERT INTO "USER_ROLE" VALUES (2, 2);
INSERT INTO "USER_ROLE" VALUES (3, 1);
INSERT INTO "USER_ROLE" VALUES (3, 2);
INSERT INTO "USER_ROLE" VALUES (3, 3);

INSERT INTO "ROLE_PRIVILEGE" VALUES (1, 1);
INSERT INTO "ROLE_PRIVILEGE" VALUES (2, 2);
INSERT INTO "ROLE_PRIVILEGE" VALUES (2, 3);
INSERT INTO "ROLE_PRIVILEGE" VALUES (3, 4);
