package com.trustedoffer.snackbarwithinternetcheck;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   CoordinatorLayout corLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        corLay=findViewById(R.id.CorLay);
        checkInternetConnection();
    }

    private void checkInternetConnection() {
        ConnectivityManager connectivityManager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if (info==null)
        {
           ShowSnackBar();
        }

    }

    private void ShowSnackBar() {
        Snackbar snackbar=Snackbar.make(corLay,"No Internet Connection",Snackbar.LENGTH_INDEFINITE)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar1=Snackbar.make(corLay,"Seen",Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                }).setActionTextColor(Color.GREEN);
        View snackView=snackbar.getView();
        TextView snackText=snackView.findViewById(android.support.design.R.id.snackbar_text);
        snackText.setTextColor(Color.YELLOW);

        snackbar.show();
    }
}
