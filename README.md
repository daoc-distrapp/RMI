# RMI
Ejemplo base de RMI

### Compilar y empaquetar
En el dir raíz ya tiene el código en rmi.jar. Si hace cambios y necesita actualizar, entonces, 
abra una consola en el dir raíz del proyecto (supongamos que es /home/ubuntu/git/RMI) y ejecute:

`cd bin && jar cvf ../rmi.jar rmi/* && cd ..`

### Ejecutar rmiregistry
Supongamos que está en la máquina mp1.local. 
Supongamos también que el rmi.jar se encuentra en `/home/ubuntu/rmi.jar`.
Abra una consola y ejecute:

`rmiregistry -J-Djava.rmi.server.codebase=file:/home/ubuntu/rmi.jar`

### Ejecutar servidor
Debe estar en el mismo equipo que el rmiregistry!
Abra una consola nueva y ejecute:

`java -cp /home/ubuntu/rmi.jar -Djava.rmi.server.hostname=mp1.local rmi.Server`

### Ejecutar cliente
Los clientes pueden estar en cualquier otra máquina.
Supongamos también que el código está en `/home/ubuntu/rmi.jar`.
Abra una consola y ejecute:

`java -cp /home/ubuntu/rmi.jar rmi.Client mp1.local`

<!---
Podría ser necesario en el cliente!?
-Djava.security.policy=todos.policy
-->


