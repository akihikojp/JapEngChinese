<<<<<<< HEAD
//package com.example.demo.controller;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
///**
// *PDFファイルダウンロード
// *・SpringBoot/SpringMVCでファイルのダウンロード(CSV, Excel, PDF, ローカルファイル) http://wannabe-jellyfish.hatenablog.com/entry/2016/05/20/005755
// *・Spring Bootでファイルダウンロードをする http://blog.okazuki.jp/entry/2015/07/18/220959 動作確認済み
// *・SpringMVCでファイルダウンロード http://blog.pepese.com/entry/20130424/1366806184
// *・JDBC経由でBLOBデータ取得 http://se-bikou.blogspot.jp/2010/02/jdbcblob.html
// */
//@Controller
//@RequestMapping
//public class DownloadController {
//// ★第1章 HTTPレスポンスの内容(サンプル) 参考:http://wa3.i-3-i.info/word1848.html */
//	/**1.ステータスライン → 「HTTPリクエストの結果が書いてある」*/
////	HTTP/1.1 200 OK\r\n 　 →　　HTTP/1.1で200 OKが返ってきたよ!
//	/**2.HTTPレスポンスヘッダ → 「【フィールド名】:【内容】でリクエストの結果が書かれている」*/
////	Server: nginx\r\n
////	Date: Tue, 11 Jul 2017 09:23:07 GMT\r\n
////	Content-Type: text/html\r\n
////	Transfer-Encoding: chunked\r\n
////	Connection: keep-alive\r\n
////	\r\n
//	/**3.HTTPレスポンスボディ → 「HTMLファイルの中身」*/
////	<!DOCTYPE html>\r\n
////	<html lang="ja">\r\n
////	<head>\r\n
////	\t<meta http-equiv="content-type" content="text/html; charset=UTF-8" />\r\n
////	\t<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">\r\n
////	\r\n
////	\r\n
////	\t<meta name="keywords" content="\350\276\236\345\205\270,IT,\347\224\250\350\252\236,\345\210\235\345\277\203\350\200\205">\r\n
////	\t<meta name="author" content="Makoto Sasaki">\r\n
////	\t<meta name="copyright" content="Copyright PCS">\r\n
////	\r\n
////	\t<meta name="application-name" content="\343\202\217\343\202\217\343\202\217IT\347\224\250\350\252\236\350\276\236\345\205\270"/>\r\n
////	\t<link rel="stylesheet" href="css/style.css?ver=00109">\r\n
////	\t<link rel="stylesheet" href="css/search.css?ver=00109">\r\n
////	\t<script src="./js/jquery-1.7.2.min.js?ver=00109"></script>\r\n
////	\t<script src="./js/common.js?ver=00109"></script>\r\n
////	</head>\r\n
////	<body>\r\n
////	（中略）
////	</body>\r\n
////	</html>\r\n
////	\r\n
//	
//// ★第2章 シリアライズとデシリアライズ 参考:https://qiita.com/Sekky0905/items/b3c6776d10f183d8fc89
////	・シリアライズ（直列化） → Javaのインスタンスをバイト列として出力すること。
////	・デシリアライズ → バイト列をJavaのインスタンスに復元すること。
////  
////	<上がシリアライズ、下がでデシリアライズ>
////  JavaのObject => <ObjectOutputStream> ----<FileOutputStream>--->  <ファイル(バイト列)>
////  JavaのObject <= <ObjectInputStream>  <---<FileInputStream> ----  <ファイル(バイト列)>
//
//// ★第3章 用語集 
////	  1.BLOB(Binaly Large Object):
////	    データベースシステムで用いられるデータ型のひとつ。
////      一般的に、画像や音声などの大きなバイナリデータもそのままメモリに格納することが可能。
////	  2.MultipartFile ・・・　このクラスでファイルを受け取れるみたい
////	  3.String.getBytes()　・・・　文字列をByte型に変換してくれるメソッド
////    4.new String ("※byteの文字")　Byte型をStringに変換するメソッド
////    5.InputStream ・・・　ファイルからの読込み 参考：http://www.atmarkit.co.jp/ait/articles/0709/12/news124_2.html
//	
//	/**BYTEとかBLOBとか : https://www.sejuku.net/blog/19650*/
//    public void  ByteAndString() {
//        //バイナリ文字列→String型変換
//	    	//byte→String
//        byte[] sbyte = null;
//		try {
//			sbyte = "apple".getBytes("MS932"); //Byteを文字列に変換
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//        String str = new String(sbyte);
//        System.out.println("str : " + str); // str : apple
//    }
//    
////	/**1-1 http://blog.okazuki.jp/entry/2015/07/18/220959 */
////	@RequestMapping(value = "/download", method = RequestMethod.GET)
////	public ResponseEntity<byte[]> download() throws IOException {
////	    HttpHeaders h = new HttpHeaders(); //レスポンスヘッダーのみを返却
////	    h.add("Content-Type", "text/csv; charset=MS932"); //ここでレスポンスボディの内容を作ってaddしてる？
////	    h.setContentDispositionFormData("filename", "hoge.csv");
////	    return new ResponseEntity<>("あ,い,う,え,お".getBytes("MS932")/**バイト型に変換*/, h, HttpStatus.OK);
////	}
//	
//	/** 2-1 https://qiita.com/kazuki43zoo/items/36b4dc0f13f1434e490c*/
=======
package com.example.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.impl.io.IdentityInputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *PDFファイルダウンロード
 *・SpringBoot/SpringMVCでファイルのダウンロード(CSV, Excel, PDF, ローカルファイル) http://wannabe-jellyfish.hatenablog.com/entry/2016/05/20/005755
 *・Spring Bootでファイルダウンロードをする http://blog.okazuki.jp/entry/2015/07/18/220959 動作確認済み
 *・SpringMVCでファイルダウンロード http://blog.pepese.com/entry/20130424/1366806184
 *・JDBC経由でBLOBデータ取得 http://se-bikou.blogspot.jp/2010/02/jdbcblob.html
 */
