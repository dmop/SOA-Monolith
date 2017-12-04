import java.util.*;
import java.util.function.ToIntFunction;

import org.junit.*;

import br.com.fish.devops.domain.cliente.Cliente;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import br.com.fish.devops.domain.cliente.Cliente;

public class JUnitTest {

	private static final Map<Long, Cliente> clientes = new HashMap<Long, Cliente>();

	private Cliente cliente = new Cliente();
	private Cliente cliente1 = new Cliente();

	@Test
	public void clietesListaTest() {
		cliente.setId(1);
		cliente.setNome("Cliente 1");
		cliente.setEmail("customer1@gmail.com");
		cliente1.setId(2);
		cliente1.setNome("Cliente 2");
		cliente1.setEmail("customer2@gmail.com");
		clientes.put(cliente.getId(), cliente);
		clientes.put(cliente1.getId(), cliente1);

		int currentclientes = clientes.values().size();
		assertEquals(clientes.values().size(), currentclientes);
	}

	@Test
	public void getClienteTest() {
		cliente.setId(1);
		cliente.setNome("Cliente 1");
		cliente.setEmail("customer1@gmail.com");
		clientes.put(cliente.getId(), cliente);
		long clienteID = cliente.getId();
		Cliente cli = null;

		for (Cliente c : clientes.values()) {

			if (c.getId() == clienteID)
				cli = c;
		}

		assertEquals("foi buscado o cliente ",cliente.getNome(), cli.getNome());
	}

	@Test
	public void clienteExistTest() {
		cliente.setId(1);
		cliente.setNome("Cliente 1");
		cliente.setEmail("customer1@gmail.com");
		clientes.put(cliente.getId(), cliente);
		long clienteID = cliente.getId();
		boolean exists = false;
		
		for (Cliente c : clientes.values()) {

			if (c.getId() == clienteID)
				exists = true;

		}

		assertEquals("usuario com id: "+clienteID+" é : ",true,exists);

		

	}

	@Test
	public void addClienteTest() {
		Cliente cliente = new Cliente();		
		clientes.put(cliente.getId(), cliente);
		
		assertTrue("O cliente " + cliente.getId() + " foi inserido!", clientes.containsValue(cliente));

	}
	@Test
	public void removeClienteTest(){
		cliente.setId(1);
		cliente.setNome("Cliente 1");
		cliente.setEmail("customer1@gmail.com");
		
		clientes.put(cliente.getId(), cliente);
		clientes.remove(cliente.getId());
		assertEquals(clientes.containsKey(cliente.getId()), false);
		
	}

}
