package maingame.model.vo;

public class Player
{
	private String name; // 이름
	private int money; // 현금 자산
	private int turn; // 자신의 턴(1 ~ 3)
	private int round; // 바퀴 수(2가 되면 게임 종료)
	private int position; // 현 위치(0 ~ 11)
	private int salary; // 월급(관람료)
	private int status; // 파산 여부(초기값 1, 파산시 0)
	private int black; // 블랙홀 여부(초기값 1, 블랙홀시 0)
	private int property; // 전 재산(초기값 0, 이후 지속적인 갱신값 유지)

	// 생성자
	public Player() {

	}

	public Player(String name, int money, int turn, int round, int position, int salary, int status, int black, int property) {
		this.name = name;
		this.money = money;
		this.turn = turn;
		this.round = round;
		this.position = position;
		this.salary = salary;
		this.status = status;
		this.black = black;
		this.property = property;
	}

	// Get, Set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBlack() {
		return black;
	}

	public void setBlack(int black) {
		this.black = black;
	}
	
	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}
}