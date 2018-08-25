package jp.co.seattleconsulting.learning18;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * Appデフォルト作成クラス
 *
 */
public class App
{
	/**
	 * Mainメソッド
	 * サンプルソース群
	 *
	 * @param args 初期設定引数
	 */
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("あなたの名前を入力してください。");
        String name = scanner.nextLine();
        System.out.println("あなたの年齢を入力してください。");
        int age = scanner.nextInt();
        System.out.println("ようこそ" + age + "才の" + name + "さん");

        if (StringUtils.isEmpty("")) {

        }

        String s = "３";

        System.out.println(org.apache.commons.lang.StringUtils.isNumeric(s));
        System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(s));

        System.out.println(org.apache.commons.lang.math.NumberUtils.isDigits(s));
        System.out.println(org.apache.commons.lang.math.NumberUtils.isNumber(s));

        System.out.println(org.apache.commons.lang3.math.NumberUtils.isDigits(s));
        System.out.println(org.apache.commons.lang3.math.NumberUtils.isNumber(s));

        s = "-100";
        System.out.println(org.apache.commons.lang.StringUtils.isNumeric(s));
        System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(s));

        System.out.println(org.apache.commons.lang.math.NumberUtils.isDigits(s));
        System.out.println(org.apache.commons.lang.math.NumberUtils.isNumber(s));

        System.out.println(org.apache.commons.lang3.math.NumberUtils.isDigits(s));
        System.out.println(org.apache.commons.lang3.math.NumberUtils.isNumber(s));

        s = "0xff";
        System.out.println(org.apache.commons.lang.StringUtils.isNumeric(s));
        System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(s));

        System.out.println(org.apache.commons.lang.math.NumberUtils.isDigits(s));
        System.out.println(org.apache.commons.lang.math.NumberUtils.isNumber(s));

        System.out.println(org.apache.commons.lang3.math.NumberUtils.isDigits(s));
        System.out.println(org.apache.commons.lang3.math.NumberUtils.isNumber(s));

    }
}
