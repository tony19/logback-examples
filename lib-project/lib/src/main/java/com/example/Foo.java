package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {
	public Foo() {}

	public void sayHello() {
            org.slf4j.Logger log = LoggerFactory.getLogger(Foo.class);
            log.info("hello world!");
	}
}

