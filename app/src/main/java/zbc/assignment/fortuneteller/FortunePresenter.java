package zbc.assignment.fortuneteller;

public class FortunePresenter {

    public interface View {
        void updateText(Fortune fortune);
    }


    private View view;

    public FortunePresenter(View view) {
        this.view = view;
    }


    Fortune fortune = new Fortune();

    public void GetUrlRequest() {
        HTTPRequest httpRequest = new HTTPRequest(this);
        httpRequest.execute();
    }

    public void SetFortune(Fortune fortune) {
        view.updateText(fortune);
    }
}
