package community;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import account.Register;

public class PostManagement {
	List <Post> postList; 
	Register user;
	
	public PostManagement() {
		postList = new ArrayList<>();
		
		List<String> c1 = Arrays.asList("아현역 사는데", "대패 삼겹살 공구하실 분?");
		List<String> c2 = Arrays.asList("창천동 삽니다", "바퀴벌레 잡아주실 분 구해요", "진짜급함");
		List<String> c3 = Arrays.asList("청년 월세 지원금 신청 기간 언제까지인가요??", "제곧내");
		List<String> c4 = Arrays.asList("에어컨 하루에 10시간 틀면", "전기세 한 달에 얼마 나오나요?");
		List<String> c5 = Arrays.asList("중고책 팔아요", "이산수학, 기초논리설계 책 있습니다!!", "반값에 쿨거래 ㅂㅌ합니다");
		
		postList.add(new Post(c1, "거지의마지막단말마", "이화여자대학교", "서대문구"));
		postList.add(new Post(c2, "벌레무서워함", "서강대학교", "마포구"));
		postList.add(new Post(c3, "고슬밥아니면밥상엎음", "역앞대학교", "종로구"));
		postList.add(new Post(c4, "혠", "이화여자대학교", "송파구"));
		postList.add(new Post(c5, "유성", "집앞대학교", "부산진구"));
	}
	// 가입 및 로그인한 user 객체(main에서 생성) 가져오기
	public void setUser(Register user) {
		this.user = user;
	}
	
	public void showCommunityScreen(Scanner sc) {
		showAllPosts();
		
		int option;
		while(true) {
			System.out.println("1. 포스트 작성하기");
			System.out.println("2. 포스트 삭제하기");
			System.out.println("3. 댓글 달기");
			System.out.println("0. 뒤로 가기\n");
			System.out.print("메뉴를 선택하세요: ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				Post myPost = new Post(user);
				myPost.setMyPostContent(sc);
				myPost.uploadMyPost(sc);
				postList.add(myPost);
				break;
			case 2:
				deleteMyPost();
				break;
			case 3:
				uploadComment(sc);
				break;
			case 0:
				System.out.println("===========================");
				return;
			}
			showAllPosts();
		}
	}
	
	public void showAllPosts() {
		for (Post p : postList) {
			System.out.println("--------------------------------");
			System.out.print((postList.indexOf(p) + 1) + ". ");
			p.showPost();
			System.out.println("--------------------------------");
		}
	}
	
	public void deleteMyPost() {
		for (int i = postList.size() - 1; i >= 0; i--) {
			if (postList.get(i).getIsMyPost()) {
				postList.remove(i);
			}
		}
		System.out.println("내 포스트를 삭제했습니다.");
	}
	
	public void uploadComment(Scanner sc) {
		int index;
		String comment;
		
		System.out.print("댓글을 달 포스트의 번호: ");
		index = sc.nextInt() - 1;
		sc.nextLine();
		if (index < 0 || index >= postList.size()) {
			System.out.println("유효하지 않은 번호입니다.");
			return;
		}
		
		System.out.println("댓글을 적어주세요 (엔터 치면 업로드)");
		comment = sc.nextLine();
		
		postList.get(index).addComment(comment);
		System.out.println("댓글이 등록되었습니다.");
		System.out.println("================================");
	}
}
