Primecalc
==========

This is a small demo application testing numbers for primality.


Build using Maven 3.* and Java 8:
----------------------------------

```
$mvn install
```

This will create two jar files under the target/ directory:

* primecalc-1.0.jar
* primecalc-1.0.one-jar.jar

The .one-jar.jar is a fat jar file that contains all dependencies.


Run 
----

With default options:
```
$java -jar primecalc-1.0.one-jar.jar
```

With optional output file for results:

```
$java -jar primecalc-1.0.one-jar.jar -o /some/path/to/file
```

Display usage help:

```
$java -jar primecalc-1.0.one-jar.jar --help
```

or

```
$java -jar primecalc-1.0.one-jar.jar -h
```


Command line options:
---------------------

```
 -h,--help                Show help
 -o,--output-file <arg>   Append results to a file
```
