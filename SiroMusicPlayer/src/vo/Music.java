package vo;

public class Music {
		private String Musicseq;
		private String MusicName;
		private String singer;
		private int playtime;
		private String musicPath;
		private String id;
		
		public Music(String musicseq, String musicName, String singer, int playtime, String musicPath, String id) {
			super();
			Musicseq = musicseq;
			MusicName = musicName;
			this.singer = singer;
			this.playtime = playtime;
			this.musicPath = musicPath;
			this.id = id;
		}
		public Music() {
			super();
		}
		
		public String getMusicseq() {
			return Musicseq;
		}
		public void setMusicseq(String musicseq) {
			Musicseq = musicseq;
		}
		public String getMusicName() {
			return MusicName;
		}
		public void setMusicName(String musicName) {
			MusicName = musicName;
		}
		public String getSinger() {
			return singer;
		}
		public void setSinger(String singer) {
			this.singer = singer;
		}
		public int getPlaytime() {
			return playtime;
		}
		public void setPlaytime(int playtime) {
			this.playtime = playtime;
		}
		public String getMusicPath() {
			return musicPath;
		}
		public void setMusicPath(String musicPath) {
			this.musicPath = musicPath;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "곡 번호="+Musicseq+", 노래 이름=" + MusicName + ", 아티스트=" + singer + ", 재생시간=" + playtime;
		}
}
