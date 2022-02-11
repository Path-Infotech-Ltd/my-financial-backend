FROM openjdk:8
EXPOSE 9021
ADD target/my_financial_backend.jar my_financial_backend.jar
ENTRYPOINT ["java","-jar","my_financial_backend.jar"]