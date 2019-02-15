package midas;


import java.net.URL;
import java.util.List;

public class MidasUrlBuilder{

    private String BASE_URL;
    private String API_URL;
    private String ACTION;
    private List<String> PARAMETERS;

    public MidasUrlBuilder(String BASE_URL, String API_URL){
        this.BASE_URL = BASE_URL;
        this.API_URL = API_URL;
    }

    public MidasUrlBuilder setBASE_URL(String BASE_URL){
        this.BASE_URL = BASE_URL;
        return this;
    }

    public MidasUrlBuilder setAPI_URL(String API_URL){
        this.API_URL = API_URL;
        return this;
    }

    public MidasUrlBuilder setACTION(String ACTION){
        //TODO
        this.ACTION = ACTION;
        return this;
    }

    public static URL build(){
        //TODO
        return null;
    }

}
