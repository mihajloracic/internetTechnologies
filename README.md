
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

<div class="section"><div class="titlepage"><div><div><h2 class="title" style="clear: both"><a name="using-boot-running-with-the-maven-plugin" href="#using-boot-running-with-the-maven-plugin"></a>&nbsp;Using the Maven Plugin</h2></div></div></div><p>The Spring Boot Maven plugin includes a <code class="literal">run</code> goal that can be used to quickly compile
and run your application. Applications run in an exploded form, as they do in your IDE.
The following example shows a typical Maven command to run a Spring Boot application:</p><pre class="screen">$ mvn spring-boot:run</pre><p>You might also want to use the <code class="literal">MAVEN_OPTS</code> operating system environment variable, as
shown in the following example:</p><pre class="screen">$ export MAVEN_OPTS=-Xmx1024m</pre></div>
