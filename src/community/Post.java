package community;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import account.Register;

public class Post {
	Register user;  // 사용자 정보 나타냄
	List <String> postContent;  // 포스트 내용
	List <String> comments;  // 한 포스트 내의 댓글들
	String nickname;  // 포스트 작성자 이름
	String schoolName;  // 포스트 작성자 학교
	String address; // 포스트 작성자 거주지역
	LocalDateTime dateTime;  // 포스트 작성 날짜 및 시간
	
	private boolean isUploaded = false;  // 포스트 내용 작성 -> 포스트 올리기 -> true값으로 변환 -> 커뮤니티에 내가 작성한 포스트 뜸
	private boolean isMyPost; // 나의 포스트 <-> 다른 사람들의 포스트 분리
	
	// 나 외에 다른 사용자들의 포스트, 내용 지정
	public Post(List <String> postContent, String nickname, String schoolName, String address) {
		this.comments = new ArrayList<>();
		this.postContent = postContent;
		this.nickname = nickname;
		this.schoolName = schoolName;
		this.address = address;
		this.dateTime = LocalDateTime.now(); 
		this.isUploaded = true;
		this.isMyPost = false;
	}
	// 나의 포스트
	public Post(Register user) {
		this.user = user;
		this.postContent = new ArrayList<>();
		this.comments = new ArrayList<>();
		this.nickname = user.nickname;
		this.schoolName = user.schoolName;
		this.address = user.address;
		this.isMyPost = true;
	}
	
	// 나의 포스트 작성하기
	public void setMyPostContent(Scanner sc) {
		System.out.println("포스트를 작성합니다. (빈 줄 입력 시 종료)");
		while (true) {
			String line = sc.nextLine();
			if (line.trim().isEmpty()) break;
			postContent.add(line);
		}
	}
	// 포스트 작성 후 업로드 -> 취소할 경우 업로드 x / 내용 삭제 
	public boolean uploadMyPost(Scanner sc) {
		String yesOrNo;
		
		while(true) {
			System.out.println("포스트를 업로드하시겠습니까?(y/n)");
			System.out.print(">> ");
			yesOrNo = sc.nextLine();
			
			if (yesOrNo.equalsIgnoreCase("y")) {
				dateTime = LocalDateTime.now();
				System.out.println("포스트를 업로드했습니다.");
				isUploaded = true;
				return isUploaded;
			}
			else if (yesOrNo.equalsIgnoreCase("n")) {
				postContent.clear();
				System.out.println("작성을 취소했습니다.");
				return isUploaded;
			}
			else
				System.out.println("잘못된 입력입니다.");
		}
	}
	// 포스트 보여주기 
	public void showPost() {
		System.out.println(showInfo());  // 작성자 정보
		for (String pc : postContent) {
			System.out.println(pc);  // 포스트 내용
		}
		showComments();  // 포스트에 달린 댓글
	}
	// 내가 쓴 댓글 추가
	public void addComment(String comment) {
		comments.add(comment);
	}
	// 댓글 보여주기 
	public void showComments() {
		if (comments.isEmpty()) return;
		else {
			System.out.print("  [댓글] ");
			for (String comment : comments) {
				System.out.println(comment);
			}
		}
	}
	// 포스트 작성자 정보 나타내기
	public String showInfo() {
		return this.nickname + " | " + this.schoolName + " | " + this.address + dateTime;
	}
	// 나의 포스트 <-> 다른 사람들의 포스트 분리
	public boolean getIsMyPost() {
		return isMyPost;
	}

}
