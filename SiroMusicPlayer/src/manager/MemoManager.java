package manager;

import java.util.ArrayList;

import dao.MemoDaoManager;
import vo.Music;
import vo.UserAccount;
import vo.UserMemo;

public class MemoManager {

	private MemoDaoManager mdm = null;
	private String id;// 로그인한 ID
	private String name;// 로그인한 이용자 이름

	public MemoManager() {

		this.mdm = new MemoDaoManager();
	}

	public boolean insertAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.insertAccount(user);
		return result;
	}

	public UserAccount loginAccount(UserAccount user) {
		// TODO Auto-generated method stub
		UserAccount result = null;
		result = mdm.loginAccount(user);
		if (result != null) {
			this.id = result.getId();
			this.name = result.getName();
		}
		return result;
	}

	public boolean deleteAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAccount(user);
		return result;
	}

	public boolean insertMemo(UserMemo memo) {
		// TODO Auto-generated method stub
		boolean result = false;
		memo.setId(this.id);
		result = mdm.insertMemo(memo);
		return result;
	}

	public ArrayList<UserMemo> getMemoList() {
		// TODO Auto-generated method stub
		ArrayList<UserMemo> result = null;
		result = mdm.getMemoList(this.id);
		return result;
	}

	public ArrayList<UserMemo> searchMemo(String searchword) {
		// TODO Auto-generated method stub
		ArrayList<UserMemo> result = null;
		result = mdm.searchMemo(searchword, this.id);
		return result;
	}

	public UserMemo searchOneMemo(String seq) {
		// TODO Auto-generated method stub
		UserMemo result = null;
		result = mdm.searchOneMemo(seq, this.id);
		return result;
	}

	public boolean updateMemo(String seq,UserMemo memo) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.updateMemo(seq,memo);
		return result;
	}

	public boolean deleteMemo(String seq) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteMemo(seq);
		return result;
	}

	public boolean deleteAllMemo(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAllMemo(id);
		return result;
	}

	public boolean logout() {

		if (this.name == null) {
			return false;
		}

		this.name = null;
		this.id = null;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//추가기능단
	public void printMusicinfo(Music m) {
		String musicName = m.getMusicName();
		String singer = m.getSinger();
		int playTime = m.getPlaytime();
		System.out.println(musicName + " ," + singer + " ," + playTime / 60 + "분" + playTime % 60 + "초");
	}
	public boolean addeleteAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.addeleteAccount(user);
		return result;
	}
	public boolean insertMusic(Music m) {
		boolean result = false;
		result = mdm.insertMusic(m);
		return result;
	}
	public boolean updateAccount(String id,String pass,UserAccount user) {
		boolean result = false;
		result = mdm.updateAccount(id, pass, user);
		return result;
	}
	//수정전
	public ArrayList<Music> getMusicList() {
		ArrayList<Music> result = null;
		result = mdm.getAllMusicList();
		return result;
	}	

	
	public ArrayList<Music> getAllMusicList() {
		ArrayList<Music> result = null;
		result = mdm.getAllMusicList();
		return result;
	}
	public ArrayList<UserAccount> getUserList() {
		ArrayList<UserAccount> result = null;
		result = mdm.getAllUserList();
		return result;
	}	
	public ArrayList<UserAccount> getAllUserList() {
		ArrayList<UserAccount> result = null;
		result = mdm.getAllUserList();
		return result;
	}
	
	public ArrayList<Music> searchMusic(String searchword) {
		ArrayList<Music> result = null;
		result = mdm.searchMusic(searchword, this.id);
		return result;
	}

	public Music searchOneMusic(String seq) {
		Music result = null;
		result = mdm.searchOneMusic(seq, this.id);
		return result;
	}

	public boolean updateMusic(String seq,Music m) {
		boolean result = false;
		result = mdm.updateMusic(seq,m);
		return result;
	}

	public boolean deleteMusic(String seq) {
		boolean result = false;
		result = mdm.deleteMusic(seq);
		return result;
	}
}
