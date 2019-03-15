package zbc.assignment.fortuneteller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements FortunePresenter.View {

    FortunePresenter fortunePresenter;

    TextView fortuneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fortuneView = findViewById(R.id.FortuneTextView);

        fortunePresenter = new FortunePresenter(this);

    }

    //Method that gets called when the user clicks on the button
    public void onGetFortuneClick(View view) throws IOException {
        //Calls the presenter to get the HTTP call
        fortunePresenter.GetUrlRequest();

    }


    //Update text view
    @Override
    public void updateText(Fortune fortune) {
        fortuneView.setText(fortune.getFortune());
        fortuneView.setTextSize(20);
        Log.e("tg", fortune.getFortune() );
    }
}
