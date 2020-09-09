package br.edu.infnet.home.broker.abc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeBrokerAbcDashboard {
	
	private static final String SERVICE_URL = "http://localhost:8080/home-broker-abc-api/valores";
	private RestTemplate restClient = new RestTemplate();
	
	
	@GetMapping("/grafico-full")
	public ModelAndView graficoFull(Model model) {
		
		ModelAndView mv = new ModelAndView("financeiro/grafico-magazine-luiza-full");
		try {
		
			mv.addObject(model);
		} catch (ResourceAccessException e) {
			
			System.err.println("Erro de Comunicação com o HOST : " + SERVICE_URL);
		}
		return mv;		
	}
	
	@GetMapping("/grafico-macd")
	public ModelAndView graficoMACD(Model model) {
		
		ModelAndView mv = new ModelAndView("financeiro/grafico-magazine-luiza-macd");
		try {
		
			mv.addObject(model);
		} catch (ResourceAccessException e) {
			
			System.err.println("Erro de Comunicação com o HOST : " + SERVICE_URL);
		}
		return mv;		
	}
	
	@GetMapping("/grafico-sma")
	public ModelAndView graficoSMA(Model model) {
		
		ModelAndView mv = new ModelAndView("financeiro/grafico-magazine-luiza-sma");
		try {
		
			mv.addObject(model);
		} catch (ResourceAccessException e) {
			
			System.err.println("Erro de Comunicação com o HOST : " + SERVICE_URL);
		}
		return mv;		
	}
	
	@GetMapping("/grafico-ema")
	public ModelAndView graficoEMA(Model model) {
		
		ModelAndView mv = new ModelAndView("financeiro/grafico-magazine-luiza-ema");
		try {
		
			mv.addObject(model);
		} catch (ResourceAccessException e) {
			
			System.err.println("Erro de Comunicação com o HOST : " + SERVICE_URL);
		}
		return mv;		
	}
	
	@GetMapping("/financeiro")
	public ModelAndView financialData(Model model) {
		
		ModelAndView mv = new ModelAndView("financeiro/financeiro");
		try {
		
			DadosFinanceirosDTO[] wrapper = restClient.getForObject(SERVICE_URL, DadosFinanceirosDTO[].class);
			
			List<DadosFinanceirosDTO> financesDTO =  Arrays.asList(wrapper);
			model.addAttribute("financesDTO", financesDTO);
			
			mv.addObject(model);
		} catch (ResourceAccessException e) {
			
			System.err.println("Erro de Comunicação com o HOST : " + SERVICE_URL);
		}
		return mv;		
	}
}
