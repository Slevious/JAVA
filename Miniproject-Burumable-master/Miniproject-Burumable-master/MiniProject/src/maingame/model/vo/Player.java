package maingame.model.vo;

public class Player
{
	private String name; // �̸�
	private int money; // ���� �ڻ�
	private int turn; // �ڽ��� ��(1 ~ 3)
	private int round; // ���� ��(2�� �Ǹ� ���� ����)
	private int position; // �� ��ġ(0 ~ 11)
	private int salary; // ����(������)
	private int status; // �Ļ� ����(�ʱⰪ 1, �Ļ�� 0)
	private int black; // ��Ȧ ����(�ʱⰪ 1, ��Ȧ�� 0)
	private int property; // �� ���(�ʱⰪ 0, ���� �������� ���Ű� ����)

	// ������
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