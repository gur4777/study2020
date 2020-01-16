package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	public static void main(String[] args) throws IOException {
		//https://www.tiffany.kr/jewelry/shop/rings/
		//18k개수  27개가 답 대소문자 전부
		
		
		URL url = new URL("http://liebli.com/goods/goods_list.php?cateCd=001002"); // 100개
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		int cnt =0;
		String data = null;
		while((data = br.readLine()) !=null) {
			int i=0;
			while((i=data.toUpperCase().indexOf("14K",i))!=-1) {
				i+="14K".length();
				cnt++;
				System.out.println(cnt);
			}
			
		}
		br.close();
		System.out.println("14k 반지 "+cnt+"개");
		
	
	}
}
