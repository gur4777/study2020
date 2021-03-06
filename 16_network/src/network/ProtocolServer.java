package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("서버준비완료..");
			
			socket = serverSocket.accept(); // 낚아챈다
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 되지 않습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		String line;
		String msg;
		while(true) {
			try {
				//받는쪽
				line = br.readLine();
				String[] ar = line.split(":");
				
				//보내는쪽
				if(ar[0].equals(Protocol.ENTER)) {
					bw.write(ar[1]+"님 입장\n");
					bw.flush();
				}else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1]+"님 퇴장\n");
					bw.close();
					br.close();
					socket.close();
					System.exit(0);
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("["+ar[1]+"]"+">"+ar[2]+"\n");
					bw.flush();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
	
}
