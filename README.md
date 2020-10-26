# Welcome to CustomGreeter

This repository shows the working example of how to build a docker image out of a Java application and deploy to WildFly (jboss/wildfly).
1. Uses <a href="https://registry.hub.docker.com/u/jboss/wildfly/">jboss/wildfly</a> as a base image
2. Uses <a href="https://github.com/fabric8io/docker-maven-plugin">fabric8io plugin</a> to build docker image from maven

Instructions
-----------------

1. Clone this repository:

`git clone https://github.com/sainik73/custom-greeter`

2. Build the project with Maven:

```
cd custom-greeter/
mvn clean verify
```

3. Output image `sainik73/custom-greeter` will be created

`D:\Work\Code> docker image list

REPOSITORY                TAG                      IMAGE ID            CREATED             SIZE

sainik73/custom-greeter   latest                   fe58c7b688d5        6 hours ago         702MB`


4. Run the application on container:

`docker container run -d -p 8080:8080 --name my-custom-greeter sainik73/custom-greeter`

5. Use docker inpect to inspect the health of container

`docker inspect  --format "{{json .State.Health}}" my-custom-greeter`

`D:\Work\Code>docker inspect  --format "{{json .State.Health}}" my-custom-greeter`

`{"Status":"healthy","FailingStreak":0,"Log":[{"Start":"2020-10-26T07:13:27.5480136Z","End":"2020-10-26T07:13:27.6774922Z","ExitCode":0,"Output":"  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n"},{"Start":"2020-10-26T07:14:27.689663Z","End":"2020-10-26T07:14:27.7993989Z","ExitCode":0,"Output":"  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n"},{"Start":"2020-10-26T07:15:27.8148079Z","End":"2020-10-26T07:15:27.9387159Z","ExitCode":0,"Output":"  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n"},{"Start":"2020-10-26T07:16:27.956363Z","End":"2020-10-26T07:16:28.0833897Z","ExitCode":0,"Output":"  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n"},{"Start":"2020-10-26T07:17:28.101562Z","End":"2020-10-26T07:17:28.2177343Z","ExitCode":0,"Output":"  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\n"}]}`

6. Test the application using browser or curl:

 - `http://localhost:8080/custom-greeter/greeter/greet`

`D:\Work\Code>curl "http://localhost:8080/custom-greeter/greeter/greet"`

`Hello, World!`

- `http://localhost:8080/custom-greeter/greeter/greet\{name}`

`D:\Work\Code>curl "http://localhost:8080/custom-greeter/greeter/greet/Abby"`

`Hello, Abby, Welcome to My Custom Greeter app!`
