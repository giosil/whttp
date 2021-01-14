# WHttp - HTTP client

Simple HTTP client.

## Build

- `git clone https://github.com/giosil/whttp.git`
- `mvn clean install`

## Example

```java
WHttp whttp = new WHttp("http://localhost:8080/echo/test");
whttp.setBasicAuthUsername("user");
whttp.setBasicAuthPassword("pass");

String data = "{\"firstName\":\"Clark\",\"lastName\":\"Kent\"}";

String response = whttp.post("contacts", data);

System.out.println(response);
```

## Contributors

* [Giorgio Silvestris](https://github.com/giosil)
