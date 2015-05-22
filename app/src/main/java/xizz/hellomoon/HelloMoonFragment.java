package xizz.hellomoon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();

	private Button mPlayButton;
	private Button mStopButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle
			savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

		mPlayButton = (Button) v.findViewById(R.id.hellomoon_playPauseButton);
		mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);

		mPlayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (mPlayer.isPlaying())
					mPlayer.pause();
				else
					mPlayer.play(getActivity());
				updateButtons();
			}
		});
		mStopButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.stop();
				updateButtons();
			}
		});

		updateButtons();
		return v;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}

	void updateButtons() {
		if (mPlayer.isPlaying())
			mPlayButton.setText(R.string.hellomoon_pause);
		else
			mPlayButton.setText(R.string.hellomoon_play);
	}
}
