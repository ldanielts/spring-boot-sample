# spring-boot-sample
Scaffold of a Maven project with spring-boot. Included BOWER configuration for AngularJS and Bootstrap. Just run the following command on the base folder of the application.

    bower install

## Proposed Exercise:
Write a set of REST services with two endpoints:

* GET service to *retrieve* the Greeting Message of the Day
* POST service to *change* the current Greeting Message.

Observations:
* The Greeting Message should be a Spring Bean.
* The Greeting Message could be stored on memory. It can be a Singleton. 
* The application should be self-contained
* The application *SHOULD NOT* use WEB.XML or any spring XML configuration.

### Challenge 1:
Use JERSEY instead of Spring Web

### Challenge 2:
Write a set of JUNIT Tests to test the endpoints.

### Challenge 3:
Write an Angular Application to show the current Greeting Message, and a form to change it. Bonus points if using IIFE. 
Extra-bonus points for using one-time binding when showing the Greeting Message.

### Message from Daniel:
I am not so used with Jersey. In fact, I am not used at all and my first thought was not accepting the first challenge.
However, I searched for examples, searched the other contributors work and managed to get the application running.
Once I could not get all the Jersey tests running, I left the first version of my tests (without Jersey) for any one who might be interested. And this is it.
