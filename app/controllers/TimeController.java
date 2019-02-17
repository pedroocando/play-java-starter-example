package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.utils.Response;
import play.mvc.Controller;
import play.mvc.Result;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Pedro Ocando on 2/16/19
 */
public class TimeController extends Controller {

    public final static String TIMEZONE = "UTC";

    public Result calculateTime(){
        // hacemos las validaciones correspondientes
        JsonNode request = request().body().asJson();
        if (request == null)
            return Response.requiredJson();
        if(request.get("dato1") == null)
            return Response.requiredParameter("dato1 - time");
        if(request.get("dato2") == null)
            return Response.requiredParameter("dato2 - timezone");


        // tomamos los datos del request
        String time =  request.get("dato1").asText();
        String timezone = request.get("dato2").asText();
        String response = null;
        try{
            // tomamos la hora y la dividimos en secciones
            String[] array = time.split(":");
            // asignamos UTC a la zona horaria
            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone(TIMEZONE));
            // tomamos la hora
            calendar.set(Calendar.HOUR_OF_DAY,Integer.valueOf(array[0]));
            // tomamos los minutos
            calendar.set(Calendar.MINUTE,Integer.valueOf(array[1]));
            // tomamos los segundos
            calendar.set(Calendar.SECOND,Integer.valueOf(array[2]));
            // creamos el formato que necesitamos para la salida
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            format.setTimeZone(TimeZone.getTimeZone(ZoneId.of(timezone)));
            // tomaos la hora
            response = format.format(calendar.getTime());
        }catch (Exception e){
            // hubo algun error en el proceso
           return badRequest(e.getMessage());
        }

        return Response.success(response,TIMEZONE.toLowerCase());
    }
}

