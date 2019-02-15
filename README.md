# Prints Java System Defaults for Locale, Currency, Country & TimeZone 

Build the JAR with all dependencies
```console
$ ./gradlew fatJar
```
Run the JAR using sandbox Java installation
```console
$ java -jar ./build/libs/locale-test-all-1.0.jar
```
Bulid & Run Docker container
```console
$ docker build -t locale-test --no-cache .
$ docker run -it --rm locale-test
```
Run with following environment variables to see the correct user.country/currency/time
```console
$ docker run -e JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -e LC_ALL=c.UTF-8 -e LANG=C.UTF-8 -it --rm locale-test
```