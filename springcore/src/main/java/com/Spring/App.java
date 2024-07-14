package com.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.dependenciestest.Person;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.dependenciestest");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getPersonDetails());

//

    }
}
