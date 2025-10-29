\# Proyecto Clinic API con integración OpenAI



\## Instrucciones de instalación y ejecución



1\. Clona el repositorio localmente:



git https://github.com/jkgm8513/clinic-api

cd <clinic-api



2\. Configura la clave API de OpenAI en el archivo `src/main/resources/application.properties`:



openai.api.key="tu\_api\_key\_aqui"



3\. Opcionalmente, activa o desactiva modo prueba para evitar consumir cuota:



app.testing=true 

\# true para modo prueba, false para llamadas reales a OpenAI



4\. Compila y ejecuta la aplicación con Maven:



mvn clean install

mvn spring-boot:run



---



\## Explicación técnica del diseño



\- La aplicación está construida con Spring Boot y expone un endpoint POST `/assistant`.

\- El endpoint recibe una cadena de texto con una solicitud de agendar cita.

\- La cadena es procesada y enviada a la API de OpenAI GPT (modelo `gpt-3.5-turbo`) con un prompt personalizado para extraer el nombre del doctor, fecha y hora en formato JSON.

\- La respuesta JSON devuelta por OpenAI es parseada y mapeada a un objeto `AppointmentResponse` que se envía como respuesta JSON al cliente.

\- Se incluye en la configuración un modo de prueba que devuelve respuestas simuladas para evitar consumir la cuota de la API durante desarrollo.

\- Se usa la librería `org.json` para manipular JSON en Java, y `RestTemplate` para llamadas HTTP a OpenAI.





Reflexión:
Si tuviera una semana más, aprovecharía ese tiempo para profundizar y experimentar más con la inteligencia artificial, especialmente con las capacidades del modelo OpenAI. Debido a que mi cuenta actual no tiene suficiente cuota para realizar un uso intensivo, me enfocaría en optimizar las pruebas mediante simulaciones, desarrollar casos de uso creativos y explorar cómo integrar mejor la IA con otras tecnologías. Esto me permitiría aprovechar al máximo las oportunidades que ofrece la inteligencia artificial para innovar y resolver problemas, mientras gestiono de forma eficiente los recursos disponibles.

