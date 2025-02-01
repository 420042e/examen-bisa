# Implementación de la Aplicación

## Estrategia
La aplicación fue desarrollada siguiendo una arquitectura RESTful, lo que permite una separación entre el cliente y el servidor. Se utilizó el patrón de diseño MVC (Modelo-Vista-Controlador) para organizar el código en capas lógicas, lo que facilita el mantenimiento y la escalabilidad de la aplicación.

## Tecnologías y Frameworks
- **Spring Boot**: Framework de Java para el desarrollo de aplicaciones basadas en Spring. Proporciona un servidor embebido (Tomcat) y configuración automática, lo que reduce el tiempo de desarrollo.
- **Spring Web**: Para la creación de endpoints RESTful y el manejo de solicitudes HTTP.
- **Java 17**: Versión de Java utilizada para el desarrollo, ya que es una versión LTS (Long-Term Support), lo que garantiza estabilidad y soporte a largo plazo.
- **Docker**: Para empaquetar la aplicación en un contenedor, garantizando su portabilidad y consistencia en diferentes entornos.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **Swagger**: Herramienta para la documentación del proyecto.

## Implementación de las Distintas Partes de la Solución

### Gestión de Blogs
- Se implementaron endpoints para crear blog, actualizar blog, consultar un blog específico o varios blogs, agregar comentarios en un blog.
- Cada blog contiene información como título, tema, contenido, periodicidad y un campo para permitir comentarios.
- Se mantiene un histórico de versiones para cada blog, lo que permite rastrear cambios a lo largo del tiempo.

### Gestión de Comentarios
- Los comentarios se pueden agregar a un blog siempre y cuando este permita comentarios.
- Cada comentario incluye información del autor (nombre, correo, país) y una puntuación entre 0 y 10.
- Se calcula un resumen de puntuaciones en función a los comentarios (mínimo, máximo y promedio) para cada blog.

### Manejo de Errores
- Se implementó un manejo centralizado de excepciones utilizando `@ControllerAdvice` y `@ExceptionHandler`.
- Se definieron excepciones personalizadas para errores de negocio, como "Blog no encontrado" o "Comentarios no permitidos".

### Persistencia en Memoria
- Los datos se almacenan en memoria utilizando estructuras de Java (`Map` y `List`), lo que elimina la necesidad de una base de datos externa.
- Esto simplifica la implementación y es adecuado para una aplicación de prueba.

### Despliegue en Contenedor
- La aplicación se empaquetó en una imagen Docker, lo que permite su ejecución en cualquier entorno que soporte contenedores.
- Se proporcionó un `Dockerfile` para facilitar el despliegue.

### Instrucciones para crear y levantar la aplicación desde el Dockerfile.
- Ingresar a la ruta del proyecto
- Construir la Imagen Docker con el siguiente comando:

`docker build -t blog-app .`

- Ejecutar la Aplicación en un Contenedor con el siguiente comando:

`docker run -p 8080:8080 blog-app`

### Instrucciones para acceder a swagger
- Ingresar a la ruta:

`http://localhost:8080/swagger-ui/index.html`

## Recomendaciones
- **Pruebas**: Se recomienda utilizar herramientas como Postman o `curl` para probar los endpoints de la API.
