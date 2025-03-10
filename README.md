# Práctica de Java con Spring Boot, MySQL y Swing

## 📢 Descripción

Este proyecto es una práctica que combina **Java**, **Spring Boot**, **MySQL** y **Swing** para desarrollar una aplicación de escritorio con conexión a una base de datos. La aplicación permite la gestión de datos utilizando una interfaz gráfica creada con **Swing**, mientras que **Spring Boot** se encarga de la lógica del backend y la persistencia en MySQL.

---

## 🛠️ Tecnologías utilizadas

- **Java 17+**
- **Spring Boot 3+**
- **MySQL** (Base de datos relacional)
- **Hibernate/JPA** (Para el manejo de la persistencia de datos)
- **Swing** (Interfaz gráfica de usuario)
- **Maven** (Gestión de dependencias)

---

## 🚀 Instalación y ejecución del proyecto

### 📌 Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado en tu sistema:

- **JDK 17 o superior** ([Descargar aquí](https://www.oracle.com/java/technologies/javase-downloads.html))
- **Maven** ([Descargar aquí](https://maven.apache.org/download.cgi))
- **MySQL Server** ([Descargar aquí](https://dev.mysql.com/downloads/installer/))

### 📥 Clonar el repositorio

```sh
 git clone https://github.com/Haluuuu/Zona_Fit_Spring.git
 cd Zona_Fit_Spring
```

### 🛠️ Configuración de la base de datos

1. Abre MySQL y crea una base de datos para la aplicación:

```sql
CREATE DATABASE nombre_basedatos;
```

2. Configura las credenciales en el archivo **`application.properties`** dentro de `src/main/resources/`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_basedatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```


### 🖥️ Ejecutar la aplicación de escritorio (Swing)

1. En tu **IDE (IntelliJ, Eclipse, NetBeans, etc.)**, ejecuta la clase principal del proyecto **ZonaFitSwing.java**.
2. La interfaz gráfica se abrirá y podrás interactuar con la base de datos.

---

## 📚 Funcionalidades

✅ CRUD de registros en la base de datos.  
✅ Interfaz gráfica con Swing.  
✅ Conexión con MySQL mediante Hibernate/JPA.  
✅ Integración con Spring Boot como backend.

---

## 🙌 Créditos

Desarrollado por **Harold Herrea** como parte de una práctica en Java con tecnologías modernas.



