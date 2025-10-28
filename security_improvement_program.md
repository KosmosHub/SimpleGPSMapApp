# App Security Improvement Program (ASIP)

Este programa estructurado está diseñado para evaluar y mejorar continuamente la seguridad de la aplicación, cumpliendo con los estándares de la industria.

## I. Proceso de Revisión Periódica

Se establece un ciclo de revisión trimestral (cada 3 meses) para el código base de la aplicación.

1.  **Revisión de Código:** Auditoría manual de las funcionalidades críticas (autenticación, manejo de datos sensibles) y de todas las integraciones de terceros (APIs de Google Maps).
2.  **Re-Escaneo con MobSF/ZAP:** Ejecución de análisis estático y dinámico periódicos utilizando MobSF y OWASP ZAP.
3.  **Revisión de Dependencias:** Uso de herramientas como OWASP Dependency-Check para asegurar que todas las librerías de terceros estén actualizadas y no contengan vulnerabilidades conocidas.

## II. Métricas Clave de Seguridad

Se medirán las siguientes métricas para evaluar la salud de la seguridad:

* **Puntuación MobSF:** Mantener la puntuación de seguridad por encima de 85/100 (Grado A).
* **Vulnerabilidades Abiertas:** El número de vulnerabilidades de severidad Alta/Crítica debe ser siempre **cero (0)**.
* **Tiempo de Corrección (MTTR):** El tiempo promedio para corregir una vulnerabilidad de alta severidad no debe superar las 72 horas después de su descubrimiento.

## III. Plan de Acción Futuro (Roadmap)

1.  **Implementación de Certificado Pinning:** Implementar *Certificate Pinning* para validar la cadena de certificados de los servidores de backend y de Google Maps.
2.  **Implementación de R8/ProGuard Avanzado:** Aplicar reglas más agresivas de ofuscación y optimización de código para dificultar la ingeniería inversa del código Java/Kotlin.
3.  **Integración de Pruebas de Seguridad en CI/CD:** Automatizar la ejecución de MobSF Scan dentro del pipeline de integración continua (CI/CD) para que las pruebas de seguridad se ejecuten automáticamente en cada *commit* o *pull request*.
