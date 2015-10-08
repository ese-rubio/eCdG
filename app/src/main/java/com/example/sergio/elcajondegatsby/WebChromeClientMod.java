package com.example.sergio.elcajondegatsby;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by Sergio on 01/09/2015.
 */
public class WebChromeClientMod extends WebChromeClient {

    private Activity actividadPrincipal;
    private ProgressBar barra;

    public WebChromeClientMod(Activity actividad, ProgressBar barra){
        this.actividadPrincipal=actividad;
        this.barra=barra;
    }

}
