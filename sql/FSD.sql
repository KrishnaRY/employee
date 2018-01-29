

DROP TABLE IF EXISTS  register_user  ;


CREATE  TABLE IF NOT EXISTS  register_user
(
   ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   username varchar(100) UNIQUE KEY NOT NULL,
   first_Name varchar(100) NOT NULL,
   last_Name varchar(100) NOT NULL,
   password varchar(100) NOT NULL

);

insert into register_user(username,first_Name,last_Name,password) values ('admin','admin','admin','admin');

ALTER TABLE register_user MODIFY COLUMN username VARCHAR(255) NOT NULL DEFAULT '' ;
ALTER TABLE register_user MODIFY COLUMN password VARCHAR(255) NOT NULL DEFAULT ''  ;
ALTER TABLE register_user MODIFY COLUMN first_Name VARCHAR(255) NOT NULL DEFAULT '' ;
ALTER TABLE register_user MODIFY COLUMN last_Name VARCHAR(255) NOT NULL DEFAULT '' ;



