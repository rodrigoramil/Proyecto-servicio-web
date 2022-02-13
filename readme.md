# AD-1. Servicios web

### Introducción

El proyecto esta implementado en lenguaje Java.

Para su ejecución utilizaremos un entorno Windows.

Necesitaremos tener instalado la [JDK](https://www.oracle.com/java/technologies/downloads/#jdk17-windows) de Java y  [Maven](https://maven.apache.org/download.cgi).

---

### Configuración de Variables de entorno

Tras la instalación de Maven, debemos configurar las variables de entorno para su correcto funcionamiento.
Para ello accederemos a las `Propiedades del sistema` y pulsaremos el botón `Variables de entorno...`, En esta ventana configuraremos lo siguiente:

- Pulsamos el botón `Nueva...` del aparatado variables del sistema. 
- Rellenaremos el nombre de la variable `JAVA_HOME` y la ruta donde esta instalado Java (por defecto `C:\Program Files\Java\jdk-17.0.1\`). 
- Añadiremos una nieva variable llamada `MAVEN_HOME` con el valor de la ruta donde esta la carpeta de Maven que habíamos descargado y descomprimido.
- Editaremos la variable de entorno llamada `path` y añadiremos a la lista `%JAVA_HOME%\bin` y `%MAVEN_HOME%\bin`.

---

### Instalación del Programa

En primer lugar, debemos de descargarnos el proyecto de GitHub, al que podemos acceder mediante este [link](https://github.com/rodrigoramil/Proyecto-servicio-web.git)

Una vez dispongamos del proyecto, lo importaremos a nuestro entorno de trabajo, abrimos una terminal de comandos de Windows, nos colocamos en la ruta de nuestro proyecto y ejecutamos los siguientes comandos:

- mvn install
- mvn jacoco:report

---

### Ejecución del programa

Una vez ejecutados los comandos anteriormente indicados, ejecutaremos el archivo `inicio.bat` (que se encuentra en la raíz del proyecto), que automatiza la ejecución del programa y abrirá dos webs, una con los resultados de las pruebas unitarias que nos facilita Jacoco y otra con la ejecución del programa donde podemos realizar las pruebas de funcionamiento (NOTA: la web esta preparada para ejecutarse en el navegador Firefox).

---

### Pruebas de funcionamiento

Al ejecutar el programa se arrancará un servidor local, al que accederemos mediante el puerto _1234_.

Para probar su correcto funcionamiento, abriremos un navegador web e introduciremos en la barra de direcciones ___127.0.0.1___ o ___localhost___ seguido del puerto ___1234___.

- `127.0.0.1:1234`
- `localhost:1234`

---

#### Almacenar

Para añadir una palabra al fichero _.txt_, que se crea automáticamente en la raíz del proyecto, si éste no existe, introduciremos en el navegador lo anteriormente citado, seguido de ___/almacena?___ e introduciendo la palabra que deseamos almacenar.
 
- `127.0.0.1:1234/almacena?palabra`
- `localhost:1234/almacena?palabra`

![ejemplo de almacenar una palabra](https://github.com/rodrigoramil/ServicioWebAD1/blob/master/img/almacena.PNG)

---

#### Consultar

Para consultar si la palabra introducida por el usuario ya se encuentra almacenada en el fichero y las veces que se encuentra repetida, obviando las mayúsculas, minúsculas y tildes; debemos introducir ___/consulta?___ seguido de la palabra que deseamos consultar.

- `127.0.0.1:1234/consulta?palabra`
- `localhost:1234/consulta?palabra`

![ejemplo de consultar una palabra](https://github.com/rodrigoramil/ServicioWebAD1/blob/master/img/consulta.PNG)

---

#### Sintaxis incorrecta

Si introducimos mal en la barra de direcciones alguno de los comandos indicados con anterioridad, obtendremos un mensaje en el navegador indicado como debemos realizar correctamente la sentencia de consulta o almacenaje.

![ejemplo de estructura incorrecta](https://github.com/rodrigoramil/ServicioWebAD1/blob/master/img/estructuraIncorrecta.PNG)

