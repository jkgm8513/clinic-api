package jk.clinic_api.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/assistant")
public class AssistantController {

    @Value("${openai.api.key}")
    private String apiKey;

    public static class AppointmentResponse {
        private String doctorName;
        private String date;
        private String time;

        public AppointmentResponse() {}

        public AppointmentResponse(String doctorName, String date, String time) {
            this.doctorName = doctorName;
            this.date = date;
            this.time = time;
        }

        public String getDoctorName() { return doctorName; }
        public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> interactWithAssistant(@RequestBody String userInput) {
        try {
            String prompt = "Extrae nombre de doctor, fecha y hora de esta frase: \"" + userInput + "\". " +
                    "Devuelve en formato JSON con campos doctorName, date, time.";

            String jsonResponse = callOpenAIChatAPI(prompt);

            AppointmentResponse response = parseAppointmentResponse(jsonResponse);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(500).body(new AppointmentResponse("", "", ""));
        }
    }

    private AppointmentResponse parseAppointmentResponse(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            String doctorName = jsonObject.optString("doctorName", "");
            String date = jsonObject.optString("date", "");
            String time = jsonObject.optString("time", "");

            return new AppointmentResponse(doctorName, date, time);
        } catch (JSONException e) {
            return new AppointmentResponse("", "", "");
        }
    }

    private String callOpenAIChatAPI(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";

        RestTemplate restTemplate = new RestTemplate();

        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", prompt);

        JSONArray messages = new JSONArray();
        messages.put(message);

        JSONObject body = new JSONObject();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", messages);
        body.put("temperature", 0);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonResponse = new JSONObject(response.getBody());
            return jsonResponse
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content").trim();
        } else {
            throw new RuntimeException("Error en OpenAI API: " + response.getStatusCode());
        }
    }
}