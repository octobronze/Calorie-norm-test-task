create database calorie_norm;

\c calorie_norm;

CREATE TABLE "dish" (
	"id" INTEGER NOT NULL,
	"calories" DECIMAL(8,2) NOT NULL,
	"carbohydrates_grams" DECIMAL(8,2) NULL DEFAULT NULL,
	"fats_grams" DECIMAL(8,2) NULL DEFAULT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"proteins_grams" DECIMAL(8,2) NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE "user" (
	"id" INTEGER NOT NULL,
	"age" INTEGER NOT NULL,
	"email" VARCHAR(255) NOT NULL,
	"height" DECIMAL(8,2) NOT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"user_goal_id" SMALLINT NOT NULL,
	"weight" DECIMAL(8,2) NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "user_user_goal_id_check" CHECK (((user_goal_id >= 0) AND (user_goal_id <= 2)))
);

CREATE TABLE "eating" (
	"id" INTEGER NOT NULL,
	"date" DATE NOT NULL,
	"time" TIME NOT NULL,
	"user_id" INTEGER NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "eating_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "user" ("id") ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE "eating_dishes" (
       "id" INTEGER NOT NULL,
	"eating_id" INTEGER NOT NULL,
	"dish_id" INTEGER NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "eating_dishes_dish_id_fkey" FOREIGN KEY ("dish_id") REFERENCES "dish" ("id") ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT "eating_dishes_eating_id_fkey" FOREIGN KEY ("eating_id") REFERENCES "eating" ("id") ON UPDATE CASCADE ON DELETE CASCADE
);
