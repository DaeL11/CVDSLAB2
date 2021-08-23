##
# Taller 2

Diego Alejandro Leon

Juan Sebastian Ospina

##
# PATTERNS - FACTORY

##
# LA HERRAMIENTA MAVEN

La herramienta [Apache Maven](https://maven.apache.org/) se usa para gestionar y manejar proyectos de software. La base de maven para un poyecto es el concepto de un modelo de objeto de proyecto (POM), Maven puede gestionar la compilación, los informes y la documentación de un proyecto a partir de este modelo, que se concreta en el archivo pom.xml.

Ingresar a la página de la herramienta y entender:

- Cuál es su mayor utilidad
  - Su mayor utilidad es la de manejar proyectos, empaquetar y usar plugins con facilidad.
- Fases de maven

![](https://i.ibb.co/Hg7tVRj/a.png)

- Ciclo de vida de la construcción
  - Son tres Clean, Default,Site
- Para qué sirven los plugins
  - Sirven para ampliar las funcionalidades y expandir las posibilidades de uso.
- Qué es y para qué sirve el [repositorio central de maven](https://www.mvnrepository.com/)
  - Aquí encuentras todas las librerías que se pueden usar en maven

##
# EJERCICIO DE LAS FIGURAS

##
# CREAR UN PROYECTO CON MAVEN

- Buscar cómo se crea un proyecto maven con ayuda de los arquetipos (archetypes).
- Busque cómo ejecutar desde línea de comandos el objetivo &quot;generate&quot; del plugin &quot;archetype&quot;, con los siguientes parámetros:
  - Grupo: edu.eci.cvds
  - Id del Artefacto: Patterns
  - Paquete: edu.eci.cvds.patterns
  - archetypeArtifactId: maven-archetype-quickstart

Se debió haber creado en el directorio, un nuevo proyecto Patterns a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Cambie al directorio Patterns:

$ cd Patterns

Para ver el conjunto de archivos y directorios creados por el comando mvn ejecute el comando tree.

$ tree

En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: tree /f). En caso que funcione, la salida muestra la estructura del proyecto, similar a como se muestra a continuación:

.

│ pom.xml

└───src

├───main

│ └───java

│ └───edu

│ └───eci

│ └───cvds

│ └───patterns

│ App.java

│

└───test

└───java

└───edu

└───eci

└───cvds

└───patterns

AppTest.java

![](https://i.ibb.co/wQyHqWN/b.png)

##
# COMPILAR Y EJECUTAR

- Para compilar ejecute el comando:
$ mvn package
Si maven no actualiza las dependencias utilice la opción -U asi:
$ mvn -U package

![](https://i.ibb.co/fXc7VSt/c.png)

- Busque cuál es el objetivo del parámetro &quot;package&quot; y qué otros parámetros se podrían enviar al comando mvn.

- Empaqueta el código compilado en su formato distribuible, normalmente como un fichero del tipo jar.
-

- Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase App.java como parámetro en &quot;mainClass&quot;. Tip: [https://www.mojohaus.org/exec-maven-plugin/usage.html](https://www.mojohaus.org/exec-maven-plugin/usage.html)
  - mvn exec:java -Dexec.mainClass=&quot;edu.eci.cvds.patterns.App&quot;

![](https://i.ibb.co/TT7tPp7/d.png)

- Realice el cambio en la clase App.java para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. Utilizar la primera posición del parámetro que llega al método &quot;main&quot; para realizar el saludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:
  - Buscar cómo enviar parámetros al plugin &quot;exec&quot;.
  - Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!
  - Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

![](https://i.ibb.co/hCLZPpW/e.png)

  - Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?

![](https://i.ibb.co/89bT96M/f.png)

![](https://i.ibb.co/93Xzhgr/g.png)

  - Verifique cómo enviar los parámetros de forma &quot;compuesta&quot; para que el saludo se realice con nombre y apellido.
    - mvn exec:java -Dexec.mainClass=&quot;edu.eci.cvds.patterns.App&quot; -Dexec.args=&quot;Args1 Args2 ...&quot;
  - Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!

![](https://i.ibb.co/QFcqmGf/h.png)

![](https://i.ibb.co/G9xsydF/i.png)

##
# HACER EL ESQUELETO DE LA APLICACIÓN

- Cree el paquete edu.eci.cvds.patterns.shapes y el paquete edu.eci.cvds.patterns.shapes.concrete.

Cree una interfaz llamada Shape.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes de la siguiente manera:
package edu.eci.cvds.patterns.shapes;

public interface Shape {

public int getNumberOfEdges();

- }

Cree una enumeración llamada RegularShapeType.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes así:
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {

Triangle, Quadrilateral, Pentagon, Hexagon

- }

En el directorio src/main/java/edu/eci/cvds/patterns/shapes/concrete cree las diferentes clases (Triangle, Quadrilateral, Pentagon, Hexagon), que implementen la interfaz creada y retornen el número correspondiente de vértices que tiene la figura. Siguiendo el ejemplo del triangulo:
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {

public int getNumberOfEdges() {

return 3;

}

- }

Cree el archivo ShapeMain.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes con el metodo main:
package edu.eci.cvds.patterns.shapes;

public class ShapeMain {

public static void main(String[] args) {

if (args == null || args.length != 1) {

System.err.println(&quot;Parameter of type RegularShapeType is required.&quot;);

return;

}

try {

RegularShapeType type = RegularShapeType.valueOf(args[0]);

Shape shape = ShapeFactory.create(type);

System.out.println(String.format(&quot;Successfully created a %s with %s sides.&quot;, type, shape.getNumberOfEdges()));

} catch (IllegalArgumentException ex) {

System.err.println(&quot;Parameter &#39;&quot; + args[0] + &quot;&#39; is not a valid RegularShapeType&quot;);

return;

}

}

}

- Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente.
- Cree el archivo ShapeFactory.java en el directorio src/main/java/edu/eci/cvds/patterns/shapes implementando el patrón fábrica, haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.

![](https://i.ibb.co/4fV56Zx/j.png)

- Ejecute múltiples veces la clase ShapeMain, usando el plugin _exec_ de maven con los siguientes parámetros y verifique la salida en consola para cada una:
  - Sin parámetros

![](https://i.ibb.co/G5yN8d6/k.png)

  - Parámetro: qwerty

![](https://i.ibb.co/HqbqsDF/m.png)

  - Parámetro: pentagon

![](https://i.ibb.co/P4Hhvnz/n.png)

  - Parámetro Hexagon

![](https://i.ibb.co/t360qjr/o.png)

- ¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?

- Funciona únicamente con el parámetro &#39;Hexagon&#39; debido a que hace parte de la enumeración creada en RegularShapeType. Mientras que si se envía un parámetro con un nombre erróneo o que no pertenezca a la enumeración manda una excepción, al igual que si no se envía el parámetro manda un mensaje diciendo que se requiere un parámetro que pertenezca a RegularShapeType.