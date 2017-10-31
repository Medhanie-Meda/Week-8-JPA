DROP DATABASE if exists NotesDB;
CREATE DATABASE NotesDB;

USE NotesDB;

DROP TABLE Note;

CREATE TABLE Note( 
    noteId INT AUTO_INCREMENT,
    dateCreated DATE NOT NULL,
    contents VARCHAR(10000) CHARACTER SET utf8 NOT NULL,
    PRIMARY KEY (noteID) 
);

INSERT INTO Note values (DEFAULT, '2010-05-01', 'Content One');
INSERT INTO Note values (DEFAULT, '2010-05-02', 'Content Two');
INSERT INTO Note values (DEFAULT, '2010-05-03', 'Content Three');
INSERT INTO Note values (DEFAULT, '2010-05-04', 'Content Four');
INSERT INTO Note values (DEFAULT, '2010-05-05', 'Content Five');
