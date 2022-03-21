package cal.zemoga.CALZemogaTest.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;


@Configuration
public class TwitterConfig{

    private static String consumerKey = "KRy7l0v8wex3w8Sy5zThai3Ea";
    private static String consumerSecret = "X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu";
    private static String accessToken = "1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja";
    private static String accessTokenSecret = "tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj";


    public static Twitter getTwitterTemplate(){
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);

        return twitter;
    }

}
