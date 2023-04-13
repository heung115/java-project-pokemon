package Pokemon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //Input,Output 예외처리 
import java.util.StringTokenizer;

public class Poketmon {
	String name;
	int  maxHp,correntHp;
	int level;
	int exp, maxExp;
	int belong; //0은 플레이어, 1은 야생, 2는 AI
	int type; //0은 물, 1은 불, 2는 풀
	int attack;
	
	//포켓몬 정보를 한 줄 읽어오고, 공백 단위로 구분해서 담기
	public void getPokeInfo() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("poketmonList.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		name = st.nextToken();
		type = Integer.parseInt(st.nextToken());
		maxHp = Integer.parseInt(st.nextToken());
		attack = Integer.parseInt(st.nextToken());
		
		System.out.println(name+" "+type+" "+maxHp+" "+attack);
	}

	int getMaxHp(){
		return maxHp;
	}

	//전투 이후 남은 HP를 리턴
	int setHp(int damege){

		correntHp -= damege;//damege는 전투 영역에서 타입별로 setDamege();,어디선가 correntHp=maxHp 초기화 필요
		return correntHp;
	}

	
	public static void main(String[] args) throws IOException {
		
		Poketmon po = new Poketmon();
		po.getPokeInfo();

	}
	
	

}
