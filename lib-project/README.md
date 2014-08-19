
This project demonstrates how to build an app that depends on an Android library
project (apklib) that uses logback-android.

### Modules
#### LibFoo
`Foo.sayHello()` uses SLF4J to output "hello world". logback-android is on classpath.

#### AppBar
`Bar.onCreate()` calls `Foo.sayHello()`.

### Build

    git clone https://github.com/tony19/logback-examples.git -b sandbox
    cd logback-examples/lib-project
    ./build.sh

`build.sh` will build and install the library and then the app.
