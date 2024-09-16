package Service;

import com.supera.gerenciamentotarefas.Service.ListaService;
import com.supera.gerenciamentotarefas.entidades.Lista;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ListaServiceTest {

    @Autowired
    private ListaService listaService;

    @Test
    public void testarCriacaoLista() {
        Lista lista = new Lista();
        lista.setNome("Minha Lista");
        Lista criada = listaService.criarLista(lista);

        assertNotNull(criada.getId());
    }
}
