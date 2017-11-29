import java.util.*;
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
	@Before
	public void setUp(){		
		cliente.setId(1);
		cliente.setNome("Cliente");
		cliente.setEmail("customer1@gmail.com");
		
	}
	
	@Test
	public void getClientTest(){
		clientes.put(cliente.getId(), cliente);
		long clientID = cliente.getId();
		assertEquals("Era pra ser ",cliente.getId(), clientID);
	}
	
	@Test
	public void existsClientTest (){
		clientes.values().contains(cliente);
	}
	
	@Test
	public void removeClientTest(){
		clientes.remove(null);
	}
	
	@Test
	public void qtdClientes(){
		assertFalse(clientes.values().size()>0);
		
	}

}
