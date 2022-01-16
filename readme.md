# AD-1. Servicios web

### Introducción

Para desarrollar este proyecto hemos utilizado el lenguaje Java.

Ha sido implementado en un entorno Windows.

Su ejecución, esta explicado en el presente documento para el terminal de comandos de Windows.

---

### Instalación del Programa

En primer lugar, debemos de descargarnos el proyecto de GitHub, al que podemos acceder mediante este [link](https://github.com/rodrigoramil/ServicioWebAD1.git)

Una vez dispongamos del proyecto, lo importaremos a nuestro entorno de trabajo, indicándole que deseamos importar ***Existing Maven Projects*** e indicándole la ruta del proyecto.

---

### Ejecución del programa

Mediante el terminal de comandos de Windows, accederemos a la carpeta donde se encuentra nuestro proyecto, y allí accederemos a la carpeta ***target***.

A continuación, ejecutaremos el comando: 

- ***java -cp Proyecto-servicio-web-0.0.1-SNAPSHOT.jar paqueteServidor.Server***

Esto arrancará el servidor y estará preparado para realizar las pruebas de funcionamiento que se indican a continuación.


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

