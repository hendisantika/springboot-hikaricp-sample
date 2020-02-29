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