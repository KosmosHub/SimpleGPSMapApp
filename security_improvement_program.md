# App Security Improvement Program (ASIP)

Este programa estructurado est� dise�ado para evaluar y mejorar continuamente la seguridad de la aplicaci�n, cumpliendo con los est�ndares de la industria.

## I. Proceso de Revisi�n Peri�dica

Se establece un ciclo de revisi�n trimestral (cada 3 meses) para el c�digo base de la aplicaci�n.

1.  **Revisi�n de C�digo:** Auditor�a manual de las funcionalidades cr�ticas (autenticaci�n, manejo de datos sensibles) y de todas las integraciones de terceros (APIs de Google Maps).
2.  **Re-Escaneo con MobSF/ZAP:** Ejecuci�n de an�lisis est�tico y din�mico peri�dicos utilizando MobSF y OWASP ZAP.
3.  **Revisi�n de Dependencias:** Uso de herramientas como OWASP Dependency-Check para asegurar que todas las librer�as de terceros est�n actualizadas y no contengan vulnerabilidades conocidas.

## II. M�tricas Clave de Seguridad

Se medir�n las siguientes m�tricas para evaluar la salud de la seguridad:

* **Puntuaci�n MobSF:** Mantener la puntuaci�n de seguridad por encima de 85/100 (Grado A).
* **Vulnerabilidades Abiertas:** El n�mero de vulnerabilidades de severidad Alta/Cr�tica debe ser siempre **cero (0)**.
* **Tiempo de Correcci�n (MTTR):** El tiempo promedio para corregir una vulnerabilidad de alta severidad no debe superar las 72 horas despu�s de su descubrimiento.

## III. Plan de Acci�n Futuro (Roadmap)

1.  **Implementaci�n de Certificado Pinning:** Implementar *Certificate Pinning* para validar la cadena de certificados de los servidores de backend y de Google Maps.
2.  **Implementaci�n de R8/ProGuard Avanzado:** Aplicar reglas m�s agresivas de ofuscaci�n y optimizaci�n de c�digo para dificultar la ingenier�a inversa del c�digo Java/Kotlin.
3.  **Integraci�n de Pruebas de Seguridad en CI/CD:** Automatizar la ejecuci�n de MobSF Scan dentro del pipeline de integraci�n continua (CI/CD) para que las pruebas de seguridad se ejecuten autom�ticamente en cada *commit* o *pull request*.