@Controller
@RequestMapping
public class DownloadController {
// ★第1章 HTTPレスポンスの内容(サンプル) 参考:http://wa3.i-3-i.info/word1848.html */
	/**1.ステータスライン → 「HTTPリクエストの結果が書いてある」*/
//	HTTP/1.1 200 OK\r\n 　 →　　HTTP/1.1で200 OKが返ってきたよ!
	/**2.HTTPレスポンスヘッダ → 「【フィールド名】:【内容】でリクエストの結果が書かれている」*/
//	Server: nginx\r\n
//	Date: Tue, 11 Jul 2017 09:23:07 GMT\r\n
//	Content-Type: text/html\r\n
//	Transfer-Encoding: chunked\r\n
//	Connection: keep-alive\r\n
//	\r\n
	/**3.HTTPレスポンスボディ → 「HTMLファイルの中身」*/
//	<!DOCTYPE html>\r\n
//	<html lang="ja">\r\n
//	<head>\r\n
//	\t<meta http-equiv="content-type" content="text/html; charset=UTF-8" />\r\n
//	\t<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">\r\n
//	\r\n
//	\r\n
//	\t<meta name="keywords" content="\350\276\236\345\205\270,IT,\347\224\250\350\252\236,\345\210\235\345\277\203\350\200\205">\r\n
//	\t<meta name="author" content="Makoto Sasaki">\r\n
//	\t<meta name="copyright" content="Copyright PCS">\r\n
//	\r\n
//	\t<meta name="application-name" content="\343\202\217\343\202\217\343\202\217IT\347\224\250\350\252\236\350\276\236\345\205\270"/>\r\n
//	\t<link rel="stylesheet" href="css/style.css?ver=00109">\r\n
//	\t<link rel="stylesheet" href="css/search.css?ver=00109">\r\n
//	\t<script src="./js/jquery-1.7.2.min.js?ver=00109"></script>\r\n
//	\t<script src="./js/common.js?ver=00109"></script>\r\n
//	</head>\r\n
//	<body>\r\n
//	（中略）
//	</body>\r\n
//	</html>\r\n
//	\r\n
	
// ★第2章 シリアライズとデシリアライズ 参考:https://qiita.com/Sekky0905/items/b3c6776d10f183d8fc89
//	・シリアライズ（直列化） → Javaのインスタンスをバイト列として出力すること。
//	・デシリアライズ → バイト列をJavaのインスタンスに復元すること。
//  
//  <上がシリアライズの動き、下がデシリアライズの動き>
//  JavaのObject => <ObjectOutputStream> ----<FileOutputStream>--->  <ファイル(バイト列)>
//  JavaのObject <= <ObjectInputStream>  <---<FileInputStream> ----  <ファイル(バイト列)>

// ★第3章 用語集 
//	  1.BLOB(Binaly Large Object):
//	    データベースシステムで用いられるデータ型のひとつ。
//      一般的に、画像や音声などの大きなバイナリデータもそのままメモリに格納することが可能。
//	  2.MultipartFile ・・・　このクラスでファイルを受け取れるみたい
//	  3.String.getBytes()　・・・　文字列をByte型に変換してくれるメソッド
//        4.new String ("※byteの文字")　Byte型をStringに変換するメソッド
//        5.InputStream ・・・　ファイルからの読込み 参考：http://www.atmarkit.co.jp/ait/articles/0709/12/news124_2.html
	
　　/**BYTEの変換とか : https://www.sejuku.net/blog/19650*/
    public void  ByteAndString() {
        //バイナリ文字列→String型変換
	    	//byte→String
        byte[] sbyte = null;
		try {
			sbyte = "apple".getBytes("MS932"); //Byteを文字列に変換
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        String str = new String(sbyte);
        System.out.println("str : " + str); // str : apple
    }
    
	/**1-1 http://blog.okazuki.jp/entry/2015/07/18/220959 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download() throws IOException {
	    HttpHeaders h = new HttpHeaders(); //レスポンスヘッダーのみを返却
	    h.add("Content-Type", "text/csv; charset=MS932"); //ここでレスポンスボディの内容を作ってaddしてる？
	    h.setContentDispositionFormData("filename", "hoge.csv");
	    return new ResponseEntity<>("あ,い,う,え,お".getBytes("MS932")/**バイト型に変換*/, h, HttpStatus.OK);
	}
	
	/** 2-1 https://qiita.com/kazuki43zoo/items/36b4dc0f13f1434e490c*/
