package com.example;

import android.app.Activity;
import android.os.Bundle;

public class Bar extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	System.out.println("------- about to call Foo.sayHello()");
	Foo foo = new Foo();
	foo.sayHello();
    }
}
