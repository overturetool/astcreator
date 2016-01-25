# The Overture AstCreator Tool [![Build Status](https://travis-ci.org/overturetool/astcreator.png?branch=master)](https://travis-ci.org/overturetool/astcreator)

This generates heterogenous ASTs in Java for the Overture project, and should be applicable to anything else that needs an AST.

## Using AstCreator as a Maven plugin

~~~xml
<plugin>
  <groupId>org.overturetool.astcreator</groupId>
  <artifactId>astcreator-plugin</artifactId>  
  <version>1.6.8</version>
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

## Using the core jar

The `jar` produced from the `core/` directory is embeddable; please contact us if you plan to use it.

## Making a release

See https://github.com/overturetool/astcreator/wiki/Release-Procedure


# Specification Language

# AST Specification Syntax and Template

The specification consists of:


- 1. Base and analysis package declerations
- 2. Tokens section
 - Definition of any externally specified nodes. This is nodes that is manually written in Java and implements `INode`
 - Definition of external java types
  - `enum`
	- any object
- 3. Abstract Syntax Tree: This is the definition of the AST itself it consists of:
	- Level 0 nodes prefixed after generation with `P`
	- Level 1+ nodes prefixed after generation with `S` and in the specification with `#`
	- Leaf nodes prefixed after generation with `A` and specified as {node name} followed by field declerations. Only these nodes can be instantiated.

Both all nodes can speficy fields both only Level X can specify packages.


```
Packages
base org.overture.ast.node;
analysis org.overture.ast.analysis;
  
Tokens

  LexStringToken = 'java:node:org.overture.ast.intf.lex.ILexStringToken';
  location = 'java:org.overture.ast.intf.lex.ILexLocation';
  
  nameScope = 'java:enum:org.overture.ast.typechecker.NameScope';
  
  //Java
  java_Boolean = 'java:java.lang.Boolean';
  java_Integer = 'java:java.lang.Integer';
  
Abstract Syntax Tree

exp {-> package='org.overture.ast.expressions'
	| (type):type 
	| [location]:location}
    =   #Unary
    |   #Binary
		|		{apply} [root]:exp [args]:exp* (argtypes):type*
    ;
    
#Unary {-> package='org.overture.ast.expressions'
	|	[exp]:exp}
    =   {absolute} 
		;
```

# To String Specification Syntax and Template

The ToString extension is used to generate `toString` method bodies for AST nodes.

The structure consist of two parts:

- 1. Import declerations
- 2. *ToString* specifications

The *ToString* specification is a fully qualified AST name of the format:

```
<tostring-body> ::= "%" <path> "=" <body>

<path> ::= <text> <s-name>* "->" <text>
<s-name> ::= "->" <text> 

<body> ::= <field> | <java-embeding> | <string> | "+"
<field> ::= "[" <text> "]"
<java-embeding> ::= "$" \.* "$"
<string> ::= "\"" <text> "\""
 
```



```
To String Extensions

// import packages used by external $$ java code
import org.overture.ast.util.Utils;
import org.overture.ast.util.ToStringUtil;

%CG->#decl->classHeader = [name]


```
