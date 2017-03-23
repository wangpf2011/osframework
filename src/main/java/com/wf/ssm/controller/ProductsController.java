package com.wf.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wf.ssm.controller.validation.ValidGroup1;
import com.wf.ssm.exception.CustomException;
import com.wf.ssm.po.Products;
import com.wf.ssm.po.ProductsCustom;
import com.wf.ssm.po.ProductsQueryVo;
import com.wf.ssm.service.ProductsService;

/**
 * <P>商品的controller</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午8:38:35
 */
@Controller
// 为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
// 比如：商品列表：/products/queryProducts.action
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	// 商品分类
	//productstypes表示最终将方法返回值放在request中的key
	@ModelAttribute("productstypes")
	public Map<String, String> getProductsTypes() {
		Map<String, String> productsTypes = new HashMap<String, String>();
		productsTypes.put("101", "数码");
		productsTypes.put("102", "母婴");

		return productsTypes;
	}

	// 商品查询
	@RequestMapping("/queryProducts")
	public ModelAndView queryItems(HttpServletRequest request,
			ProductsQueryVo productsQueryVo) throws Exception {
		System.out.println(request.getParameter("id"));

		// 调用service查找 数据库，查询商品列表
		List<ProductsCustom> productsList = productsService.findProductsList(productsQueryVo);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过productsList取数据
		modelAndView.addObject("productsList", productsList);

		// 指定视图
		// 路径配置时，如果未在程序中指定jsp路径的前缀和jsp路径的后缀
		// modelAndView.setViewName("/WEB-INF/jsp/products/itemsList.jsp");
		// 如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("products/itemsList");
		modelAndView.setViewName("products/productsList");

		return modelAndView;
	}

	@RequestMapping(value = "/editProducts", method = { RequestMethod.POST,
			RequestMethod.GET })
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String editProducts(Model model,
			@RequestParam(value = "id", required = true) String items_id)
			throws Exception {
		// 调用service根据商品id查询商品信息
		Products products = productsService.findProductsById(items_id);
		//判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户商品信息不存 在
		if(products == null){
			throw new CustomException("修改的商品信息不存在!");
		}

		// 通过形参中的model将model数据传到页面
		// 相当于modelAndView.addObject方法
		model.addAttribute("products", products);
		return "products/productsForm";
	}
	
	//查询商品信息，输出json
	///itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数，
	//如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
	@RequestMapping("/productsView/{id}")
	public @ResponseBody Products productsView(@PathVariable("id") String id)throws Exception{
		//调用service查询商品信息
		Products products = productsService.findProductsById(id);
		return products;
	}

	// 商品信息修改提交
	// 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
	// bindingResult接收校验出错信息
	// 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
	// value={ValidGroup1.class}指定使用ValidGroup1分组的 校验
	// @ModelAttribute可以指定pojo回显到页面在request中的key
	@RequestMapping("/editProductsSubmit")
	public String editProductsSubmit(
			Model model,
			HttpServletRequest request,
			String id,
			@ModelAttribute("products") @Validated(value = { ValidGroup1.class }) Products products,
			BindingResult bindingResult,
			MultipartFile items_pic) throws Exception {

		// 获取校验错误信息
		if (bindingResult.hasErrors()) {
			// 输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				// 输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			
			
			//可以直接使用model将提交pojo回显到页面
			model.addAttribute("products", products);
			
			// 出错重新到商品修改页面
			return "products/productsForm";
		}
		//原始名称
		String originalFilename = items_pic.getOriginalFilename();
		//上传图片
		if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
			//存储图片的物理路径
			String pic_path = "F:\\develop\\upload\\temp\\";
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);
			//将新图片名称写到itemsCustom中
			products.setPic(newFileName);	
		}

		// 调用service更新商品信息，页面需要将商品信息传到此方法
		productsService.updateProducts(id, products);

		// 重定向到商品查询列表
		// return "redirect:queryItems.action";
		// 页面转发
		// return "forward:queryItems.action";
		return "success";
	}

	// 批量删除 商品信息
	@RequestMapping("/deleteProducts")
	public String deleteProducts(Integer[] id) throws Exception {
		// 调用service批量删除商品
		// ...
		return "success";
	}

	// 批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
	@RequestMapping("/editProductsQuery")
	public ModelAndView editProductsQuery(HttpServletRequest request,
			ProductsQueryVo productsQueryVo) throws Exception {

		// 调用service查找 数据库，查询商品列表
		List<ProductsCustom> productsList = productsService.findProductsList(productsQueryVo);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过productsList取数据
		modelAndView.addObject("productsList", productsList);
		modelAndView.setViewName("products/productsQuery");

		return modelAndView;
	}

	// 批量修改商品提交
	// 通过productsQueryVo接收批量提交的商品信息，将商品信息存储到productsQueryVo中itemsList属性中。
	@RequestMapping("/editProductsAllSubmit")
	public String editProductsAllSubmit(ProductsQueryVo productsQueryVo)
			throws Exception {
		return "success";
	}
}
