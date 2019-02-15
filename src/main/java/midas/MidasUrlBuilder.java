package midas;


import java.net.URL;
import java.util.List;

public class MidasUrlBuilder{

    private String BASE_URL;
    private String API_KEY;
    private String ACTION;
    private List<String> PARAMETERS;

    private String GENERATED_URL;

    public MidasUrlBuilder(String BASE_URL, String API_KEY){
        this.BASE_URL = BASE_URL;
        this.API_KEY = "&key=" + API_KEY;
        this.GENERATED_URL = this.BASE_URL + this.API_KEY;
    }

    public MidasUrlBuilder setBASE_URL(String BASE_URL){
        this.BASE_URL = BASE_URL;
        return this;
    }

    public MidasUrlBuilder setAPI_URL(String API_KEY){
        this.API_KEY = "&key=" + API_KEY;
        return this;
    }

    public MidasUrlBuilder setACTION(String ACTION){
        //TODO
        this.ACTION = "&action=" + ACTION;
        return this;
    }

    public static URL build(){
        //TODO
        return null;
    }

}
