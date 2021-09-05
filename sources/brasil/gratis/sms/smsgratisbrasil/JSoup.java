package brasil.gratis.sms.smsgratisbrasil;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JSoup {
    static String recaptcha_challenge_field_holder;
    static String sessionId;
    static String urlimage;

    /* access modifiers changed from: package-private */
    public void enviar_mensagem() {
        try {
            Connection.Response res = Jsoup.connect("http://torpedogratis.org/salva.php").data("campoOperadora", "TIM").data("campoDDD_d", "88").data("campoCEL_d", "999455102").data("campoDDD_r", "88").data("campoCEL_r", "999455102").data("campoSMS", "Olá irmão").userAgent("Mozilla").method(Connection.Method.POST).execute();
            Document parse = res.parse();
            sessionId = res.cookie("SESSIONID");
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: package-private */
    public void confirmar_envio(String captcha, String Challenge) {
        try {
            Jsoup.connect("http://torpedogratis.org/verifica.php").cookie("SESSIONID", sessionId).data("recaptcha_response_field", captcha).data("recaptcha_challenge_field", recaptcha_challenge_field_holder).post();
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: package-private */
    public String vercaptcha() {
        Document iframeContentDoc = null;
        try {
            String iframeSrc = Jsoup.connect("http://167.114.14.172/01_sms/confirma.php").cookie("SESSIONID", sessionId).post().select("iframe").first().attr("src");
            if (iframeSrc != null) {
                iframeContentDoc = Jsoup.connect(iframeSrc).get();
            }
            urlimage = iframeContentDoc.getElementById("recaptcha_challenge_image").val();
            String val = iframeContentDoc.getElementById("recaptcha_challenge_field_holder").val();
            urlimage = val;
            recaptcha_challenge_field_holder = val;
        } catch (Exception e) {
        }
        return urlimage;
    }

    /* access modifiers changed from: package-private */
    public String verimg() {
        try {
            Element captcha = Jsoup.connect("http://167.114.14.172/01_sms/confirma.php").get().select("#recaptcha_challenge_image").first();
            if (captcha != null) {
                return captcha.absUrl("src");
            }
            throw new RuntimeException("Unable to find captcha...");
        } catch (Exception e) {
            return "";
        }
    }
}