>>>>>>> 55c0f97d52311657b9e67559cfe029801c6dcc5b
//	@Autowired
//	DownloadSupport downloadSupport;
//
//	@RequestMapping(path = "/mocks/{id}/file", method = RequestMethod.GET)
//	public ResponseEntity<Resource> download(@PathVariable int id) throws UnsupportedEncodingException {
//	    MockResponse mockResponse = service.findOne(id); // ファイル名とダウンロードデータ(BLOBデータ)はDBから取得
//	    HttpHeaders headers = new HttpHeaders();
//	    downloadSupport.addContentDisposition(headers, mockResponse.getFileName()); // 2-2 サポートクラス参照！
//	    return ResponseEntity
//	            .status(HttpStatus.OK)
//	            .contentType(MediaType.APPLICATION_OCTET_STREAM) /**ここでファイル形式指定*/
//	            .headers(headers)
//	            .body(new InputStreamResource(mockResponse.getBody()));
//	}
//	/**2-2*/
//	@Component
//	public class DownloadSupport {
//
//	    private static final String CONTENT_DISPOSITION_FORMAT = "attachment; filename=\"%s\"; filename*=UTF-8''%s";
//
//	    public void addContentDisposition(HttpHeaders headers, String fileName) throws UnsupportedEncodingException {
//	        String headerValue = String.format(CONTENT_DISPOSITION_FORMAT,
//	                fileName, UriUtils.encode(fileName, StandardCharsets.UTF_8.name()));
//	        headers.add(HttpHeaders.CONTENT_DISPOSITION, headerValue);
//	    }
//
//	}
//	
//
//}
