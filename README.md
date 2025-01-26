# Enviro365 Graduate Software Developer Assessment

## Background:

Enviro365, a leading environmental solutions company, is developing a waste sorting
mobile application aimed at promoting sustainable waste management practices. The
application will serve as an educational tool for individuals and communities, providing
guidance on proper waste disposal techniques and encouraging recycling habits. As a
recent graduate developer at Enviro365, you've been tasked with implementing REST
endpoints to enable communication between the frontend and backend systems of the
application.

<br />

## API

#### Waste Categories

POST (a.k.a. Create)

```
/api/v1/waste-categories/
```

GET (a.k.a. Read)

```
/api/v1/waste-categories/
/api/v1/waste-categories/{id}
```

PUT (a.k.a. Update)

```
/api/v1/waste-categories/{id}
```

DELETE

```
/api/v1/waste-categories/{id}
```

<br />

#### Disposal Guidelines

POST (a.k.a. Create)

```
/api/v1/disposal-guidelines/
```

GET (a.k.a. Read)

```
/api/v1/disposal-guidelines/
/api/v1/disposal-guidelines/{id}
```

PUT (a.k.a. Update)

```
/api/v1/disposal-guidelines/{id}
```

DELETE

```
/api/v1/disposal-guidelines/{id}
```

<br />

#### Recycling Tips

POST (a.k.a. Create)

```
/api/v1/recycling-tips/
```

GET (a.k.a. Read)

```
/api/v1/recycling-tips/
/api/v1/recycling-tips/{id}
```

PUT (a.k.a. Update)

```
/api/v1/recycling-tips/{id}
```

DELETE

```
/api/v1/recycling-tips/{id}
```

<br />

## Scenario:

You are part of a dedicated team working on the development of the waste sorting mobile
application at Enviro365. Your team is passionate about environmental sustainability and is
committed to creating a user-friendly and informative application that empowers users to
make environmentally conscious decisions. The application will feature various
functionalities, including waste category lookup, disposal guidelines retrieval, and recycling
tips display. Your role is to design and implement REST endpoints using Spring Boot that
facilitate data exchange between the frontend mobile application and the backend server.

<br />

## Task

#### Build an exposed REST API with Spring Boot Application

- Design **_RESTful APIs_** using Spring Boot to expose the required functionalities for
data retrieval and manipulation.


- Define resource URIs, request methods, request/response payloads, and error
handling mechanisms for each endpoint.


- Implement endpoints to save/update/delete/retrieve data such as waste
categories, disposal guidelines, and recycling tips.


- Ensure that the endpoints return _JSON-formatted_ responses containing relevant
data in a structured format.


- Implement input validation using Spring Boot validation annotations to ensure the
integrity and validity of incoming requests and data payloads.

<br />

## Resources

- [Waste Classification & Management Regulations Norms & Standards for Assessment and Disposal of Waste to Landfill](https://sawic.environment.gov.za/documents/2177.pdf)
  - Published 2013
