# Fruits API Documentation

This is a RESTful API that allows you to manage a collection of fruits, including creating, retrieving, updating, and deleting fruit records. Below is a guide to using the API with various HTTP requests.

## Table of Contents
- [Base URL](#base-url)
- [Endpoints](#endpoints)
  - [Create a Fruit](#create-a-fruit)
  - [Retrieve All Fruits](#retrieve-all-fruits)
  - [Retrieve a Fruit by ID](#retrieve-a-fruit-by-id)
  - [Update a Fruit](#update-a-fruit)
  - [Delete a Fruit](#delete-a-fruit)
- [Request/Response Examples](#requestresponse-examples)

---

## Base URL
```
http://localhost:8080
```

## Endpoints

### 1. Create a Fruit
- **URL**: `/fruits`
- **Method**: `POST`
- **Description**: Creates a new fruit entry.
- **Request Body**:
  ```json
  {
    "id": null,
    "name": "Pear",
    "quantity": 1
  }
  ```
- **Response**:
  - Status: `201 Created`
  - Body: The created fruit with its assigned `id`.

### 2. Retrieve All Fruits
- **URL**: `/fruits`
- **Method**: `GET`
- **Description**: Retrieves a list of all fruits.
- **Response**:
  - Status: `200 OK`
  - Body: A list of fruit objects.
  ```json
  [
    {
      "id": 1,
      "name": "Pear",
      "quantity": 1
    },
    {
      "id": 2,
      "name": "Apple",
      "quantity": 7
    }
  ]
  ```

### 3. Retrieve a Fruit by ID
- **URL**: `/fruits/{id}`
- **Method**: `GET`
- **Description**: Retrieves a specific fruit by its ID.
- **Path Variable**:
  - `id`: The ID of the fruit to retrieve.
- **Response**:
  - Status: `200 OK`
  - Body: The fruit object with the specified ID.
  ```json
  {
    "id": 1,
    "name": "Pear",
    "quantity": 1
  }
  ```

### 4. Update a Fruit
- **URL**: `/fruits/{id}`
- **Method**: `PUT`
- **Description**: Updates an existing fruit entry.
- **Path Variable**:
  - `id`: The ID of the fruit to update.
- **Request Body**:
  ```json
  {
    "id": 1,
    "name": "Apple",
    "quantity": 7
  }
  ```
- **Response**:
  - Status: `200 OK`
  - Body: The updated fruit object.
  ```json
  {
    "id": 1,
    "name": "Apple",
    "quantity": 7
  }
  ```

### 5. Delete a Fruit
- **URL**: `/fruits/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a specific fruit by its ID.
- **Path Variable**:
  - `id`: The ID of the fruit to delete.
- **Response**:
  - Status: `204 No Content`

---

## Request/Response Examples

### Create a Fruit

**Request**:
```bash
POST http://localhost:8080/fruits
Content-Type: application/json

{
  "id": null,
  "name": "Pear",
  "quantity": 1
}
```

**Response**:
```json
{
  "id": 1,
  "name": "Pear",
  "quantity": 1
}
```

### Retrieve All Fruits

**Request**:
```bash
GET http://localhost:8080/fruits
Content-Type: application/json
```

**Response**:
```json
[
  {
    "id": 1,
    "name": "Pear",
    "quantity": 1
  },
  {
    "id": 2,
    "name": "Apple",
    "quantity": 7
  }
]
```

### Retrieve a Fruit by ID

**Request**:
```bash
GET http://localhost:8080/fruits/1
Content-Type: application/json
```

**Response**:
```json
{
  "id": 1,
  "name": "Pear",
  "quantity": 1
}
```

### Update a Fruit

**Request**:
```bash
PUT http://localhost:8080/fruits/1
Content-Type: application/json

{
  "id": 1,
  "name": "Apple",
  "quantity": 7
}
```

**Response**:
```json
{
  "id": 1,
  "name": "Apple",
  "quantity": 7
}
```

### Delete a Fruit

**Request**:
```bash
DELETE http://localhost:8080/fruits/1
Content-Type: application/json
```

**Response**:
Status: `204 No Content`
