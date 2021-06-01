package maingame.model.vo;

public class Stadium
{
	private String name; // �̸�
	private int owner; // ������(�ʱⰪ 3, ���� 0 ~ 2)
	private int price; // ����
	private int takePrice; // �μ��� ����(�ʱⰪ==����, ���� 10%�� ����)
	private int takeCount; // �μ��� Ƚ��
	private int toll; // �����(�μ��� ������ 40%)
	private int admission; // ������(�μ��� ������ 20%)
	private int ownerCheck; // ���� ����(�ʱⰪ 0(0/3/6/9�� �ʱⰪ 1), ������ 1)

	// ������
	public Stadium() {

	}

	public Stadium(String name, int owner, int price, int takePrice, int takeCount, int toll, int admission, int ownerCheck) {
		this.name = name;
		this.owner = owner;
		this.price = price;
		this.takePrice = takePrice;
		this.takeCount = takeCount;
		this.toll = toll;
		this.admission = admission;
		this.ownerCheck = ownerCheck;
	}

	// Get, Set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTakePrice() {
		return takePrice;
	}

	public void setTakePrice(int takePrice) {
		this.takePrice = takePrice;
	}

	public int getTakeCount() {
		return takeCount;
	}

	public void setTakeCount(int takeCount) {
		this.takeCount = takeCount;
	}

	public int getToll() {
		return toll;
	}

	public void setToll(int toll) {
		this.toll = toll;
	}

	public int getAdmission() {
		return admission;
	}

	public void setAdmission(int admission) {
		this.admission = admission;
	}

	public int getOwnerCheck() {
		return ownerCheck;
	}

	public void setOwnerCheck(int ownerCheck) {
		this.ownerCheck = ownerCheck;
	}
}