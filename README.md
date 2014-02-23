# The Overture AstCreator Tool

This generates heterogenous ASTs in Java for the Overture project, and should be applicable to anything else that needs an AST.

## Using releases as a Maven plugin

~~~xml
<plugin>
  <groupId>org.overturetool.astcreator</groupId>
  <artifactId>astcreator-plugin</artifactId>  
  <version>1.6.4</version>
  <artifactId>root</artifactId>
  <executions>
    <execution>
      <id>java</id>
      <phase>generate-sources</phase>
      <goals>
        <goal>generate</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <ast>overtureII.astv2</ast>
  </configuration>
</plugin>
~~~

## Using snapshot versions

..._to be filled in_

## Using the core jar

The `jar` produced from the `core/` directory is embeddable; please contact us if you plan to use it.

## Making a release

See https://github.com/overturetool/astcreator/wiki/Release-Procedure
