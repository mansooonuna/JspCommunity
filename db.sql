DROP DATABASE IF EXISTS Jsp_community;
CREATE DATABASE Jsp_community;
USE DATABASE Jsp_community;

CREATE TABLE article(
	id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(200) NOT NULL,
	`body` LONGTEXT NOT NULL
);

SELECT * FROM article;

INSERT INTO article(regDate, updateDate, title, `body`)
VALUES (NOW(), NOW(), "제목1", "내용1"), (NOW(), NOW(), "제목2", "내용2"), (NOW(), NOW(), "제목3", "내용3");