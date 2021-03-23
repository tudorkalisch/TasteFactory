# TasteFactory
This is a backend project designed to handle recipes. Hope it helps! 

# SETUP
Install ProstgreSQL and IntelliJ. You need to start the Postre server before running the application and you need to create a database. I've used the name TasteFactory, but you can change it to whatever you want, just remember to change it in the application.json also.

# Details
I've created a list of ingredients to be able to create recipes and find a way to recommend other ingredients when we find a recipe where we do not have all the ingredients. Copy the content of a the IngredientsJSON and use it as Body for Postman with a POST request to http://localhost:8080/api/v1/ingredient/addAll.

For the recipe, you can the AddRecipeJSON, but there are a few details that we need to keep in mind. We need to add the ingredients before adding the recipe and remember to update the ingredients id's from the database as it will throw an exception if the ids are not found. You can find all the ingredients using a GET on http://localhost:8080/api/v1/ingredient/all. Here you will find the ids. After this, you can use a POST request at http://localhost:8080/api/v1/recipe/add
with the JSON from the AddRecipeJSON.

This will be used on the web project. The flow that we are using right now is getting recommended ingredients by type or type and calories. Check Ingredient in model folder.

There is also a Login/Register feature. Also, I made some extra CRUD requests if they are needed in the future.

If you need some help setting it up or you don't understand some stuff, reach out.
