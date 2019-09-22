package ui;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MusicPlayer;
import manager.MemoManager;
import vo.Music;
import vo.UserAccount;
import vo.UserMemo;

public class MemoUI {

	private MemoManager manager = new MemoManager(); // 요청과 관련된 처리를 하기 위해 생성한
														// MemoManager 클래스의 객체
	private MusicPlayer player = new MusicPlayer();
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private Scanner sc2Line = new Scanner(System.in);
	private boolean accountflag = true;
	private boolean memoflag = true;
	private boolean secflag = true;
	private boolean playerflag = true;
	private boolean adminflag = true;

	/**
	 * <pre>
	 * 메모 관리 프로그램의 사용자 화면을 구성하고 사용자 입력을 대기한다.
	 * 프로그램은 종료 메뉴를 선택하기 전까지 무한 반복하여 처리 된다.
	 * </pre>
	 */
	public MemoUI() {

		while (accountflag) {// 로그 인 시작
			secflag = true;
			adminflag=true;
			mainMenu();
			switch (sc.next()) {
			case "Con/Admin":
				System.out.println("관리자 계정");
				while (adminflag) {
					adminMenu();
					switch (sc.nextInt()) {		// Music table에서 ID 컬럼이 Null이면 음원
							case 1:		
								addeleteAccount();
								break;
							case 2:
								insertMusic(); //음원 등록
								break;
							case 3:
								searchAllUser();	//모든 유저 확인
								break;
							case 4:	
								searchAllMusic();	//모든 음원 확인
								break;
							case 5:
								searchMusic();		//음원 검색
								break;
							case 6:
								deleteMusic();		//음원 삭제
								break;
							case 9:
								adminflag = false;
								break;
							}
				}
				break;
			case "1":
				insertAccount();
				break;
			case "2":
				deleteAccount();
				break;
			case "3":
				loginAccount();
				while (secflag) {
					memoflag = true;
					playerflag = true;
					PageTwo();
					switch (sc.nextInt()) {
					case 1:// 메모
						while (memoflag) {// 메모페이지
							subMenu();
							switch (sc.nextInt()) {
							case 1:
								insertMemo();
								break;
							case 2:
								searchMemo();
								break;
							case 3:
								searchAllMemo();
								break;
							case 4:
								searhOneMemo();
								break;
							case 5:
								updateMemo();
								break;
							case 6:
								deleteMemo();
								break;
							case 9:
								memoflag = false;
								break;
							}
						}
						break;

					case 2: // 뮤직플레이어
						while (playerflag) {
							playerMenu();
							switch (sc2.nextInt()) {
							case 1:// 플레이어
								Musicplayer();
								break;
							case 2: // 노래추가
								insertMusic();
								break;
							case 3: // 재생 목록 보기
								searchMusic();
								break;
							case 4: // 전체 노래 보기
								searchAllMusic();
								break;
							case 5: // 노래 검색
								searchMusic();
								break;
							case 6: // 노래 삭제
								deleteMusic();
								break;
							case 9:
								playerflag = false;
								break;
							}
						}
						break;
					case 3: // 회원 정보수정
						updateAccount();
						break;
					case 9:
						secflag = false;
						break;
					}
				}
				break;
			case "9":
				accountflag = false;
				break;
			}

		}

	}

