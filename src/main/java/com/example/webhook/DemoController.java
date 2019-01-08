package com.example.webhook;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DemoController {

    @RequestMapping("/instagram/{instagramBusinessId}")
    public String readJSON(HttpServletRequest request) throws JSONException{

        long reqOffset = Long.parseLong(request.getParameter("offset"));
        String result = FileReaderService.readFileAsString("src/payload.json");

        JSONArray array = new JSONArray(result);

        JSONArray returnVal = new JSONArray();
        JSONObject offsetObject = array.getJSONObject(0);
        long currOffset = offsetObject.getLong("offset");
        long diff = currOffset -reqOffset;
        for(int i=1; i<= diff; i++)
        {
            returnVal.put(array.getJSONObject(i));
        }

        return returnVal.toString();
    }
}
