package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manager.MemoManager;
import vo.Music;
import vo.UserAccount;
import vo.UserMemo;

public class MemoDaoManager implements MemoInterface {

	UserAccount UserVO = new UserAccount();
	UserMemo MemoVO = new UserMemo();

	@Override
	public boolean insertAccount(UserAccount user) {

		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "insert into useraccount values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPassword());
			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("<성공>");
				return true;
			}
		} catch (SQLException e) {
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}

	@Override
	public UserAccount loginAccount(UserAccount user) {
		UserAccount result = null;
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "select * from useraccount where Id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String userName = rs.getString(1);
				String userId = rs.getString(2);
				String userPw = rs.getString(3);
				result = new UserAccount(userName, userId, userPw);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return null;
	}

	@Override
	public boolean deleteAccount(UserAccount user) {
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "delete from useraccount where id = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("<성공>");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;

	}

	@Override
	public boolean insertMemo(UserMemo memo) {
		Connection con = ConnectionManager.getConnection();
		int result = 0;
		try {
			String sql = "insert into UserMemo values (?,?,?,sysdate,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNextUserId());
			pstmt.setString(2, memo.getTitle());
			pstmt.setString(3, memo.getContent());
			pstmt.setString(4, memo.getId());
			result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("<성공>");
				return true; }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}

	@Override
	public ArrayList<UserMemo> getMemoList(String id) {
		Connection con = ConnectionManager.getConnection();
		ArrayList<UserMemo> allData = new ArrayList<>();
		try {
			String sql = "select * from Usermemo where id ="+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String Seq = rs.getString(1);
				String Title = rs.getString(2);
				String Content= rs.getString(3);
				String Indate = rs.getString(4);
				String  Id= rs.getString(5);
				UserMemo vo = new UserMemo(Seq, Title, Content, Indate, Id);
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}

	@Override
	public ArrayList<UserMemo> searchMemo(String searchword, String id) {
		Connection con = ConnectionManager.getConnection();
		ArrayList<UserMemo> allData = new ArrayList<>();
		try {
			String sql = "select * from Usermemo where title like '%"+searchword+ "%'or content like'%"+searchword+"%' ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String Seq = rs.getString(1);
				String Title = rs.getString(2);
				String Content= rs.getString(3);
				String Indate = rs.getString(4);
				String  Id= rs.getString(5);
				UserMemo vo = new UserMemo(Seq, Title, Content, Indate, Id);
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}

	@Override
	public UserMemo searchOneMemo(String seq, String id) {
		UserMemo result = null;
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "select * from Usermemo where memoseq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String Seq = rs.getString(1);
				String Title = rs.getString(2);
				String Content= rs.getString(3);
				String Indate = rs.getString(4);
				String Id= rs.getString(5);
				result = new UserMemo(Seq, Title, Content, Indate, Id);}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return result;
	}

	@Override
	public boolean updateMemo(String seq, UserMemo memo) {
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "update Usermemo set title = ?, content = ? where memoseq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memo.getTitle());
			pstmt.setString(2, memo.getContent());
			pstmt.setString(3, seq);
			pstmt.executeUpdate();
			System.out.println("<수정 성공>");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}
	@Override
	public boolean deleteMemo(String seq) {
		Connection con = ConnectionManager.getConnection();
		try {		
			String sql = "delete from usermemo where memoseq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
			System.out.println("<삭제 성공>");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}
	@Override
	public boolean deleteAllMemo(String id) {
		Connection con = ConnectionManager.getConnection();
		try {		
			String sql = "delete from usermemo where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("<계정의 전 메모 삭제 성공>");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}

	//추가 메소드
	
	public int getNextUserId() {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "select memo_seq.nextval from dual";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return result;
	}
	public int getNextMusicseq() {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "select music_seq.nextval from dual";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return result;
	}
	@Override
	public boolean addeleteAccount(UserAccount user) {
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "delete from useraccount where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			int count = pstmt.executeUpdate();
			if (count == 1) {
				System.out.println("<성공>");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;

	}
	public boolean insertMusic (Music m) {
		Connection con = ConnectionManager.getConnection();
		int result = 0;
		try {
			String sql = "insert into Music values (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNextMusicseq());
			pstmt.setString(2, m.getMusicName());
			pstmt.setString(3, m.getSinger());
			pstmt.setInt(4, m.getPlaytime());
			pstmt.setString(5, m.getMusicPath());
			pstmt.setString(6, m.getId());
			result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("<성공>");
				return true; }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}
	@Override
	public ArrayList<Music> getAllMusicList() {
		Connection con = ConnectionManager.getConnection();
		ArrayList<Music> allData = new ArrayList<>();
		try {
			String sql = "select * from Music";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String Seq = rs.getString(1);
				String title = rs.getString(2);
				String singer= rs.getString(3);
				int playtime = rs.getInt(4);
				String musicpath= rs.getString(5);
				String id= rs.getString(5);
				Music vo = new Music(Seq, title, singer, playtime, musicpath, id);
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}
	@Override
	public ArrayList<Music> getMusicList(String id) {
		Connection con = ConnectionManager.getConnection();
		ArrayList<Music> allData = new ArrayList<>();
		try {
			String sql = "select * from Music where id ="+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String Seq = rs.getString(1);
				String title = rs.getString(2);
				String singer= rs.getString(3);
				int playtime = rs.getInt(4);
				String musicpath= rs.getString(5);
				String userid= rs.getString(5);
				Music vo = new Music(Seq, title, singer, playtime, musicpath, userid);
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}
	@Override
	public boolean updateAccount(String id, String pass, UserAccount user) {
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "update Useraccount set name = ?, password = ? where id = '"+id+"' ,password = '"+pass+"'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
//			pstmt.setString(3, id);
//			pstmt.setString(4, pass);
			pstmt.executeUpdate();
			System.out.println("<수정 성공>");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}
	@Override
	public ArrayList<Music> searchMusic(String searchword, String id) {
		Connection con = ConnectionManager.getConnection();
		ArrayList<Music> allData = new ArrayList<>();
		try {
			String sql = "select * from Music where musicname like '%"+searchword+ "%'or singer like'%"+searchword+"%' ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String Seq = rs.getString(1);
				String title = rs.getString(2);
				String singer= rs.getString(3);
				int playtime = rs.getInt(4);
				String musicpath= rs.getString(5);
				String userid= rs.getString(5);
				Music vo = new Music(Seq, title, singer, playtime, musicpath, userid);
			allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}
	@Override
	public boolean deleteMusic(String seq) {
		Connection con = ConnectionManager.getConnection();
		try {		
			String sql = "delete from Music where Musicseq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
			System.out.println("<삭제 성공>");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}

	//수정전
	@Override
	public ArrayList<UserAccount> getAllUserList() {
		Connection con = ConnectionManager.getConnection();
		ArrayList<UserAccount> allData = new ArrayList<>();
		try {
			String sql = "select * from UserAccount";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String userName = rs.getString(1);
				String userId = rs.getString(2);
				String userPw = rs.getString(3);
				UserAccount vo = new UserAccount(userName, userId, userPw);
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}
	@Override
	public ArrayList<UserAccount> getUserList(String id) {
		Connection con = ConnectionManager.getConnection();
		ArrayList<UserAccount> allData = new ArrayList<>();
		try {
			String sql = "select * from UserAccount where id ="+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String userName = rs.getString(1);
				String userId = rs.getString(2);
				String userPw = rs.getString(3);
				UserAccount vo = new UserAccount(userName, userId, userPw);
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return allData;
	}

	@Override
	public Music searchOneMusic(String seq, String id) {
		Music result = null;
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "select * from Music where Musicseq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String Seq = rs.getString(1);
				String title = rs.getString(2);
				String singer= rs.getString(3);
				int playtime = rs.getInt(4);
				String musicpath= rs.getString(5);
				String userid= rs.getString(5);
				result = new Music(Seq, title, singer, playtime, musicpath,userid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return result;
	}

	@Override
	public boolean updateMusic(String seq, Music m) {
		Connection con = ConnectionManager.getConnection();
		try {
			String sql = "update Music set Musicname = ?, singer = ? where Musicseq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getMusicName());
			pstmt.setString(2, m.getSinger());
			pstmt.setString(3, seq);
			pstmt.executeUpdate();
			System.out.println("<수정 성공>");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(con);
		}
		return false;
	}

	
	
	
}
