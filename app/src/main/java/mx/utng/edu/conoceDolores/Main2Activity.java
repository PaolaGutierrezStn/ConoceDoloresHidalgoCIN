package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_main2);
        Intent intent=getIntent();
        Bundle extras = intent.getExtras();
        String url=extras.getString("value");
        webView= findViewById(mx.utng.edu.conoceDolores.R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}
