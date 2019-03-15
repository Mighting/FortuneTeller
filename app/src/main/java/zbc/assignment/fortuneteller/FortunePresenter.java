package zbc.assignment.fortuneteller;

import java.io.IOException;

public class FortunePresenter {

    public interface View{
        void updateText();
    }


    private View view;

    public FortunePresenter(View view) {
        this.view = view;
    }


    HTTPRequest httpRequest = new HTTPRequest(this);
    Fortune fortune = new Fortune();

    public void GetUrlRequest()throws IOException {
        httpRequest.execute();
    }

    public void SetForune(Fortune fortune){
        //CAL THE FORTUNE........................................
        
    }
}
