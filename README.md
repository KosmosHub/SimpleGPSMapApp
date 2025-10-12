# SimpleGPSMapApp

Aplicación Android desarrollada como parte de la **Actividad 2.3** del curso de Programación Android. Este proyecto integra funcionalidades reales como mapas, ubicación y descarga de imágenes, utilizando fragmentos, navegación modular y buenas prácticas de arquitectura.

##  Funcionalidades principales

-  **Mapa con ubicación actual**: muestra la posición del usuario usando Google Maps y FusedLocationProviderClient.
-  **Marcadores personalizados**: permite añadir marcadores tocando el mapa.
-  **Descarga de imágenes desde Internet**: utiliza subprocesos (threads) para descargar y mostrar imágenes.
-  **Navegación modular con fragmentos**: cada funcionalidad está separada en su propio fragmento.
-  **Permisos en tiempo de ejecución**: solicita acceso a ubicación de forma segura.

##  Tecnologías utilizadas

- Java
- Android Studio
- Google Maps API
- FusedLocationProviderClient
- Threads (Java)
- Fragments y FragmentManager
- ConstraintLayout y FrameLayout

##  Estructura del proyecto

GPSMapApp/ 
├── java/com/example/gpsmapapp/Vista/ 
│ ├── MainActivity.java 
│ ├── MapFragment.java 
│ └── ImageDownloadFragment.java 
├── res/layout/ 
│ ├── activity_main.xml 
│ ├── fragment_map.xml 
│ └── fragment_image_download.xml 
├── res/values/ 
│ ├── google_maps_api.xml 
│ └── strings.xml 
├── AndroidManifest.xml

Código

##  Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/KosmosHub/SimpleGPSMapApp.git
