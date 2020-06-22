# TPFinal-Redes

## Pasos a seguir para utilizarlo

    1. Clonar el repositorio.

    - Mediante un IDE:

    2. Abrir el proyecto con un IDE que soporte Java, preferentemente Intellij.
    3. Ejecutar la clase ServerMain y la clase ClientMain para comenzar a utilizar la aplicacion.

    - Mediante la consola:

    2. Abrir una consola para el servidor y una o mas para clientes. 
    3. Para ejecutar el servidor, dirigirte utilizando el comando cd a "..\tpFinalRedes\build\server-jar" y luego ingresar el comando "java -jar server-jar.jar".
    4. Para ejecutar cada cliente, dirigirte utilizando el comando cd a "..\tpFinalRedes\build\client-jar" y luego ingresar el comando "java -jar client-jar.jar".


## Preguntas

### 1. ¿Que es un puerto? 
     Un puerto es un punto de conexión dedicado al intercambio de información y la transmisión de datos con otras computadoras o perifericos. Los datos viajan desde un puerto en el dispositivo inicial, dirigiendose hacia el extremo receptor de la línea. 
### 2. ¿Como estan formados los endpoints?
     Un endpoint es un dispositivo informático remoto que se comunica con una red a la que está conectado, y esta conformado por un puerto y una dirección de IP que se utilizan para acceder a la red.
### 3. ¿Que es un socket? 
     Es un método para la comunicación entre un programa del cliente y un programa del servidor en una red, y es definido como el punto final en una conexión. Estos sockets se realizan y movilizan junto con un conjunto de peticiones de programación que se identifican como llamadas de función, lo que técnicamente se denomina interfaz de programación de aplicaciones (API). Basicamente, un socket tiene la funcion de intercomunicar diferentes procesos actuando como una interfaz de entrada y salida de datos.
### 4. ¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Porque?
     Pertenecen a la capa de transporte del modelo TCP/IP ya que se encargan del transporte de los flujos de datos, sin importar el tipo de red física que se esté utilizando.
### 5. ¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets?
     El funcionamiento se da a traves de la comunicacion mediante sockets entre un servidor y uno o mas clientes. Los sockets cumplen la funcion de trasladar los paquetes de informacion de manera bidireccional hacia los puertos correspondientes, utilizando flujos de entrada y salida de datos.
### 6. ¿Cuales son las causas comunes por la que la conexión entre cliente/servidor falle?
     - El servidor intenta enviar una respuesta a un cliente que ya no esta conectado.
     - El cliente no puede conectarse al servidor porque este no esta habilitado.
     - El servidor se desvía del flujo de control. 
     - El puerto a utilizar por el servidor no esta habilitado.
     - El cliente ingresa un host o un puerto incorrecto al intentar conectarse a un servidor.
### 7. Diferencias entre sockets UDP y TCP
     La principal diferencia entre ambos es que el UDP necesita que le entregemos paquetes de datos que el usuario debe construir, mientras el TCP admite bloques de datos que serán empaquetados de forma transparente antes de ser transmitidos.
     Los sockets UDP son más rápidos y eficientes que los TCP, mientras que estos se caracterizan por su fiabilidad. Ademas, los TCP son orientados a la conexion, a diferencia de los UDP que no son orientados a la conexion.
### 8. Diferencia entre sync & async sockets?
     Al momento de realizar una comunicacion mediante un socket sincrono esta se entabla de manera bloqueante, es decir, el socket debera esperar una respuesta una vez que haya finalizado el envio de datos. Luego de obtener una respuesta, el socket estara disponible para realizar otro transporte.
     En cambio, cuando se trata de un socket asincrono no se espera una respuesta cuando los datos hayan sido enviados, por lo tanto no se produce ningun bloqueo en la comunicacion y el envio y recepcion de datos se realizan de manera paralela.




