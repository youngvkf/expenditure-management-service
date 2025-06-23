package 지출관리서비스;

import java.util.Scanner;

import account.LogIn;
import account.LoginRegister;
import account.Register;
import community.PostManagement;
import homeScreen.HomeScreen;

public class Main {

	public static void main(String[] args) {
		LoginRegister loginRegister = new LoginRegister();
		PostManagement pManagement = new PostManagement();
		
		Scanner sc = new Scanner(System.in);
		
		while(!loginRegister.getUser().isLoginState()) {
			loginRegister.loginRegisterScreen();
		}
		
		pManagement.setUser(loginRegister.getUser());
		
		HomeScreen hs = new HomeScreen(pManagement, loginRegister.getUser());
		hs.showHomeScreen(sc);
	}

}
