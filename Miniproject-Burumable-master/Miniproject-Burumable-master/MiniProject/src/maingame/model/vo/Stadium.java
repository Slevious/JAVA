package maingame.model.vo;

public class Stadium
{
	private String name; // 이름
	private int owner; // 소유자(초기값 3, 이후 0 ~ 2)
	private int price; // 가격
	private int takePrice; // 인수된 가격(초기값==가격, 이후 10%씩 증가)
	private int takeCount; // 인수된 횟수
	private int toll; // 통행료(인수된 가격의 40%)
	private int admission; // 관람료(인수된 가격의 20%)
	private int ownerCheck; // 소유 여부(초기값 0(0/3/6/9는 초기값 1), 소유시 1)

	// 생성자
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