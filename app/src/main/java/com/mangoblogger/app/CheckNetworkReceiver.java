package com.mangoblogger.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class CheckNetworkReceiver extends BroadcastReceiver {

    interface OnNetworkConnection{
        void onNetworkConnectionChanged(boolean isConnected);

    }
   static OnNetworkConnection onNetworkConnection;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.net.conn.CONNECTIVITY_CHANGE")) {
            ConnectivityManager connection = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connection.getActiveNetworkInfo();

            boolean isConnect = info != null && info.isConnectedOrConnecting();

            if (onNetworkConnection != null) {
                //this.onNetworkConnection = onNetworkConnection;
                onNetworkConnection.onNetworkConnectionChanged(isConnect);
            }
        }
    }

    public void setOnNetworkConnection(OnNetworkConnection onNetworkConnection) {
        this.onNetworkConnection = onNetworkConnection;
       /* if (onNetworkConnection != null)
       //
        onNetworkConnection.onNetworkConnectionChanged(checkNetwork());*/


    }


}
