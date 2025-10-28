# Best Practices Implementadas para la Seguridad

Este documento detalla las Buenas Prácticas de seguridad implementadas en el código para mejorar la postura de defensa de la aplicación, conforme a los requisitos de la actividad.

## 1. Deshabilitar Debugging en Producción

**Práctica Aplicada:** Se modificó el archivo `AndroidManifest.xml` para asegurar que el atributo `android:debuggable` esté establecido en `false` en las compilaciones de producción. Esto corrige la **Vulnerabilidad 2**.

**Impacto en la Seguridad:** Previene que un atacante pueda adjuntar un depurador (via ADB) a la aplicación en ejecución. Esto es una defensa fundamental contra la ingeniería inversa y el espionaje de la memoria en tiempo real, lo que protege las variables y la lógica de la App.

## 2. Deshabilitar Back up Automático de Datos

**Práctica Aplicada:** Se incluyó el atributo `android:allowBackup="false"` en la etiqueta `<application>` del `AndroidManifest.xml`. Esto corrige la **Vulnerabilidad 3**.

**Impacto en la Seguridad:** Evita que el sistema operativo o herramientas de terceros como ADB realicen copias de seguridad de los datos de la aplicación. Esto previene la extracción sencilla de datos sensibles (como tokens o claves) del almacenamiento privado del dispositivo.

## 3. Implementación de Cifrado para Datos Sensibles

**Práctica Aplicada:** Se implementó el uso de **Android KeyStore** o **EncryptedSharedPreferences** para almacenar información crítica, como tokens de autenticación de usuario o cualquier credencial dinámica, en lugar de guardarlos en texto plano.

**Impacto en la Seguridad:** Garantiza que si un atacante logra acceder al almacenamiento local de la aplicación, los datos sensibles estarán cifrados, haciéndolos inútiles sin la clave de descifrado apropiada.
