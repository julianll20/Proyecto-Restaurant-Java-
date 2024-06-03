##Subido al repositorio (https://github.com/julianll20/Proyecto-Restaurant-Java-)
##Proyecto: Administracion de restaurante por Julian Llera.
##Es un trabajo simple usando la tecnologia Java.
##Descripción General del Proyecto:
El proyecto consiste en un sistema de gestión de reservas para un restaurante. Está diseñado para facilitar la administración de las reservas de mesas, clientes y empleados, así como para proporcionar una interfaz para realizar operaciones como realizar, cancelar y modificar reservas, asignar mesas a clientes sin reserva, y visualizar la disponibilidad de mesas y el historial de reservas.

Funcionalidades Principales:
Gestión de Reservas:

Los clientes pueden realizar reservas ingresando su información personal, seleccionando una mesa disponible, y especificando la fecha, hora y número de personas para la reserva.
Las reservas se registran en el sistema junto con los datos del cliente y la mesa asignada.
Los clientes también tienen la opción de cancelar sus reservas, lo que libera la mesa para futuras reservas.
Asignación de Mesas:

Además de realizar reservas, los clientes sin reserva pueden solicitar una mesa disponible en el restaurante.
Si hay mesas disponibles, se asigna una mesa al cliente sin reserva, y se registra en el sistema como ocupada.
Gestión de Empleados:

El sistema también gestiona la información de los empleados del restaurante, incluyendo camareros y cocineros.
Cada empleado tiene un nombre y un puesto, y puede ser asignado a sus respectivas tareas dentro del restaurante.
Visualización de Disponibilidad:

El sistema permite a los usuarios visualizar la disponibilidad de mesas en tiempo real, mostrando qué mesas están ocupadas y cuáles están disponibles en un momento dado.
También proporciona un historial de reservas, mostrando las reservas pasadas junto con la información del cliente y la fecha/hora de la reserva.
Arquitectura del Proyecto:
El proyecto sigue una arquitectura orientada a objetos y está organizado en clases que representan entidades del dominio del restaurante, como Cliente, Reserva, Mesa y Empleado. Estas clases están agrupadas en un paquete llamado restaurante para mantener la modularidad y la cohesión del código. Se utilizan clases abstractas, como Empleado, para definir comportamientos comunes entre diferentes tipos de empleados.

El sistema utiliza ArrayLists para almacenar y gestionar colecciones dinámicas de objetos, como listas de mesas, reservas, clientes y empleados. Los atributos estáticos se utilizan para realizar un seguimiento global de ciertos datos, como el número total de mesas en el restaurante.

Interacción con el Usuario:
El usuario interactúa con el sistema a través de una interfaz de línea de comandos (CLI), donde se presentan diferentes opciones de operaciones, como realizar, cancelar y modificar reservas, asignar mesas a clientes sin reserva, y visualizar la disponibilidad de mesas y el historial de reservas. El sistema procesa las entradas del usuario y realiza las acciones correspondientes en función de las opciones seleccionadas.

Conclusión
En resumen, el proyecto proporciona una solución integral para la gestión de reservas en un restaurante, automatizando procesos como la reserva de mesas, el seguimiento de reservas y la asignación de mesas a clientes sin reserva. Utiliza una arquitectura orientada a objetos y técnicas de programación avanzadas, como clases abstractas, paquetes y ArrayLists, para lograr una implementación modular, eficiente y fácil de mantener.

