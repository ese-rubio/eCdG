package com.example.sergio.elcajondegatsby;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by Sergio on 01/09/2015.
 */
public class WebViewClientMod extends WebViewClient {

    private Activity actividadPrincipal;
    private final String URL_INCIAL="http://www.elcajondegatsby.com/";

    public WebViewClientMod(Activity actividad){
        this.actividadPrincipal=actividad;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (Uri.parse(url).getHost().contains(URL_INCIAL)) {
            //comprueba si la pagina a la que intentas acceder pertenece al dominio de la pagina de la aplicacion
            return false;
        } else {
            //si no pertenece al dominio, en vez de abrirlo en la aplicacion, lo abre en el navegador
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            actividadPrincipal.startActivity(intent);
            return true;
        }
    }

}
