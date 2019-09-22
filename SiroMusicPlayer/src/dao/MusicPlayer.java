package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javazoom.jl.player.MP3Player;
import vo.Music;
import vo.UserAccount;
import oracle.sql.BLOB;

public class MusicPlayer {
	ArrayList<Music> musicList;
	int currentIndex = 0; 
	MP3Player mp3 = new MP3Player();
	MemoDaoManager mdm = new MemoDaoManager();
	UserAccount user = new UserAccount();

	public MusicPlayer() {
		musicList = new ArrayList<Music>();
//		musicList.add(new Music("chokobo", "Fantasy", 120, "C:\\Users\\user\\Desktop\\JDBC\\JavaGUI\\chokobo.mp3",""));
//		musicList.add(new Music("헤 네 시 스", "MAPLE", 210, "C:\\Users\\user\\Desktop\\JDBC\\JavaGUI\\henesys.mp3",""));
//		musicList.add(new Music("커 닝 시 티", "MAPLE", 222, "C:\\Users\\user\\Desktop\\JDBC\\JavaGUI\\curning.mp3",""));
//		musicList.add(new Music("페 리 온", "MAPLE", 170, "C:\\Users\\user\\Desktop\\JDBC\\JavaGUI\\prion.mp3",""));
//		musicList.add(new Music("로 리 엔", "Fighter", 192, "C:\\Users\\user\\Desktop\\JDBC\\JavaGUI\\rorien.mp3",""));
	}
	public void Musiccheck() {
		musicList = new ArrayList<Music>();
		for (Music music : musicList) {
			musicList.addAll(mdm.getMusicList(user.getId()));
		}
	}
	
	public Music play() {
		musicList.addAll(mdm.getAllMusicList());
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		Music m = musicList.get(currentIndex);
		mp3.play(m.getMusicPath());
		return m;
//					mp3.play(musicList.get(currentIndex)).getMusicPath();
//					return musicList.get(currentIndex);
	}
//					public Music play() {
//						return musicList.get(currentIndex); }

	public String stop() {
		mp3.stop();
		return "노래가 정지 되었습니다";
	}

	public Music nextPlay() {
		if (currentIndex == musicList.size() - 1) {
			return null;
		}
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		currentIndex++;
		mp3.play(musicList.get(currentIndex).getMusicPath());
		return musicList.get(currentIndex);
	}

	public Music prePlay() {
		if (currentIndex == 0) {
			return null;
		}
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		currentIndex--;
		mp3.play(musicList.get(currentIndex).getMusicPath());
		return musicList.get(currentIndex);
	}
}
