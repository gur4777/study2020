package project;

import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.Key;
import java.util.Arrays;
import java.util.Set;

public class SdokuAlgorithm {
	private int[][] su;
	private int[][] dap;
	private int[][] question;
	private int cnt;
	private int clsCnt;
	private int temp;
	private boolean b=true;
	
	public SdokuAlgorithm() {
		su = new int[][]{{8,1,2, 7,5,3, 6,4,9}  //{{8,1,2, 7,5,3, 6,4,9}
						,{9,4,3, 6,8,2, 1,7,5}
						,{6,7,5, 4,9,1, 2,8,3}
						
						,{3,6,9, 8,4,5, 7,2,1}
						,{2,8,7, 1,6,9, 5,3,4}
						,{1,5,4, 2,3,7, 8,9,6}
						
						,{5,2,1, 9,7,4, 3,6,8}
						,{4,3,8, 5,2,6, 9,1,7}
						,{7,9,6, 3,1,8, 4,5,2}};
		dap = Arrays.copyOf(su, su.length);
		question = new int[9][9];
		cnt = (int)(Math.random()*20+5);
		clsCnt = (int)(Math.random()*30+20);
		
		for(int i=0; i<su.length; i++) {
			dap[i] = Arrays.copyOf(su[i], su[i].length);
		}
		
		for(int i=0; i<cnt; i++) {
			
			for(int x=0; x<dap.length; x++) {
				for(int y=0; y<9; y++) {
					if(y<3) {
						if(y==2) {
							
						}else {
							temp = dap[x][y];
							dap[x][y] = dap[x][y+1];
							dap[x][y+1] = temp;
						}
					}else if(y<6) {
						if(y==5) {
							
						}else {
							temp = dap[x][y];
							dap[x][y] = dap[x][y+1];
							dap[x][y+1] = temp;
						}
					}else if(y<9) {
						if(y==8) {
							
						}else {
							temp = dap[x][y];
							dap[x][y] = dap[x][y+1];
							dap[x][y+1] = temp;
						}
					}
				}
			}
		} // 가로값 초기화
		
		
		
		int[][] temp = new int[9][9]; 
		for(int i=0; i<cnt; i++) {
			for(int x=0; x<9; x++) {
				if(x<3) {
					if(x==2) {
					}else {
						temp[x] = dap[x];
						dap[x]=dap[x+1];
						dap[x+1]=temp[x];
					}
				}else if(x<6) {
					if(x==5) {
					}else {
						temp[x] = dap[x];
						dap[x]=dap[x+1];
						dap[x+1]=temp[x];
					}
				}else if(x<9) {
					if(x==8) {
					}else {
						temp[x] = dap[x];
						dap[x]=dap[x+1];
						dap[x+1]=temp[x];
					}
				}
			}
		}
		
		for(int i =0; i<dap.length;i++) {
			question[i] = Arrays.copyOf(dap[i], dap[i].length);
		}
		while(b) {
			int cnt = 0;
			for(int i =0; i<1; i++) {//clsCnt
				int x=(int)(Math.random()*9);
				int y=(int)(Math.random()*9);
				question[x][y]=0;
			}
			for(int x =0; x<9;x++) {
				for(int y=0; y<9;y++) {
					if(question[x][y]==0) cnt++;
				}
			}
			if(cnt>5) b=false;
		}

		System.out.println("------------답안지----------------");
		for(int i =0; i<9;i++) {
			for(int c=0; c<9;c++) {
				System.out.print(dap[i][c]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");

						
	}
	
	public boolean checkDap(int[][] question) {
		int cnt=0;
		int[][] temp= new int[9][9];
		boolean a=true;
		boolean b=true;
		for(int i=0; i<question.length;i++) {
			for(int j =0; j<question.length; j++) {
				if(question[i][j] == dap[i][j]) {
					cnt++;
				}
			}
		}
		if(cnt==81) {
			return true;
		}
		
		System.out.println("//////////////////////////////////////////-------------------------------");
		for(int x = 0; x<9; x++) {
			for(int i=0; i<9; i++) {
				for(int j=1+i; j<9; j++) {
					
					if(question[x][i]==question[x][j]) {
						System.out.println(x+","+i);
						System.out.println(x+","+j);
						a=false;
					}
				}
			}
		}
		
		
	
		
		System.out.println("/////////////////////////////가로변환/////////////-------------------------------");
		for(int i =0; i<9; i++) {
			for(int j=0; j<9; j++) {
				temp[i][j] = question[j][i];
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		} //세로변환
		///
		for(int x = 0; x<9; x++) {
			for(int i=0; i<9; i++) {
				for(int j=1+i; j<9; j++) {
					if(temp[x][i]==temp[x][j]) {
						System.out.println(x+","+i);
						System.out.println(x+","+j);
						b=false;
					}
				}
			}
		}

		System.out.println("////////////////////////////////////////세로변환-------------------------------");
		for(int i =0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		} //세로변환
		
		
		System.out.println(a);
		System.out.println(b);
		return a && b ? true:false;
		
	}
	
	public int[][] getDap() {
		return dap;
	}
	public int[][] getQuestion() {
		return question;
	}
	
	public static void main(String[] args) {
		new SdokuAlgorithm();
		
	}
}
