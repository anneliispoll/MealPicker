CREATE TABLE MealPicker (
ID int NOT NULL AUTO_INCREMENT,
MealName varchar (255),
breakfast bit NOT NULL DEFAULT 0,
lunch bit NOT NULL DEFAULT 0,
dinner bit NOT NULL DEFAULT 0, 
winter bit NOT NULL DEFAULT 0,
spring bit NOT NULL DEFAULT 0,
summer bit NOT NULL DEFAULT 0,
autumn bit NOT NULL DEFAULT 0,
PRIMARY KEY(ID)
);

-- inserting into table
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Fried eggs',1,0,0,1,1,1,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Porridge',1,0,0,1,1,0,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Muesli',1,0,0,0,0,1,0);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Pancakes',1,0,0,1,1,1,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Sandwiches',1,0,0,1,1,1,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Pasta',0,1,1,1,1,1,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Soup',0,1,1,1,1,0,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Salat',0,1,1,0,1,1,0);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Mashed potatoes with meatballs',0,1,1,1,1,1,1);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Hamburger',0,1,1,0,1,1,0);
INSERT INTO MealPicker (MealName, breakfast, lunch, dinner, winter, spring, summer, autumn)
VALUES ('Casserole',0,1,1,1,0,0,0);

SELECT * FROM MealPicker;
DROP TABLE MealPicker;

SELECT * FROM MealPicker WHERE dinner=true AND summer = 1 order by rand() limit 1;