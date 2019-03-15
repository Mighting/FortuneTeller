package zbc.assignment.fortuneteller;

public class FortunePresenter {

    //Refence to the view we want to use
    public interface View {
        void updateText(Fortune fortune);
    }


    private View view;

    public FortunePresenter(View view) {
        this.view = view;
    }


    Fortune fortune = new Fortune();

    //Call the HTTP requester to do execute
    public void GetUrlRequest() {
        //I use a task, and task's only run once, so i create a new everytime i need a HTTP call
        HTTPRequest httpRequest = new HTTPRequest(this);
        httpRequest.execute();
    }

    public void SetFortune(Fortune fortune) {
        view.updateText(fortune);
    }
}
