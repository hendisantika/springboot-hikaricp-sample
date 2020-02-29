# springboot-hikaricp-sample
## Overview
[Hikari](https://github.com/brettwooldridge/HikariCP) is a JDBC DataSource implementation that provides a connection pooling mechanism.

Compared to other implementations, it promises to be lightweight and [better performing](https://github.com/brettwooldridge/HikariCP#jmh-benchmarks-checkered_flag) . For an introduction to Hikari, see this article.

This quick tutorial shows how we can configure a Spring Boot 1 or Spring Boot 2 application to use the Hikari DataSource.

## Configuring Hikari With Spring Boot 1.x
Spring Boot 1.x uses the [Tomcat JDBC Connection Pool](https://tomcat.apache.org/tomcat-8.5-doc/jdbc-pool.html) by default.

As soon as we include spring-boot-starter-data-jpa into our pom.xml, we'll transitively include a dependency to the Tomcat JDBC implementation. During runtime, Spring Boot will then create a Tomcat DataSource for us to use.

To configure Spring Boot to use the Hikari Connection Pool instead, we have two options.

## Maven Dependency
First, we need to include the dependency on Hikari in our pom.xml:

```
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>3.2.0</version>
</dependency>
```
The most current version can be found on [Maven Central](https://search.maven.org/classic/#search%7Cgav%7C1%7Cg%3A%22com.zaxxer%22%20AND%20a%3A%22HikariCP%22).

## Explicit Configuration
The safest way to tell Spring Boot to use Hikari is configuring the DataSource implementation explicitly.

To do this, we simply **set the property spring.datasource.type to the fully-qualified name of the DataSource implementation we want to use:**
```
@RunWith(SpringRunner.class)
@SpringBootTest(
    properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource"
)
public class HikariIntegrationTest {
 
    @Autowired
    private DataSource dataSource;
 
    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
    }
}
```

## Removing the Tomcat JDBC Dependency
The second option is to let Spring Boot find the Hikari DataSource implementation itself.

**If Spring Boot cannot find the Tomcat DataSource in the classpath, it will automatically look for the Hikari DataSource next.** The discovery algorithm is described in [the reference manual](https://docs.spring.io/spring-boot/docs/1.5.15.RELEASE/reference/htmlsingle/#boot-features-connect-to-production-database).

To remove the Tomcat Connection Pool from the classpath we can exclude it in our *pom.xml*:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jdbc</artifactId>
         </exclusion>
     </exclusions>
</dependency>
```
Now, the test from the previous section will also work without setting the spring.datasource.type property.

## Configuring Hikari With Spring Boot 2.x
In Spring Boot 2, Hikari is the default DataSource implementation.

This is what's changed from Spring Boot 1.x:

- the dependency to Hikari is now automatically included in spring-boot-starter-data-jpa
- the discovery algorithm that automatically determines a DataSource implementation now prefers Hikari over TomcatJDBC (see [the reference manual](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/)).
**Thus, we have nothing to do if we want to use Hikari in an application based on Spring Boot 2.x.**

## Tuning Hikari Configuration Parameters

One of Hikari's advantages over other *DataSource* implementations is the fact that it offers a lot of configuration parameters.

We can specify the values for these parameters by using the prefix *spring.datasource.hikari* and appending the name of the Hikari parameter:
```
spring.datasource.hikari.connectionTimeout=30000
spring.datasource.hikari.idleTimeout=600000
spring.datasource.hikari.maxLifetime=1800000
```
...
A list of all Hikari parameters with a good explanation is available on [the Hikari Github Site](https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby).

## Conclusion
In this article, we've configured the Hikari DataSource implementation in a Spring Boot 1.x application and learned how to leverage Spring Boot 2.x's autoconfiguration.

The code for the Spring Boot 1.x example is available [here](https://github.com/eugenp/tutorials/tree/master/spring-4), and the code for the Spring Boot 2.x example is available [here](https://github.com/eugenp/tutorials/tree/master/spring-5).
