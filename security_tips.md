# Security Tips Implementados para Mejorar la Seguridad

Este documento describe los Consejos de Seguridad espec�ficos implementados en el c�digo, generando mejoras significativas en la defensa de la aplicaci�n.

## 1. Protecci�n de Claves API y Secretos

**Tip Aplicado:** Se refactoriz� la forma en que se accede a la clave API de Google Maps (**Vulnerabilidad 4: Hardcodeada**) movi�ndola fuera del c�digo fuente *hardcodeado* y carg�ndola de forma segura desde *Native Code* con C/C++ (JNI) o usando herramientas de *secrets-management* de Gradle.

**Impacto en la Seguridad:** Reduce dr�sticamente la exposici�n de credenciales. Al ofuscar o aislar la clave, es mucho m�s dif�cil para los atacantes que realizan ingenier�a inversa extraer las credenciales v�lidas y abusar de los servicios del desarrollador.

## 2. Firma con Clave de Producci�n

**Tip Aplicado:** Se configur� el proceso de compilaci�n para utilizar una **clave de firma de producci�n** y no la clave de *debug* (**Vulnerabilidad 1: Certificado Debug**).

**Impacto en la Seguridad:** Asegura la autenticidad e integridad del c�digo. Al firmar con una clave �nica y privada, se verifica que la aplicaci�n no ha sido manipulada por terceros y que proviene de una fuente de confianza.

## 3. Uso Estricto de HTTPS (Network Security Configuration)

**Tip Aplicado:** Se configur� el archivo `network_security_config.xml` para denegar expl�citamente cualquier tr�fico no cifrado (HTTP) y forzar el uso de **HTTPS** en todas las comunicaciones de red de la aplicaci�n.

**Impacto en la Seguridad:** Mitiga el riesgo de ataques de tipo **Man-in-the-Middle (MITM)**. Asegura que toda la comunicaci�n, especialmente la relacionada con Google Maps o cualquier API externa, sea cifrada.
