package community;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import account.LogIn;
import account.Register.UserType;

public class Post {
	LogIn user;
	List <String> postContent;
	List <String> comments;
	String nickname;
	String major;
	UserType userType;
	LocalDateTime dateTime;
	
	private boolean isUploaded = false;
	private boolean isMyPost;
	
	// 나 외에 다른 사용자들의 포스트, 내용 지정
	public Post(List <String> postContent, String nickname, UserType userType, String major) {
		this.comments = new ArrayList<>();
		this.postContent = postContent;
		this.nickname = nickname;
		this.userType = userType;
		this.major = major;
		this.dateTime = LocalDateTime.now();
		this.isUploaded = true;
		this.isMyPost = false;
	}
	// 나의 포스트
	public Post(LogIn user) {
		this.user = user;
		this.postContent = new ArrayList<>();
		this.comments = new ArrayList<>();
		this.nickname = user.nickname;
		this.major = user.major;
		this.userType = user.userType;
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
	
	public void showPost() {
		System.out.println(showInfo());
		for (String pc : postContent) {
			System.out.println(pc);
		}
		showComments();
	}
	
	public void addComment(String comment) {
		comments.add(comment);
	}
	
	public void showComments() {
		if (comments.isEmpty()) return;
		else {
			System.out.print("  [댓글] ");
			for (String comment : comments) {
				System.out.println(comment);
			}
		}
	}
	
	public String showInfo() {
		switch (userType) {
		case COLLEGE:
			return this.nickname + " | 대학생 | " + this.major + " | " + dateTime;
		case GRADUATE: 
			return this.nickname + " | 대학원생 | " + this.major + " | " + dateTime;
		}
		return null;
	}
	
	public boolean getIsMyPost() {
		return isMyPost;
	}

}
