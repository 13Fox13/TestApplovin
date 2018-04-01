package com.klopov.andrey.testapplovin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdk;

import java.util.List;
/**
 * Created by andrejklopov on 30.03.2018.
 */

public class NativeActivity extends AppCompatActivity {
    private static final int NUM_ADS_TO_LOAD = 1;

    private AppLovinNativeAd nativeAd;
    private Button   button3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_native);


        button3 = (Button) findViewById( R.id.button3 );
        button3.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button3.setEnabled( false );

                loadNativeAds( NUM_ADS_TO_LOAD );
            }
        } );

        button3 = (Button) findViewById( R.id.button3 );
        button3.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final AppLovinSdk sdk = AppLovinSdk.getInstance( getApplicationContext() );
                sdk.getNativeAdService().precacheResources( nativeAd, new AppLovinNativeAdPrecacheListener()
                {
                    @Override
                    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
                    }

                    @Override
                    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd)
                    {
                        runOnUiThread( new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                button3.setEnabled( true );
                            }
                        });
                    }

                    @Override
                    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {

                    }

                    @Override
                    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                    }
                } );
            }
        } );
    }

    public void loadNativeAds(final int numAdsToLoad)
    {
        final AppLovinSdk sdk = AppLovinSdk.getInstance( getApplicationContext() );
        sdk.getNativeAdService().loadNativeAds( numAdsToLoad, new AppLovinNativeAdLoadListener()
        {
            @Override
            public void onNativeAdsFailedToLoad(int i) {
            }

            @Override
            public void onNativeAdsLoaded(final List list)
            {

                runOnUiThread( new Runnable()
                {
                    @Override
                    public void run()
                    {

                        nativeAd = (AppLovinNativeAd) list.get( 0 );
                        button3.setEnabled( true );
                    }
                } );
            }

        } );
    }
}
