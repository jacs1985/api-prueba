# api-prueba
hola esta es un api para probar un servicio de registro, los valores que se pueden probar con postman son;
      .- url: http://localhost:8080/api/users/register // POST
      .- valores de la peticion son en body es en raw y en JSON 
            {
          "name": "Juan cuevas",
          "email": "juan@cuevas.org",
          "password": "Hunter2@",
          "phones": [
                    {
                        "number": "1234567",
                        "citycode": "1",
                        "contrycode": "57"
                    }
                  ]
          }
