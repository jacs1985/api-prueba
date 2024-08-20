# api-prueba
hola esta es un api para probar un servicio de registro,Instrucciones para Realizar el Registro de un Usuario en Postman
Para registrar un nuevo usuario en el sistema utilizando Postman, sigue estos pasos:

1. Abrir Postman
      Asegúrate de tener Postman instalado y abierto en tu computadora.
2. Crear una Nueva Solicitud
      Haz clic en "New" y selecciona "Request" para crear una nueva solicitud.
3. Configurar la Solicitud
      Método HTTP: Selecciona POST del menú desplegable de métodos HTTP.
      URL de la Solicitud: Introduce la siguiente URL en el campo de dirección:

            http://localhost:8080/api/users/register
            Si tu aplicación está corriendo en un puerto diferente, asegúrate de ajustar la URL en consecuencia.
4. Configurar el Cuerpo de la Solicitud (Body)
      Haz clic en la pestaña "Body" en Postman.
      Selecciona la opción raw y asegúrate de que el tipo de contenido esté configurado como JSON desde el menú desplegable       a la derecha.
      En el campo de texto que aparece, introduce el siguiente JSON, que contiene los detalles del usuario que deseas                   registrar:
            {
                "name": "Juan Rodriguez",
                "email": "juan@rodriguez.org",
                "password": "Hunteeer2@",
                "phones": [
                    {
                        "number": "1234567",
                        "citycode": "1",
                        "contrycode": "57"
                    }
                ]
            }
5. Enviar la Solicitud
      Una vez que hayas configurado todo, haz clic en el botón "Send" para enviar la solicitud.
6. Revisar la Respuesta
      Si el registro es exitoso, deberías recibir una respuesta con código de estado 201 Created y un cuerpo JSON que              contiene los siguientes campos:
      
            {
                "id": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
                "created": "2023-08-20T14:28:23.382Z",
                "modified": "2023-08-20T14:28:23.382Z",
                "lastLogin": "2023-08-20T14:28:23.382Z",
                "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
                "active": true
            }
      Si el registro falla (por ejemplo, si el correo ya está registrado o la contraseña no cumple con los requisitos), 
      recibirás una respuesta con un código de estado 400 Bad Request y un mensaje de error en el siguiente formato:

      {
          "mensaje": "El correo ya registrado"
      }
7. Errores Comunes
      Error 400: Verifica que el correo y la contraseña cumplan con los requisitos.
      Error 500: Asegúrate de que el servidor esté corriendo y que la URL esté correcta.
