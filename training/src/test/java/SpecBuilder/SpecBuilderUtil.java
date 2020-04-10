package SpecBuilder;

public enum  SpecBuilderUtil {


    getLKEndPoint("/lk/10350"),
    getUSEndPoint("/us/90201");

    private String resourcePath;

    SpecBuilderUtil(String resourcePath){

        this.resourcePath=resourcePath;
    }

    public String getResource(){
        return resourcePath;
    }
}
