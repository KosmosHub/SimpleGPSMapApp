# Best Practices Implementadas para la Seguridad

Este documento detalla las Buenas Pr�cticas de seguridad implementadas en el c�digo para mejorar la postura de defensa de la aplicaci�n, conforme a los requisitos de la actividad.

## 1. Deshabilitar Debugging en Producci�n

**Pr�ctica Aplicada:** Se modific� el archivo `AndroidManifest.xml` para asegurar que el atributo `android:debuggable` est� establecido en `false` en las compilaciones de producci�n. Esto corrige la **Vulnerabilidad 2**.

**Impacto en la Seguridad:** Previene que un atacante pueda adjuntar un depurador (via ADB) a la aplicaci�n en ejecuci�n. Esto es una defensa fundamental contra la ingenier�a inversa y el espionaje de la memoria en tiempo real, lo que protege las variables y la l�gica de la App.

## 2. Deshabilitar Back up Autom�tico de Datos

**Pr�ctica Aplicada:** Se incluy� el atributo `android:allowBackup="false"` en la etiqueta `<application>` del `AndroidManifest.xml`. Esto corrige la **Vulnerabilidad 3**.

**Impacto en la Seguridad:** Evita que el sistema operativo o herramientas de terceros como ADB realicen copias de seguridad de los datos de la aplicaci�n. Esto previene la extracci�n sencilla de datos sensibles (como tokens o claves) del almacenamiento privado del dispositivo.

## 3. Implementaci�n de Cifrado para Datos Sensibles

**Pr�ctica Aplicada:** Se implement� el uso de **Android KeyStore** o **EncryptedSharedPreferences** para almacenar informaci�n cr�tica, como tokens de autenticaci�n de usuario o cualquier credencial din�mica, en lugar de guardarlos en texto plano.

**Impacto en la Seguridad:** Garantiza que si un atacante logra acceder al almacenamiento local de la aplicaci�n, los datos sensibles estar�n cifrados, haci�ndolos in�tiles sin la clave de descifrado apropiada.
