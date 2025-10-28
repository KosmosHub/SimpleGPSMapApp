# Security Tips Implementados para Mejorar la Seguridad

Este documento describe los Consejos de Seguridad específicos implementados en el código, generando mejoras significativas en la defensa de la aplicación.

## 1. Protección de Claves API y Secretos

**Tip Aplicado:** Se refactorizó la forma en que se accede a la clave API de Google Maps (**Vulnerabilidad 4: Hardcodeada**) moviéndola fuera del código fuente *hardcodeado* y cargándola de forma segura desde *Native Code* con C/C++ (JNI) o usando herramientas de *secrets-management* de Gradle.

**Impacto en la Seguridad:** Reduce drásticamente la exposición de credenciales. Al ofuscar o aislar la clave, es mucho más difícil para los atacantes que realizan ingeniería inversa extraer las credenciales válidas y abusar de los servicios del desarrollador.

## 2. Firma con Clave de Producción

**Tip Aplicado:** Se configuró el proceso de compilación para utilizar una **clave de firma de producción** y no la clave de *debug* (**Vulnerabilidad 1: Certificado Debug**).

**Impacto en la Seguridad:** Asegura la autenticidad e integridad del código. Al firmar con una clave única y privada, se verifica que la aplicación no ha sido manipulada por terceros y que proviene de una fuente de confianza.

## 3. Uso Estricto de HTTPS (Network Security Configuration)

**Tip Aplicado:** Se configuró el archivo `network_security_config.xml` para denegar explícitamente cualquier tráfico no cifrado (HTTP) y forzar el uso de **HTTPS** en todas las comunicaciones de red de la aplicación.

**Impacto en la Seguridad:** Mitiga el riesgo de ataques de tipo **Man-in-the-Middle (MITM)**. Asegura que toda la comunicación, especialmente la relacionada con Google Maps o cualquier API externa, sea cifrada.
