package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface PropertyConfig extends Config {

    @Key("stgServer")
    String stgServer();

    @Key("userEmail")
    String userEmail();

    @Key("invalidUserPassword")
    String getInvalidPassword();

}
