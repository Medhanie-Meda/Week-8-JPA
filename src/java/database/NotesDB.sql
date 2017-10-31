DROP DATABASE if exists NotesDB;
CREATE DATABASE NotesDB;

USE NotesDB;

DROP TABLE User;

CREATE TABLE Note( 
    noteId INT AUTO_INCREMENT,
    dateCreated DATE NOT NULL,
    contents VARCHAR(10000) CHARACTER SET utf8 NOT NULL,
    PRIMARY KEY (noteID) 
);

INSERT INTO Note values (1, '2011-11-11', 'Content One');
INSERT INTO Note values (2, '2012-12-12', 'Content Two');
INSERT INTO Note values (3, '2013-13-13', 'Content Three');
INSERT INTO Note values (4, '2014-14-14', 'Content Four');
INSERT INTO Note values (5, '2015-15-15', 'Content Five');
