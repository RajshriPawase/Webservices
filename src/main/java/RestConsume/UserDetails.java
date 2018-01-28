package RestConsume;

public class UserDetails {


	  int id;
	  String name;
	  String userName;
	  String email;
	  Address add;
	  String phone;
	  String webSite;
	  Company company;
	 
	  
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", userName=" + userName + ", email="
				+ email + ", add=" + add + ", phone=" + phone + ", webSite=" + webSite + ", company=" + company + "]";
	}
		
		  
		  
	

}


class Address{
	
	String street;
	String suite;
	String city;
	String zipcode;
	Geo geo;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Geo getGeo() {
		return geo;
	}
	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode + ", geo="
				+ geo + "]";
	}

	
	
	
}

class Geo{
	
	String lattitude;
	String longitude;
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Geo [lattitude=" + lattitude + ", longitude=" + longitude + "]";
	}

	
	
}

class Company{
	
	String name;
	String bs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", bs=" + bs + "]";
	}
	
	
	
}
