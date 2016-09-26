package Laboratory5;

public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account(1000);
		account.credit(500);
		account.debit(345);
		System.out.println(account);
		
		Account account1 = new Account(5032);
		account1.credit(400);
		account1.debit(500);
		System.out.println(account1);

	}

}
