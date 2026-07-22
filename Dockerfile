# ---- Этап сборки ----
FROM maven:3.9-eclipse-temurin-17 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы проекта (для кэширования зависимостей)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Даём права на выполнение mvnw
RUN chmod +x mvnw

# Скачиваем зависимости (этот шаг кэшируется, если pom.xml не менялся)
RUN ./mvnw dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Собираем проект (пропускаем тесты)
RUN ./mvnw clean package -DskipTests -B

# ---- Этап запуска ----
FROM openjdk:17-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR из этапа сборки
COPY --from=build /app/target/*.jar app.jar

# Открываем порт (по умолчанию 8080)
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]