package main_supermarket;

import product.*;

import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static SupermarketInventory initInv() {
		SupermarketInventory superInv =  new SupermarketInventory();
		superInv.addProduct(new Product(11111, "Detergente ABC", 1), 15);
		superInv.addProduct(new Product(22222, "Sabão em pó OMO", 6.5), 20);
		superInv.addProduct(new Product(33333, "Shampoo Beleza Fácil", 12.5), 10);
		superInv.addProduct(new Product(44444, "Creme dental Colgate", 3.5), 30);
		superInv.addProduct(new Product(55555, "Sabonete Nívea", 1.8), 40);
		superInv.addProduct(new Product(66666, "Biscoito maizena", 2), 50);
		superInv.addProduct(new Product(77777, "Leite desnatado Parmelat", 3), 35);
		
		return superInv;
		
		
	}
	
	public static int mainMenu() {
		System.out.println("==========Supermecado==========\n");
		System.out.println("0 - Sair do programa");
		System.out.println("1 - Listar itens a venda");
		System.out.println("2 - Ver carrinho");
		
		return sc.nextInt();
		
	}
	
	public static int sellingOptions() {
		System.out.println("0 - Voltar");
		System.out.println("1 - Adicionar um produto ao carrinho um produto");
		return sc.nextInt();
	}
	
	public static void addingToCart(SupermarketInventory superInv, Cart cart) {
		boolean voltar = false;
		do {
			System.out.println(superInv.listAll());
			int userResponse = sellingOptions();
			switch(userResponse) {
				case 0:
					voltar = true;
					break;
				case 1:
					System.out.print("\nDigite o código do produto: ");
					ItemProduct<Product> item = superInv.getItemProduct(sc.nextInt());
					if(item != null) {
						System.out.print("\nDigite a quantidade que quer desse produto: ");
						int qnt = sc.nextInt();
						if(item.remove(qnt)) {
							if(cart.addProduct(item.getProduct(), qnt)) {
								System.out.println("Produto adicionado ao carrinho com sucesso");
							}else {
								System.out.println("Erro ao adicionar produto ao carrinho");
								item.add(qnt);
							}
							
						}else {
							System.out.println("Não temos essa quantia em estoque");
						}
					}else {
						System.out.println("Produto não encontrado\n");
					}
					break;
				default:
					System.out.println("O valor " + userResponse + " não é uma das opções");
					
			}
		}while(!voltar);
	}
	
	public static int cartOptions() {
		System.out.println("0 - Voltar");
		System.out.println("1 - Adicionar ou remover quantidade de um produto");
		System.out.println("2 - Finalizar Compra");
		return sc.nextInt();
	}
	
	public static void seeCart(Cart cart, SupermarketInventory superInv) {
		boolean voltar = false;
		do {
			System.out.println(cart.listAll());
			System.out.println("Preço total: R$" + cart.totalPrice());
			int userResponse = cartOptions();
			switch(userResponse) {
				case 0:
					voltar = true;
					break;
				case 1:
					System.out.print("\nDigite o código do produto: ");
					int productId = sc.nextInt();
					ItemProduct<ProductReadOnly> itemCart = cart.getItemProduct(productId);
					ItemProduct<Product> itemSuper = superInv.getItemProduct(productId);
					if(itemCart != null && itemSuper != null) {
						System.out.print("\nDigite a quantidade que quer adicionar(valor positivo) ou remover(valor negativo): ");
						int qnt = sc.nextInt();
						if(qnt>0) {
							itemCart.add(qnt);
							if(itemSuper.remove(qnt)) {
								System.out.println("Quantidade adicionada com sucesso");
							}else {
								System.out.println("Não há essa quantia em estoque apenas temos " + itemSuper.getQnt() + " unidades desse item");
							}
							
						}else{
							if(itemCart.remove(-qnt)) {
								itemSuper.add(-qnt);
								if(itemCart.getQnt() == 0) {
									cart.removeItemProduct(productId);
								}
								System.out.println("Quantidade removida com sucesso");
							}else {
								System.out.println("Erro ao remover quantidade");
							}
							
						}
					}else {
						System.out.println("Produto não encontrado\n");
					}
					
					break;
				case 2: 
					double totalPrice = cart.endShop();
					System.out.println("Compra realizado com sucesso no valor de R$" + totalPrice);
					voltar = true;
					break;
					
			}
			
		}while(!voltar);
	}

	public static void main(String[] args) {
		
		SupermarketInventory superInv = initInv();
		Cart cart = new Cart();
		
		boolean sair = false;
		
		do {
			
			int userResponse = mainMenu();
			switch(userResponse) {
				case 0:
					sair = true;
					break;
				case 1:
					addingToCart(superInv, cart);
					break;
				case 2:
					seeCart(cart, superInv);
					break;
				default:
					System.out.println("O valor " + userResponse + " não é uma das opções");
			}
			
		}while(!sair);
		

		
	}

}