	public void mainMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Siro Music Player★  로그인       │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.회원가입                                            │");
		System.out.println("│2.회원탈퇴                                            │");
		System.out.println("│3.로그인                                               │");
		System.out.println("│9.종료                                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void PageTwo() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Siro Music Player★  메인          │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.메모                                                  │");
		System.out.println("│2.Siro 뮤직 플레이어                           │");
		System.out.println("│3.회원 정보 수정                                    │");
		System.out.println("│9.종료                                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void playerMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Siro Music Player★  메인          │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.플레이어 실행                                     │");
		System.out.println("│2.재생 리스트에 노래 추가                       │");
		System.out.println("│3.재생 목록보기                            	   │");
		System.out.println("│4.노래 전체 목록보기                              │");
		System.out.println("│5.노래 목록에서 검색                              │");
		System.out.println("│6.노래 목록에서 삭제                              │");
		System.out.println("│9.종료                                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void adminMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Siro Music Player★  관리자       │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.회원 삭제                                           │");
		System.out.println("│2.음원 등록                                           │");
		System.out.println("│3.전체회원 조회                         	   │");
		System.out.println("│4.음원 전체 목록보기                              │");
		System.out.println("│5.음원 목록에서 검색                              │");
		System.out.println("│6.음원 목록에서 삭제                              │");
		System.out.println("│9.종료                                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void subMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Siro Music Player★   메모        │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.메모등록                                            │");
		System.out.println("│2.메모검색(내용+제목)             │");
		System.out.println("│3.메모전체보기                                      │");
		System.out.println("│4.메모상세보기                                      │");
		System.out.println("│5.메모수정                                            │");
		System.out.println("│6.메모삭제                                            │");
		System.out.println("│9.종료                                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void loginAccount() {
		while (true) {
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if ((id == null || id.equals("")) || (password == null || password.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				UserAccount result = manager.loginAccount(new UserAccount(null, id, password));
				if (result != null) {
					System.out.println("로그인 완료 " + manager.getId() + "(" + manager.getName() + "님) 환영합니다.");
					break;
				} else {
					System.out.println("******ERROR 아이디/비밀번호가 일치하지 않습니다.");
				}
			}
		}
	}

	public void insertAccount() {
		while (true) {
			System.out.println("이름을 입력 해주세요 => ");
			String name = scLine.nextLine();
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if ((name == null || name.equals("")) || (id == null || id.equals(""))
					|| (password == null || password.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.insertAccount(new UserAccount(name, id, password));
				if (result) {
					System.out.println("계정등록 완료");
					break;
				} else {
					System.out.println("******ERROR 같은아이디가 존재합니다.");
				}
			}
		}
	}

	public void deleteAccount() {
		while (true) {
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if ((id == null || id.equals("")) || (password == null || password.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				manager.deleteAllMemo(id);
				boolean result = manager.deleteAccount(new UserAccount(null, id, password));
				if (result) {
					System.out.println("계정삭제 완료");
					break;
				} else {
					System.out.println("******ERROR 삭제실패.");
				}
			}
		}
	}
	public void addeleteAccount() {
		while (true) {
			System.out.println("ID를 입력 해주세요 => ");
			String id = sc2Line.nextLine();
			if ((id == null || id.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				manager.deleteAllMemo(id);
				boolean result = manager.addeleteAccount(new UserAccount(null, id, null));
				if (result) {
					System.out.println("계정삭제 완료");
					break;
				} else {
					System.out.println("******ERROR 삭제실패.");
				}
			}
		}
	}
	public void insertMemo() {

		while (true) {
			System.out.println("제목을 입력 해주세요 => ");
			String title = scLine.nextLine();
			System.out.println("내용을 입력 해주세요 => ");
			String content = scLine.nextLine();
			if ((title == null || title.equals("")) || (content == null || content.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.insertMemo(new UserMemo(null, title, content, null, null));
				if (result) {
					System.out.println("메모등록 완료");
					break;
				} else {
					System.out.println("******ERROR 메모등록에 실패했습니다.");
				}
			}
		}
	}

	public void searchMemo() {
		while (true) {
			System.out.println("제목또는 내용을 입력 해주세요 => ");
			String searchWord = scLine.nextLine();
			if ((searchWord == null || searchWord.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				ArrayList<UserMemo> result = manager.searchMemo(searchWord);
				if (result != null) {
					printAllMemo(result);
					break;
				} else {
					System.out.println("******ERROR 메모검색에 실패했습니다.");
				}
			}
		}
	}

	public void searchAllMemo() {
		while (true) {
			ArrayList<UserMemo> result = manager.getMemoList();
			if (result != null) {
				printAllMemo(result);
				break;
			} else {
				System.out.println("******ERROR 메모조회에 실패했습니다.");
			}

		}
	}

	public void searhOneMemo() {
		while (true) {
			System.out.println("메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				UserMemo result = manager.searchOneMemo(memoseq);
				if (result != null) {
					System.out.println("제목 : " + result.getTitle());
					System.out.println("내용 : " + result.getContent());
					break;
				} else {
					System.out.println("******ERROR 메모검색에 실패했습니다.");
				}
			}
		}
	}

	public void deleteMemo() {
		while (true) {
			System.out.println("삭제할 메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.deleteMemo(memoseq);
				if (result) {
					System.out.println("삭제에 성공했습니다.");
					break;
				} else {
					System.out.println("******ERROR 메모삭제에 실패했습니다.");
				}
			}
		}
	}

	public void updateMemo() {
		while (true) {
			System.out.println("수정할 메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {

				System.out.println("제목을 입력 해주세요 => ");
				String title = scLine.nextLine();
				System.out.println("내용을 입력 해주세요 => ");
				String content = scLine.nextLine();
				if ((title == null || title.equals("")) || (content == null || content.equals(""))) {
					System.out.println("******ERROR 다시입력해주세요.");
				} else {
					boolean result = manager.updateMemo(memoseq, new UserMemo(null, title, content, null, null));
					if (result) {
						System.out.println("메모수정 완료");
						break;
					} else {
						System.out.println("******ERROR 메모수정에 실패했습니다.");
					}
				}
			}
		}

	}

	public void printAllMemo(ArrayList<UserMemo> memos) {
		for (UserMemo memo : memos) {
			System.out.println(memo);
		}
	}

	public void Musicplayer() {
		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("│ Siro Music Player★          │");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println("│1.재생  2.정지  3.다음곡  4.이전곡        │");
			System.out.println("│5.종료                                                  │");
			System.out.println("└──────────────────────────────┘");
			int inputMenu = sc.nextInt();
			if (inputMenu == 5) {
				System.out.println("<<프로그램 종료>>");
				break;
			} else if (inputMenu == 1) {
				Music m = player.play();
				manager.printMusicinfo(m);
			} else if (inputMenu == 2) {
				String message = player.stop();
				System.out.println(message);
			} else if (inputMenu == 3) {
				Music m = player.nextPlay();
				if (m == null) {
					System.out.println("다음 곡이 없습니다.");
				} else {
					manager.printMusicinfo(m);
				}
			} else if (inputMenu == 4) {
				Music m = player.prePlay();
				if (m == null) {
					System.out.println("이전 곡이 없습니다.");
				} else {
					manager.printMusicinfo(m);
				}
			}
		}
	}

	public void insertMusic() {
		while (true) {
			System.out.println("제목을 입력 해주세요 => ");
			String musicname = scLine.nextLine();
			System.out.println("가수를 입력 해주세요 => ");
			String singer = sc2Line.nextLine();
			System.out.println("플레이타임을 입력 해주세요 => ");
			int playtime = sc.nextInt();
			System.out.println("노래파일 경로를 입력 해주세요 => ");
			String musicpath = scLine.nextLine();
			if ((musicname == null || musicname.equals("")) || (singer == null || singer.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.insertMusic(new Music(null, musicname, singer, playtime, musicpath, null));
				if (result) {
					System.out.printf("%s - %s 노래등록 완료 \n", musicname, singer);
					break;
				} else {
					System.out.println("******ERROR 노래등록에 실패했습니다.");
				}
			}
		}
	}

	public void updateAccount() {
		while (true) {
			System.out.println("<< 현재 접속한 id/Pw를 입력합니다. >>");
			System.out.println("현재 아이디를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("현재 비밀번호를 입력 해주세요 => ");
			String pass = scLine.nextLine();
			if ((pass == null || pass.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				System.out.println("바꿀 닉네임을 입력 해주세요 => ");
				String name = scLine.nextLine();
				System.out.println("바꿀 Pw를 입력 해주세요 => ");
				String password = scLine.nextLine();
				if ((name == null || name.equals("")) || (password == null || password.equals(""))) {
					System.out.println("******ERROR 다시입력해주세요.");
				} else {
					boolean result = manager.updateAccount(id, pass, new UserAccount(name, id, password));
					if (result) {
						System.out.println("계정수정 완료");
						break;
					} else {
						System.out.println("******ERROR 계정수정에 실패했습니다.");
					}
				}
			}
		}

	}

	public void searchMusic() {
		while (true) {
			System.out.println("제목 또는 가수명을 입력 해주세요 => ");
			String searchWord = scLine.nextLine();
			if ((searchWord == null || searchWord.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				ArrayList<Music> result = manager.searchMusic(searchWord);
				if (result != null) {
					printAllMusic(result);
					break;
				} else {
					System.out.println("******ERROR 곡 검색에 실패했습니다.");
				}
			}
		}
	}

	public void deleteMusic() {
		while (true) {
			System.out.println("삭제할 노래 일련번호를 입력 해주세요 => ");
			String Musicseq = scLine.nextLine();
			if ((Musicseq == null || Musicseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.deleteMusic(Musicseq);
				if (result) {
					System.out.println("곡 삭제에 성공했습니다.");
					break;
				} else {
					System.out.println("******ERROR 곡 삭제에 실패했습니다.");
				}
			}
		}
	}
	// 수정전
	public void searchAllUser() {
		while (true) {
			ArrayList<UserAccount> result = manager.getAllUserList();
			if (result != null) {
				printAllUser(result);
				break;
			} else {
				System.out.println("******ERROR 유저조회에 실패했습니다.");
			}

		}
	}
	public void searchAllMusic() {
		while (true) {
			ArrayList<Music> result = manager.getAllMusicList();
			if (result != null) {
				printAllMusic(result);
				break;
			} else {
				System.out.println("******ERROR 곡조회에 실패했습니다.");
			}

		}
	}

	public void searhOneMusic() {
		while (true) {
			System.out.println("메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				UserMemo result = manager.searchOneMemo(memoseq);
				if (result != null) {
					System.out.println("제목 : " + result.getTitle());
					System.out.println("내용 : " + result.getContent());
					break;
				} else {
					System.out.println("******ERROR 메모검색에 실패했습니다.");
				}
			}
		}
	}

	public void updateMusic() {
		while (true) {
			System.out.println("수정할 메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				System.out.println("제목을 입력 해주세요 => ");
				String title = scLine.nextLine();
				System.out.println("내용을 입력 해주세요 => ");
				String content = scLine.nextLine();
				if ((title == null || title.equals("")) || (content == null || content.equals(""))) {
					System.out.println("******ERROR 다시입력해주세요.");
				} else {
					boolean result = manager.updateMemo(memoseq, new UserMemo(null, title, content, null, null));
					if (result) {
						System.out.println("메모수정 완료");
						break;
					} else {
						System.out.println("******ERROR 메모수정에 실패했습니다.");
					}
				}
			}
		}

	}

	public void printAllMusic(ArrayList<Music> musics) {
		System.out.println("┌──────────────────────────────────────────────┐");
		for (Music m : musics) {
			System.out.println(m);
		}
		System.out.println("└──────────────────────────────────────────────┘");
	}
	public void printAllUser(ArrayList<UserAccount> Users) {
		System.out.println("┌──────────────────────────────────────────────┐");
		for (UserAccount user : Users) {
			System.out.println(user);
		}
		System.out.println("└──────────────────────────────────────────────┘");
	}
}
