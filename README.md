# wd-pokedex-challenge

This project serves as a challenge to achieve a list of requirements using the API from https://pokeapi.co/. 

The Project follows MVVM pattern and the concepts of Clean Architecture where each layer has its own responsibilities and although it makes a small project look a bit bigger due to the ammount of packages and separation, this is usually a good practice for a better, scalable, testable and overall cleanness of code to be maintained, adapt and possibly grow.

## core
This basically module holds most framework elements, SDK related and creates the bridge for network data responsible layer.

### domain
Where all common domain is defined, this will holds the entities used to expose data to a feature presentation layer.  
### data
Where all network data response and necessary models defining the data that comes remotely.
### di
Dependency injection for common elements of the Framework where the Network is shown how to be injected to be used by features.
### presentation
Common components to be reused by various features/scenarios.
Navigation that these days is done also via Compose.
### paging
Defines paging sources to be reused accordingly with feature necessities
### util
Common constants and utility functions that can be reusable all over the project. 


## pokemon_x(feature)

pretty much like core each feature is basically divided in 4 modules:

- domain: declaring all interface business rules and use cases.
- data: implementing all rules defined by domain and providing model mapping.
- di: defining the dependency injection for all business logic classes to be used.
- presentation: Ui layer free of all business logic, to be as clean as possible using viewmodel as a bridge between it and all logic and data.

Again separating responsibilities of each layer within a feature was a goal in the project for easier maintenance.