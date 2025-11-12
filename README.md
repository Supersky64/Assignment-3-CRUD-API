# Assignment-3-CRUD-API
Simple CRUD API for Hedgehog Objects with JPA (Hibernate)

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/Supersky64/Assignment-3-CRUD-API
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/pom.xml) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/resources/application.properties) This file has the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.
## Notes
### Java - [Spring ORM with JPA and Hibernate](https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac)
- We are using ORM (Object-Relational Mapping) to deal with databases. This is a technique that allows us to interact with a relational database using object-oriented programming principles.
- JPA (Jakarta Persistence, formerly Java Persistence API) is a specification that defines ORM standards in Java. It provides an abstraction layer for ORM frameworks to make concrete implementations.
- Hibernate: Hibernate is a popular ORM framework that implements JPA. It simplifies database operations by mapping Java objects to database tables and handling queries efficiently.
Spring ORM allows seamless integration of Hibernate and JPA, making database interactions more manageable and reducing boilerplate code.
### HedgehogX Java classes have different purposes: Separation of concerns!
- [Entity](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/Hedgehog.java)
  - The Hedgehog class is annotated as an `@Entity `. This is used to map class attributes to database tables and SQL types.
  - We also annotated with `@Table` to give Hibernate directions to use this specific table name. This is optional but it helps with naming conventions.
  - Any Entity must have at least one attribute that is annotated as an `@Id`. In our case it's conveniently the `hedgehogId` attribute.
    - We are also using an autogeneration strategy for the ID. This way we are not manually assigning IDs to our hedgehogs. This is optional.
       - For this reason, we also added a constructor to make a Hedgehog without an ID.
  - An Entity must have a no-argument constructor.
- [Repository](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/HedgehogRepo.java)
  - We are using an extension of the JPA Repository that comes with prebuilt database operations such as select all, select by id, select by any other reference, insert, delete, etc.
  - Annotate it as a `@Repository`.
  - We parametrize this using our object and its ID type.
    - `public interface HedgehogRepo extends JpaRepository<Hedgehog, Long>` => We want to apply the JPA repository operations on the `Hedgehog` type. The `Hedgehog` has an ID of type `long`.
  - If we need special database queries that are not the standard ones mentioned above, we can create [a method with a special purpose query](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/HedgehogRepo.java) as shown. This is an interface so no implementation body.
- [Service](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/HedgehogService.java)
  - Annotated as a `@Service`.
  - It is the go-between from controller to database. In here we define what functions we need from the repository. A lot of the functions are default functions that our repository inherits from JPA (save, delete, findAll, findByX), some of them are custom made (getHedgehogbyBreed, getHedgehogbyName, getHedgehogbyAge).
  - It asks the repository to perform SQL queries.
  - The Repository class is [`@Autowired`](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/HedgehogService.java). This is for managing the dependency to the repository. Do not use a constructor to make a Repository object, you will get errors.
