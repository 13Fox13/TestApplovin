package com.klopov.andrey.testapplovin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/**
 * Created by andrejklopov on 30.03.2018.
 */

public class InterstitialActivity extends AppCompatActivity implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {

    private AppLovinInterstitialAdDialog interstitialAd;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_interstitial );

        interstitialAd = AppLovinInterstitialAd.create( AppLovinSdk.getInstance( this ), this );

        button2 = (Button) findViewById( R.id.button2 );
        button2.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button2.setEnabled( false );

                interstitialAd.setAdLoadListener( InterstitialActivity.this );
                interstitialAd.setAdDisplayListener( InterstitialActivity.this );
                interstitialAd.setAdClickListener( InterstitialActivity.this );
                interstitialAd.setAdVideoPlaybackListener( InterstitialActivity.this );

                interstitialAd.show();
            }
        } );
    }

    @Override
    public void adReceived(AppLovinAd appLovinAd)
    {
        button2.setEnabled( true );
    }

    @Override
    public void failedToReceiveAd(int errorCode)
    {
        button2.setEnabled( true );
    }

    @Override
    public void adDisplayed(AppLovinAd appLovinAd)
    {

    }

    @Override
    public void adHidden(AppLovinAd appLovinAd)
    {

    }

    @Override
    public void adClicked(AppLovinAd appLovinAd)
    {

    }

    @Override
    public void videoPlaybackBegan(AppLovinAd appLovinAd)
    {

    }

    @Override
    public void videoPlaybackEnded(AppLovinAd appLovinAd, double percentViewed, boolean wasFullyViewed)
    {

    }
}
