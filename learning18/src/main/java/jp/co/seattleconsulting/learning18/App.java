package jp.co.seattleconsulting.learning18;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("あなたの名前を入力してください。");
        String name = scanner.nextLine();
        System.out.println("あなたの年齢を入力してください。");
        int age = scanner.nextInt();
        System.out.println("ようこそ" + age + "才の" + name + "さん");
    }
}