- [Rest Controller](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/HedgehogController.java)
  - Annotated as a `@RestController`.
  - It asks the Service class to perform data access functions.
  - The Service class is [`@Autowired`](https://github.com/Supersky64/Assignment-3-CRUD-API/blob/main/src/main/java/com/example/demo/Animal/HedgehogController.java#L20)

## API Endpoints
Base URL: [`http://localhost:8080/hedgehog`](http://localhost:8080/hedgehog)


1. ### [`/`](http://localhost:8080/hedgehog) (GET)
Gets a list of all Hedgehogs in the database.

#### Response - A JSON array of Hedgehog objects.

 ```
[
  {
    "hedgehogId": 1,
    "name": "Sonic",
    "description": "The Fastest thing alive often known as the Blue Blur. Just a guy who loves adventure",
    "breed": "Cool guy",
    "age": 34.0
  }
]
```

2. ### [`/{id}`](http://localhost:8080/hedgehog/1) (GET)
Gets an individual Hedgehog in the system. Each Hedgehog is identified by a numeric `hedgehogId`

#### Parameters
- Path Variable: `hedgehogId` &lt;Long &gt; - REQUIRED

#### Response - A single Hedgehog

```
  {
    "hedgehogId": 1,
    "name": "Sonic",
    "description": "The Fastest thing alive often known as the Blue Blur. Just a guy who loves adventure",
    "breed": "Cool guy",
    "age": 34.0
  }
```

3. ### [`/name`](http://localhost:8080/hedgehog/name?name=Sonic) (GET)
Gets a list of hedgehogs with a name that contains the given string.

#### Parameters
- query parameter: `name` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Hedgehog objects.

```
[
  {
    "hedgehogId": 1,
    "name": "Sonic",
    "description": "The Fastest thing alive often known as the Blue Blur. Just a guy who loves adventure",
    "breed": "Cool guy",
    "age": 34.0
  }
]
```

4. ### [`/breed/{breed}`](http://localhost:8080/hedgehog/breed/Cool guy) (GET)
Gets a list of Hedgehogs for a named breed.

#### Parameters
- path variable: `breed` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Hedgehog objects.

```
[
  {
    "hedgehogId": 1,
    "name": "Sonic",
    "description": "The Fastest thing alive often known as the Blue Blur. Just a guy who loves adventure",
    "breed": "Cool guy",
    "age": 34.0
  }
]
```
5. ### [`/age`](http://localhost:8080/hedgehog/age?age=34) (GET)
Gets a list of hedgehogs with thier age.

#### Parameters
- query parameter: `age` &lt;Double&gt; - REQUIRED

#### Response - A JSON array of Hedgehog objects.

```
[
  {
    "hedgehogId": 1,
    "name": "Sonic",
    "description": "The Fastest thing alive often known as the Blue Blur. Just a guy who loves adventure",
    "breed": "Cool guy",
    "age": 34.0
  }
]
```
6. ### [`/`](http://localhost:8080/hedgehog) (POST)
Create  a new Hedgehog entry

#### Request Body
A hedgehog object. Note the object does not include an ID as this is autogenerated.
```
{
    "name": "Shadow",
    "description": "The ultimate life form created by Professor Gerald Robotnik",
    "breed": "Ulitmate Life form",
    "age": 50.0
  }
```
#### Response - The newly created Hedgehog.

```
{
  "hedgehogId": 2,
  "name": "Shadow",
  "description": "The ultimate life form created by Professor Gerald Robotnik",
  "breed": "Ulitmate Life form",
  "age": 50.0
}
```

7. ### [`/{id}`](http://localhost:8080/hedgehog/2) (PUT)
Update an existing hedgehog.

#### Parameters
- Path Variable: `hedgehogId` &lt;integer&gt; - REQUIRED

#### Request Body
A hedgehog object with the updates.
```
{
    "name": "Shadow",
    "description": "The ultimate life form created by Professor Gerald Robotnik and has the blood of the black arms (updated_bio)",
    "breed": "Ultimate",
    "age": 50.0
}
```
#### Response - the updated Hedgehog object.
```
{
    "name": "Shadow",
    "description": "The ultimate life form created by Professor Gerald Robotnik and has the blood of the black arms (updated_bio)",
    "breed": "Ultimate",
    "age": 50.0
}
```

8. ### [`/{id}`](http://localhost:8080/hedgehog/3) (DELETE)
Delete an existing hedgehog.

#### Parameters
- Path Variable: `hedgehogId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Hedgehogs.
```
[
{
    "hedgehogId": 1,
    "name": "Sonic",
    "description": "The Fastest thing alive often known as the Blue Blur. Just a guy who loves adventure",
    "breed": "Cool guy",
    "age": 34.0
},
{
  "hedgehogId": 2,
  "name": "Shadow",
  "description": "The ultimate life form created by Professor Gerald Robotnik",
  "breed": "Ulitmate Life form",
  "age": 50.0
}
]
```


#### DEMO BELOW!

<video controls src="2025-11-12 00-00-14.mp4" title="Title"></video>