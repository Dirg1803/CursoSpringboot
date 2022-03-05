package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
//	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto prducto1= new Producto("Camara Sony", 100);
		Producto prducto2= new Producto("Bicicleta Bianchi aro 26", 200);
		
		ItemFactura linea1 = new ItemFactura(prducto1, 2);
		ItemFactura linea2 = new ItemFactura(prducto2, 4);
		
		return Arrays.asList(linea1,linea2);
	}
	
	
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsoficina(){
		Producto prducto1= new Producto("Monitor LG LCD 24", 250);
		Producto prducto2= new Producto("Notebook Asus", 500);
		Producto prducto3= new Producto("Impresora HP Multifuncional", 80);
		Producto prducto4= new Producto("Escritorio Oficina", 300);
		
		ItemFactura linea1 = new ItemFactura(prducto1, 2);
		ItemFactura linea2 = new ItemFactura(prducto2, 1);
		ItemFactura linea3 = new ItemFactura(prducto3, 1);
		ItemFactura linea4 = new ItemFactura(prducto4, 1);
		
		return Arrays.asList(linea1,linea2,linea3,linea4);
	}
}
