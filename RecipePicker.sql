CREATE TABLE RecipePicker (
ID int NOT NULL AUTO_INCREMENT,
RecipeName varchar (255),
breakfast bit NOT NULL DEFAULT 0,
lunch bit NOT NULL DEFAULT 0,
dinner bit NOT NULL DEFAULT 0, 
winter bit NOT NULL DEFAULT 0,
spring bit NOT NULL DEFAULT 0,
summer bit NOT NULL DEFAULT 0,
autumn bit NOT NULL DEFAULT 0,
instructions varchar (1000),
PRIMARY KEY(ID)
);

INSERT INTO RecipePicker (RecipeName, breakfast, lunch, dinner, winter, spring, summer, autumn, instructions)
VALUES ('Lentil and tomato soup',0,1,1,1,1,0,1, 'https://www.bbc.co.uk/food/recipes/lentil_and_tomato_soup_19393');
INSERT INTO RecipePicker (RecipeName, breakfast, lunch, dinner, winter, spring, summer, autumn, instructions)
VALUES ('Lasagne',0,1,1,1,1,0,1, 'https://www.bbc.co.uk/food/recipes/lasagne_22392');
INSERT INTO RecipePicker (RecipeName, breakfast, lunch, dinner, winter, spring, summer, autumn, instructions)
VALUES ('Chiken Kiev',0,1,1,1,1,1,1, 'https://www.bbc.co.uk/food/recipes/classic_chicken_kiev_16620');
