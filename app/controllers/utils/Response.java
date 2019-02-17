package controllers.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.created;
import static play.mvc.Results.ok;

/**
 * @author Pedro Ocando on 2/16/19
 */
public class Response {

    public static ObjectNode buildExtendResponse(String message){
        ObjectNode response = Json.newObject();
        response.put("message", message);
        return response;
    }

    public static ObjectNode buildExtendResponse(String time, String timezone){
        ObjectNode response = Json.newObject();
        ObjectNode content = Json.newObject();
        content.put("time", time);
        content.put("timezone", timezone);
        response.set("response", content);
        return response;
    }

    /*
     * created 200
     *
    */
    public static Result success(String time,String timezone){
        return ok(buildExtendResponse(time,timezone));
    }

    /*
     * badRequest 400
     */
    public static Result requiredJson(){
        return badRequest(buildExtendResponse("Expecting Json data"));
    }

    public static Result requiredParameter(String parameter){
        return badRequest(buildExtendResponse("Parametro faltante " + parameter + ""));
    }
}
