Proyecto Inversiones 
======================

Estructura de directorios
-------------------------

* __broker__: todos los archivos necesarios para la instalación del los WS en el MB.

* __dep__: librerias que deben ser instaladas en nuestro repositorio maven.

* __doc__: documentación del sistema

* __etc__: archivos de configuración que deben estar disponible en el classpath de la aplicación, por ejemplo:
    
		/opt/IBM/WebSphere/AppServer/profiles/appsrv01/properties		  

* __mockups__: templates html de la aplicación.

* __src__: fuentes de la aplicacion, instalar y generar artefactos:
    
		mvn install 


