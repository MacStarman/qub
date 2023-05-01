Descriptions is responsible for providing endpoints to describe the features of each Hotel.
Running docker compose up --build in the root directory will create a mysql container which will initalise a MYSQL database as well as start a container for springboot application on port 6868. The configuration settings for the database are stored in the .env file in the root directory.

The endpoints for descriptions may be viewed at http://localhost:6868/descriptions