package com.ilyes.newsapp;


import android.app.LoaderManager;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>>{

    public static final int NEWS_LOADER_ID = 1;
    public static final String GUARDIAN_REQUEST_URL =
            "https://content.guardianapis.com/search?q=debate&tag=politics%2Fpolitics&from-date=2014-01-01&api-key=test&fbclid=IwAR0qUOesFkkxSiEKUDvMnuJ_xiWpNAhsQRYVV1eHLCqiG3sLl4mPI1IKDP8";

    ListView mListView;
    TextView mTextView;
    NewsAdapter mAdapter;
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        mListView = (ListView) findViewById(R.id.list_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTextView = (TextView) findViewById(R.id.text_view);

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(R.string.no_internet_text);
        }
    }


    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        mAdapter = new NewsAdapter(this, data);
        mProgressBar.setVisibility(View.GONE);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }
}