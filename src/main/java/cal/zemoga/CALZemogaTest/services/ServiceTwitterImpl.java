package cal.zemoga.CALZemogaTest.services;


import lombok.RequiredArgsConstructor;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServiceTwitterImpl implements ServiceTwitter{

    private String consumerKey = "KRy7l0v8wex3w8Sy5zThai3Ea";
    private String consumerSecret = "X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu";
    private String accessToken = "1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja";
    private String accessTokenSecret = "tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj";


    public List getTimelines(){
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);

        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline("LewisHamilton");
        tweets = tweets.stream().limit(5).collect(Collectors.toList());
        return tweets;
    }

    public String getTextTimeLines(){
        String cad = "";
        List<Tweet> tweets = getTimelines();

        for(Tweet t: tweets) {
            cad = cad + "User: " + t.getFromUser() + " - Text: " + t.getText() + "\n";
        }

        return cad;
    }


}
