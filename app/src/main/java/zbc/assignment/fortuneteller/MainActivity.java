package zbc.assignment.fortuneteller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    FortunePresenter fortunePresenter;

    TextView fortuneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fortuneView = findViewById(R.id.FortuneTextView);

        fortunePresenter = new FortunePresenter();

    }
    public void onGetFortuneClick(View view) throws IOException {
        fortunePresenter.GetUrlRequest();

    }

    public void updateText(Fortune fortune){
        fortuneView.setText(fortune.toString());
    }




}
