package services;

import java.util.ArrayList;
import java.util.List;

import entities.User;

/* Sistema de gerenciamento CRUD - 
incorpora e exemplifica encapsulamento através da utilização dos métodos getters e setters 
da classe User e se utiliza dos métodos e atributos static 
visto que não faz sentido instrânciar essa classe*/
public class UserCRUD {
	private static List<User> users = new ArrayList<User>();
	private static int idCount = 1;

	public static void createUser(String name, String email) {

		User user = new User(idCount, name, email);
		users.add(user);
		System.out.println(user + " cadastrado com sucesso");
		idCount++;
	}

	public static void readUsers() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}

	public static void updateUser(int id, String newName, String newMail) {
		User u = userById(id);

		if (u != null) {
			u.setName(newName);
			u.setMail(newMail);
			System.out.println("Cadastro concluído com sucesso");
		} else {
			System.out.println("cadastro não encotrado");
		}
	}

	public static void deleteUser(int id) {
		User u = userById(id);
		if (u != null) {
			users.remove(u);
			System.out.println("Usuário deletado com sucesso");
		} else {
			System.out.println("Cadastro não encontrado");
		}

	}

	private static User userById(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}

		return null;
	}

}