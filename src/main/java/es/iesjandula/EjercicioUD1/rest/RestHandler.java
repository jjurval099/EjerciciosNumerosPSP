package es.iesjandula.EjercicioUD1.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/operaciones", produces = {"application/json"})
@RestController
public final class RestHandler 
{
	public RestHandler()
    {
		
    }
	
	/** Numeros Perfectos*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/perfectos/{numerosPerfectos}/")
    public ResponseEntity<?> numerosPerfectos(@PathVariable("numerosPerfectos") Integer numerosPerfectos) 
	{
        List<Integer> perfectos = new ArrayList<>();

        for (int i = 1; i <= numerosPerfectos; i++) 
        {
            int sumaDivisores = 0;

            for (int j = 1; j < i; j++) 
            {
                if (i % j == 0) {
                    sumaDivisores += j;
                }
            }
            
            if (sumaDivisores == i) 
            {
                perfectos.add(i);
            }
        }

        return ResponseEntity.ok(perfectos);
    }
	
	/** Numeros Factoriales*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/factorial/{numerosFactoriales}/")
    public ResponseEntity<?> numeroFactorial(@PathVariable("numerosFactoriales") Integer numerosFactoriales)
	{
        int factorial = 1;

        for (int i = 1; i <= numerosFactoriales; i++) 
        {
            factorial *= i;
        }

        return ResponseEntity.ok(factorial);
    }
		
	/** Numeros Pares*/
	@RequestMapping(method = RequestMethod.GET, value = "/par/{numerosPares}/")
    public ResponseEntity<?> numeroPar(@PathVariable("numerosPares") Integer numerosPares)
	{
        List<Integer> pares = new ArrayList<>();
        
        for (int i = 0; i <= numerosPares; i++) 
        {
            
        	if (i % 2 == 0)
        	{
        		pares.add(i);
        	}
        }

        return ResponseEntity.ok(pares);
    }
	
	/** Numeros Impares*/
	@RequestMapping(method = RequestMethod.GET, value = "/impar/{numerosImpares}/")
    public ResponseEntity<?> numeroImpar(@PathVariable("numerosImpares") Integer numerosImpares)
	{
        List<Integer> impares = new ArrayList<>();
        
        for (int i = 0; i <= numerosImpares; i++) 
        {
            
        	if (i % 2 != 0)
        	{
        		impares.add(i);
        	}
        }

        return ResponseEntity.ok(impares);
    }
	

	/** Numeros Primos*/
	@RequestMapping(method = RequestMethod.GET, value = "/number/{numerosPrimos}/")
    public ResponseEntity<?> numerosPrimo(@PathVariable("numerosPrimos") Integer numerosPrimos)
	{
        List<Integer> primos = new ArrayList<>();
        
        for (int i = 2; i <= numerosPrimos; i++) 
        {
            boolean esPrimo = true;
            
            for (int j = 2; j < i; j++) 
            {
                if (i % j == 0) 
                {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo)
        	{
            	primos.add(i);
        	}
        }

        return ResponseEntity.ok(primos);
    }

}
