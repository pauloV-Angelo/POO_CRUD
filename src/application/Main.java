package application;

import java.util.Scanner;

import services.UserCRUD;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean systemOn = true;
		do {
			System.out.println("Deseja inserir um input (s/n)?");
			String input = sc.next();
			if (input.equals("s")) {
				System.out.printf("Digite: %n 1 - Para inserir um novo usuário %n "
						+ "2 - Para Listar os usuários do Sistema %n "
						+ "3 - Para atualizar o cadastro de algum usuário %n " + "4 - Para deletar um usuário%n");
				int inputNum = sc.nextInt();
				sc.nextLine();
				switch (inputNum) {
				case 1:
					System.out.println("Digite o nome do usuário:");
					String name = sc.nextLine();
					System.out.println("Digite o email do usuário:");
					String email = sc.nextLine();
					UserCRUD.createUser(name, email);
					break;
				case 2:
					UserCRUD.readUsers();
					break;
				case 3:
					System.out.println("Digite o id do usuário que deseja atualizar: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Agora digite o novo nome do usuário: ");
					String newName= sc.nextLine();
					System.out.println("Agora digite o novo email do usuário: ");
					String newMail = sc.nextLine();
					UserCRUD.updateUser(id,newName, newMail);
					break;
				case 4:
					System.out.println("Digite o id do usuário que deseja excluir: ");
					int idDel = sc.nextInt();
					UserCRUD.deleteUser(idDel);
					break;
				default:
					System.out.println("Opção numérica inválida");
				}

			} else if(input.equals("n")){
				System.out.println("Saindo do sistema");
				systemOn = false;
			} else {
				System.out.println("Input não reconhecido");
			}

		} while (systemOn);

		sc.close();

	}

}
