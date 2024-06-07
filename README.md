# GPS receiver

Welcome to the GPS points of interest API

## Description
This REST API aims to provide points of interest close to your reference point within a specified radius.

## Functionalities
- **Register POIs**: Add points of interest with name, X coordinate and Y coordinate.
- **List all POIs**: Display all registered points of interest.
- **List POIs by proximity**: Return POIs that are within a specific distance from a reference point.

## Endpoints

Register a new POI
- POST /points-of-interests
  ```
  {
  	"name": "Snack Bar",
  	"x": 27,
  	"y": 12
  }
  ```
  
 List all POIs
 - GET /points-of-interests
 
 List POIs by proximity
 - GET /points-of-interests/near-me

## Example
Consider the following POI database:

- Snack bar (x=27, y=12)
- Post (x=31, y=18)
- Jewelry (x=15, y=12)
- Floriculture (x=19, y=21)
- Pub (x=12, y=8)
- Supermarket (x=23, y=6)
- Steakhouse (x=28, y=2)

Given the reference point (x=20, y=10) and a maximum distance of 10 meters, the service must return the following POIs:

- Cafeteria
- Jewelry
- Pub
- Supermarket

## Technologies Used

- **Programming language**: Java
- **Framework for REST**: Spring
- **Database**: H2 Database

## How to Run the Project

1. Clone the repository.
2. Run the application.

