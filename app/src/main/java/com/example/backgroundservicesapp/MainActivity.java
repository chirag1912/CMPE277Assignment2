package com.example.backgroundservicesapp;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.app.DownloadManager;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    private EditText url0;
    private EditText url1;
    private EditText url2;
    private EditText url3;
    private EditText url4;
    private Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url0 = (EditText) findViewById(R.id.url);
        url0.setText("https://static.googleusercontent.com/media/research.google.com/en//pubs/archive/45530.pdf");
        url1 = (EditText) findViewById(R.id.url1);
        url1.setText("https://hadoop.apache.org/docs/r1.2.1/hdfs_design.pdf");
        url2 = (EditText) findViewById(R.id.url2);
        url2.setText("https://pages.databricks.com/rs/094-YMS-629/images/LearningSpark2.0.pdf");
        url3 = (EditText) findViewById(R.id.url3);
        url3.setText("https://docs.aws.amazon.com/wellarchitected/latest/machine-learning-lens/wellarchitected-machine-learning-lens.pdf");
        url4 = (EditText) findViewById(R.id.url4);
        url4.setText("https://developers.snowflake.com/wp-content/uploads/2020/09/SNO-eBook-7-Reference-Architectures-for-Application-Builders-MachineLearning-DataScience.pdf");

        downloadButton = (Button)findViewById(R.id.downloadButton);
        // https://jobs.ca.gov/pdf/jobs_by_education.pdf
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUrl = url0.getText().toString();
                String getUrl1 = url1.getText().toString();
                String getUrl2= url2.getText().toString();
                String getUrl3 = url3.getText().toString();
                String getUrl4 = url4.getText().toString();


                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getUrl) );
                DownloadManager.Request request1 = new DownloadManager.Request(Uri.parse(getUrl1));
                DownloadManager.Request request2 = new DownloadManager.Request(Uri.parse(getUrl2));
                DownloadManager.Request request3 = new DownloadManager.Request(Uri.parse(getUrl3));
                DownloadManager.Request request4 = new DownloadManager.Request(Uri.parse(getUrl4));

                String title = URLUtil.guessFileName(getUrl, null,null);
                String title1 = URLUtil.guessFileName(getUrl1, null,null);
                String title2 = URLUtil.guessFileName(getUrl2, null,null);
                String title3 = URLUtil.guessFileName(getUrl3, null,null);
                String title4 = URLUtil.guessFileName(getUrl4, null,null);

                request.setTitle(title);
                request1.setTitle(title1);
                request2.setTitle(title2);
                request3.setTitle(title3);
                request4.setTitle(title4);

                request.setDescription("Download in progress");
                request1.setDescription("Download in progress");
                request2.setDescription("Download in progress");
                request3.setDescription("Download in progress");
                request4.setDescription("Download in progress");


                String cookie = CookieManager.getInstance().getCookie(getUrl);
                String cookie1 = CookieManager.getInstance().getCookie(getUrl4);
                String cookie2 = CookieManager.getInstance().getCookie(getUrl1);
                String cookie3 = CookieManager.getInstance().getCookie(getUrl2);
                String cookie4 = CookieManager.getInstance().getCookie(getUrl3);


                request.addRequestHeader("cookie",cookie);
                request1.addRequestHeader("cookie",cookie1);
                request2.addRequestHeader("cookie",cookie2);
                request3.addRequestHeader("cookie",cookie3);
                request4.addRequestHeader("cookie",cookie4);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request1.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request2.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request3.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request4.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);
                request1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title1);
                request2.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title2);
                request3.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title3);
                request4.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title4);


                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
                downloadManager.enqueue(request1);
                downloadManager.enqueue(request2);
                downloadManager.enqueue(request3);
                downloadManager.enqueue(request4);

                Toast.makeText(MainActivity.this, "Download Started", Toast.LENGTH_SHORT).show();
            }
        });
    }
}