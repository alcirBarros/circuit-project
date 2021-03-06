package br.facebookmediamarkt.facebook.restfacebook;

import br.facebookmediamarkt.facebook.token.Token;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import java.util.Date;

public class RestFacebook extends Token {

    //https://github.com/restfb/restfb-examples/tree/master/src/main/java/com/restfb/example
    private final FacebookClient facebookClient;

    /**
     * Entry point. You must provide a single argument on the command line: a
     * valid Graph API access token. In order for publishing to succeed, you
     * must use an access token for an application that has been granted
     * stream_publish and create_event rights.
     *
     * @param args Command-line arguments.
     * @throws IllegalArgumentException If no command-line arguments are
     * provided.
     */
    public static void main(String[] args) {
        new RestFacebook(tok).runEverything();
    }

    private RestFacebook(String accessToken) {
        facebookClient = new DefaultFacebookClient(accessToken);
    }

    void runEverything() {
        String messageId = publishMessage();
        delete(messageId);
        String eventId = publishEvent();
        delete(eventId);
        String photoId = publishPhoto();
        delete(photoId);
    }

    String publishMessage() {
        System.out.println("* Feed publishing *");

        FacebookType publishMessageResponse
                = facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", "RestFB test"));

        System.out.println("Published message ID: " + publishMessageResponse.getId());
        return publishMessageResponse.getId();
    }

    String publishEvent() {
        System.out.println("* Event publishing *");

        Date tomorrow = new Date(currentTimeMillis() + 1000L * 60L * 60L * 24L);
        Date twoDaysFromNow = new Date(currentTimeMillis() + 1000L * 60L * 60L * 48L);

        FacebookType publishEventResponse = facebookClient.publish("me/events", FacebookType.class, Parameter.with("name", "Party"),
                Parameter.with("start_time", tomorrow), Parameter.with("end_time", twoDaysFromNow));

        System.out.println("Published event ID: " + publishEventResponse.getId());
        return publishEventResponse.getId();
    }

    String publishPhoto() {
        System.out.println("* Binary file publishing *");

        FacebookType publishPhotoResponse = facebookClient.publish("me/photos", FacebookType.class,
                BinaryAttachment.with("cat.png", getClass().getResourceAsStream("/cat.png")),
                Parameter.with("message", "Test cat"));

        System.out.println("Published photo ID: " + publishPhotoResponse.getId());
        return publishPhotoResponse.getId();
    }

    void delete(String objectId) {
        System.out.println("* Object deletion *");
        System.out.println(format("Deleted %s: %s", objectId, facebookClient.deleteObject(objectId)));
    }
}
