package data;

import java.util.ArrayList;
import java.util.List;

import data.Product;

public class Products {

	private List<Product> list = new ArrayList<Product>();
	
	public Products() {
		Product backpack = new Product(
				"Sauce Labs Backpack", 
				"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising "
				+ "style with unequaled laptop and tablet protection.",
				"$29.99");
		Product bikeLight = new Product(
				"Sauce Labs Bike Light",
				"A red light isn't the desired state in testing but it sure helps when riding your "
				+ "bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
				"$9.99");
		Product tShirt = new Product(
				"Sauce Labs Bolt T-Shirt",
				"Get your testing superhero on with the Sauce Labs bolt T-shirt. From American "
				+ "Apparel, 100% ringspun combed cotton, heather gray with red bolt.", 
				"$15.99");
		Product jacket = new Product(
				"Sauce Labs Fleece Jacket",
				"It's not every day that you come across a midweight quarter-zip fleece jacket "
				+ "capable of handling everything from a relaxing day outdoors to a busy day "
				+ "at the office.",
				"$49.99");
		Product onesie = new Product(
				"Sauce Labs Onesie", 
				"Rib snap infant onesie for the junior automation engineer in development. "
				+ "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom "
				+ "won't unravel.", 
				"$7.99");
		Product tShirtRed = new Product(
				"Test.allTheThings() T-Shirt (Red)",
				"This classic Sauce Labs t-shirt is perfect to wear when cozying up to your "
				+ "keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
				"$15.99");
		list.add(backpack);
		list.add(bikeLight);
		list.add(tShirt);
		list.add(jacket);
		list.add(onesie);
		list.add(tShirtRed);
	}
	
	/**
	 * Method to get the product's name
	 * @param index Position of the product to get the name
	 * @return Product's name
	 */
	public String getName(int index) {
		Product prod = list.get(index);
		return prod.getName();
	}
	
	/**
	 * Method to get the product's description
	 * @param index Position of the product to get the description
	 * @return Product's Description
	 */
	public String getDescription(int index) {
		Product prod = list.get(index);
		return prod.getDescription();
	}

	/**
	 * Method to get the product's price
	 * @param index Position of the product to get the price
	 * @return Product's price
	 */
	public String getPrice(int index) {
		Product prod = list.get(index);
		return prod.getPrice();
	}
	
	/**
	 * Method to get the product's description searched by name
	 * @param name Product name
	 * @return Product's description
	 */
	public String getDescription(String name) {
		String desc = null;
		for (Product product: list) {
			if (product.getName().equals(name)) {
				desc = product.getDescription();
				break;
			}
		}
		return desc;
	}
	
	/**
	 * Method to get the product's price searched by name
	 * @param name Product's name
	 * @return Product's price
	 */
	public String getPrice(String name) {
		String price = null;
		for (Product product: list) {
			if (product.getName().equals(name)) {
				price = product.getPrice();
				break;
			}
		}
		return price;
	}
}
