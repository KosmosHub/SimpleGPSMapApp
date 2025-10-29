# SimpleGPSMapApp

## Descripción
Este proyecto es una aplicación Android desarrollada como parte de la Actividad 2.3 del curso de Programación Android. Integra funcionalidades de mapas, ubicación y descarga de imágenes, utilizando fragmentos, navegación modular y buenas prácticas de arquitectura. Además, incorpora medidas de seguridad para proteger contra vulnerabilidades comunes.

## Vulnerabilidades Identificadas
- Clave de Google Maps hardcodeada (V-4)
- Certificado de depuración activo (V-1)
- Debugging habilitado en producción (V-2)
- Backup de datos activo (V-3)

## Mejoras Implementadas
- Cifrado de datos sensibles con EncryptedSharedPreferences / KeyStore
- Comunicación segura (HTTPS) mediante network_security_config
- Deshabilitación de Debugging y Backup en producción
- Protección de claves API movidas a BuildConfig y local.properties
- Firma con keystore de producción
- Ofuscación de código con R8 / ProGuard

## Documentación
- [Vulnerabilidades](vulnerabilities.md)
- [Best Practices](best_practices.md)
- [Security Tips](security_tips.md)
- [Security Improvement Program](security_improvement_program.md)

## Cómo Ejecutar la Aplicación de Forma Segura
1. Clonar el repositorio:  
   `git clone https://github.com/KosmosHub/SimpleGPSMapApp.git`
2. Importar el proyecto en Android Studio
3. Ejecutar la aplicación en un dispositivo o emulador
4. Asegurarse de que los permisos necesarios están configurados
5. Verificar que las banderas de seguridad estén activas (`debuggable=false`, `allowBackup=false`) y que BuildConfig.MAPS_KEY se esté usando en lugar del string hardcodeado

## Reporte de Vulnerabilidades
El reporte detallado de las pruebas de vulnerabilidad realizadas se encuentra en el archivo `vulnerability_report.pdf`.
