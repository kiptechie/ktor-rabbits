
# ktor-rabbits
A simple backend with ktor


**Random Rabbits**
----
  Returns json data of a random rabbit.

* **URL**

  /rabbit:random

* **Method:**

  `GET`
  
*  **URL Params**

	None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
     ```json
      {
      "success": true,
      "message": "A random rabbit",
      "rabbits": null,
      "rabbit": {
        "id": 5,
        "name": "Rabbit 5",
        "description": "Just a fake description 5",
        "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit5.jpg"
      },
      "count": null 
      }
      ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** 
    ```json
    { error : "Unprecedented error!" }
    ```

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "https://ktor-rabbits.herokuapp.com/rabbit:random",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```



**Find a Rabbit**
----
  Returns json data of a rabbit given the id.

* **URL**

  /rabbit:find

* **Method:**

  `GET`
  
*  **URL Params**

	 **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
     ```json
     {
	   "success": true,
	   "message": "Rabbit with id:4",
	   "rabbits": null,
	   "rabbit": {
		  "id": 4,
		  "name": "Rabbit 4",
		  "description": "Just a fake description 4",
		  "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit4.jpg"
	   },
	  "count": null
    }
     ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** 
    ```json
    { error : "Unprecedented error!" }
    ```

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "https://ktor-rabbits.herokuapp.com/rabbit:find?id=4",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```



 **Rabbits**
----
  Returns json data of a list of rabbits.

* **URL**

  /rabbits

* **Method:**

  `GET`
  
*  **URL Params**

	None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**
     ```json 
      {
      "success": true,
      "message": "List of all rabbits",
      "rabbits": [
        {
          "id": 1,
          "name": "Rabbit 1",
          "description": "Just a fake description 1",
          "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit1.jpg"
        },
        {
          "id": 2,
          "name": "Rabbit 2",
          "description": "Just a fake description 2",
          "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit2.jpg"
        },
        {
          "id": 3,
          "name": "Rabbit 3",
          "description": "Just a fake description 3",
          "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit3.jpg"
        },
        {
          "id": 4,
          "name": "Rabbit 4",
          "description": "Just a fake description 4",
          "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit4.jpg"
        },
        {
          "id": 5,
          "name": "Rabbit 5",
          "description": "Just a fake description 5",
          "imageUrl": "https://ktor-rabbits.herokuapp.com/rabbits/rabbit5.jpg"
        }
      ],
      "rabbit": null,
      "count": 5
    }
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** 
    ```json
    { error : "Unprecedented error!" }
    ```

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "https://ktor-rabbits.herokuapp.com/rabbits",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```

