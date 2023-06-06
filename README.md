# spring-derived-query
En este proyecto vamos a jugar con las derived query, sort y pageable


**Vamos a tratar de implementar los siguientes items:**

<ol>
	<li>Agregar la dependencia de spring JDBC</li>
	<li>Agergar dependencia para el DBMS lightweight <a href="https://www.h2database.com/html/main.html">Página oficial H2</a></li>
	<li>Prefijar el nombre de la BD en el archivo <b>applications.properties</b></li>
	<li>Agregar un campo id a los objetos del dominio que no lo tengan (Del tipo Long)</li>
	<li>Crear el archivo schema.sql con el DDL de las tablas y ponerlo en /src/main/resources</li>
	<li>Crear el archivo data.sql con los datos precargados de las tablas y ponerlo en /src/main/resources</li> 
	<li>Cambiar el controller DiseniarPizzaController para que utilice el repo de Ingredientes</li>
	<li>También debemos hacer lo mismo con el Converter IngredienteConverter</li> 
</ol>


https://www.baeldung.com/spring-data-jpa-query