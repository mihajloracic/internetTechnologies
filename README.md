Working version
https://wheretogotonight.herokuapp.com/index.html


Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

<div class="section"><div class="titlepage"><div><div><h2 class="title" style="clear: both"><a name="using-boot-running-with-the-maven-plugin" href="#using-boot-running-with-the-maven-plugin"></a>&nbsp;Using the Maven Plugin</h2></div></div></div><p>The Spring Boot Maven plugin includes a <code class="literal">run</code> goal that can be used to quickly compile
and run your application. Applications run in an exploded form, as they do in your IDE.
The following example shows a typical Maven command to run a Spring Boot application:</p><pre class="screen">$ mvn spring-boot:run</pre><p>You might also want to use the <code class="literal">MAVEN_OPTS</code> operating system environment variable, as
shown in the following example:</p><pre class="screen">$ export MAVEN_OPTS=-Xmx1024m</pre></div>


<h2> Get access token example </h2>
<div class="section><pre class="screen">var data = null;

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("POST", "http://localhost:8080/oauth/token?grant_type=password&username=user&password=user");
xhr.setRequestHeader("authorization", "Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0");
xhr.setRequestHeader("cache-control", "no-cache");
xhr.setRequestHeader("postman-token", "ed0c00f7-697b-6b86-6d2c-789414b01b7d");

xhr.send(data);</pre>
</div>
