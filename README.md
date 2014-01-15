astCreator
==========

This generates heterogenous ASTs in Java for the Overture project, and should be applicable to anything else that needs an AST.



Steps to release a new vertion to the online repository
--------------
The releasing procedure is a three step procedure:

	1. Increment version number
	2. Local deploy
	3. Upload of the deployed artifacts into the online repository
	

### Incrementing the version numbers

There are two tasks to perform:

	1. update the maven version numbers
	2. update the asteditor Manifest bundle-version
	
In this example the current version is "1.6.0" and the new version is "1.6.1".
First run the following commend in the root of the repository to update all maven versions
```
mvn versions:set -DnewVersion=1.6.1 -Dtycho.mode=maven
```
Next go to "eclipse\astEditor\META-INF\MANIFEST.MF" and update the line bundle-version to match "Bundle-Version: 1.6.1".

### Local Deploy

To build the new release version run:
```
mvn deploy
```

### Upload of the deployed artifacts into the online repository
The final step is to upload the newly deployed release version to the online repository. This is done by running the following command in the root of the repository:

```
mvn -N -Pdev-repo 
```
