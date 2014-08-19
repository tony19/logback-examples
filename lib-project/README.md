h1. Purpose

This project demonstrates how to build an Android App that depends on an Android library
project (apklib) that uses SLF4J and logback-android.

h1. Design

 * LibFoo
 ** `Foo.sayHello()` uses SLF4J to output "hello world". logback-android is on classpath.

 * AppBar
 ** `Bar.onCreate()` calls `Foo.sayHello()`.
