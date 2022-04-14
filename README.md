# DiningReview
A Dining Review RESTful web API using Spring and Spring Data JPA with the H2 embedded database. 

# 
# 
# 

Using cURL, we can return information from our database about the users, restaurants, and reviews as well as add and edit tuples.

## Users:

##### Adding new user using a username, city, state, zip code, and whether they are interested in allergies from peanuts, eggs, and/or dairy.
#

curl -X POST localhost:8080/user/add -H "Content-Type: application/json" -d "{\\"displayName\\":\\"coolusername\\",\\"city\":\\"Reno\\",\\"state\\":\\"NV\\",\\"zipCode\\":89501,\\"peanutAllergies\\":true,\\"eggAllergies\\":false,\\"dairyAllergies\\":true}"

##### Retrieving user information based off of the username.
#
curl localhost:8080/user/search?username=username

##### Editing user information using user id and new values.
#

curl -X PUT localhost:8080/user/update/1 -H "Content-Type: application/json" -d "{\\"eggAllergies\\": true, \\"dairyAllergies\\": false}"

## Dining review:

##### Creating a new review using username and the restaurant id while rating the restaurant's concern with each allergy and a small excerpt.
#

curl -X POST localhost:8080/dining-review/create -H "Content-Type: application/json" -d "{\\"username\\":\\"coolusername\\", \\"restaurantId\\":1, \\"peanutAllergy\\":5, \\"dairyAllergy\\":2}"

##### Retrieving all review based on their review status.
#

curl -X GET "localhost:8080/dining-review/search?status=pending"

##### Editing review from id to approve or reject.
#

curl -X PUT "localhost:8080/dining-review/approve?status=approved&id=1"


## Restaurant:

##### Create new restaurant using name, zip code, and their allergy scores.
#

curl -X POST localhost:8080/restaurant/create -H "Content-Type: application/json" -d "{\\"name\\":\\"McDougles\\", \\"zipCode\\":89501, \\"overallScore\\":4, \\"peanutAllergy\\":5,\\"eggAllergy\\":4, \\"dairyAllergy\\":2}"

##### Retrieve restaurant from their id.
#

curl localhost:8080/restaurant/1

##### Retreive all restaurants in a zip code and returns it in descending order based on the allergy.
#

curl "localhost:8080/restaurant/search?zipCode=90210&peanutAllergy=5"





