package jp.co.seattleconsulting.learning18.service;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jaksonを使用するためのエンティティクラス
 *
 * */
class Info {
	public String name;
	public int age;
}

public class MaruService {

	/**
	 * サンプルメソッド
	 *
	 * ライブラリの使用サンプル
	 * */
	public void sampleMethod() {

		String empty1 = StringUtils.SPACE;
		String empty2 = StringUtils.EMPTY;
		if (StringUtils.isBlank(empty1)) {
			System.out.println("BlankCheck empty1");
		} else if (StringUtils.isBlank(empty2)) {
			System.out.println("BlankCheck empty2");
		}
		if (StringUtils.isEmpty(empty1)) {
			System.out.println("EmptyCheck empty1");
		} else if (StringUtils.isEmpty(empty2)) {
			System.out.println("EmptyCheck empty2");
		}

		String null1 = null;
		String notNull = "藍子様";

		// nullの場合、設定した値に置き換える
		System.out.println("defaultString:" + StringUtils.defaultString(notNull, "nullです"));
		System.out.println("defaultString:" + StringUtils.defaultString(null1, "nullです"));
		System.out.println("defaultString:" + StringUtils.defaultIfBlank(empty2, "defaultIfBlankです"));
		System.out.println("defaultString:" + StringUtils.defaultIfEmpty(empty2, "defaultIfEmptyです"));

		// 配列をカンマ区切り文字列へ変換
		String[] strArray = { "abc", "def", "123", "456", "xyz" };
		String separator = ",";
		System.out.println(String.join(separator, strArray));

		/** JacksonでJSONデータを扱う方法*/
		// クラスオブジェクトへdecode(変換)
		// クラスオブジェクトに変換するに、ObjectMapperクラスを使ってインスタンスを生成する。
		// 生成したオブジェクトからreadValueメソッドを呼び出して使用することで、クラスオブジェクトを生成することができる。
		// ObjectMapperクラスのreadValueメソッドを使ってクラスオブジェクトinfoを生成し、そのメンバの値を出力表示する。
		String script = "{ \"name\":\"Mayu Morimoto\", \"age\":25}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Info info = mapper.readValue(script, Info.class);
			System.out.println(info.name + ", " + info.age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
