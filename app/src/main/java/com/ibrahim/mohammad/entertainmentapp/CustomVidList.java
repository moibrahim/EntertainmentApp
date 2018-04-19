package com.ibrahim.mohammad.entertainmentapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.VideoView;

import java.util.List;

import com.ibrahim.mohammad.entertainmentapp.R;
import com.ibrahim.mohammad.entertainmentapp.model.Video;

public class CustomVidList extends ArrayAdapter<Video> {
    private Context mContext;
    private List<Video> mVideos;

    public CustomVidList(@NonNull Context context, @NonNull List<Video> objects) {
        super(context, R.layout.vid_list, objects);

        mContext = context;
        mVideos = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;


        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.vid_list, null);
            holder = new ViewHolder();

            holder.videoView = (VideoView) convertView
                    .findViewById(R.id.videoView);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();

        }

        /***get clicked view and play video url at this position**/
        try {
            Video video = mVideos.get(position);
            //play video using android api, when video view is clicked.
            String url = video.getVideoUrl(); // your URL here
            Uri videoUri = Uri.parse(url);
            holder.videoView.setVideoURI(videoUri);
            holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    holder.videoView.start();
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }


        return convertView;
    }

    public static class ViewHolder {
        VideoView videoView;

    }

}
