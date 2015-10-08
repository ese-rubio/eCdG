package com.example.sergio.elcajondegatsby;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;


public class MainActivity extends Activity {

    private ProgressBar barra;
    private WebView webViewPrincipal;
    private int opcion=0;

    private final String URL_INCIAL="http://www.elcajondegatsby.com/";

    public MainActivity(){}
    public MainActivity(int opcion){
        this.opcion=opcion;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        //

        setContentView(R.layout.activity_main);

        this.webViewPrincipal=(WebView) this.findViewById(R.id.webView);
        barra=(ProgressBar) findViewById(R.id.progressbar);

        // Makes Progress bar Visible
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        webViewPrincipal.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                setTitle("Loading...");
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if(progress == 100)
                    setTitle(R.string.app_name);
            }
        });


        WebSettings webSettings=webViewPrincipal.getSettings();
        WebViewClientMod webClientMod=new WebViewClientMod(this);
        webSettings.setJavaScriptEnabled(true);
        //para que se ajuste el texto al ancho de la pantalla
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        // habilitamos el zoom
        webViewPrincipal.getSettings().setBuiltInZoomControls(true);
        //para que abra las paginas en la aplicacion en vez de en el navegador
        webViewPrincipal.setWebViewClient(webClientMod);

        webViewPrincipal.loadUrl(URL_INCIAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //para poder volver atras con el boton de atras del movil
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewPrincipal.canGoBack()) {
            webViewPrincipal.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
