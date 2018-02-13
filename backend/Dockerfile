#FROM alpine/git as clone
#WORKDIR /app
#RUN git clone https://github.com/tonsV2/PlanningPoker.git

#FROM maven:3.5-jdk-8-alpine as build
#COPY --from=clone /app/PlanningPoker /app
#ADD . /app
#RUN mvn install
#FROM gradle:alpine as build
FROM openjdk:8-jdk-alpine as build
ADD . /app
WORKDIR /app
RUN ./gradlew bootJar

FROM openjdk:8-jre-alpine
WORKDIR /app
#COPY --from=build /app/target/*.jar /app
COPY --from=build /app/build/libs/backend*.jar /app/
CMD java -jar *.jar

