                 # selenium-java-portfolio

Suite de automatización UI construida con Java + Selenium + TestNG + Allure.  
Proyecto de portafolio orientado a QA Automation en el sector financiero.

---

## Stack

| Herramienta | Versión | Rol |
|---|---|---|
| Java | 21 | Lenguaje principal |
| Selenium WebDriver | 4.27.0 | Automatización UI |
| TestNG | 7.10.2 | Runner de tests |
| Allure | 2.27.0 | Reportes |
| Maven | 3.x | Build y gestión de dependencias |

---

## Estructura del proyecto

```
selenium-java-portfolio/
├── pom.xml
├── testng-smoke.xml          # Suite de smoke tests
├── testng-functional.xml     # Suite de tests funcionales
├── testng-regression.xml     # Suite de regresión completa
└── src/
    └── test/
        └── java/
            ├── pages/        # Page Object Model
            │   ├── BasePage.java
            │   ├── LoginPage.java
            │   ├── AlertsPage.java
            │   ├── CheckPage.java
            │   └── DropdownPage.java
            └── tests/        # Clases de test
                ├── BaseTests.java
                ├── LoginTest.java
                ├── AlertsTest.java
                ├── CheckboxTest.java
                └── DropdownTest.java
```

---

## Sitio bajo prueba

[The Internet - Herokuapp](https://the-internet.herokuapp.com)  
Cubre los módulos: Login, JavaScript Alerts, Checkboxes, Dropdown.

---

## Requisitos previos

- Java JDK 21
- Google Chrome (versión reciente)
- Scoop (gestor de paquetes Windows)
- Maven
- Allure CLI

### Instalación de Scoop (Windows — PowerShell sin permisos de administrador)

```powershell
Invoke-RestMethod -Uri https://get.scoop.sh | Invoke-Expression
```

### Instalación de Maven y Allure

```powershell
scoop install maven
scoop install allure
```

### Verificar instalaciones

```powershell
java --version
mvn --version
allure --version
```

---

## Instalación del proyecto

```powershell
git clone https://github.com/manuelVerdugoK/selenium-java.git
cd selenium-java
mvn install -DskipTests
```

---

## Ejecución de tests

Desde la raíz del proyecto:

```powershell
# Smoke — verificar que las páginas responden
mvn test -Dsurefire.suiteXmlFiles=testng-smoke.xml

# Functional — tests por módulo con casos positivos y negativos
mvn test -Dsurefire.suiteXmlFiles=testng-functional.xml

# Regression — suite completa
mvn test -Dsurefire.suiteXmlFiles=testng-regression.xml
```

---

## Reportes con Allure

Después de ejecutar cualquier suite, los resultados se guardan en `allure-results/`.

### Ver reporte localmente

```powershell
allure serve allure-results
```

### Generar reporte HTML estático

```powershell
allure generate allure-results --clean -o allure-report
allure open allure-report
```

---

## Decisiones de diseño

**Page Object Model (POM)**  
Separa la lógica de localización de elementos de la lógica de los tests. Si un elemento cambia en la UI, el cambio se hace en un solo lugar — la clase Page — sin tocar los tests.

**BasePage y BaseTests**  
Centraliza el código común de inicialización y teardown. Las clases hijas heredan `driver` y `wait` sin repetirlos. Aplica el principio DRY (Don't Repeat Yourself) en la capa de infraestructura de testing.

**Grupos TestNG (smoke / functional)**  
Permite ejecutar subconjuntos de tests según el contexto — post-deploy rápido con smoke, validación completa con functional o regression — sin modificar el código.

**Data Providers**  
Parametrización de tests para cubrir múltiples combinaciones de datos con un solo método. Evita duplicación de tests para casos positivos, negativos y casos borde.

**alwaysRun = true en BaseTests**  
Garantiza que el setup y teardown del padre se ejecuten siempre, independiente del grupo que esté corriendo. Necesario para que la herencia funcione correctamente con filtros de grupos en TestNG.
