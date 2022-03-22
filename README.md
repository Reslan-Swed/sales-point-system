# sales-point-system
A demo that uses AOP, custom validator &amp; JSON selializers implemented using Spring Boot framwork

# API Reference 📙

## Clients

**The client API allows you to create, update and retrieve all exist clients**

1. List all exist clients:

   *Endpoint*: 🚩

   > ```
   > GET /clients
   > ```

   *Parameters*: 🔠

   ​	None

   *Default Response:* ✅

   ```
   Status: 200 OK
   ```

   > ```json
   > [
   >     {
   >         "id": 1,
   >         "name": "Client 1",
   >         "lastName": "Client 1",
   >         "mobile": "0987654321"
   >     }
   > ]
   > ```

2. Create a client:

   *Endpoint*: 🚩

   > ```
   > POST /clients
   > ```

   *Parameters*: 🔠

   | Name       | Type   | In   | Description                                     | Other details |
   | ---------- | ------ | ---- | ----------------------------------------------- | ------------- |
   | `name`     | string | body |                                                 | required      |
   | `lastName` | string | body |                                                 | required      |
   | `mobile`   | string | body | client's mobile phone in a form like 09xxxxxxxx | required      |

   *Default Response:* ✅

   ```
   Status: 201 CREATED
   ```

   > ```json
   > {
   >     "message": "Client created successfully"
   > }
   > ```

3. Edit existing client:

   *Endpoint*: 🚩

   > ```
   > PUT /clients/{id}
   > ```

   *Parameters*: 🔠

   | Name       | Type    | In   | Description                                     | Other details |
   | ---------- | ------- | ---- | ----------------------------------------------- | ------------- |
   | `id`       | integer | path | already exist client's id                       | required      |
   | `name`     | string  | body |                                                 |               |
   | `lastName` | string  | body |                                                 |               |
   | `mobile`   | string  | body | client's mobile phone in a form like 09xxxxxxxx |               |

   *Default Response:* ✅

   ```
   Status: 200 OK
   ```

   > ```json
   > {
   >     "message": "Client updated successfully"
   > }
   > ```

## Products

**The products API allows you to create, update and retrieve all exist products**

1. List all exist products:

   *Endpoint*: 🚩

   > ```
   > GET /products
   > ```

   *Parameters*: 🔠

   ​	None

   *Default Response:* ✅

   ```
   Status: 200 OK
   ```

   > ```json
   > [
   >     {
   >         "id": 1,
   >         "name": "Product 1",
   >         "description": "A very nice product",
   >         "createDate": "2021-02-18T09:28:39.119+00:00",
   >         "category": {
   >             "id": 1,
   >             "name": "Category 1"
   >         }
   >     }
   > ]
   > ```

2. Create a product:

   *Endpoint*: 🚩

   > ```
   > POST /products
   > ```

   *Parameters*: 🔠

   | Name          | Type    | In   | Description                 | Other details |
   | ------------- | ------- | ---- | --------------------------- | ------------- |
   | `name`        | string  | body |                             | required      |
   | `description` | string  | body |                             |               |
   | `categoryId`  | integer | body | already exist category's id | required      |

   *Default Response:* ✅

   ```
   Status: 201 CREATED
   ```

   > ```json
   > {
   >     "message": "Product created successfully"
   > }
   > ```

3. Edit existing product:

   *Endpoint*: 🚩

   > ```
   > PUT /products/{id}
   > ```

   *Parameters*: 🔠

   | Name          | Type    | In   | Description                 | Other details |
   | ------------- | ------- | ---- | --------------------------- | ------------- |
   | `id`          | integer | path | already exist product's id  | required      |
   | `name`        | string  | body |                             |               |
   | `description` | string  | body |                             |               |
   | `categoryId`  | integer | body | already exist category's id |               |

   *Default Response:* ✅

   ```
   Status: 200 OK
   ```

   > ```json
   > {
   >     "message": "Product updated successfully"
   > }
   > ```

## Sales

**The sale API allows you to create, update sale's entries and retrieve all exist sales**

1. List all exist sales:

   *Endpoint*: 🚩

   > ```
   > GET /sales
   > ```

   *Parameters*: 🔠

   ​	None

   *Default Response:* ✅

   ```
   Status: 200 OK
   ```

   > ```json
   > [
   >  {
   >      "id": 1,
   >      "createDate": "2021-02-18T09:44:50.154+00:00",
   >      "seller": {
   >          "id": 1,
   >          "name": "Seller 1"
   >      },
   >      "client": {
   >          "id": 1,
   >          "name": "Client 1",
   >          "lastName": "Client 1",
   >          "mobile": "0987654321"
   >  	 },
   >      "entries": [
   >          {
   >              "id": 1,
   >              "product": {
   >                  "id": 1,
   >                  "name": "Product 1",
   >                  "description": "A very nice product",
   >                  "createDate": "2021-02-18T09:40:01.981+00:00",
   >                  "category": {
   >                      "id": 1,
   >                      "name": "Category 1"
   >                  }
   >              },
   >              "price": 50.0,
   >              "quantity": 10
   >          },
   >          {
   >              "id": 2,
   >              "product": {
   >                  "id": 2,
   >                  "name": "Product 2",
   >                  "description": "A very nice product",
   >                  "createDate": "2021-02-18T09:44:46.000+00:00",
   >                  "category": {
   >                      "id": 2,
   >                      "name": "Category 2"
   >                  }
   >              },
   >              "price": 90.0,
   >              "quantity": 100
   >          }
   >      ],
   >      "total": 140.0
   >  }
   > ]
   > ```

2. Create a sale:

   *Endpoint*: 🚩

   > ```
   > POST /sales
   > ```

   *Parameters*: 🔠

   | Name                | Type    | In   | Description                | Other details |
   | ------------------- | ------- | ---- | -------------------------- | ------------- |
   | `sellerId`          | integer | body | already exist seller's id  | required      |
   | `clientId`          | integer | body | already exist client's id  | required      |
   | `entries`           | array   | body |                            | required      |
   | `entries.*.productId` | integer | body | already exist product's id | required      |
   | `entries.*.price`     | double  | body |                            | required      |
   | `entries.*.quantity`  | integer | body |                            | required      |

   *Default Response:* ✅

   ```
   Status: 201 CREATED
   ```

   > ```json
   > {
   >     "message": "Sale created successfully"
   > }
   > ```

3. Edit existing sale's entry:

   *Endpoint*: 🚩

   > ```
   > PUT /sales/{id}
   > ```

   *Parameters*: 🔠

   | Name        | Type    | In   | Description                                 | Other details |
   | ----------- | ------- | ---- | ------------------------------------------- | ------------- |
   | `id`        | integer | path | already exist sale's id                     | required      |
   | `productId` | integer | body | already exist sale's entry for product's id | required      |
   | `price`     | double  | body |                                             |               |
   | `quantity`  | integer | body |                                             |               |

   *Default Response:* ✅

   ```
   Status: 200 OK
   ```

   > ```json
   > {
   >     "message": "Sale entry updated successfully"
   > }
   > ```

   

------




