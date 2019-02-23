package midas.responses;

import json.AbstractJsonObj;

import javax.json.JsonObject;

/**
 *
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 *
 * General JsonResponse for the Midas api
 *
 * <p>
 *     specifically stores any api response errors due to the request.
 * </p>
 */
public abstract class AbstractMidasJsonObjResponse extends AbstractJsonObj {

    private static final String ERROR = "error";

    private static String error;
    private static boolean errorOccured;

    public AbstractMidasJsonObjResponse(JsonObject jsonObject) {
        super(jsonObject);
        try {
            this.error = jsonObject.getJsonString(ERROR).getString() + "";
        }catch (Exception e){
            this.error = "";
        }
        if(this.error.equals("")){
            this.errorOccured = false;
        }else{
            this.errorOccured = true;
        }
    }

    public static String getError(){
        return error;
    }

    public static boolean didErrorOccur(){
        return errorOccured;
    }

}
