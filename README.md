# ChallengeShopRUs
Proyectps creados por Eduardo García Solis - Baufest

Propuesta de solución a Challenge ShopRUs: La arquitectura de la aplicación está conformada por 6 componentes:
        
        1- Microservicio de clientes: Con el se puede crear usuarios y acceder al registro de usuarios. Usa la BD "db_microservicios_usuarios" y el esquema "clientes"
        2- Microservicio de descuentos y productos: Con el se puede crear descuentos, ver detalle que descuentos aplican a un producto y listar los descuentos. Usa la BD "db_microservicios_usuarios" y el esquema "descuentos"
        3- Microservicio de facturas: Con el se puede facturar (una orden de productos con el usuario que realiza la compra y obteniendo total con y sin descuento). Usa la BD "db_microservicios_facturas" y el esquema "facturas"
        4- Servidor Eureka: Discovery Server que habilita la registro de N cantidad de instancias de los microservicios al ambiente. Los proyectos de microservicios están configurados para poder agregar múltiples instancias sin importar que ya exista una del mismo tipo.
        5- Gateway: Servidor Gateway que sirve de punto de acceso para los microservicios y de balanceador en caso de que haya más de una instancia del mismo tipo un microservicios
        6- Biblioteca con clases genericas y comumes que se comparten entre los microservicios

Requisitos para su ejecución:
        
        1- Tener instaldo Java 11 o superior
        2- Contar con una instalación de Gradle
        3- Tener acceso a un manejador de BD Postgres ya sea local o remota.
        4.- Tener disponibles los puertos 8761 y 8090

Configuración:
        
        1- Descargar solución completa, los 6 componentes (3 microservicios, eureka, gateway y biblioteca commons/generic), todos los componentes deberán estárn en la misma carpeta
        2- Ingresar a la carpeta "generics-microservicios" y ejecutar la tarea de gradle "jar". Esto crear el Jar de la biblioteca, la cual será usada por los microservicios
        3- Los microservicios clientes (carpeta microservicios-clientes), facturas (carpeta facturas) y descuentos (carpeta descuentos) vienen configurados para usar una BD Postrgres de forma local, esto se puede modificar en los archivos "application-dev.properties", archivo que se ubica src/main/resources
        4- En caso de usar la configuración establecida, asegurese de que en dicha BD existan las bases de datos "db_microservicios_usuarios" con los esquemas "clientes" y "descuentos" y la base de datos "db_microservicios_facturas" con el esquema "facturas"
        5- Los microservicios vienen configurados para crear la estructura de la BD así como sus reglas de integridad (primary keys, constraints, etc)
        6- Para crear los JARs de ejecución entrar a cada uno de las carpetas de los modulos (3 microservicios, eureka y gateway) y construir los ejecutables con el comando de gradle "gradlew.bat clean build -x:test"
        7- Esto creara los JARs listos para ser ejecutados, el orden de ejecución es de la siguiente: 1 eureka, 2 microservicio clientes, 3 microservicio descuentos, 4 microservicio factuas y 5 gateway
        8- Antes de usar, ejecute el archivo SQL dentro de la BD
       
Una vez que todos los componentes estén en ejecución podrá lanzar peticiones HTTP a través de la utilería de Swagger, la ruta es http://localhost:8090/swagger-ui/index.html