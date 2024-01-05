INSERT INTO PERSON (name) VALUES ('Alice');
SET @aliceId = SELECT ID FROM PERSON WHERE NAME = 'Alice';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportAlice123', @aliceId);

INSERT INTO PERSON (name) VALUES ('Bob');

SET @bobId = SELECT ID FROM PERSON WHERE NAME = 'Bob';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportBob123', @bobId);

INSERT INTO PERSON (name) VALUES ('Dani');
SET @daniId = SELECT ID FROM PERSON WHERE NAME = 'Dani';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportDani123', @daniId);

INSERT INTO PERSON (name) VALUES ('Yoni');

SET @yoniId = SELECT ID FROM PERSON WHERE NAME = 'Yoni';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportYoni123', @yoniId);

INSERT INTO PERSON (name) VALUES ('Beth');
SET @bethId = SELECT ID FROM PERSON WHERE NAME = 'Beth';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportBeth123', @bethId);

INSERT INTO PERSON (name) VALUES ('Alex');
SET @alexId = SELECT ID FROM PERSON WHERE NAME = 'Alex';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportAlex123', @alexId);

INSERT INTO PERSON (name) VALUES ('Rufta');
SET @rufthaId = SELECT ID FROM PERSON WHERE NAME = 'Rufta';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportRufta123', @rufthaId);

INSERT INTO PERSON (name) VALUES ('Aman');
SET @amanId = SELECT ID FROM PERSON WHERE NAME = 'Aman';
INSERT INTO PASSPORT (passport_number, person_id) VALUES ('PassportAman123', @amanId);

