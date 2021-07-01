# ChallengeShopRUs
Proyecto creados por Eduardo García Solis - Baufest

API Rest con los servicios para gestionar Clientes, Descuentos y Facturas

Requisitos para su ejecución:
        
        1- Tener instaldo Java 11 o superior
        2- Tener acceso a un manejador de BD Postgres ya sea local o remota.
        3.- Tener disponibles los puertos 8080

Configuración:
        
        1- Ingresa la configuración de tu BD en el archivo src\main\resources\application-dev.properties, deberas ingresar IP, nombre base de datos, usuario y contraseña
        2.- Usa el script "Crear BD.sql" para crear los esquemas dentro de la BD
        3.- Para arrancar la aplicación usa el comando: En Windows es ".\gradlew.bat clean build bootRun -x:test" y en Linux ".\gradlew clean build bootRun -x:test"
        4.- Una vez arriba la aplicación usa el script "Llenado BD.sql" para llenar los catalogos e ingresar registros. También para tener los descuentos planteados en el Challenge
       
Una vez que la aplicación esté en ejecución podrá lanzar peticiones HTTP a través de la utilería de Swagger, la ruta es "http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config"